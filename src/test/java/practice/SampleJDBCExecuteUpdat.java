package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class SampleJDBCExecuteUpdat {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		Driver driverref=new Driver();
		
		//step1:register Driver
			
		
		DriverManager.registerDriver(driverref);
		
		//step2:get connection
		
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db ", "root", "root");
		 
		
		
		//step3:issue create statement
		
		Statement state = con.createStatement();
		
		//step4:execute a query
		
		
		String query= "insert into candidateinfo values('Kusuma',05,'Gorantla');";
		
		int result = state.executeUpdate(query);
		if(result>=1) {
			
			System.out.println("data added");
			
		}
		
		
		ResultSet resul = state.executeQuery("select * from candidateinfo");
		while(resul.next()) {
			System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
			
		}
		
		con.close();
		
		System.out.println("db closed");
		
			}
		}


