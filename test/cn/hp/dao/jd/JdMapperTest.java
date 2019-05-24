package cn.hp.dao.jd;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.hp.entity.Jd;
import cn.hp.utils.MyBatisUtil;

class JdMapperTest {
	private static Logger logger = Logger.getLogger(JdMapperTest.class);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void selectAllTest() {
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.selectOne("cn.hp.dao.jd.JdMapper.count");
			logger.debug("------"+count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void listAllTest() {
		SqlSession sqlSession = null;
		List<Jd> jdList = new  ArrayList<Jd>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			jdList = sqlSession.selectList("cn.hp.dao.jd.JdMapper.ListAll");
			for(Jd u : jdList) {
				logger.debug("-----"+u.getXh() + "-----" + u.getMoney());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void listAllTestOne() {
		SqlSession sqlSession = null;
		List<Jd> jdList = new  ArrayList<Jd>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			jdList = sqlSession.getMapper(JdMapper.class).ListAll();
			for(Jd u : jdList) {
				logger.debug("--型号--"+u.getXh() + "---出厂价格---" + u.getMoney() + "---出厂日期 "+ u.getDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}

}
