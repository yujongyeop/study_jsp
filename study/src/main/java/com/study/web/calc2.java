package com.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		ServletContext application = request.getServletContext(); application
		HttpSession session = request.getSession();
		String v_ = request.getParameter("v");
		String op = request.getParameter("button");
		int v = 0;
		if (v_ != null)
			v = Integer.parseInt(v_);
		int result = 0;
		// 계산
		if (op.equals("=")) {
//			int x = (Integer) application.getAttribute("value");
			int x = (Integer) session.getAttribute("value");
			int y = v;
			String operator = (String) session.getAttribute("op");
//			String operator = (String) application.getAttribute("op");
			if (operator.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}
			response.getWriter().printf("result is " + result);
		}
		// 저장
		else {
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}
	}
}