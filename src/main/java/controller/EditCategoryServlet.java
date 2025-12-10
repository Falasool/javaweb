package controller;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/edit")
public class EditCategoryServlet extends HttpServlet {
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = categoryService.getCategoryById(id);

		request.setAttribute("category", category);
		request.getRequestDispatcher("/editCategory.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("categoryName");
		String createTime = request.getParameter("createTime");

		Category c = new Category();
		c.setId(id);
		c.setCategoryName(name);
		c.setCreateTime(LocalDateTime.parse(createTime));

		categoryService.editCategory(c);

		// 更新完成回首页
		response.sendRedirect(request.getContextPath() + "/");
	}

}