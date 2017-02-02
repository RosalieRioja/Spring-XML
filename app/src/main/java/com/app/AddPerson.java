package com.app;

import com.model.*;
import com.service.*;
import com.util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;

import java.util.*;
import java.text.*;
import java.text.DateFormat;
/*
public class AddPerson extends HttpServlet {
  
    private PersonCRUD personCRUD;
    private ContactsCRUD contactsCRUD;
    private RolesCRUD rolesCRUD;

    public AddPerson() {
        personCRUD = new PersonCRUD();
        //contactsCRUD = new ContactsCRUD();
        //rolesCRUD = new RolesCRUD();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget pathinfo " + request.getRequestURI());

        if((request.getRequestURI()).contains("add")) {
            request.getRequestDispatcher("/AddPerson.jsp").forward(request, response);
        }
        else if((request.getRequestURI()).contains("list") || (request.getRequestURI().contains("delete"))) {
            List<Person> lstPerson = personCRUD.read(7);
            request.setAttribute("people", lstPerson);
            request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
        }
        else if((request.getRequestURI()).contains("edit")) {
            Person editPerson = personCRUD.get(Integer.parseInt(request.getParameter("EditId")));
            request.setAttribute("person", editPerson);
            request.getRequestDispatcher("/AddPerson.jsp").forward(request, response);
        }
        //else if((request.getRequestURI()).contains("delete")) {
        //    request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
        //}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost pathinfo " + request.getRequestURI());

        if(request.getRequestURI().contains("list")) {
            Person newPerson = new Person();
            PersonName newPersonName = new PersonName();
            PersonAddress newPersonAddress = new PersonAddress();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            PersonGender gender = null;

            try{
                if(!request.getParameter("id").equals("") && request.getParameter("id") != null) {
                    newPerson = personCRUD.get(Integer.parseInt(request.getParameter("id")));
                    newPersonAddress = newPerson.getAddress();
                }
                newPersonName.setFirstName(request.getParameter("firstname"));
                newPersonName.setLastName(request.getParameter("lastname"));
                newPersonName.setMiddleName(request.getParameter("middlename"));
                newPersonName.setSuffix(request.getParameter("suffix"));
                newPersonName.setTitle(request.getParameter("title"));

                newPersonAddress.setStreetNumber(Integer.parseInt(request.getParameter("streetnumber")));
                newPersonAddress.setBarangay(request.getParameter("barangay"));
                newPersonAddress.setCity(request.getParameter("city"));
                newPersonAddress.setZipCode(Integer.parseInt(request.getParameter("zipcode")));

                newPerson.setName(newPersonName);
                newPerson.setBirthday(df.parse(request.getParameter("birthday")));
                newPerson.setGWA(new Float(request.getParameter("gwa")));
                newPerson.setDateHired(df.parse(request.getParameter("datehired")));
                newPerson.setCurrentlyEmployed(new Boolean(request.getParameter("employed")));

                switch(request.getParameter("gender")) {
                    case "MALE" : case "male" :
                        gender = PersonGender.MALE;
                        break;
                    case "FEMALE" : case "female" :
                        gender = PersonGender.FEMALE;
                        break;
                }

                newPerson.setGender(gender);
                newPerson.setAddress(newPersonAddress);

                if(newPerson.getId() != 0) {
                    personCRUD.update(newPerson);
                }
                else  {
                    personCRUD.create(newPerson);
                }
            }
            catch(IllegalArgumentException | NullPointerException | ParseException ex) {
                System.out.println("doPost add/edit person Exception");
                ex.printStackTrace();
            }

            //request.getRequestDispatcher("/").forward(request, response);
            //response.sendRedirect("/ListPerson.jsp");
            //request.getRequestDispatcher("/Person/list").forward(request, response);
            doGet(request, response);
        }
        else if(request.getRequestURI().contains("delete")) {
            personCRUD.delete(Integer.parseInt(request.getParameter("DeleteId")));
            //response.sendRedirect("/ListPerson.jsp");
            //request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
            doGet(request, response);
        }
    }

}
*/

public class AddPerson extends AbstractController{ /*{extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/MainClass.jsp").forward(request, response);
    
    }

    public ModelAndView Menu() {
        return new ModelAndView("MainClass");
    }*/

    private PersonCRUD personCRUD;

    public AddPerson() {
        personCRUD = new PersonCRUD();
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("ListPerson");
            //List<PersonDTO> lstPerson = personCRUD.read(7);
        personCRUD = new PersonCRUD();
            List<Person> lstPerson = personCRUD.read(7);
            //request.setAttribute("people", lstPerson);
        model.addObject("people", lstPerson);

        return model;

        //return new ModelAndView("ListPerson");
    }
}