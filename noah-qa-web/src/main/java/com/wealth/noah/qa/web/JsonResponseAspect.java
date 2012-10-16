package com.wealth.noah.qa.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
public class JsonResponseAspect {
	
	@Pointcut("execution(public org.springframework.http.ResponseEntity<String> com.wealth.noah.qa.web.*Controller.* (..))")
	public void jsonResponse() {}
	
	@Around("com.wealth.noah.qa.web.JsonResponseAspect.jsonResponse()")
	public ResponseEntity<String> setJsonResponseHeaders(ProceedingJoinPoint joinPoint) throws Throwable {
		ResponseEntity<?> r = (ResponseEntity<?>) joinPoint.proceed();
		HttpStatus status = r.getStatusCode();
		String body = r.getBody().toString();
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
		ResponseEntity<String> response = new ResponseEntity<String>(body, headers, status);
		return response;
	}
}
