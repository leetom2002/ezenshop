package com.ezen.shop.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.shop.common.utils.SearchCriteria;

public interface ReviewMapper {

	List<ReviewVO> rev_list(@Param("pro_num") Integer pro_num, @Param("cri") SearchCriteria cri);
	
	// 페이징정보를 구성하기위한 상품후기 개수.
	int getCountReviewByPro_num(Integer pro_num);
}
