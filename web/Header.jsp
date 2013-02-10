<%-- 
    Document   : Header
    Created on : Jan 9, 2013, 8:50:57 PM
    Author     : ZenitH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <table width="996"  border="0" cellspacing="0" cellpadding="0" align="center">
           
         <td height="607" valign="top">
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>

                            <td width="40%">
                                <table width="200"  border="0" cellspacing="0" cellpadding="0"  float="right">
                                    <br><br><br>
                                    <tr> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                    <c:choose>
                                        <c:when test="${currentUser==null}">
                                            <a href="LogIn">click here to login</a>&nbsp&nbsp
                                            <a href ="signup">click to sing-up</a>&nbsp&nbsp<font color="red">${userError}</font>
                                   
                                        </c:when>
                                        <c:when test="${currentUser!=null}">
                                            <a> Hello, ${currentUser.email} </a><br>
                                            <a href="logOff">Log off</a>&nbsp&nbsp
                                    
                                        </c:when>
                                    </c:choose>
                                    
                                             
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                   <table width="996"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="75" height="52"><img src="images/announce.jpg" alt="" width="75" height="52" border="0"></a></td>
                            <td width="711" class="menu">
                                <table width="581"  border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <c:choose>
                                            <c:when test="${currentUser==null}">
                                               
                                                <td width="98" align="center"><a href ="viewAll" <span class="style4" id="whitetxt"> Home Page </a></span></td>
                                            </c:when>
                                                
                                            <c:when test="${currentUser!=null}">
                                                <td width="98" align="center"><a href ="viewAll" <span class="style4" id="whitetxt"> Home Page </a></span></td>
                                                <td width="116" align="center"><a href ="AddItem.jsp" <span class="style4" id="whitetxt" >Add Advertisement</a></span></td>
                                                <td width="98" align="center"><a href ="edituser" <span class="style4" id="whitetxt"> Edit User </a></span></td>
                                                <td width="98" align="center"><a href ="ViewFavourites" <span class="style4" id="whitetxt"> View Favourites </a></span></td>
                                                <td width="98" align="center"><a href ="BidsViewer" <span class="style4" id="whitetxt"> View Bid Details </a></span></td>
                                                
                                              
                                            </c:when>
                                        </c:choose>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>

                    <table width="996"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="images/banner.jpg" alt="" width="996" height="100" border="0" ></a></td>
                        </tr>
                    </table>
                                    <div>
    </body>
</html>
