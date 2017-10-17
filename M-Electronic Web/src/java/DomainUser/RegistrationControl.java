/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainUser;

import Users.Korisnici;
import Model.HibernateUtil;
import DomainParametersRegularExpression.ParametersRegularExpression;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Toni
 */
@WebServlet(name = "RegistrationControl", urlPatterns = {"/RegistrationControl"})
public class RegistrationControl extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Session session = HibernateUtil.createSessionFactroy().openSession();
            ParametersRegularExpression pc = new ParametersRegularExpression();
            
            SQLQuery query1 = session.createSQLQuery("select k.korisnicko_ime from korisnici k where binary k.korisnicko_ime = :username");
            query1.setParameter("username", request.getParameter("username"));
            List<String> list = query1.list();
            
            Korisnici korisnik = new Korisnici();
            
            for(String row : list){
                korisnik.setKorisnickoIme(row);
            }
            boolean controled = true;
            boolean success = true;
            boolean register = true;
            String attentionName = "Nepravilan unos!";
            String attentionSurname = "Nepravilan unos!";
            String attentionEmail = "Nepravilan unos!";
            String attentionPhoneNumber = "Nepravilan unos!";
            String attentionConfirmPassword = "Lozinka nije ista!";
            String sameUsername = "Korisničko ime već postoji!";
            String attentionUsername = "Upisite 6-18 karaktera (slova + brojevi,specijalni karakteri)";
            String attentionPassword = "Upisite 8-20 karaktera (slova + brojevi,specijalni karakteri)";
            String attentionCity = "Nepravilan unos!";
            String attentionStreet = "Nepravilan unos!";
            String parameterName = request.getParameter("name");
           // byte[] bytes = parameterName.getBytes(StandardCharsets.ISO_8859_1);
            //parameterName = new String(bytes, StandardCharsets.UTF_8);
            boolean name = pc.name(parameterName);
            boolean surname = pc.surname(request.getParameter("surname"));
            System.out.println(parameterName);
            boolean username = pc.username(request.getParameter("username"));
            boolean password = pc.password(request.getParameter("password"));
            boolean confirmPassword = pc.confirmPassword(request.getParameter("confirmPassword"));           
            boolean city = pc.city(request.getParameter("city"));
            boolean street = pc.street(request.getParameter("street"));
            boolean email = pc.email(request.getParameter("email"));
            boolean phoneNumber = pc.phoneNumber(request.getParameter("phoneNumber"));
            
            if(korisnik.getKorisnickoIme() == null){
                if(request.getParameter("password").equals(request.getParameter("confirmPassword"))){

                        if(name == false){
                            request.setAttribute("attentionName", attentionName);
                        }

                        if(surname == false){
                            request.setAttribute("attentionSurname", attentionSurname);
                        }

                        if(email == false){
                            request.setAttribute("attentionEmail", attentionEmail);
                        }

                        if(phoneNumber == false){
                            request.setAttribute("attentionPhoneNumber", attentionPhoneNumber);
                        }

                        if(username == false){
                            request.setAttribute("attentionUsername", attentionUsername);
                        }

                        if(password == false){
                            request.setAttribute("attentionPassword", attentionPassword);
                        }
                        
                        if(city == false){
                            request.setAttribute("attentionCity", attentionCity);
                        }
                        
                        if(street == false){
                            request.setAttribute("attentionStreet", attentionStreet);
                        }

                    boolean[] control = {name, surname, username, password, email, phoneNumber, city, street};
                    for(int i=0; i<control.length; i++){
                        if(control[i] == false){
                            controled = false;
                            break;
                        }
                    }
                    if(controled == false){

                        request.setAttribute("register", register);
                        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
                        return;
                    }else{
                        request.setAttribute("success", success);
                        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
                    }

                    korisnik.setIme(request.getParameter("name"));
                    korisnik.setPrezime(request.getParameter("surname"));
                    korisnik.setKorisnickoIme(request.getParameter("username"));
                    korisnik.setLozinka(request.getParameter("password"));
                    korisnik.setEmail(request.getParameter("email"));
                    korisnik.setBrojTelefona(request.getParameter("phoneNumber"));
                    korisnik.setMestoIPostanskiBroj(request.getParameter("city"));
                    korisnik.setUlicaIBroj(request.getParameter("street"));

                    session.save(korisnik);

                    Query query = session.createSQLQuery("update korisnici set lozinka = password('"+request.getParameter("password")+"') where lozinka = '"+request.getParameter("password")+"'");
                    query.executeUpdate();


                }else{
                    request.setAttribute("register", register);
                    request.setAttribute("attentionConfirmPassword", attentionConfirmPassword);
                    request.getRequestDispatcher("HomePage.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("register", register);
                request.setAttribute("sameUsername", sameUsername);
                request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            }
            
            if(session.isOpen()){
                session.close();
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
