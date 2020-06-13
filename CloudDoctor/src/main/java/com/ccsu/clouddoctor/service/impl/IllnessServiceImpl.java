package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.IllnessMapper;
import com.ccsu.clouddoctor.pojo.Illness;
import com.ccsu.clouddoctor.service.IllnessService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    private IllnessMapper illnessMapper;
    @Override
    public Illness selectIllnessById(int illnessId) {
        return illnessMapper.selectIllnessById(illnessId);
    }

    @Override
    public PageInfo<Illness> selectAllIllness(int pageNum,int pageSize) {
        Page<Object> page=PageHelper.startPage(pageNum,pageSize);
        List<Illness> list=illnessMapper.selectAllIllness();
        PageInfo<Illness>info = new PageInfo<>(list);
        return info;
    }

    @Override
    public List<Illness> selectIllnessByName(String key) {
        return illnessMapper.selectIllnessByName(key);
    }


    @Override
    public int addIllness(Illness illness) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        illness.setCreateTime(date);
        return illnessMapper.addIllness(illness);
    }

    @Override
    public int updateIllnessById(Illness illness) {
        return illnessMapper.updateIllnessById(illness);
    }

    @Override
    public int deleteIllnessById(int illnessId) {
        return illnessMapper.deleteIllnessById(illnessId);
    }

    @Override
    public PageInfo<Illness> queryIllnessByAdmin(String key, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Illness>list=illnessMapper.queryIllnessByAdmin(key);
        PageInfo<Illness>info=new PageInfo<>(list);
        return info;
    }
}
