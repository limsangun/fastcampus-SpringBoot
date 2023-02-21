//package com.study.restaurant.naver;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.PropertySource;
//
//import com.study.restaurant.naver.dto.SearchLocalReq;
//import com.study.restaurant.naver.dto.SearchLocalRes;
//
//import lombok.extern.slf4j.Slf4j;
//
//@SpringBootTest
//@PropertySource(value = "application.yaml")
//public class NaverClientTest {
//
//	@Autowired
//	private NaverClient naverClient;
//	
//	@Test
//	public void localSearchTest() {
//		
//		var search = new SearchLocalReq();
//		search.setQuery("갈비집");
//		
//		var result = naverClient.localSearch(search);
//		System.out.println(result);
//	}
//}
