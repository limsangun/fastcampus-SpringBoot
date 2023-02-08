package com.study.filter.fliter;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 전처리
		
		ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
		ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
		
		
		chain.doFilter(httpServletRequest, httpServletResponse);
		
		String url = httpServletRequest.getRequestURI();
		
		// 후처리
		// req
		String reqContent = new String(httpServletRequest.getContentAsByteArray());
		log.info("response url : {}, requestBody : {}", url, reqContent);
		
		
		String resContent = new String(httpServletResponse.getContentAsByteArray());
		int httpStatus = httpServletResponse.getStatus();
		
		httpServletResponse.copyBodyToResponse();
		
		log.info("response status : {}, responseBody : {}", httpStatus, resContent);
	}

}
