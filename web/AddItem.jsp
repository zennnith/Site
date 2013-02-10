<%-- 
    Document   : AddItem
    Created on : Jan 7, 2013, 12:34:42 AM
    Author     : ZenitH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
    </head>
    <body>
         <%@ include file="/Header.jsp" %> 
      <script>
            function validateForm()
            {
                if(document.myForm.title.value=="")
                {
                    var x=document.forms["myForm"]["title"].value;
                    if (x==null || x=="")
                      {
                      alert("Please add a title");
                      return false;
                      }
                }
                
               
                else if(document.myForm.price.value=="")
                {
                    var x=document.forms["myForm"]["price"].value;
                    if (x==null || x=="")
                      {
                      alert("Expected price not entered");
                      return false;
                      }
                }
                else if(document.myForm.description.value=="")
                {
                    var x=document.forms["myForm"]["description"].value;
                    if (x==null || x=="")
                      {
                      alert("Description be filled out");
                      return false;
                      }
                }
                
                
                
               
            }           
        </script>


      <form action="AddItem" method="post" name="myForm" enctype="multipart/form-data" onsubmit="return validateForm()">
            <div style= "background: #FFFFFF; height: 900px; width: 25%; float: left;">
         
            </div>     
            <div style="background:#EFF5FB; height: 900px ; width: 50% ; float: left;">
                <pre><h2><p>    Fill the below details to advertise your item </p></h2><br></pre>
               
                <pre>   Advertisement  Title    :   <input type ="text" name ="title" required="true"></pre> <br>
                
                <pre>   Phone Brand             :   <select name="type" size="1" >  </pre> <br>
                                                        <option>Select Brand
                                                        <option> Nokia
                                                        <option>Samsung
                                                        <option>Sony Ericson
                                                        <option>LG
                                                        <option>BlackBerry
                                                        <option>Apple
                                                        <option>Motorola
                                                        <option>Alcatel
                                                        <option>HTC
                                                        <option>Other
                                                    </select>
                 
                <pre>   Price                   :   <input type="text" name ="price"></pre> <br>  
                <pre>   Condition               :   <select name="condition" size="1" ></pre> <br>
                                                        <option> Select condition
                                                        <option> New
                                                        <option> Used
                                                    </select>
                
                
                <pre>   Warranty                :   <select name="warranty" size="1" ></pre> <br>
                                                        <option> Select option
                                                        <option> No warranty
                                                        <option> Yes,6 Months more
                                                        <option> Yes,1 Year
                                                        <option> Yes,2 Years
                                                    </select>

                <pre>   Description             :   <input type ="text" name="description"></pre> <br> 
                <pre>   Item Located at         :  <select name="location" size="1" ></pre> <br>
                                                        <option> Select 
                                                        <option> Colombo
                                                        <option> Galle
                                                        <option> Kandy
                                                        <option> Matale
                                                    </select>
                <pre>   Add Image               :  <input type="file"  name="uploaded" data-provide="fileinput">
                 
                <div style=" height: 10px; width: 70%; float: left; ">
                    <input type="Submit" value="Ok " > <input type="Reset" value="Reset" >
                    
                </div>    

            </div>   
            <div style="background: #FFFFFF; height: 900px ; width: 25% ; float: left;">

            </div>    
        </form>    
        
        
        
        
        
        
        <%@ include file="/Footer.jsp" %> 
    </body>
        
        
    </body>
</html>
