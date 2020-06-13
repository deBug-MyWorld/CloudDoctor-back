package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.User;
import com.ccsu.clouddoctor.service.UserService;
import com.ccsu.clouddoctor.utils.Md5;
import com.ccsu.clouddoctor.utils.SavePic;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    //controller调service层
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(User user){
        user.setPassword(Md5.generate(user.getPassword()));
        return userService.addUser(user);
    }

    @RequestMapping("/queryUserByUname")
    @ResponseBody
    public User queryUserByUname(@RequestParam("username") String username){
        System.out.println(username);
        System.out.println("queryUserByUname1111");
        User user=userService.queryUserByUname(username);
        if(user!=null)user.setPassword("");//这个接口不止一个调用，暂时把密码屏蔽防止泄露
        return user;
    }

    @RequestMapping("/updateUserByUname")
    @ResponseBody
    public int updateUserByUname(User user){
        return userService.updateUserByUname(user);
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println("login111111111111111111111");
        System.out.println(username);
        User user = userService.queryUserByUname(username);
        System.out.println(user);
        if(user==null){
            return "no";
        }
        if(Md5.verify(password,user.getPassword())==false){
            return "error";
        }
        return "ok";
    }
    @RequestMapping("/updateIcon")
    @ResponseBody
    public String updateIcon(@RequestParam("file")MultipartFile file, @RequestParam Map<String ,String>map) throws IOException {
        if (!file.isEmpty()){
            String path = "D:\\vue2\\cloudDoctor\\static\\userIcon";
            String URL=SavePic.savePic(file.getInputStream(),file.getOriginalFilename(),path);
//            String url=URL.replaceAll("\\\\","/");
            String urlIcon="http://localhost:8082/static/userIcon/"+file.getOriginalFilename();
            userService.updateIcon(urlIcon,map.get("username"));
            return "ok";
        }
        return "no";
    }
    @RequestMapping("/updatePassWord")
    @ResponseBody
    public String updatePassWord(@RequestParam("password") String password,@RequestParam("newPassword")String newPassword,@RequestParam("username") String username){
        User user = userService.queryUserByUname(username);
        if(Md5.verify(password,user.getPassword())==false){
            return "no";
        }
//        newPassword=Md5.generate("Buzhidao13");

        newPassword=Md5.generate(newPassword);
        userService.updatePassWord(newPassword,username);
        return "ok";
    }
    @RequestMapping("/updateMoney")
    @ResponseBody
    public int updateMoney(@RequestParam("username")String username,@RequestParam("money")double money){
        return userService.updateMoney(username,money);
    }

    @RequestMapping("/queryAllUser")
    @ResponseBody
    public PageInfo<User>queryAllUser(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return userService.queryAllUser(pageNum,pageSize);
    }

    @RequestMapping("/updateUserByAdmin")
    @ResponseBody
    public int updateUserByAdmin(User user){return userService.updateUserByAdmin(user);}

    @RequestMapping("/deleteUserByAdmin")
    @ResponseBody
    public int deleteUserByAdmin(@RequestParam("id")int id){
        return userService.deleteUserByAdmin(id);
    }
}
