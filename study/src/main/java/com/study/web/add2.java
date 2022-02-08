package com.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int result = 0;
		String[] num_ = request.getParameterValues("num");
		for (int i = 0; i < num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
