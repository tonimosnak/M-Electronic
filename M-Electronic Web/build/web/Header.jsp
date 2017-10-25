<%@page import="Cart.CartBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DomainUser.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div id="CartImage">
                    <input type="image" width="80" value="submit" src="Images/Shop.png">
                </div>
                <%
                    int counter = 0;
                    request.setAttribute("counter", counter);
                    CartBean cartBean = new CartBean();
                    if(session.getAttribute("Cart") != null){
                        cartBean = (CartBean) session.getAttribute("Cart");
                        request.setAttribute("ItemslistCounter", cartBean.itemList());
                    }
                %>
                <c:forEach items="${ItemslistCounter}" var="numberOfItems">
                    <span hidden="${counter = counter + 1}"></span>
                </c:forEach>
                <div>
                    <span id="ItemsInCart">${counter}</span>

                </div>
            </div>
        </form>
</div>
