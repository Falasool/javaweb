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
}
