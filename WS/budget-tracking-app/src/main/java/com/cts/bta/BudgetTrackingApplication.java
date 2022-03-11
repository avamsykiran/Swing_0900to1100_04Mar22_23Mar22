package com.cts.bta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BudgetTrackingApplication {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:sqlanywhere:uid=root;pwd=root;eng=MyDB")) {
			System.out.println("connected!");
		}catch(SQLException exp) {
			exp.printStackTrace();
		}
	}

}
