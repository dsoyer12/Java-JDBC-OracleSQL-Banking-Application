package com.revature.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ACC_BALANCETest {

	
	@Test
	void test() throws SQLException, IOException {
		ACC_BALANCE.getBalance(10026);
		
		ACC_BALANCE.DepositBalance(1000,10020);
		ACC_BALANCE.withdrawBalance(10000, 10020);
		
	}

}
