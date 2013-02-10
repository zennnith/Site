<%-- 
    Document   : Login
    Created on : Jan 6, 2013, 5:25:31 PM
    Author     : ZenitH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>                 
    <body>
       
        <%@ include file="/Header.jsp" %> 
      
        
        
        <form action="LogIn" method="post">
            <div style= "background: #FFFFFF; height: 150px; width: 25%; float: left;">
         
            </div>     
            <div style="background:#EFF5FB; height: 225px ; width: 50% ; float: left;">
                <pre><h2><p> Enter E-mail and Password to sign-in </p></h2><br></pre>
                
                <pre>   E mail             : <input type ="text" name ="email"value=""></pre> <br> 
                <pre>   Password           : <input type="password" name ="password"value=""></pre> <br>  
                   

                <div style=" height: 10px; width: 70%; float: right;">
                     <input tabindex="6" type="submit" class="btn" value="Insert" onclick="submitForm();"/> 
                    
                    <input type="Reset" value="Reset" ><input border="white" type="text" name="a" value="${error}" readonly="readonly" /><br>
                    <a href="ResetPassword.jsp"id="blue1" >can not remember password</a>
                </div> 
                
               
               
            </div>   
           
            <div style="background: #FFFFFF; height: 650px ; width: 25% ; float: left;">
            </div>    
        </form> 
        
        
        
        <%@ include file="/Footer.jsp" %> 
    </body>
</html>
