package com.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;

@WebServlet("/calc3")
public class calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String value = request.getParameter("value");
		String op = request.getParameter("operator");
		String dot = request.getParameter("dot");
		String exp = "";
		if (cookies != null) {
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp += c.getValue();
					break;
				}
		}
		if (op != null && op.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");//삭제됨
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		} else if (op != null && op.equals("C")) {
			exp = "";
		} else {
			exp += (value == null) ? "" : value;
			exp += (op == null) ? "" : op;
			exp += (dot == null) ? "" : dot;
		}
		Cookie expCookie = new Cookie("exp", exp);
		if (op != null && op.equals("C"))
			expCookie.setMaxAge(0);
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
	}
}