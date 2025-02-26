package com.ezen.shop.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.shop.common.utils.PageMaker;
import com.ezen.shop.common.utils.SearchCriteria;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 리뷰 : 상품상세페이지에서 사용목적. REST API 개발형태로 작업
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/*")  // /review로 시작하는 모든주소는 ReviewController 클래스가 처리한다.
public class ReviewController {

	private final ReviewService reviewService;
	
	// 자바스크립트로 작업하기 이전에 테스트를 postman 툴로 확인해본다.
	// 1)상품후기목록- List<ReviewVO)  2)페이징 데이타 작업 PageMaker 2가지를 하나의 Map으로 관리
	@GetMapping("/rev_list/{pro_num}/{page}")  // /rev_list/pages/20/1
	public ResponseEntity<Map<String, Object>> rev_list(@PathVariable("pro_num") Integer pro_num, @PathVariable("page") int page) throws Exception {
		
		log.info("상품코드: " + pro_num);
		log.info("페이지: " + page);
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		//1)상품후기목록
		SearchCriteria cri = new SearchCriteria();
		cri.setPerPageNum(10);
		cri.setPage(page);
		
		List<ReviewVO> rev_list = reviewService.rev_list(pro_num, cri);
		
		//2)페이징정보 : 개수
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(reviewService.getCountReviewByPro_num(pro_num));
		
		// key가 자바스크립트의 ajax 변수에서 참조한다.
		map.put("rev_list", rev_list);
		map.put("pageMaker", pageMaker);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
}
