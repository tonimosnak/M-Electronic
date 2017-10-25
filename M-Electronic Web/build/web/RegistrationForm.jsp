<%-- 
    Document   : RegistrationForm
    Created on : 21.10.2017., 16.24.57
    Author     : Toni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
