package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.Illness;

import java.util.List;


public interface IllnessMapper {
    Illness selectIllnessById(int illnessId);//获取对应疾病的信息(疾病页)

    List<Illness> selectAllIllness();//获取全部疾病（首页）

    List<Illness> selectIllnessByName(String key);//根据名称模糊查询（查询页）

    int addIllness(Illness illness);//新增疾病信息(管理员)

    int updateIllnessById(Illness illness);//修改疾病信息(管理员)

    int deleteIllnessById(int illnessId);//根据id删除疾病信息(管理员)

    List<Illness>queryIllnessByAdmin(String key);//查询全部疾病(管理员)
}
