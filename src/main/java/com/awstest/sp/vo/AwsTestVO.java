package com.awstest.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("awstest")
@Data
public class AwsTestVO {
	private int atnum;
	private String atname;
	private int atage;
}
