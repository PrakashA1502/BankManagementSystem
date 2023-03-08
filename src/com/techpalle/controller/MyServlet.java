package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path =request.getServletPath();
		
		switch(path) 
		{ 
		case"/logCustomer":
		{
			validateCustomer(request,response);
			break;
		}
		case"/regCustomer":
		{
			insertCustomer(request,response);
			break;
		}
	    case"/reg":
		{
		    getRegistrationPage(request,response);
		    break;
		}
		case"/log":
		{
			getLoginPage(request, response);
			break;
	    }
	    default:
	    {
	        getStartupPage(request, response);
	        break;
	    }
	    }
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		//Read the email and password from (login.jsp) page
		String email1=request.getParameter("tbemail");
		String pass1=request.getParameter("tbpass");
		
		//Call the method present in DAO
		boolean res =DataAccess.ValidateCustomer(email1, pass1);
		
		//Condition and Redirect user to destination page(success)
	  if(res)
	  {
		try 
		{
			RequestDispatcher rd1=request.getRequestDispatcher("success.jsp");
			//Store the success page class data inside RD
			SuccessPage sp = new SuccessPage();
			request.setAttribute("SuccessDetails", sp); // we will set the variable name again in SuccessPage class
			
			rd1.forward(request, response);//transfer the data
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	  }
	  else 
	  {
		  getLoginPage(request,response);
	  }
	}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		//Read the data from (customer_registration.jsp) page
		String name1=request.getParameter("tbName");
		String email1=request.getParameter("tbEmail");
		long mobile1=Long.parseLong(request.getParameter("tbMobile"));
		String pass1=request.getParameter("tbPass");
		String state1=request.getParameter("ddlstates");
		
		//store that data in customer object
		Customer cus = new Customer(name1,email1,mobile1,pass1,state1);
		
		//call insertCustomer method present in DAO by passing above object
		DataAccess.insertCustomer(cus);
		
		//Redirect user to login page
		try 
		{
			RequestDispatcher rd1=request.getRequestDispatcher("customer_login.jsp");
			rd1.forward(request, response);//transfer the data
			
			
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd =request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd =request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}


	private void getStartupPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd =request.getRequestDispatcher("Customer_Management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
