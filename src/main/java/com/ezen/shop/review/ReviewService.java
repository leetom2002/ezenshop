package com.ezen.shop.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.shop.common.utils.SearchCriteria;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	private final ReviewMapper reviewMapper;
	
	public List<ReviewVO> rev_list(Integer pro_num, SearchCriteria cri) {
		return reviewMapper.rev_list(pro_num, cri);
	}
	
	public int getCountReviewByPro_num(Integer pro_num) {
		return reviewMapper.getCountReviewByPro_num(pro_num);
	}
}
