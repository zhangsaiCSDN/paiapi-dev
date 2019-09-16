package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable{
    /**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	private Integer lig;

    private Integer uid;

    private Date ltime;

    private String loption;
 
}