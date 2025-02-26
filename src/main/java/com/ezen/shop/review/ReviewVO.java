package com.ezen.shop.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {

	private Long rev_code;
	private String mbsp_id;
	private Integer pro_num;
	private String rev_content;
	private int rev_rate;
	private LocalDateTime rev_date;
}
