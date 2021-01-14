package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDao;
import com.dao.ProfileDaoImpl;
import com.google.gson.Gson;
import com.servlet.dto.ProfileDTO;

@WebServlet("/ajaxSearchProfiles")
public class AjaxSearchProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		ProfileDao profileDao = new ProfileDaoImpl();
		ProfileDTO profileDTO = profileDao.findByEmail(email);
System.out.println("fjhgdsjhfjhfgdfjhd");
		resp.setContentType("application/json");

		Gson gson = new Gson();
		String jsonData = gson.toJson(profileDTO);
		System.out.println(jsonData);

		resp.getWriter().println(jsonData);
	}

}
