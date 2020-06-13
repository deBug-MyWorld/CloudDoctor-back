package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.FavoriteMapper;
import com.ccsu.clouddoctor.pojo.Favorite;
import com.ccsu.clouddoctor.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Override
    public int addFavorite(Favorite favorite) {
        return favoriteMapper.addFavorite(favorite);
    }

    @Override
    public int deleteFavoriteById(int favoriteId) {
        return favoriteMapper.deleteFavoriteById(favoriteId);
    }

    @Override
    public List<Favorite> queryFavoriteByUsername(String username) {
        return favoriteMapper.queryFavoriteByUsername(username);
    }

    @Override
    public Favorite selectFavoriteFlag(int doctorId, String username) {
        return favoriteMapper.selectFavoriteFlag(doctorId,username);
    }

    @Override
    public int deleteFavorite(int doctorId, String username) {
        return favoriteMapper.deleteFavorite(doctorId,username);
    }
}
