package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;



public class GetAllCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		CartDAO dao=new CartDAO();
		//Cart ca=new Cart();
		List<Cart> ls=dao.getAllCart();
		System.out.println(ls);

	}

}
