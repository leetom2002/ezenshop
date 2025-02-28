package com.ezen.shop.admin.review;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ezen.shop.common.utils.SearchCriteria;
import com.ezen.shop.review.ReviewVO;

import lombok.RequiredArgsConstructor;


// 비지니스 로직작업 목적
@RequiredArgsConstructor
@Service
public class AdReviewService {

	private final AdReviewMapper adReviewMapper;
	
	public List<ReviewVO> review_list(SearchCriteria cri, String rev_rate, String rev_content) {
		return adReviewMapper.review_list(cri, rev_rate, rev_content);
	}
	
	public int review_count(SearchCriteria cri, String rev_rate, String rev_content) {
		return adReviewMapper.review_count(cri, rev_rate, rev_content);
	}
}
