package cn.hp.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * @author HP
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static {//静态代码块下,factory只会被创建一次
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//创建sqlSession对象
	public static SqlSession createSqlSession() {
		return factory.openSession(false);  //true为自动提交事务
	}
	//关闭sqlSession
	public static void closeSqlSession(SqlSession sqlSession) {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
}
