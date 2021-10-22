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
				saveAddress(request, response);
				break;
			default:
				listAddress(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void saveAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			updateAddress(request, response);
		} else {
			insertAddress(request, response);
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
				listAddress(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAddress(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Address> listAddress = addressDao.selectAllAddresses();
		request.setAttribute("listAddress", listAddress);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/listAddress.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("address/addAddress.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Address existingAddress = addressDao.selectAddress(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("address/addAddress.jsp");
		request.setAttribute("address", existingAddress);
		dispatcher.forward(request, response);

	}

	private void insertAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String streetline1 = request.getParameter("streetline1");
		String streetline2 = request.getParameter("streetline2");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String state = request.getParameter("state");

		Address newAddress = new Address();
		addressDao.insertAddress(newAddress);
		response.sendRedirect("address");
	}

	private void updateAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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
		addressDao.updateAddress(book);
		response.sendRedirect("address");
	}

}