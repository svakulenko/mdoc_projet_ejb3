<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<a href="menuMainPage"> back to Acceuil</a>
<h1>Update contact:</h1>
<jsp:include page="/commonPages/dbdataOutput.jsp" />

<script>
    function toggle(arg){
	var tr1 = document.getElementById('tr1');
        if (arg == 'contact')
        {
        	tr1.style.display = 'none'; 
        } 
        else 
        {
        	tr1.style.display = 'block' ;

        }
}
</script>
<form>

</form> 
<div style='display:block'>
<form name="myForm" method="post" action="UpdateContact">
    <br/>  <input type="submit" value="Save"> <input type="reset"  value="Clear">

    <table><tbody>   		           
			
			<tr>
                <td style="width: 140px;">Contact Id:</td>
                <td valign="top"> <input type="hidden"  name="id" size="25" value="<%= request.getParameter("id")%>">  </td>
            </tr>
			
            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstName" size="25" value="<%= request.getParameter("firstName")%>">  </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastName" size="25" value="<%= request.getParameter("lastName")%>">  </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="<%= request.getParameter("email")%>">  </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="<%= request.getParameter("street")%>"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="<%= request.getParameter("city")%>"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="<%= request.getParameter("zip")%>"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="<%= request.getParameter("country")%>"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phoneKind" size="25" value="<%= request.getParameter("phoneKind")%>"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phoneNumber" size="25" value="<%= request.getParameter("phoneNumber")%>"> </td>
            </tr>

			<tr id='tr1' style= 'display:none'>
                <td style="width:140px">NumSiret:</td>
                <td valign="top"> <input type="text"  name="numsiret" size="25" value="12345"> </td>
            </tr>
            
    </tbody></table>
    <table>
    </table>
</form>

</div>
</body>
</html>