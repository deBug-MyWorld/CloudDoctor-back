package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.DepartmentsMapper;
import com.ccsu.clouddoctor.pojo.Departments;
import com.ccsu.clouddoctor.service.DepartmentsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentsMapper departmentsMapper;

    @Override
    public List<String> selectByDepartment() {
        return departmentsMapper.selectByDepartment();
    }

    @Override
    public List<String> selectByDepartmentSmall(String department) {
        return departmentsMapper.selectByDepartmentSmall(department);
    }

    @Override
    public List<Departments> selectDepartmentByName(String key) {
        return departmentsMapper.selectDepartmentByName(key);
    }

    @Override
    public List<String> queryByDepartmentSmall(String department) {
        return departmentsMapper.queryByDepartmentSmall(department);
    }

    @Override
    public PageInfo<Departments> selectDepartmentByAdmin(int pageNum, int pageSize) {
        Page<Object> page=PageHelper.startPage(pageNum,pageSize);
        List<Departments>list=departmentsMapper.selectDepartmentByAdmin();
        PageInfo<Departments>info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteDepartmentById(int departmentId) {
        return departmentsMapper.deleteDepartmentById(departmentId);
    }

    @Override
    public int AddDepartment(Departments departments) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        departments.setCreateTime(date);
        return departmentsMapper.AddDepartment(departments);
    }

    @Override
    public int updateDepartment(Departments departments) {
        return departmentsMapper.updateDepartment(departments);
    }

    @Override
    public PageInfo<Departments> searchByAdmin(String key,int pageNum,int pageSize) {
        Page<Object> page=PageHelper.startPage(pageNum,pageSize);
        List<Departments>list=departmentsMapper.searchByAdmin(key);
        PageInfo<Departments>info=new PageInfo<>(list);
        return info;
    }
}
