
<%-- 
    Document   : index
    Created on : Jan 7, 2013, 6:31:02 PM
    Author     : ZenitH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Announce.lk</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body class="body">
        <%@ include file="/Header.jsp" %> 
        <form action="ItemBrandControler" method="get">
        <table width="996"  border="0" cellspacing="0" cellpadding="0" class="popular">
            <tr>
                <td height="40" ><img src="images/spacer.gif" alt="" width="27" height="19"><span class="popular_text">Latest Phones for sale </span>
                    <a  id="whitetxt"><select name="type" size="1" >
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
                                            
                        </select></a>
                    <input float="left" tabindex="6" type="submit" class="btn" value="Filter" onclick="ItemBrandControler"/> </td>
           </tr>


        </table>



        <table width="1000"  border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td height="479">&nbsp;</td>
                <td align="left" valign="top">

            <c:forEach var="display" items="${items}">
                
                    <table width="207" height="234"  border="0" cellpadding="0" cellspacing="0" class="productleft_top">
                        <tr>
                            <td align="left" valign="top" class="newtovar">
                                <table width="207"  border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td height="200" valign="top">
                                            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    
                                                    <td height="53"><span class="style7">${display.title}<br> 
                                                               <br> 
                                                          
                                                                </a></span>
                                                        
                                                     
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td height="147" align="center"><a target="_blank" href="getImage?imgName=${display.imageName}"><img src="getImage?imgName=${display.imageName}" alt="" width="175" height="144" border="0"></a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35">
                                            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="38%" height="24"><span class="style7"><a href="DisplayFullAdd?id=${display.id}" id="blue1" >More details</a></span></td>
                                                    <td width="23%">&nbsp;</td>
                                                <rd>
                                                                
                                                    
                                                </rd>
                                                    <td width="39%" class="price">Rs.${display.price} </td>
                                                </tr>
                                            </table>
                                        </td>                                    
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>


    </c:forEach>


                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
</form>
        <%@ include file="/Footer.jsp" %> 
    </body>
</html>
