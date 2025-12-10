package dao;

import entity.Category;
import java.util.List;

public interface CategoryMapper {
    List<Category> selectAllCategories();
    void deleteCategory(int id);
    void addCategory(Category category);
    void editCategory(Category category);
    Category selectCategoryById(int id);
    List<Category> selectCategoryListByWord(String keyword);
}
