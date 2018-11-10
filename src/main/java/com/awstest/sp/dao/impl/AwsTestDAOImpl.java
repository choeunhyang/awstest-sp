package com.awstest.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.awstest.sp.dao.AwsTestDAO;
import com.awstest.sp.vo.AwsTestVO;

@Repository
public class AwsTestDAOImpl implements AwsTestDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<AwsTestVO> selectAwsTestList() {
		return ss.selectList("com.awstest.sp.AWSTEST.selectAWSTESTList");
	}

	@Override
	public AwsTestVO selectAwsTest(int atnum) {
		return ss.selectOne("com.awstest.sp.AWSTEST.selectAWSTEST",atnum);
	}

	@Override
	public Integer insertAwsTest(AwsTestVO aws) {
		return ss.insert("com.awstest.sp.AWSTEST.insertAWSTEST",aws);
	}

	@Override
	public Integer updateAwsTest(AwsTestVO aws) {
		return ss.update("com.awstest.sp.AWSTEST.updateAWSTEST",aws);
	}

	@Override
	public Integer deleteAwsTest(int atnum) {
		return ss.delete("com.awstest.sp.AWSTEST.deleteAWSTEST",atnum);
	}

}
