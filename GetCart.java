package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;


public class GetCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CartDAO dao=new CartDAO();
		Cart ca=new Cart();
		System.out.println("Enter the id");
		int id4 = sc.nextInt();
	
		Cart b = dao.getCart(id4);
		System.out.println(b.getId());
		System.out.println(b.getEmail());
		System.out.println(b.getPassword());
		System.out.println(b.getUsername());
		System.out.println(b.getAddress());

	}

}
