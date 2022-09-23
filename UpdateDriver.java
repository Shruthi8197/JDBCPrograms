package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class UpdateDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CartDAO dao=new CartDAO();
		Cart ca=new Cart();
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the mail id");
		String mail=sc.next();
		System.out.println("Enter the password");
		String pwd=sc.next();
		System.out.println("Enter the username");
		String usn=sc.next();
		System.out.println("Enter the address");
		String address=sc.next();
		
		ca.setId(id);
		ca.setEmail(mail);
		ca.setPassword(pwd);
		ca.setUsername(usn);
		ca.setAddress(address);
		Cart p=dao.updateCart(ca);
		System.out.println(p);


	}

}
