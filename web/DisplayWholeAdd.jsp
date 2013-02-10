<%-- 
    Document   : DisplayAllAdds
    Created on : Jan 12, 2013, 10:39:04 AM
    Author     : ZenitH
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@ include file="/Header.jsp" %> 
        <div style= "background: #FFFFFF; height: 225px; width: 10%; float: left;"> </div>
         
         
       
     
        <div style="background:#EFF5FB; height: 100% ; width: 80% ; float: left;">
            <table>
                <a class="favourite" href="AddFavourite" id="blue1" >Add to favourite <img src="images/fav.jpg" width="40" height="40" alt="fav"/>
                </a>
               
        <pre><h2>   ${item.title}                   </h2><pre>
        <pre><h3>   Brand     :  ${item.type}       </h3></pre>     
        <pre><h3>   Price     :  ${item.price}      </h3></pre>
        <pre><h3>   Condition :  ${item.condition}  </h3></pre>
        <pre><h3>   Warranty  :  ${item.warranty}   </h3> </pre>
        <pre><h3>   More Info :  ${item.description}</h3></pre>   
            </table>
            
            <form action="BidsController" method="get">
                <table>
                   <p id="blue1">   Place your Bid Hear </p> 
                    <input type="text" name="bid"/>
                    
                    <input type="submit" value="Ok"/>
                    ${handleErroe} <br>
                    <p style="color:red">   ${maxbidValues} </p><br>
                </table>
            </form>
            
            <form action="ItemCommentsInsertController" method="post">
           <h2> 
               Enter Comment/inquiry <br>
           </h2>
               <textarea rows="4" cols="50" name="comment">


                </textarea>
             <input  type="Submit" value="Ok" /> 
            </form>
            
            
          
                
                  <h2>  User Comments/ Inquiries about the item </h2>
                  
                   <c:forEach var="stylesE" items="${styles}">
                     <table style="border:1px solid black; font-size: 5">
                     <tr>
                     <td></td>
                     <td>${stylesE.comment} </td>
                     </tr>
                     </table>
                     <br> <br>
                  </c:forEach>
            
         
          
                
                
            
            

        </div>
        
         <div style= "background: #FFFFFF; height: 225px; width: 10%; float: left;"></div>      
        <%@ include file="/Footer.jsp" %> 
    </body>
</html>
