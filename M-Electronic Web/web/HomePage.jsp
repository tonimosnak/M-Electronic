<%-- 
    Document   : Naslovna
    Created on : May 7, 2017, 12:21:50 PM
    Author     : Toni
--%>
<%@page import="Cart.Cart"%>
<%@page import="org.jboss.weld.context.http.Http"%>
<%@page import="DomainUser.Login"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
<db:setDataSource var="base" driver="com.mysql.jdbc.Driver" user="root" password="" url="jdbc:mysql://localhost/m_electronic"/>
<db:query dataSource="${base}" var="data" sql="select * from kategorije"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a href="HomePage.jsp" id="Title"><h1 id="TitlePosition">M-Electronic</h></a>
                </div>
                <div id="Form">
                    <div id="RegisterForm">
                        <form method="post" action="Registration">
                            &nbsp;<input type="submit" name="register" value="Registracija" id="Register" />
                        </form>
                    </div>
                    <form method="post" action="Login">
                        <div id="Login-out">
                            <div>
                                <c:if test="${username != null}">
                                    &nbsp;<input type="submit" name="logout" value="Odjava" id="Logout"/>
                                    <%
                                        if(request.getParameter("logout")== null){
                                            Login.logout = 1;
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
                    <div id="Pretraga">
                        <form method="post" action="FastSearch">
                            <span id="Unos">Unesite naziv ili neku ključnu reč(opis):&nbsp;<input type="text" name="pretraga"></span>
                            <input type="submit" name="pretrazi" value="pretraga">
                        </form>
                    </div>
                </div>
                    <form method="post" action="Cart">
                        <div id="Korpa">
                            <input type="hidden" name="action" value="showCart">
                            <input type="image" width="80" value="submit" src="Images/Shop.png">
                        </div>
                    </form>
            </div>
            <div id="Navigation">
                <div><a class="ex" id="Home" href="HomePage.jsp">Naslovna</a></div>
                <div><a class="ex" id="AboutUs" href="HomePage.jsp">O nama</a></div>
                <div><a class="ex" id="Contact" href="HomePage.jsp">Kontakt</a></div>
            </div>
            <div id="KategoryBorder">
                <c:forEach items="${data.rows}" var="component">
                    <p><a class="ex" id="Kategories" href="ParametarPodkategorija?Kategorija=${component.id}">${component.naziv}</a></p>
                </c:forEach>
            </div>
            <div id="Podkategorije">
                <c:forEach items="${listaPodKategorija}" var="podkategorija">
                    <a href="${podkategorija.pod_kategorija}"  class="ex" style="color: brown;"><div id="Podkategorija">   
                        <p><img src="ImagesPodkategorije/${podkategorija.slika}" width="120"></p>
                        <p style="color: brown;">${podkategorija.naziv}</p>
                    </div></a>
                </c:forEach>
            </div>
            <div id="Proizvodi">
                <c:forEach items="${listaProizvodi}" var="proizvod">
                    <div id="Proizvod">
                        <img id="Image" src="ImagesProizvodi/${proizvod.slika}" width="90">&nbsp;
                        <div id="Naziv"><p>${proizvod.naziv}</p></div>
                        <div style="width: 300px; float: right;">
                            <div id="Cena">${proizvod.cena} din.</div>
                            <div id="KomadaUKorpuDiv">
                                <div id="SifraProizvoda">Šifra proizvoda:&nbsp;${proizvod.sifra_proizvoda}</div>
                                <form method="post" action="Cart">
                                    <input type="hidden" value="${proizvod.opis}" name="opis">
                                    <input type="hidden" value="${proizvod.slika}" name="slika">
                                    <input type="hidden" value="${proizvod.naziv}" name="naziv">
                                    <input type="hidden" value="${proizvod.cena}" name="cena">
                                    <input type="hidden" value="${proizvod.sifra_proizvoda}" name="sifraProizvoda">
                                    <input type="hidden" value="${proizvod.na_stanju}" name="naStanju">
                                    <div>
                                        <span style="font-family: sans-serif; font-size: 85%;">Komada:</span>&nbsp;<input type="text" value="1" name="komada" id="KomadaUKorpu">
                                        <input type="hidden" name="komadaNaStanju" value="${proizvod.komada}">
                                        <input type="hidden" name="action" value="add">
                                        <input type="submit" value="U korpu">
                                    </div>
                                </form>
                                <c:choose>
                                    <c:when test="${proizvod.komada != 0 && proizvod.na_stanju eq 'Na stanju'}">
                                        <span id="NaStanju">${proizvod.na_stanju}:&nbsp;${proizvod.komada}&nbsp;kom.</span>&nbsp;
                                    </c:when>
                                    <c:otherwise>
                                        <span id="NaStanju"><span style="font-weight: bold;">Nema na stanju</span></span>
                                    </c:otherwise>
                                </c:choose>    
                            </div>
                        </div>
                        <div id="Opis"><p>${proizvod.opis}</p></div>
                    </div><br>
                </c:forEach>
                <c:if test="${empty listaProizvodi && infoShow == true}">
                    <p id="nepronadjeniProizvodi">Nije pronadjen ni jedan proizvod</p>
                </c:if>
            </div>       
            <c:if test="${register == true}">
                <div id="RegistrationDiv">
                    <form method="post" action="RegistrationControl">
                        <div id="RegistrationForms">
                            <p class="data">Ime:&emsp;<input type="text" name="name"></p>
                            <p class="Control">${attentionName}&nbsp;</p>
                            <p class="data">Prezime:&emsp;<input type="text" name="surname">
                            <p class="Control">${attentionSurname}&nbsp;</p>
                            <p class="data">Korisničko ime:&emsp;<input type="text" name="username">
                            <p class="Control">${attentionUsername}${sameUsername}&nbsp;</p>
                            <p class="data">Lozinka:&emsp;<input type="password" name="password">
                            <p class="Control">${attentionPassword}&nbsp;</p>
                            <p class="data">Ponovite lozinku:&emsp;<input type="password" name="confirmPassword">
                            <p class="Control">${attentionConfirmPassword}&nbsp;</p>
                            <p class="data">Mesto i poštanski broj:&nbsp;<input type="text" name="city" >
                            <p class="Control">${attentionCity}&nbsp;</p>
                            <p class="data">Ulica i broj:&nbsp;<input type="text" name="street">
                            <p class="Control">${attentionStreet}&nbsp;</p>
                            <p class="data">Email:&emsp;<input type="text" name="email">
                            <p class="Control">${attentionEmail}&nbsp;</p>
                            <p class="data">Broj telefona:&emsp;<input type="text" name="phoneNumber">
                            <p class="Control">${attentionPhoneNumber}&nbsp;</p>
                            <p id="RegisterButton"><input type="submit" name="registerYourSelf" value="Registruj se"></p>
                        </div>
                    </form>
                </div>
            </c:if>    
            <c:if test="${success == true}">
                <div id="RegisterSuccess">Uspešno ste se registrovani na naš sajt.</div>
            </c:if>
            <c:forEach items="${Itemslist}" var="proizvod">
                ${proizvod}
            </c:forEach>
        </div>
    </body>
</html>
