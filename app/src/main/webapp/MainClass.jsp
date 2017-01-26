<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<!-- MAIN JSP -->
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
        Mini Registration System
    </div>

    <div align="center">
        <!--
        <br>Menu<br>
        <br><a href="#" onclick="window.location.assign('/Person/add');" >Register Person</a>
        <br><a href="#">Update Person record</a>
        <br><a href="#">Delete Person record</a>
        <br><a href="#" onclick="window.location.assign('/Person/list');">Print list of Person record</a>
        <br><a href="#">Add Contact to Person</a>
        <br><a href="#">Update Contact of Person</a>
        <br><a href="#">Delete Contact of Person</a>
        <br><a href="#">Assign Role to Person</a>
        <br><a href="#">Unassign Role of Person</a>
        -->
        <a href="/Person/list">Go to List of Person</a>
    </div>
    </body>
</html>