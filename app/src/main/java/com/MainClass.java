package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;

public class MainClass implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("MainClass");
        model.addObject("title", "Mini Registration System");

        return model;
	}
}