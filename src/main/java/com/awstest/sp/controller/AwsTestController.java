package com.awstest.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awstest.sp.service.AwsTestService;
import com.awstest.sp.vo.AwsTestVO;

@Controller
public class AwsTestController {
	
	@Autowired
	private AwsTestService ats;
	
	@GetMapping("/awstests")
	public @ResponseBody List<AwsTestVO> getAwsTestList(){
		return ats.selectAwsTestList();
	}
}
