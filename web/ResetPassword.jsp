<%-- 
    Document   : ResetPassword
    Created on : Jan 9, 2013, 10:45:16 PM
    Author     : ZenitH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <%@ include file="/Header.jsp" %> 
        
        <form action="passwordReset" method="post">
            <div style= "background: #FFFFFF; height: 125px; width: 25%; float: left;">
        
            </div>     
            <div style="background:#EFF5FB; height: 225px ; width: 50% ; float: left;">
                <pre><h2><p> Enter your password to get it <br> e-mailed to your email account </p></h2><br></pre>
                
                <pre>   your E mail             : <input type ="text" name ="email"></pre> <br> 
                <div style=" height: 10px; width: 70%; float: right;">
                    <input type="Submit" value="Insert " >&nbsp; &nbsp; &nbsp;
                    <input type="Reset" value="Reset" ><br><br><br>
                </div> 
            </div>>
           
        </form>>
        <%@ include file="/Footer.jsp" %> 
      
    </body>
</html>
