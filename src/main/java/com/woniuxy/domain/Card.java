package com.woniuxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Integer cid;

    private Integer uid;

    private String cfront;

    private String cback;

    private Integer cstate;
     
}