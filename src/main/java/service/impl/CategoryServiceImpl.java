package service.impl;

import entity.Category;
import service.CategoryService;
import dao.CategoryMapper;
// 导入我们新建的工具类
import util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> getAllCategories() {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {

			// 1. 获取 Mapper 接口的实现
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

			// 2. 执行查询并返回结果
			return categoryMapper.selectAllCategories();

		} catch (Exception e) {
			// 实际项目中应该记录日志
			e.printStackTrace();
			// 抛出运行时异常或返回空列表，取决于业务需求
			return null;
		}
	}

	@Override
	public void deleteCategory(int id) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
			categoryMapper.deleteCategory(id);
			sqlSession.commit();
		} catch (Exception e) {
			// In a real project, you should log this exception
			e.printStackTrace();
		}
	}

	@Override
	public void addCategory(Category category) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
			categoryMapper.addCategory(category);
			sqlSession.commit();
		} catch (Exception e) {
			// In a real project, you should log this exception
			e.printStackTrace();
		}
	}

	@Override
	public void editCategory(Category category) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
			categoryMapper.editCategory(category);
			sqlSession.commit();
		} catch (Exception e) {
			// In a real project, you should log this exception
			e.printStackTrace();
		}
	}

	@Override
	public Category getCategoryById(int id) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
			return categoryMapper.selectCategoryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> searchCategories(String keyword) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
			return categoryMapper.selectCategoryListByWord(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}