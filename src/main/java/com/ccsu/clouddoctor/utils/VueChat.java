package com.ccsu.clouddoctor.utils;

import net.sf.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/vueChat/{sendUser}")
public class VueChat {
    // 当前的websocket对象
    private static ConcurrentHashMap<String, VueChat> webSocketMap = new ConcurrentHashMap<String, VueChat>();
    // 当前会话,属于websocket的session
    private Session session;
    // 聊天信息
    private String sendUser;// 当前用户
    private String toUser;// 接收人
    private String message;// 聊天信息
    private String userIcon;//用户头像
//    连接建立成功调用的方法
    @OnOpen
    public void onOpen(@PathParam("sendUser") String sendUser, Session session) throws IOException {
        this.sendUser = sendUser;
        this.session = session;
        VueChat user = webSocketMap.get(sendUser);
        if(user != null) {
            String closeInfo="{\"type\":\"userClose\",\"closeUser\":\""+sendUser.toString()+"\""+"}";
            broadcast(closeInfo,"errorClose");
            webSocketMap.remove(sendUser);
            System.out.println("有一连接关闭！当前在线人数为" +webSocketMap.size());
        }
        webSocketMap.put(sendUser, this);//当前用户的websocket
        System.out.println("有新连接加入！当前在线人数为" + webSocketMap.size() + " 当前session是" + session.hashCode());

    }

//    连接关闭所调用的方法
    @OnClose
    public void onClose() throws IOException {
        // 在线数减1
        String closeInfo="{\"type\":\"userClose\",\"closeUser\":\""+sendUser.toString()+"\""+"}";
        broadcast(closeInfo,"onClose");
        webSocketMap.remove(sendUser);
        System.out.println("有一连接关闭！当前在线人数为" +webSocketMap.size());
    }


//    收到客户端的消息后所调用的方法
    @OnMessage
    public void onMessage(String jsonMsg, Session session) throws IOException {
        JSONObject jsonOject = JSONObject.fromObject(jsonMsg);
        sendUser = jsonOject.getString("sendUser");
        toUser = jsonOject.getString("toUser");
        message = jsonOject.getString("message");
        userIcon = jsonOject.getString("userIcon");
        String type="received";
        String jsonString="{\"sendUser\":\""+sendUser+"\",\"type\":\""+type+"\",\"userIcon\":\""+userIcon+"\",\"toUser\":\""+toUser+"\",\"message\":\""+message+"\""+"}";
        // 得到接收人
        VueChat user = webSocketMap.get(toUser);
        if (user == null) {
            System.out.println("接受人不在线");
            return;
        }
        user.sendMessage(jsonString);
    }
//    发成错误所调用的方法
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);//提供阻塞式的消息发送方式
    }

    public void broadcast(String message,String type) throws IOException {
        if(type.equals("onClose")) {//正常关闭链接，除自己外都发，直接群发会报错
            for (VueChat chat : webSocketMap.values()) {
                if(chat.session!=this.session) {
                    chat.sendMessage(message);
                }
            }
        }else {//错误关闭链接，挤号，群发
            for (VueChat chat : webSocketMap.values()) {
                chat.sendMessage(message);
            }
        }
    }


}
