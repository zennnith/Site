<%-- 
    Document   : EditUserAccount
    Created on : Jan 9, 2013, 10:21:12 PM
    Author     : ZenitH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Account</title>
    </head>
    <body>
         <%@ include file="/Header.jsp" %> 
          <form action="edituser" method="post">
            <div style= "background: #FFFFFF; height: 650px; width: 25%; float: left;">
         
            </div>     
            <div style="background:#EFF5FB; height: 650px ; width: 50% ; float: left;">
                <pre><h2><p>    Edit the details you want</p></h2><br></pre>
                <pre>                                                         </pre>
                <pre>   Phone Number       : <input type ="text" name="phone" value="${phone}"></pre> <br> 
                <pre>   Security Question  : <select name= "securityQuestion" size="1">                                  
                    <option>Your is your favourite food
                    <option>What is your favourite colour
                    
                </select>
                </pre><br> 
                <pre>   Answer             : <input type="text" name ="answer" value="${answer1}"></pre><br>        

                <div style=" height: 10px; width: 70%; float: right;">
                    <input type="Submit" value="Ok " >&nbsp; &nbsp; &nbsp;
                    <input type="Reset" value="Reset" >
                </div>    

            </div>   
            <div style="background: #FFFFFF; height: 650px ; width: 25% ; float: left;">

            </div>    
        </form>    
        
         <%@ include file="/Footer.jsp" %> 
    </body>
</html>
