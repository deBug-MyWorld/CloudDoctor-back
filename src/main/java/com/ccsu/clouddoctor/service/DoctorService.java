package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.Doctor;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorService {
    PageInfo<Doctor> selectByDpm(String departmentBig,int pageNum,int pageSize);//查询大科室下的免费医生

    List<String> getRecommend();//获取推荐的科室

    List<Doctor> selectByRecommend(String departmentBig);//查询推荐医生

    List<Doctor> selectDoctorByName(String key);//模糊查询医生信息

    PageInfo<Doctor> queryDoctorByDpm(String dpm,int pageNum,int pageSize,String orderBy);//根据大科室或者小科室查询医生

    Doctor getDoctorInfoById(int doctorId);//根据医生id查询该医生的全部信息

    int updateDoctorTag(@Param("doctorId") int doctorId, @Param("tag") int tag);//根据医生id更新他在线状态


    PageInfo<Doctor>selectAllDoctor(int pageNum,int pageSize);//获取全部医生信息(管理员)

    int addDoctor(Doctor doctor);//新增一名医生(管理员)

    int deleteDoctorById(int doctorId);//根据医生Id删除医生(管理员)

    int updateDoctor(Doctor doctor);//编辑一名医生(管理员)

    PageInfo<Doctor>selectDoctorByAdmin(String key,int pageNum,int pageSize);//模糊查询医生全部信息(管理员)
}
