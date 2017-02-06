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

public class AddPerson implements Controller{

    private final int DEFAULT_PATH_COUNT = 8;   // "/Person/"

    private PersonCRUD personCRUD;

    public AddPerson(PersonCRUD personCRUD_param) {
        personCRUD = personCRUD_param;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = request.getRequestURI();
        System.out.println("url = " + url);

        String page = url.substring(DEFAULT_PATH_COUNT, url.length());

        ModelAndView model = new ModelAndView();

        switch(page) {
            case "list" :
                List<PersonDTO> lstPerson = personCRUD.read(SortValue.SORT_LASTNAME_ASC);
                model.addObject("people", lstPerson);
                model.setViewName("ListPerson");
                break;

            case "add" :
                model.setViewName("AddPerson");
                break;

            case "edit" :
                System.out.println("editId = " + request.getParameter("editId"));

                PersonDTO editPerson = personCRUD.get(Integer.parseInt(request.getParameter("editId")));
                model.addObject("person", editPerson);
                model.setViewName("AddPerson");
                break;

            case "delete" :
                System.out.println("deleteId = " + request.getParameter("deleteId"));

                personCRUD.delete(Integer.parseInt(request.getParameter("deleteId")));
            
                model.setViewName("redirect:/Person/list");
                break;

            case "submit" :
                PersonDTO newPerson = new PersonDTO();
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
                    System.out.println("add/edit person Exception");
                    ex.printStackTrace();
                }

                model.setViewName("redirect:/Person/list");
                break;
                
            default :
                break;
        }

        return model;
    }

}