package controller;

import entity.Category;
import jakarta.servlet.annotation.WebServlet;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategories();
        // --- DEBUGGING ---
        System.out.println("Number of categories fetched from database: " + (categories != null ? categories.size() : "null"));
        // -----------------
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("categoryList.jsp").forward(request, response);
    }
}
