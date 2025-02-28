package com.ezen.shop.review;

import java.time.LocalDateTime;
import java.util.List;

import com.ezen.shop.admin.product.ProductVO;

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
	
	
	private ProductVO product;
	
	
	// review_tbl테이블과 review_replies_tbl테이블(1:N관계)
	// left outer join
	// mybatis의 collection문법사용
	private List<ReviewReply> replies; // 추가
}
