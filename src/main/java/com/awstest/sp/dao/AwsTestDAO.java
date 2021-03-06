package com.awstest.sp.dao;

import java.util.List;

import com.awstest.sp.vo.AwsTestVO;

public interface AwsTestDAO {
	public List<AwsTestVO> selectAwsTestList();
	public AwsTestVO selectAwsTest(int atnum);
	public Integer insertAwsTest(AwsTestVO aws);
	public Integer updateAwsTest(AwsTestVO aws);
	public Integer deleteAwsTest(int atnum);
}
