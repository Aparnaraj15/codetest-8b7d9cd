package com.aparna.jdvu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String userEnteredInt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		userEnteredInt = request.getParameter("login");

		response.getWriter().println("<p> The number entered is: " + userEnteredInt + "<p>");
		
		IsTenSubstrings obj = new IsTenSubstrings();

		if (!obj.isInteger(userEnteredInt)) {
			response.getWriter().println("NOT A Valid integer.");
			
		}
		else if(Integer.parseInt(userEnteredInt)<0)
		{
			response.getWriter().println("Integer should be positive.");
		}
		else 
		{

			ArrayList<Integer> friends = IsTenSubstrings.getFriends(Integer.parseInt(userEnteredInt));
			response.getWriter().println("[");
			boolean first = true;
			for (int i : friends) {
				if (first) {
					response.getWriter().println(i);
					first = false;
				} else
					response.getWriter().println(", " + i);
			}
			response.getWriter().println("]");
		}


	}

}
