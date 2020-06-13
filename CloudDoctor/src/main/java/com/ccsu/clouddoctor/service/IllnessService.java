package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.Illness;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IllnessService {
    Illness selectIllnessById(int illnessId);//获取对应疾病的信息
    PageInfo<Illness> selectAllIllness(int pageNum,int pageSize);//获取全部疾病
    List<Illness> selectIllnessByName(String key);//根据名称模糊查询
    int addIllness(Illness illness);//新增疾病信息(管理员)
    int updateIllnessById(Illness illness);//修改疾病信息(管理员)
    int deleteIllnessById(int illnessId);//根据id删除疾病信息(管理员)
    PageInfo<Illness>queryIllnessByAdmin(String key,int pageNum,int pageSize);//查询全部疾病(管理员)
}
