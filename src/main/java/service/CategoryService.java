package service;/*
 *@title CategoryService
 *@description
 *@author pika
 *@version 1.0
 *@create 2025/12/6 09:10
 */

import entity.Category;

import java.util.List;

public interface CategoryService {
	List<Category> getAllCategories();

	void deleteCategory(int id);

	void addCategory(Category category);

	void editCategory(Category category);

	Category getCategoryById(int id);

	List<Category> searchCategories(String keyword);
}
