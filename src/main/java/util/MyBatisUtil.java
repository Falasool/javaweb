package util;/*
 *@title MyBatisUtil
 *@description
 *@author pika
 *@version 1.0
 *@create 2025/12/8 02:06
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类：负责初始化SqlSessionFactory并提供获取SqlSession的方法。
 */
public class MyBatisUtil {

	private static final SqlSessionFactory SQL_SESSION_FACTORY;
	private static final String RESOURCE = "mybatis-config.xml";

	static {
		try (InputStream inputStream = Resources.getResourceAsStream(RESOURCE)) {
			SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("✅ SqlSessionFactory 初始化成功！");
		} catch (IOException e) {
			System.err.println("❌ 初始化SqlSessionFactory失败，请检查 " + RESOURCE + " 配置。");
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * 获取一个新的SqlSession实例。
	 * 默认情况下，SqlSession的事务不会自动提交（需要手动调用commit()）。
	 * @return SqlSession实例
	 */
	public static SqlSession getSqlSession() {
		return SQL_SESSION_FACTORY.openSession();
	}

	/**
	 * 获取一个新的SqlSession实例，并指定是否自动提交事务。
	 * @param autoCommit true表示自动提交事务，false表示需要手动提交
	 * @return SqlSession实例
	 */
	public static SqlSession getSqlSession(boolean autoCommit) {
		return SQL_SESSION_FACTORY.openSession(autoCommit);
	}
}
