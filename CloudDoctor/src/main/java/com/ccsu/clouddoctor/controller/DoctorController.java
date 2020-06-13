package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Doctor;
import com.ccsu.clouddoctor.service.DoctorService;
import com.ccsu.clouddoctor.utils.SavePic;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/selectByDpm")
    @ResponseBody
    public PageInfo<Doctor>selectByDpm(@RequestParam("departmentBig")String departmentBig,@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        System.out.println(departmentBig);
        return doctorService.selectByDpm(departmentBig,pageNum,pageSize);
    }

    @RequestMapping("/getRecommend")
    @ResponseBody
    public List<String> getRecommend(){
        return doctorService.getRecommend();
    }

    @RequestMapping("/selectByRecommend")
    @ResponseBody
    public List<Doctor> selectByRecommend(@RequestParam("departmentBig") String departmentBig){
        return doctorService.selectByRecommend(departmentBig);
    }

    @RequestMapping("/selectDoctorByName")
    @ResponseBody
    public List<Doctor>selectDoctorByName(@RequestParam("key") String key){
        return doctorService.selectDoctorByName(key);
    }

    @RequestMapping("/queryDoctorByDpm")
    @ResponseBody
    public PageInfo<Doctor>queryDoctorByDpm(@RequestParam("dpm")String dpm,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,@RequestParam("orderBy") String orderBy){
        return doctorService.queryDoctorByDpm(dpm,pageNum,pageSize,orderBy);
    }

    @RequestMapping("/getDoctorInfoById")
    @ResponseBody
    public Doctor getDoctorInfoById(@RequestParam("doctorId") int doctorId){
        return doctorService.getDoctorInfoById(doctorId);
    }

    @RequestMapping("/updateDoctorTag")
    @ResponseBody
    public int updateDoctorTag(@RequestParam("doctorId") int doctorId,@RequestParam("tag") int tag){
        return doctorService.updateDoctorTag(doctorId,tag);
    }

    @RequestMapping("/selectAllDoctor")
    @ResponseBody
    public PageInfo<Doctor>selectAllDoctor(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return doctorService.selectAllDoctor(pageNum, pageSize);
    }

    @RequestMapping("/addDoctor")
    @ResponseBody
    public int addDoctor(Doctor doctor){
        System.out.println(doctor);
        return doctorService.addDoctor(doctor);
    }

    @RequestMapping("/deleteDoctorById")
    @ResponseBody
    public int deleteDoctorById(@RequestParam("doctorId")int doctorId){
        return doctorService.deleteDoctorById(doctorId);
    }
    @RequestMapping("/updateDoctor")
    @ResponseBody
    public int updateDoctor(Doctor doctor){
        return doctorService.updateDoctor(doctor);
    }

    @RequestMapping("/selectDoctorByAdmin")
    @ResponseBody
    public PageInfo<Doctor>selectDoctorByAdmin(@RequestParam("key") String key,@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return doctorService.selectDoctorByAdmin(key, pageNum, pageSize);
    }

    @RequestMapping("/doctorIcon")
    @ResponseBody
    public String doctorIcon(@RequestParam("file")MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            String path = "D:\\vue2\\cloudDoctor\\static\\images\\doctors";
            SavePic.savePic(file.getInputStream(),file.getOriginalFilename(),path);
            return "ok";
        }
        return "no";
    }
}
