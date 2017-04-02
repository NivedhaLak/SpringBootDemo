package com.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.DemoService;

@Controller
public class DemoController {
	@Autowired
	DemoService demoService;

	@RequestMapping("/sayhello")
	public String sayHello(Model model) {
		model.addAttribute("test", demoService.getAll());
		System.out.println("in sayhello");
		// fetchvalue();
		return "hello";
	}

	/** jdbc connection demo */
	String fetchvalue() {
		String value = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from city");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			value += rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "/n";
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
}
