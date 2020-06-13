package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    private int favoriteId;
    private String username;
    private String doctorIcon;
    private String doctorName;
    private int doctorId;
    private String goodAt;
}
