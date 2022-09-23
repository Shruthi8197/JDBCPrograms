package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDao;
import com.ty.dto.Signup;

public class TestUpdate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Signup si=new Signup();
		SignupDao dao=new SignupDao();
		
		System.out.println("Enter the first name");
		String fn=sc.next();
		System.out.println("Enter the last name");
		String ln=sc.next();
		System.out.println("Enter the email");
		String email=sc.next();
		System.out.println("Enter the password");
		String pwd=sc.next();
		System.out.println("Enter the phonenum");
		long phone=sc.nextLong();
		System.out.println("Enter the DOB");
		String dob=sc.next();
		System.out.println("Enter the Gender");
		String gender=sc.next();
		
		si.setFirstname(fn);
		si.setLastname(ln);
		si.setEmail(email);
		si.setPassword(pwd);
		si.setPhone(phone);
		si.setDob(dob);
		si.setGender(gender);
		
		Signup p=dao.updateDetails(si);
		System.out.println(p);

	}

}
