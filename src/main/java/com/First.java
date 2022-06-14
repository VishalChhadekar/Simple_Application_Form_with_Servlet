package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * PrintWriter out = response.getWriter();
	 * out.println("This is service method"); out.println("Date and Time: "+ new
	 * Date(0).toString()); }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to the registation services</h1>");
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String emial = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");

		String cond = request.getParameter("condition");
		if (cond != null) {
			if (cond.equals("checked")) {
				out.println("<h2>Name : " + name + "</h2>");
				out.println("<h2>Password : " + password + "</h2>");
				out.println("<h2>Email : " + emial + "</h2>");
				out.println("<h2>Gender : " + gender + "</h2>");
				out.println("<h2>Selected Course : " + course + "</h2>");
				
				//forwarding request to another servlet
				RequestDispatcher rd = request.getRequestDispatcher("Success");
				rd.forward(request, response);
			} else {
				out.println("<h2>You have not accpeted terms and conditions</h2>");
			}

		}else {
			out.println("<h2>You have not accpeted terms and conditions</h2>");
			
			//to include response of other servlet
			RequestDispatcher rd = request.getRequestDispatcher("index.html");//url of file
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { PrintWriter out =
	 * response.getWriter(); out.println("This is doPost"); }
	 */

}
