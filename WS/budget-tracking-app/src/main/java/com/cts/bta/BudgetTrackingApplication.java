package com.cts.bta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cts.bta.dao.AccountHolderDao;
import com.cts.bta.dao.AccountHolderDaoImpl;
import com.cts.bta.entities.AccountHolder;
import com.cts.bta.exceptions.BTAException;

public class BudgetTrackingApplication {

	public static void main(String[] args) {
		AccountHolderDao dao = new AccountHolderDaoImpl();
		try {
			System.out.println(dao.getAll());
		} catch (BTAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
