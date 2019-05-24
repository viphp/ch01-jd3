package cn.hp.dao.jd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.hp.entity.Provider;
import cn.hp.utils.MyBatisUtil;

class ProviderMapperTest {
	private Logger logger = Logger.getLogger(ProviderMapperTest.class);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	//第一种方式
	public void ListAllTestOne() {
		SqlSession sqlSession = null;
		List<Provider> uList = new ArrayList<Provider>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			uList = sqlSession.selectList("cn.hp.dao.jd.ProviderMapper.ListAll");
			for(Provider u : uList) {
				logger.debug("---"+u.getProName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	//第二种方式
		public void ListAllTestTwo() {
			SqlSession sqlSession = null;
			List<Provider> uList = new ArrayList<Provider>();
			try {
				sqlSession = MyBatisUtil.createSqlSession();
				uList = sqlSession.getMapper(ProviderMapper.class).ListAll();
				for(Provider u : uList) {
					logger.debug("---"+u.getProName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MyBatisUtil.closeSqlSession(sqlSession);
			}
		}

}
