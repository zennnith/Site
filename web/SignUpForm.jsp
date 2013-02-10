<%-- 
    Document   : SignUpForm
    Created on : Jan 6, 2013, 4:52:10 PM
    Author     : ZenitH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>  
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <title>JSP Page</title>
    </head>
     <body class="body">
       
         <%@ include file="/Header.jsp" %> 
         <script>
              function validateForm()
            {
                if(document.myForm.name.value=="")
                {
                    var x=document.forms["myForm"]["name"].value;
                    if (x==null || x=="")
                      {
                      alert("Please enter your name");
                      return false;
                      }
                }
                 (document.myForm.password.value)
                {
                   var x=document.forms["myForm"]["password"].value;
                    var y=document.forms["myForm"]["password2"].value;
                   if (x==null || x=="")
                   {
                     alert("Please fill the password");
                     return false;
                   }     
                   if (y==null || y=="")
                   {
                     alert("Please confirm the password");
                     return false;
                   }     
                  
                   if (x!=y)
                   {
                        alert("wrong password match");
                        return false;
                   }
                 
                }
               
               
                
                
                
               
            } 
             
             
             
         </script>
      
         <form action="signup" method="post" name="myForm" onsubmit="return validateForm() >
            <div style= "background: #FFFFFF; height: 650px; width: 25%; float: left;">
         
            </div>     
            <div style="background:#EFF5FB; height: 650px ; width: 50% ; float: left;">
                <pre><h2><p>    Fill  the form and get an announce.lk account  </p></h2><br></pre>
                <pre>   Full Name          : <input type ="text" name ="name"></pre> <br>
                <pre>   E mail             : <input type ="text" name ="email"></pre> <br> 
                <pre>   Phone Number       : <input type ="text" name="phone"></pre> <br> 
                <pre>   Password           : <input type="password" name ="password"></pre> <br>  
                <pre>   Confirm Password   : <input type="password" name ="password2"></pre> <br>  
                <pre>   Security Question  : <select name="securityQuestion" size="1">                                  
                <option>What is your favourite food
                <option>What is your favourite colour
                </select>
                </pre><br> 
                <pre>   Answer             : <input type="text" name="answer"></pre><br>        

                <div style=" height: 10px; width: 70%; float: right;">
                    <input tabindex="6" type="Submit" class="btn" value="Ok" onclick="submitForm();"/> 
                   &nbsp; &nbsp; &nbsp;
                    <input type="Reset" value="Reset" >
                </div>    

            </div>   
            <div style="background: #FFFFFF; height: 650px ; width: 25% ; float: left;">

            </div>    
        </form>   
         
         <%@ include file="/Footer.jsp" %> 
         
    </body>
</html>
