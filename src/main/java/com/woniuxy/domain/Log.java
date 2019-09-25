package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ltime;

    private String loption;
    
    private User user;
 
}