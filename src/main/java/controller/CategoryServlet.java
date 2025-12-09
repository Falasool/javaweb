package controller;

import entity.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {

	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		if (pathInfo != null && pathInfo.equals("/delete")) {
			handleDelete(request, response);
		} else {
			handleList(request, response);
		}
	}

	private void handleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/categoryList.jsp").forward(request, response);
	}

	private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// redirect to homepage
			categoryService.deleteCategory(id);
		} catch (NumberFormatException e) {
			// Handle error: id is not a valid number
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath());
	}
}
