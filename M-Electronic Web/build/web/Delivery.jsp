<%-- 
    Document   : Delivery
    Created on : Jun 28, 2017, 6:09:04 PM
    Author     : Toni
--%>
<%@page import="DomainUser.LoginCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>M-Electronic</title>
        <link rel="icon" href="Images/Transistor.ico">
        <link href="CSS/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body id="Body">
        <div id="Wrapper">
            <div id="Header">
                <div id="HeaderImage">
                    <img src="Images/Components.png" width="150">
                </div>
                <div id="HeaderTitle">
                    <a href="HomePage.jsp" id="Title" class="ex"><h1 id="TitlePosition">M-Electronic</h></a>
                </div>
                <div id="Form">
                    <form method="post" action="LoginCart">
                        <div id="Login-out">
                            <div>
                                <c:if test="${username != null}">
                                    &nbsp;<input type="submit" name="logout" value="Odjava" id="Logout"/>
                                    <%
                                        if(request.getParameter("logout")== null){
                                            LoginCart.logout = 1;
                                        };
                                    %>
                                </c:if>
                            </div>
                            <div>
                                <c:if test="${username == null}">
                                    &nbsp;<input type="submit" name="login" value="Prijava" id="Login"/>
                                </c:if>
                            </div>
                        </div>
                        <div id="LoginForm">
                            Korisničko ime:&nbsp;<input type="text" name="usernameLogin" id="Username" />
                            Lozinka:&nbsp;<input type="password" name="passwordLogin" id="Password" />
                        </div>
                    </form>
                    <div id="UserLogin">
                        <p id="UserLogged">${username}</p>
                    </div>
                    <div id="NotLogin">
                        <p id="UserNotLogged">&nbsp;${wrong}</p>
                    </div>
                </div>
            </div> 
            <div id="Dostava">
                <form method="post" action="Shop">
                    <div id="Posiljka">
                        <input type="radio" name="dostava" value="1">&nbsp;Kurirskom službom<br><br>
                        <input type="radio" name="dostava" value="2">&nbsp;Preporučeno pismo<br><br>
                        <input type="radio" checked="" name="dostava" value="3">&nbsp;Preuzimanje u radnji<br>
                    </div>
                    <div id="Napomena">
                        Napomena:<br><textarea name="napomena" style="font-family: sans-serif; width: 200px; height: 100px;"></textarea><br>
                    </div>
                    <div id="Kupi">
                        <input type="hidden" name="action" value="buy">
                        <input type="submit" name="kupi" value="Kupi">
                    </div>
                </form>
            </div>
        </div>        
    </body>            
</html>
