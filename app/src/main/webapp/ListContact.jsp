<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<!-- LIST CONTACT JSP -->
<html>
    <style type="text/css">
    body {
        background-image:
            url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
    }
    </style>
 
    <head>
        <title>Mini Registration System</title>
    </head>

    <body>
     
    <div align="center">
        <a href="#" onclick="window.location.assign('/Person/list');">Back</a>
    </div>
    <br>
    <div align="center">
        <a href="#" onclick="window.location.assign('/Contact/add?PersonId=${person.id}');">Add Contact</a>
    </div>
    <br>
    <div align="center">
        ${person.name.lastName}, ${person.name.firstName} ${person.name.middleName}'s List of Contact/s
    </div>
    <br>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td></td><td></td><td></td>
                    <td>Contact Type</td>
                    <td>Contact Value<td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${person.contacts}" var="contact">
                    <tr>
                        <td>
                            <a href="/Contact/edit?PersonId=${person.id}&EditId=${contact.id}">Edit</a>
                        </td>
                        <td></td>
                        <td>
                            <form action="/Contact/delete?PersonId=${person.id}&DeleteId=${contact.id}" method="post" onsubmit="return confirm('Are you sure you want to delete this contact?');">
                                <!--<a href="#" onclick="deletePerson(${person.id});">Delete</a>-->
                                <input type="submit" value="Delete"/>
                            </form>
                        </td>
                        <td>${contact.type}</td>
                        <td>${contact.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>