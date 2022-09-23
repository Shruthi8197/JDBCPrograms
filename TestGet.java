package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDao;
import com.ty.dto.Signup;

public class TestGet {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Signup si=new Signup();
		SignupDao dao=new SignupDao();
		System.out.println("Enter the email");
		String email=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		Signup a=dao.getDetails(email,password);
		System.out.println(a.getFirstname());
		System.out.println(a.getLastname());
		System.out.println(a.getEmail());
		System.out.println(a.getPassword());
		System.out.println(a.getPhone());
		System.out.println(a.getDob());
		System.out.println(a.getGender());
		if(a!=null) {
			System.out.println("Welcome "+a.getFirstname());
		}
		else {
			System.out.println("Invalid email and password");
		}
		

	}

}
