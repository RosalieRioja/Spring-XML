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

public class ContactController implements Controller{

    private final int DEFAULT_PATH_COUNT = 9;   // "/Contact/"

    private PersonCRUD personCRUD;

    public ContactController() {
        personCRUD = new PersonCRUD();
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = request.getRequestURI();
        System.out.println("url = " + url);

        String page = url.substring(DEFAULT_PATH_COUNT, url.length());

        ModelAndView model = new ModelAndView();
        String personId_reqparam = request.getParameter("personId");
        int contactId;
        ContactsDTO contact;

        switch(page) {
            case "list" :
                System.out.println("personId on session = " + request.getSession().getAttribute("personId"));

                if(personId_reqparam == null) {
                    personId_reqparam = String.valueOf(request.getSession().getAttribute("personId"));
                }
                PersonDTO lstContact = personCRUD.get(Integer.parseInt(personId_reqparam));
                model.setViewName("ListContact");
                model.addObject("person", lstContact);
                break;

            case "add" :
                model.addObject("personId", personId_reqparam);
                model.setViewName("AddContact");
                break;

            case "edit" :
                System.out.println("personId = " + personId_reqparam + " editId = " + request.getParameter("editId"));

                PersonDTO editPerson = personCRUD.get(Integer.parseInt(personId_reqparam));
                contact = new ContactsDTO();
                contactId = Integer.parseInt(request.getParameter("editId"));
                for(ContactsDTO getContact : editPerson.getContacts()) {
                    if(getContact.getId() == contactId) {
                        contact = getContact;
                        break;
                    }
                }

                model.addObject("personId", editPerson.getId());
                model.addObject("contact", contact);
                model.setViewName("AddContact");
                break;

            case "delete" :
                System.out.println("personId = " + personId_reqparam + " deleteId = " + request.getParameter("deleteId"));

                PersonDTO personDelete = personCRUD.get(Integer.parseInt(personId_reqparam));
                contactId = Integer.parseInt(request.getParameter("deleteId"));
                for(ContactsDTO contactDelete : personDelete.getContacts()) {
                    if(contactDelete.getId() == contactId) {
                        personDelete.getContacts().remove(contactDelete);
                        break;
                    }
                }
                personCRUD.update(personDelete);
            
                model.setViewName("redirect:/Contact/list");
                //model.addObject("personId", personId_reqparam);

                request.getSession().setAttribute("personId", personId_reqparam);
                break;

            case "submit" :
                PersonDTO person = new PersonDTO();
                Set<ContactsDTO> personContacts;
                contact = new ContactsDTO();
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

                try{
                    person = personCRUD.get(Integer.parseInt(personId_reqparam));
                    personContacts = person.getContacts();
                    
                    if(!request.getParameter("contactId").equals("") && request.getParameter("contactId") != null) {
                        contactId = Integer.parseInt(request.getParameter("contactId"));

                        System.out.println("edit contact " + contactId);

                        for(ContactsDTO getContact : personContacts) {
                            if(getContact.getId() == contactId) {
                                contact = getContact;
                                break;
                            }
                        }
                    }//edit
                    else {
                        System.out.println("add contact");

                        if(personContacts == null) {
                            personContacts = new HashSet<ContactsDTO>();
                            person.setContacts(personContacts);
                            personContacts = person.getContacts();
                        }
                        contact = new ContactsDTO();
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
                }
                catch(IllegalArgumentException | NullPointerException ex) {
                    System.out.println("add/edit contact Exception");
                    ex.printStackTrace();
                }

                model.setViewName("redirect:/Contact/list");
                //model.addObject("personId", personId_reqparam);

                request.getSession().setAttribute("personId", personId_reqparam);
                break;

            default :
                break;
        }

        return model;
    }

}