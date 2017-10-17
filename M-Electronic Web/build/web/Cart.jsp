<%-- 
    Document   : Cart.jsp
    Created on : Jun 23, 2017, 2:37:22 PM
    Author     : Toni
--%>
<%@page import="DomainUser.LoginCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <div id="ProizvodUKorpi">
                <c:choose>
                    <c:when test="${Itemslist != null && !Itemslist.isEmpty()}">
                        <table id="Tabela">
                            <th style="width: 110px;">Slika</th>
                                    <th style="width: 200px; font-weight: 100;">Naziv</th>
                                    <th style="font-weight: 100;">Opis</th>
                                    <th style="width: 70px; font-weight: 100;">Šifra proizvoda</th>
                                    <th style="width: 90px; font-weight: 100;">Cena</th>
                                    <th style="font-weight: 100; width: 60px;">Komada</th>
                                    <th style="width: 105px;"></th>
                            <c:forEach items="${Itemslist}" var="item" varStatus="counter">
                                <tr>
                                    <th style="width: 110px;"><img src="ImagesProizvodi/${item.slika}" width="50" ></th>
                                    <th style="width: 200px; font-weight: 100;">${item.naziv}</th>
                                    <th style="font-weight: 100;">${item.opis}</th>
                                    <th style="width: 70px; font-weight: 100;">${item.sifraProizvoda}</th>
                                    <th style="width: 120px; font-weight: 100;">${item.cena}&nbsp;din.</th>
                                    <th style="font-weight: 100;">${item.komada}</th>
                                    <th style="width: 105px;">
                                        <form method="post" action="Cart">
                                            <input type="hidden" name="sifraProizvoda" value="${item.sifraProizvoda}">
                                            <input type="hidden" name="komadaCart" value="${item.komada}">
                                            <input type="hidden" name="itemIndex" value="${counter.count}">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="submit" value="Izbaci iz korpe">
                                        </form>
                                    </th>
                                </tr>
                            </c:forEach>
                        <c:if test="${sum != 0}">
                            <tr>
                                <th colspan="5">
                                    <span style="float: left; margin-left: 30px; margin-top: 10px;">Ukupno:</span><span style="float: right; margin: 10px; margin-right: 30px;">${sum}&nbsp;din.</span>
                                </th>
                            </tr>
                        </c:if>
                        </table><br>
                        <c:if test="${sum != 0}">
                            <form method="post" action="Shop" id="ZavrsiSaKupovinom">
                                <input type="hidden" name="action" value="continue">
                                <input type="submit" name="shop" value="Završi kupovinu" >
                            </form>
                        </c:if>
                        <c:if test="${notLogedIn == false}">
                            <p style="float: left; clear: left; margin-left: 460px; ">Da biste završili sa kupovinom, morate da se prijavite.</p>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <div id="praznaKorpa">Vaša korpa je prazna</div>
                    </c:otherwise>
                </c:choose>       
            </div>
        </div>        
    </body>            
</html>
