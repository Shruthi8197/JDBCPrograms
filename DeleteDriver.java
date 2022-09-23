package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class DeleteDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CartDAO dao=new CartDAO();
		Cart ca=new Cart();
		System.out.println("Enter the id");
		int id = sc.nextInt();
		String n = dao.deleteCart(id);
		System.out.println(n);

	}

}
