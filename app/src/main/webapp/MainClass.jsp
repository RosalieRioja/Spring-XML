<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script>

function validateAddPerson() {
    $('.form-add-person-error').hide();
    var valid = true;

    if($('#firstname').val() == "") {
        $('#firstnameError').show();
        valid = false;
    }
    if($('#middlename').val() == "") {
        $('#middlenameError').show();
        valid = false;
    }
    if($('#lastname').val() == "") {
        $('#lastnameError').show();
        valid = false;
    }
    if($('#suffix').val() == "") {
        $('#suffixError').show();
        valid = false;
    }
    if($('#title').val() == "") {
        $('#titleError').show();
        valid = false;
    }
    if($('#birthday').val() == "") {
        $('#birthdayError').show();
        valid = false;
    }
    if($('#gwa').val() == "") {
        $('#gwaError').show();
        valid = false;
    }
    if($('#datehired').val() == "") {
        $('#datehiredError').show();
        valid = false;
    }

    var rdEmployed = $('input:radio[name="employed"]:checked');
    if(rdEmployed.length == 0)//no buttons selected
    {
        //alert("Please select an employment status.");
        $('#employedError').show();
        valid = false;
    }

    var rdGender = $('input:radio[name="gender"]:checked');
    if(rdGender.length == 0)//no buttons selected
    {
        //alert("Please select a gender.");
        $('#genderError').show();
        valid = false;
    }

    if($('#streetnumber').val() == "") {
        $('#streetnumberError').show();
        valid = false;
    }
    if($('#barangay').val() == "") {
        $('#barangayError').show();
        valid = false;
    }
    if($('#city').val() == "") {
        $('#cityError').show();
        valid = false;
    }
    if($('#zipcode').val() == "") {
        $('#zipcodeError').show();
        valid = false;
    }

    if(valid) {
        return (confirm('Are you sure to register this person?'));
    }
    else {
        return valid;
    }
}

</script>
<!-- JSP -->
<html>
    <style type="text/css">
    body {
        background-image:
            url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
    }
    </style>
 
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
        <title>Mini Registration System</title>
    </head>

    <body>
     
     <!--
        <div align="center" style="margin-top: 50px;">
            <form action="">
                Please enter your Username:  <input type="text" name="username" size="20px"> <br>
                Please enter your Password:  <input type="text" name="password" size="20px"> <br><br>
                <input type="submit" value="submit">
            </form>
        </div>
     -->

    <div align="center">
        Mini Registration System
    </div>

    <div align="center">
        <br>Menu<br>
        <br><a href="#" onclick="$('.form-add-person').show();" >Register Person</a> <!-- go to form -->
        <br><a href="#">Update Person record</a>
        <br><a href="#">Delete Person record</a>
        <br><a href="#">Print list of Person record</a>
        <br><a href="#">Add Contact to Person</a>
        <br><a href="#">Update Contact of Person</a>
        <br><a href="#">Delete Contact of Person</a>
        <br><a href="#">Assign Role to Person</a>
        <br><a href="#">Unassign Role of Person</a>
    </div>

    <div align="center" style="margin-top: 50px; display: none;" class="form-add-person" >
        <form action="/" method="post" onsubmit="return validateAddPerson();">
            Name: <br>
            First name: <input      type="text" id="firstname"  name="firstname"    size="20px"/>
                <label style="display:none; color:red;" id="firstnameError" class="form-add-person-error">Please enter First name.</label> <br>
            Middle name:    <input  type="text" id="middlename" name="middlename"   size="20px"/>
                <label style="display:none; color:red;" id="middlenameError" class="form-add-person-error">Please enter Middle name.</label> <br>
            Last name:  <input      type="text" id="lastname"   name="lastname"     size="20px"/>
                <label style="display:none; color:red;" id="lastnameError" class="form-add-person-error">Please enter Last name.</label> <br>
            Suffix: <input          type="text" id="suffix"     name="suffix"       size="20px"/>
                <label style="display:none; color:red;" id="suffixError" class="form-add-person-error">Please enter Suffix.</label> <br>
            Title:  <input          type="text" id="title"      name="title"        size="20px"/>
                <label style="display:none; color:red;" id="titleError" class="form-add-person-error">Please enter Title.</label> <br>
            Birthday:   <input      type="date" id="birthday"   name="birthday"     size="20px"/>
                <label style="display:none; color:red;" id="birthdayError" class="form-add-person-error">Please enter Birthday.</label> <br>
            Grade Weighted Average: <input type="number" id="gwa" name="gwa"        size="20px"/>
                <label style="display:none; color:red;" id="gwaError" class="form-add-person-error">Please enter GWA.</label> <br>
            Date Hired: <input      type="date" id="datehired"  name="datehired"    size="20px"/>
                <label style="display:none; color:red;" id="datehiredError" class="form-add-person-error">Please enter Date Hired.</label> <br>
            Employed:   <input type="radio" name="employed" value="true"/> True <input type="radio" name="employed" value="false"/> False
                <label style="display:none; color:red;" id="employedError" class="form-add-person-error">Please select an employment status.</label> <br>
            Gender: <input type="radio" name="gender" value="FEMALE"/> Female <input type="radio" name="gender" value="MALE"/> Male
                <label style="display:none; color:red;" id="genderError" class="form-add-person-error">Please select gender.</label> <br>
            Address <br>
            Street number:  <input  type="number"   id="streetnumber"   name="streetnumber" size="20px">
                <label style="display:none; color:red;" id="streetnumberError" class="form-add-person-error">Please enter Street number.</label> <br>
            Barangay:   <input      type="text"     id="barangay"       name="barangay"     size="20px">
                <label style="display:none; color:red;" id="barangayError" class="form-add-person-error">Please enter Barangay.</label> <br>
            City:   <input          type="text"     id="city"           name="city"         size="20px">
                <label style="display:none; color:red;" id="cityError" class="form-add-person-error">Please enter City.</label> <br>
            Zip code:   <input      type="number"   id="zipcode"        name="zipcode"      size="20px">
                <label style="display:none; color:red;" id="zipcodeError" class="form-add-person-error">Please enter Zip code.</label> <br>
            <input type="submit" value="register">
            <input type="button" value="cancel" onclick="$('.form-add-person').hide();">
        </form>
    </div>

    </body>
</html>