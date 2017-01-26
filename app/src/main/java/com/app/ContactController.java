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

import java.util.*;
import java.text.*;
import java.text.DateFormat;

public class ContactController extends HttpServlet {
  
    private PersonCRUD personCRUD;
    private ContactsCRUD contactsCRUD;
    private RolesCRUD rolesCRUD;

    public ContactController() {
        personCRUD = new PersonCRUD();
        //contactsCRUD = new ContactsCRUD();
        //rolesCRUD = new RolesCRUD();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget pathinfo " + request.getRequestURI());

        if((request.getRequestURI()).contains("add")) {
            request.setAttribute("personId", request.getParameter("PersonId"));
            request.getRequestDispatcher("/AddContact.jsp").forward(request, response);
        }
        else if((request.getRequestURI()).contains("list") || (request.getRequestURI().contains("delete"))) {
            Person lstContact = personCRUD.get(Integer.parseInt(request.getParameter("PersonId")));
            request.setAttribute("person", lstContact);
            request.getRequestDispatcher("/ListContact.jsp").forward(request, response);
        }
        else if((request.getRequestURI()).contains("edit")) {
            Person editPerson = personCRUD.get(Integer.parseInt(request.getParameter("PersonId")));
            Contacts contact = new Contacts();
            int contactId = Integer.parseInt(request.getParameter("EditId"));
            for(Contacts getContact : editPerson.getContacts()) {
                if(getContact.getId() == contactId) {
                    contact = getContact;
                    break;
                }
            }

            request.setAttribute("personId", editPerson.getId());
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("/AddContact.jsp").forward(request, response);
        } /*
        else if((request.getRequestURI()).contains("delete")) {
            request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
        }*/
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost pathinfo " + request.getRequestURI());

        if(request.getRequestURI().contains("list")) {
            Person person = new Person();
            Set<Contacts> personContacts;// = new Set<Contacts>();
            Contacts contact = new Contacts();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            PersonGender gender = null;

            try{
                person = personCRUD.get(Integer.parseInt(request.getParameter("personId")));
                personContacts = person.getContacts();
                
                if(!request.getParameter("contactId").equals("") && request.getParameter("contactId") != null) {
                    int contactId = Integer.parseInt(request.getParameter("contactId"));

                    System.out.println("edit contact " + contactId);

                    for(Contacts getContact : personContacts) {
                        if(contact.getId() == contactId) {
                            contact = getContact;
                            break;
                        }
                    }
                }//edit
                else {
                    System.out.println("add contact");

                    if(personContacts == null) {
                        personContacts = new HashSet<Contacts>();
                        person.setContacts(personContacts);
                        personContacts = person.getContacts();
                    }
                    contact = new Contacts();
                }//add new

                    switch(request.getParameter("type")) {
                        case "LANDLINE" :
                            contact.setType(ContactType.LANDLINE);
                            break;
                        case "MOBILE" :
                            contact.setType(ContactType.MOBILE);
                            break;
                        case "EMAIL" :
                            contact.setType(ContactType.EMAIL);
                            break;
                    }

                    contact.setValue(request.getParameter("value"));

                    personContacts.add(contact);
                    personCRUD.update(person);
                
                /*
                if(person.getId() != 0) {
                    personCRUD.update(person);
                }
                else  {
                    personCRUD.create(person);
                }*/
            }
            catch(IllegalArgumentException | NullPointerException ex) {
                System.out.println("doPost add/edit contact Exception");
                ex.printStackTrace();
            }

            //request.getRequestDispatcher("/").forward(request, response);
            //response.sendRedirect("/ListPerson.jsp");
            //request.getRequestDispatcher("/Person/list").forward(request, response);
            doGet(request, response);
        }
        else if(request.getRequestURI().contains("delete")) {
            Person person = personCRUD.get(Integer.parseInt(request.getParameter("PersonId")));
            int contactId = Integer.parseInt(request.getParameter("DeleteId"));
                        for(Contacts contact : person.getContacts()) {
                            if(contact.getId() == contactId) {
                                person.getContacts().remove(contact);
                                break;
                            }
                        }
            personCRUD.update(person);
            //response.sendRedirect("/ListPerson.jsp");
            //request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
            doGet(request, response);
        }
    }

}