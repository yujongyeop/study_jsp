package com.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class calculator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		String exp = "0";
		if (cookies != null) {
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		}
		out.write("<!DOCTYPE html>");
		out.write("<html>");

		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<link rel=\"stylesheet\" href=\"calc3.css\">");
		out.write("</head>");

		out.write("<body>");
		out.write("<div>");
		out.write("<form method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"CE\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"C\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"←\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"/\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"7\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"8\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"9\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"*\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"4\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"5\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"6\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"-\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"1\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"2\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"3\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"+\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"button\" type=\"submit\" value=\" \" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"0\" /></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\".\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"=\" /></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</form>");
		out.write("</div>");
		out.write("</body>");

		out.write("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");// 삭제됨
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
		expCookie.setPath("/study/calculator");
		response.addCookie(expCookie);
		response.sendRedirect("calculator");
	}
}