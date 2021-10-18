package com.task.address.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.address.dao.AddressDao;
import com.task.address.model.Address;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressDao addressDao;

	public void init() {
		addressDao = new AddressDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "" + request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "save":
				saveUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void saveUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			updateUser(request, response);
		} else {
			insertUser(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = "" + request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Address> listUser = addressDao.getUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/listAddress.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/addAddress.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Address existingUser = addressDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/addAddress.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String streetline1 = request.getParameter("streetline1");
		String streetline2 = request.getParameter("streetline2");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String state = request.getParameter("state");

		Address newUser = new Address();
		addressDao.addUser(newUser);
		response.sendRedirect("address");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String streetline1 = request.getParameter("streetline1");
		String streetline2 = request.getParameter("streetline2");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String state = request.getParameter("state");

		Address book = new Address();
		addressDao.updateUser(book);
		response.sendRedirect("address");
	}

}