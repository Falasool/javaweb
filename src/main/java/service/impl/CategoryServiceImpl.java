package service.impl;

import entity.Category;
import service.CategoryService;
import dao.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private SqlSessionFactory sqlSessionFactory;

    public CategoryServiceImpl() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        SqlSession sqlSession = null;
        List<Category> categories = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
            categories = categoryMapper.selectAllCategories();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return categories;
    }
}
