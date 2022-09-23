package com.ty.controller;

import java.util.List;

import com.ty.dao.SignupDao;
import com.ty.dto.Signup;

public class TestGetAll {

	public static void main(String[] args) {
		SignupDao dao=new SignupDao();
		List<Signup> ls=dao.getAllDetails();
		System.out.println(ls);

	}

}
