package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FieldAppEngine extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DummyDB db = new DummyDB();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		List<String> matches = db.getData(name);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Match</TITLE></HEAD>");
		Iterator<String> iterator = matches.iterator();

		out.println("<BODY>");
		out.println("Match: ");
		while(iterator.hasNext()) {
			String match = (String)iterator.next();
			out.println(match);
		}
		out.println("</BODY></HTML>");
	}

	public String getServletInfo() {
		return "A servlet that knows the name of the person to whom it's" + "saying hello";
	}
}