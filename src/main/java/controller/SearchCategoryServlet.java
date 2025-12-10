package controller;/*
 *@title SearchCategoryServlet
 *@description
 *@author pika
 *@version 1.0
 *@create 2025/12/11 00:42
 */

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * @author pika
 * @date 2025/12/11
 * @description description
 */
@WebServlet("/search")
public class SearchCategoryServlet extends HttpServlet {
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Category> categories  = categoryService.searchCategories(keyword);

		request.setAttribute("categories", categories);
		request.setAttribute("keyword", keyword); // 为回显用
		request.getRequestDispatcher("/categoryList.jsp").forward(request, response);
	}
}
