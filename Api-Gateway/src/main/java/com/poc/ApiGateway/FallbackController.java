package com.poc.ApiGateway;

import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

public class FallbackController {
	
	@RequestMapping("/customerFallback")
	public Mono<String> customerServiceFallback(){
		return Mono.just("Customer Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/mainpageFallback")
	public Mono<String> mainServiceFallback(){
		return Mono.just("Mainpage Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/companyFallback")
	public Mono<String> companyServiceFallback(){
		return Mono.just("Company Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/bookingFallback")
	public Mono<String> bookingServiceFallback(){
		return Mono.just("Booking Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/couponFallback")
	public Mono<String> couponServiceFallback(){
		return Mono.just("Coupon Service is taking too long to respond or is down. Please try again later");
	}
}
