package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.Departments;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentsService {
    List<String> selectByDepartment();//查询大科室
    List<String>selectByDepartmentSmall(String department);//查询大科室下的小科室(首页)
    List<Departments>selectDepartmentByName(String key);//根据名称模糊查找科室
    List<String>queryByDepartmentSmall(String department);//查询大科室下的小科室（科室页）
    PageInfo<Departments> selectDepartmentByAdmin(int pageNum,int pageSize);//查询全部科室信息（管理员）
    int deleteDepartmentById(int departmentId);//根据科室信息id删除科室
    int AddDepartment(Departments departments);//新增科室信息(管理员)
    int updateDepartment(Departments departments);//根据id修改科室信息(管理员)
    PageInfo<Departments>searchByAdmin(String key,int pageNum,int pageSize);//根据名称模糊查找科室（管理员）
}
