package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.DoctorMapper;
import com.ccsu.clouddoctor.pojo.Doctor;
import com.ccsu.clouddoctor.service.DoctorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public PageInfo<Doctor> selectByDpm(String departmentBig, int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Doctor> list=doctorMapper.selectByDpm(departmentBig);
        PageInfo<Doctor> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public List<String> getRecommend() {
        return doctorMapper.getRecommend();
    }

    @Override
    public List<Doctor> selectByRecommend(String departmentBig) {
        return doctorMapper.selectByRecommend(departmentBig);
    }

    @Override
    public List<Doctor> selectDoctorByName(String key) {
        return doctorMapper.selectDoctorByName(key);
    }

    @Override
    public PageInfo<Doctor> queryDoctorByDpm(String dpm,int pageNum,int pageSize,String orderBy) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Doctor>list=doctorMapper.queryDoctorByDpm(dpm);
        PageInfo<Doctor>info=new PageInfo<>(list);
        return info;
    }

    @Override
    public Doctor getDoctorInfoById(int doctorId) {
        return doctorMapper.getDoctorInfoById(doctorId);
    }

    @Override
    public int updateDoctorTag(int doctorId, int tag) {
        return doctorMapper.updateDoctorTag(doctorId,tag);
    }

    @Override
    public PageInfo<Doctor> selectAllDoctor(int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Doctor>list=doctorMapper.selectAllDoctor();
        PageInfo<Doctor>info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int addDoctor(Doctor doctor) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        doctor.setCreateTime(date);
        return doctorMapper.addDoctor(doctor);
    }

    @Override
    public int deleteDoctorById(int doctorId) {
        return doctorMapper.deleteDoctorById(doctorId);
    }

    @Override
    public int updateDoctor(Doctor doctor) {
        return doctorMapper.updateDoctor(doctor);
    }

    @Override
    public PageInfo<Doctor> selectDoctorByAdmin(String key, int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Doctor>list=doctorMapper.selectDoctorByAdmin(key);
        PageInfo<Doctor>info=new PageInfo<>(list);
        return info;
    }
}
