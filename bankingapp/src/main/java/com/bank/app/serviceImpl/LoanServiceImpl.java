package com.bank.app.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.bank.app.repo.UserRepo;


@Service
public class LoanServiceImpl {

	private static final Logger log = LogManager.getLogger(LoanServiceImpl.class);

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private UserRepo userRepo;

	private String sampleDBConnection() {
        
		//Getting the singleton bean
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		//Getting the connection frome the bean
		try (Connection connection = dataSource.getConnection()) {
			
			String sqlQuery = "SELECT k FROM KycDoc k WHERE k.documentType = ? AND k.userObj = ?";
			
			//preparing statement to get execute in database
		    PreparedStatement query = connection.prepareStatement(sqlQuery);
		    
		    query.setString(1, "AADHAAR");  // Set the first parameter
		    query.setObject(2, userRepo.findByUserId(1L));       // Set the second parameter

		    ResultSet resultSet = query.executeQuery();
		    while (resultSet.next()) {
		        // Process the results
		    }
		} catch (SQLException e) {
		    log.error("SQL Exception occurred", e);
		}
		return null;
	}

}
