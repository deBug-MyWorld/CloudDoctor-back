package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {
    //添加一条收藏信息
    int addFavorite(Favorite favorite);
    //根据favorite_id删除一条收藏信息
    int deleteFavoriteById(int favoriteId);
    //根据用户名查询收藏信息
    List<Favorite> queryFavoriteByUsername(String username);
    //根据医生id和用户名查询该医生是否被该用户收藏
    Favorite selectFavoriteFlag(@Param("doctorId") int doctorId,@Param("username") String username);
    //根据医生id和用户名删除一条收藏信息
    int deleteFavorite(@Param("doctorId") int doctorId,@Param("username") String username);
}
