package com.task.demo.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.task.demo.model.demoUser;


/**
 * 
 * 
 * @author property of trisysit.com
 *
 */
public class demoUserDao {
	public static List<demoUser> demoUserList = new ArrayList<demoUser>();

	public demoUserDao() {
	}

	public void addUser(demoUser demouser) {
		Random rand = new Random();
		int useID = rand.nextInt(1000);
		demouser.setId(useID);
		demoUserList.add(demouser);
	}

	public demoUser selectUser(int id) {
		demoUser userFinal = null;
		for (demoUser demouser : demoUserList) {
			if (demouser.getId() == id) {
				userFinal = demouser;
				break;
			}
		}
		return userFinal;
	}

	public List<demoUser> getUsers() {

		return demoUserList;
	}

	

	public boolean demoupdateUser(demoUser demoupdatedUser) {
		boolean updateStatus = false;
		for (demoUser demouser : demoUserList) {
			if (demouser.getId() == demoupdatedUser.getId()) {
				demouser.setCountry(demoupdatedUser.getCountry());
				demouser.setEmail(demoupdatedUser.getEmail());
				demouser.setName(demoupdatedUser.getName());
				demouser.setStreetline1(demoupdatedUser.getStreetline2());
				demouser.setStreetline1(demoupdatedUser.getStreetline2());
				demouser.setCity(demoupdatedUser.getCity());
				demouser.setPin(demoupdatedUser.getPin());
				demouser.setState(demoupdatedUser.getState());
				
				
				
				updateStatus = true;
				break;

			}
		}

		return updateStatus;
	}

	

}


