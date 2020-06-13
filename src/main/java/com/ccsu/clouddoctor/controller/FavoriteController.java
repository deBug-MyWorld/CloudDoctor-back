package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Favorite;
import com.ccsu.clouddoctor.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/addFavorite")
    @ResponseBody
    public int addFavorite(Favorite favorite){
        return favoriteService.addFavorite(favorite);
    }

    @RequestMapping("/deleteFavoriteById")
    @ResponseBody
    public int deleteFavoriteById(@RequestParam("favoriteId") int favoriteId){
        return favoriteService.deleteFavoriteById(favoriteId);
    }

    @RequestMapping("/queryFavoriteByUsername")
    @ResponseBody
    public List<Favorite> queryFavoriteByUsername(@RequestParam("username") String username){
        return favoriteService.queryFavoriteByUsername(username);
    }
    @RequestMapping("/selectFavoriteFlag")
    @ResponseBody
    public Favorite selectFavoriteFlag(@RequestParam("doctorId")int doctorId,@RequestParam("username")String username){
        return favoriteService.selectFavoriteFlag(doctorId,username);
    }

    @RequestMapping("/deleteFavorite")
    @ResponseBody
    public int deleteFavorite(@RequestParam("doctorId")int doctorId,@RequestParam("username")String username){
        return favoriteService.deleteFavorite(doctorId,username);
    }
}
