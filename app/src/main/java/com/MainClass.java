package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;	
//import org.springframework.web.servlet.mvc.Controller;

public class MainClass implements Controller {/*extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/MainClass.jsp").forward(request, response);
    
    }

    public ModelAndView Menu() {
		return new ModelAndView("MainClass");
	}*/

	public ModelAndView handleRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("MainClass");
            //List<PersonDTO> lstPerson = personCRUD.read(7);
        //personCRUD = new PersonCRUD();
        model.addObject("title", "Mini Registration System");

        return model;
		//return new ModelAndView("MainClass");
	}
}