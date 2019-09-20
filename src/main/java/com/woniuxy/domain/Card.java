package com.woniuxy.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable{
    /**
	 *  
	 */

	private Integer cid;

    private User user;
    
    private Integer uid;

    private String cfront;

    private String cback;

    private Integer cstate;
    
}