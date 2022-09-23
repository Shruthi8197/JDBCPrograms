package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDao;
import com.ty.dto.Signup;

public class TestDelete {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Signup si=new Signup();
		SignupDao dao=new SignupDao();
		System.out.println("Enter the email");
		String email=sc.next();
		
		String n=dao.deleteDetails(email);
		System.out.println(n);

	}

}
