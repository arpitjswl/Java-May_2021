package com.arpit.corejava;

import java.sql.SQLException;

public class ExceptionHandling {

	public static void main(String[] args) {
		BankData obj = new BankData();
		try {
			System.out.println(obj.getUpdatedBalance(-100));
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("After exec");
	}

}


class BankData{
	
	public Long getUpdatedBalance(int amount) throws SQLException {
		if (amount < 0)
			throw new ArithmeticException();
		return amount + 1L;
	}
}