package dao;

import entity.Category;
import java.util.List;

public interface CategoryMapper {
    List<Category> selectAllCategories();
    void deleteCategory(int id);
}
