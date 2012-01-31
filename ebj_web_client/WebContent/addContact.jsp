<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>add contact</title>

</head>
<body>
<jsp:include page="/commonPages/header.jsp" />
<jsp:include page="/commonPages/checkInput.jsp" />

 
 
<h1>add contact input form:</h1>
<jsp:include page="/commonPages/dbdataOutput.jsp" />

<script>
    function toggle(arg){
	var div1 = document.getElementById('div1')
	var div2 = document.getElementById('div2')
        if (arg == 'contact'){
            if (div1.style.display == 'none') {
                div1.style.display = 'block'
                div2.style.display = 'none'
                } 
            } else {
            if (div1.style.display == 'block') {
                div1.style.display = 'none'
                div2.style.display = 'block'
                } 

        }
}
</script>





<form>
<input type="radio" name="type" value="contact" CHECKED onclick="toggle('contact')" /> Contact
<input type="radio" name="type" value="entreprise" onclick="toggle('entreprise')"/> Entreprise
</form> 
<div id='div2' style='display:none'>
<form name="myForm" method="post" action="AddEntreprise" onsubmit="return checkInputFormStop()">
    <br/>  <input type="submit" value="Save"> <input type="reset"  value="Clear">

	

    <table><tbody>
            <tr>
                <td style="width: 140px;">NumSiret:</td>
                <td valign="top"> <input type="text"  name="numsiret" size="25" value="1234" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstname" size="25" value="Lionel"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value="Messi"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="messi@barca.com " > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="Camp Nou" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="Barcelone" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="12345" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="Spain" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="Mobile" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phoneNumber" size="25" value="010203040506 " > </td>
            </tr>
            <tr>
                <td style="width: 140px;" name="group">*Contact Group:</td>
                <td style="width: 140px;">
                <select>
                    <option>Work</option>
                    <option>Home</option>
                    </select>
            </tr>

    </tbody></table>
</form>

</div>
<div id='div1' style='display:block'>
<form name="myForm" method="post" action="AddContact" onsubmit="return checkInputFormStop()">
    <br/>  <input type="submit" value="Save"> <input type="reset"  value="Clear">

    <table><tbody>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstName" size="25" value="Wayne"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value="Rooney"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="rooney@mu.com" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="Mu street" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="Mancherter" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="54321" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="English" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="Mobile" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phoneNumber" size="25" value="010203040506 " > </td>
            </tr>
            
            <tr>
                <td style="width: 140px;">*Contact Group:</td>
                <td style="width: 140px;">
                <select>
                    <option>Work</option>
                    <option>Home</option>
                    </select>
            </tr>
            

    </tbody></table>
</form>


</div>






</body>
</html>
