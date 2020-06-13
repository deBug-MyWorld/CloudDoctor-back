package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Illness;
import com.ccsu.clouddoctor.service.IllnessService;
import com.ccsu.clouddoctor.utils.SavePic;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/illness")
public class IllnessController {
    @Autowired
    private IllnessService illnessService;

    @RequestMapping("/selectIllnessById")
    @ResponseBody
    public Illness selectIllnessById(int illnessId){
        return illnessService.selectIllnessById(illnessId);
    }

    @RequestMapping("/selectAllIllness")
    @ResponseBody
    public PageInfo<Illness> selectAllIllness(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return illnessService.selectAllIllness(pageNum,pageSize);
    }

    @RequestMapping("/selectIllnessByName")
    @ResponseBody
    public List<Illness> selectIllnessByName(@RequestParam("key") String key){
        return illnessService.selectIllnessByName(key);
    }

    @RequestMapping("/addIllness")
    @ResponseBody
    public int addIllness(Illness illness){
        return illnessService.addIllness(illness);
    }

    @RequestMapping("/updateIllnessById")
    @ResponseBody
    public int updateIllnessById(Illness illness){
        System.out.println(illness);
        return illnessService.updateIllnessById(illness);
    }

    @RequestMapping("/deleteIllnessById")
    @ResponseBody
    public int deleteIllnessById(@RequestParam("illnessId") int illnessId){
        return illnessService.deleteIllnessById(illnessId);
    }
    @RequestMapping("/queryIllnessByAdmin")
    @ResponseBody
    public PageInfo<Illness> queryIllnessByAdmin(@RequestParam("key")String key,@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return illnessService.queryIllnessByAdmin(key, pageNum, pageSize);
    }

    @RequestMapping("/illnessImg")
    @ResponseBody
    public String illnessImg(@RequestParam("file")MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            String path = "D:\\vue2\\cloudDoctor\\static\\images\\illness";
            SavePic.savePic(file.getInputStream(),file.getOriginalFilename(),path);
            return "ok";
        }
        return "no";
    }
}
