package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.CategoryServiceImpl;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteCategoryServlet extends HttpServlet {
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryService.deleteCategory(id);
		response.sendRedirect(request.getContextPath() + "/");
	}
}