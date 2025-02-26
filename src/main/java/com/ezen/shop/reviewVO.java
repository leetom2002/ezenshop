package com.ezen.shop;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class reviewVO {

	private Integer rev_code;
	private String mbsp_id;
	private Integer pro_num;
	private String rev_content;
	private int rev_rate;
	private LocalDateTime rev_date;   // Date 클래스대신 사용
}
