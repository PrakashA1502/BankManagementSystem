package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess
{
  private static final String dburl= "jdbc:mysql://localhost:3306/customerDetails";
  private static final String dbusername ="root";
  private static final String dbpassword ="PrakashA4$";
  
  private static Connection  con =null;
 // private static  Statement stm =null;
  private static PreparedStatement ps =null;
  private static ResultSet rs = null;
  
  private static final String insertqry="insert into "
  		+ "customer(name, email, mobile, password, state)values(?,?,?,?,?)"; //Dynamic Query
  
  private static final String validateqry="select email,password from customer"
  		+ " where email=? and password=?";
  
  public static boolean ValidateCustomer(String email, String pass) 
  {
	  boolean b = false;
	  try
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con =DriverManager.getConnection(dburl,dbusername ,dbpassword);
		
		ps=con.prepareStatement(validateqry);
		ps.setString(1, email);
		ps.setString(2, pass);
		
		rs=ps.executeQuery();
		
		
	   b = rs.next();
	    
	   String e= rs.getString("email");
	   String p= rs.getString("password");
	   
	   if(e.equals(email) && p.equals(pass)) 
	   {
		   b = true;
	   }
	   
	}
	  catch (ClassNotFoundException e) 
	  {
		e.printStackTrace();
	  }
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
	  {
		  try
		  {
			  if(rs != null)  
			  {
				rs.close();
			  }
			  if(ps != null)  
			  {
				ps.close();
			  }
			  if(con != null) 
			  {
				  con.close();
			  }
		  } 
			  catch (SQLException e)
			  {
				e.printStackTrace();
			  }
		  }
	return b; 
  }
  
  public static void insertCustomer(Customer c) 
  {
	  try
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con =DriverManager.getConnection(dburl,dbusername ,dbpassword);
		
		ps=con.prepareStatement(insertqry);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setLong(3, c.getMobile());
		ps.setString(4, c.getPassword());
		ps.setString(5, c.getState());
		
		ps.executeUpdate();
	  } 
	  catch (ClassNotFoundException e) 
	  {
		e.printStackTrace();
	  }
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
	  {
		  try
		  {
			  if(ps != null)  
			  {
				ps.close();
			  }
			  if(con != null) 
			  {
				  con.close();
			  }
		  } 
			  catch (SQLException e)
			  {
				e.printStackTrace();
			  }
		  }
	  }
  }

