package com.ccsu.clouddoctor.utils;

import java.io.*;

public class SavePic {

    public static String savePic(InputStream inputStream, String fileName,String path) {
        OutputStream os = null;
        String t = null;
        try {
//            String path = "D:\\vue2\\cloudDoctor\\static\\userIcon";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            System.out.println("fileName"+fileName);
            t = tempFile.getPath() + File.separator + fileName;
            System.out.println("t"+t);
            os = new FileOutputStream(t);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
                return t;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    return t;
    }


}
