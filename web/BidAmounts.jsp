<%-- 
    Document   : BidAmounts
    Created on : Jan 18, 2013, 1:32:09 AM
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
        <h2> Details of Highest Bids for your Advertisements are as follows</h2>
        
        <c:forEach var="bb" items="${bidsView}">
        <table border="1">
            <tr>
              <pre>  Bid Amount     :   ${bb.bidAmount} </pre>
            </tr> 
              <pre>  Bid ID         :   ${bb.itemID} </pre>
              <pre>  Biders User ID :   ${bb.userID} </pre>
                   
        </table>
        </c:forEach>
        
        
        
        
        <%@ include file="/Footer.jsp" %> 
      
    </body>
</html>
