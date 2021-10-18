package com.task.address.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.address.model.Address;



public class AddressDao {
	public static List<Address> UserList = new ArrayList<Address>();

	public AddressDao() {
	}

	public void addUser(Address address) {
		Random rand = new Random();
		int useID = rand.nextInt(1000);
		address.setId(useID);
		UserList.add(address);
	}

	public Address selectUser(int id) {
		Address userFinal = null;
		for (Address address : UserList) {
			if (address.getId() == id) {
				userFinal = address;
				break;
			}
		}
		return userFinal;
	}

	public List<Address> getUsers() {

		return UserList;
	}

	

	public boolean updateUser(Address updatedUser) {
		boolean updateStatus = false;
		for (Address address :UserList) {
			
			if (address.getId() == updatedUser.getId()) {
				address.setCountry(updatedUser.getCountry());
				address.setEmail(updatedUser.getEmail());
				address.setName(updatedUser.getName());
				address.setStreetline1(updatedUser.getStreetline2());
				address.setStreetline1(updatedUser.getStreetline2());
				address.setCity(updatedUser.getCity());
				address.setPin(updatedUser.getPin());
				address.setState(updatedUser.getState());
				
				
				
				updateStatus = true;
				break;

			}
		}

		return updateStatus;
	}

	

}
