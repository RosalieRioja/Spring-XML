package com;
/*
import com.app.*;

public class MainClass {

	public static void main(String[] args) {
		new Menu();
	}
}

package com.crunchify.jsp.servlet;
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
//import javax.servlet.annotation.WebServlet;

//@WebServlet("/person")
public class MainClass extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String username = request.getParameter("firstname");
        String password = request.getParameter("lastname");
        System.out.println(username);
        PrintWriter out = response.getWriter();
        out.println (
                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                  "<html> \n" +
                    "<head> \n" +
                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                        "charset=ISO-8859-1\"> \n" +
                      "<title> Crunchify.com JSP Servlet Example  </title> \n" +
                    "</head> \n" +
                    "<body> <div align='center'> \n" +
                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Username: " + username + " <br> " + 
                    "</font></body> \n" +
                  "</html>" 
                );      
    }
    
    //@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String username = request.getParameter("firstname");
        String password = request.getParameter("lastname");
        System.out.println(password);
        PrintWriter out = response.getWriter();
        out.println (
                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                  "<html> \n" +
                    "<head> \n" +
                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                        "charset=ISO-8859-1\"> \n" +
                      "<title> Crunchify.com JSP Servlet Example  </title> \n" +
                    "</head> \n" +
                    "<body> <div align='center'> \n" +
                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Password: " + password +
                    "</font></body> \n" +
                  "</html>" 
                );   
      /*
        String redirectUrl = "/person";
        try {
            String[] path = StringUtils.isNotBlank(req.getPathInfo()) ? req.getPathInfo().substring(1).split("/") : new String[]{""};
            String mode = path[0];
            switch (mode) {
                case "create":
                    PersonDto person = buildPerson(req);
                    personService.add(person);
                    break;

                case "addRole":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) 
                        && StringUtils.isNotBlank(req.getParameter("role"))) {

                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long roleId = Long.valueOf(req.getParameter("role"));
                        personService.addRole(personId, roleId);
                        redirectUrl = "/person/editPersonContactRole/" + personId;
                    }
                    break;

                case "removeRole":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) 
                        && StringUtils.isNotBlank(req.getParameter("roleId"))) {

                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long roleId = Long.valueOf(req.getParameter("roleId"));
                        personService.removeRole(personId, roleId);
                        redirectUrl = "/person/editPersonContactRole/" + personId;
                    }
                    break;

                case "addContact":
                    if(StringUtils.isNotBlank(req.getParameter("personId")) 
                        && StringUtils.isNotBlank(req.getParameter("contactInfo")) 
                        && StringUtils.isNotBlank(req.getParameter("contactType")) ){

                        String contactInfo = req.getParameter("contactInfo");
                        String contactType = req.getParameter("contactType");
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        personService.addContact(personId, new ContactDtoBuilder().withContactInfo(contactInfo).withContactType(contactType).build());
                        redirectUrl = "/person/editPersonContactRole/" + personId;
                    }

                    break;

                case "updateContact":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) 
                        && StringUtils.isNotBlank(req.getParameter("contactId")) 
                        && StringUtils.isNotBlank(req.getParameter("contactType"))
                        && StringUtils.isNotBlank(req.getParameter("contactInfo"))) {
                        
                        String contactInfo = req.getParameter("contactInfo");
                        String contactType = req.getParameter("contactType");
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long contactId = Long.valueOf(req.getParameter("contactId"));
                        personService.updateContact(personId, contactId, new ContactDtoBuilder().withContactInfo(contactInfo).withContactType(contactType).build());
                        redirectUrl = "/person/editPersonContactRole/" + personId;
                    }
                    break;

                case "removePerson":
                    if (StringUtils.isNotBlank(req.getParameter("personId"))){
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        personService.delete(personId);
                        redirectUrl = "/person/";

                    }
                    break;

                case "removeContact":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) 
                        && StringUtils.isNotBlank(req.getParameter("contactId"))){
                        
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long contactId = Long.valueOf(req.getParameter("contactId"));
                        personService.removeContact(personId, contactId);
                        redirectUrl = "/person/editPersonContactRole/" + personId;
                    }
                    break;

                default:
                    break;
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            //Will just redirect back to person list
        }

        resp.sendRedirect(redirectUrl);
        */
    }

}