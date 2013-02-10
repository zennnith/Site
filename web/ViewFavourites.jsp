<%-- 
    Document   : ViewFavourites
    Created on : Jan 17, 2013, 1:22:22 PM
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
        <h2> List of Favourits are </h2>
           <table width="1000"  border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td height="479">&nbsp;</td>
                <td align="left" valign="top">

            <c:forEach var="stylesE" items="${favs}">
                
                    <table width="207" height="234"  border="0" cellpadding="0" cellspacing="0" class="productleft_top">
                        <tr>
                            <td align="left" valign="top" class="newtovar">
                                <table width="207"  border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td height="200" valign="top">
                                            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    
                                                    <td height="53"><span class="style7">${stylesE.title}<br> 
                                                               <br> 
                                                          
                                                                </a></span>
                                                        
                                                     
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td height="147" align="center"><a target="_blank" href="getImage?imgName=${stylesE.imageName}"><img src="getImage?imgName=${stylesE.imageName}" alt="" width="175" height="144" border="0"></a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35">
                                            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="38%" height="24"><span class="style7"><a href="DisplayFullAdd?id=${stylesE.id}" id="blue1" >More details</a></span></td>    
                  
                                                    <td width="23%">&nbsp;</td>
                                                <rd>
                                                                
                                                    
                                                </rd>
                                                    <td width="39%" class="price">Rs.${stylesE.price} </td>
                                                </tr>
                                            </table>
                                        </td>                                    
                                    </tr>
                                </table>
                            </td>
                        </tr>
                         <a href ="RemoveListItem?itemID=${stylesE.id}" >Remove </a> 
                      </table>
                                             
                                              

    </c:forEach>


                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
        
        <%@ include file="/Footer.jsp" %>
    </body>
</html>
