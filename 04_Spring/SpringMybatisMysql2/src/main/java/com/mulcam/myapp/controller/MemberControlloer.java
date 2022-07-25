package com.mulcam.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.mulcam.myapp.service.MemberService;

@Controller
public class MemberControlloer {
	@Inject
	MemberService service;

}
