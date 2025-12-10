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

@WebServlet("/add")
public class AddCategoryServlet extends HttpServlet {
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		add(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		request.setCharacterEncoding("UTF-8");

		String categoryName	= request.getParameter("categoryName");
		LocalDateTime createTime = LocalDateTime.parse(request.getParameter("createTime"));

		Category c = new Category();
		c.setCategoryName(categoryName);
		c.setCreateTime(createTime);

		categoryService.addCategory(c);

		// 插入成功后重定向回首页（列表页）
		response.sendRedirect(request.getContextPath() + "/");
	}

}