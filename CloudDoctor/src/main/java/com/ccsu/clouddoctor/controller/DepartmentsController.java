package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Departments;
import com.ccsu.clouddoctor.service.DepartmentsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("/selectByDepartment")
    @ResponseBody
    public List<String>selectByDepartment(){
        return departmentsService.selectByDepartment();
    }

    @RequestMapping("/selectByDepartmentSmall")
    @ResponseBody
    public HashMap selectByDepartmentSmall(@RequestParam("department") String department,@RequestParam("flag") int flag){
        HashMap<String,List<String>> map =new HashMap();
        if (flag==1){
            map.put(department,departmentsService.selectByDepartmentSmall(department));
        }
        if (flag==0){
            map.put(department,departmentsService.queryByDepartmentSmall(department));
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping("/selectDepartmentByName")
    @ResponseBody
    public List<Departments>selectDepartmentByName(@RequestParam("key") String key){
        return  departmentsService.selectDepartmentByName(key);
    }

    @RequestMapping("/selectDepartmentByAdmin")
    @ResponseBody
    public PageInfo<Departments>selectDepartmentByAdmin(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return departmentsService.selectDepartmentByAdmin(pageNum,pageSize);
    }

    @RequestMapping("/deleteDepartmentById")
    @ResponseBody
    public int deleteDepartmentById(@RequestParam("departmentId")int departmentId){
        return departmentsService.deleteDepartmentById(departmentId);
    }

    @RequestMapping("/AddDepartment")
    @ResponseBody
    public int AddDepartment(Departments departments){
        return departmentsService.AddDepartment(departments);
    }

    @RequestMapping("/updateDepartment")
    @ResponseBody
    public int updateDepartment(Departments departments){
        return departmentsService.updateDepartment(departments);
    }

    @RequestMapping("/searchByAdmin")
    @ResponseBody
    public PageInfo<Departments>searchByAdmin(@RequestParam("key")String key,@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
        return departmentsService.searchByAdmin(key,pageNum,pageSize);
    }

}
