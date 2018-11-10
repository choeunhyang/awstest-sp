package com.awstest.sp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.awstest.sp.dao.AwsTestDAO;
import com.awstest.sp.vo.AwsTestVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class DBTest {
	
	

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private AwsTestDAO atdao;
	
	@Test
	public void test() throws SQLException {
		Connection con = ds.getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from aws_test");
		while(rs.next()) {
			log.info(rs.getString("atname"));
		}
		assertNotNull(con);
	}
	
	@Test
	public void test2() {
//		List<Map<String,String>> atList = ss.selectList("com.awstest.sp.AWSTEST.selectAWSTEST"); //이러면 xml가서 리졀트타입을 Map으로 바꿔줘야함. vo 없이 할수 있다.
//		assertEquals(5,	atList.size());
//		log.info("atList => {}",atList);
		List<AwsTestVO> atList = ss.selectList("com.awstest.sp.AWSTEST.selectAWSTESTList");
//		assertEquals(5,	atList.size());
		log.info("atList => {}",atList);
	}
	
	@Test
	public void test3() {
		AwsTestVO aws = ss.selectOne("com.awstest.sp.AWSTEST.selectAWSTEST",2);
		assertNotNull(aws);
		
		aws.setAtname("냐옹");
		aws.setAtage(20);
		assertEquals(1, ss.update("com.awstest.sp.AWSTEST.updateAWSTEST",aws));
	
		aws = ss.selectOne("com.awstest.sp.AWSTEST.selectAWSTEST",2); // 업데이트한 내용이 맞는지 확인
		assertEquals("냐옹",aws.getAtname());
		
//		assertEquals(1, ss.delete("com.awstest.sp.AWSTEST.deleteAWSTEST",1));	// 지우고
		
//		assertEquals(1, ss.insert("com.awstest.sp.AWSTEST.insertAWSTEST",aws)); //다시 만든다.;
		
	}
	
	@Test
	public void test4() {
		assertEquals(2, atdao.selectAwsTestList().size());
	}
}
