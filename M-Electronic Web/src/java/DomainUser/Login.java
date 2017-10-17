package DomainUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Users.Korisnici;
import Model.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Toni
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    public String username;
    public static int logout;
    public HttpSession jsession;
    SQLQuery query;
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
            jsession = request.getSession();
            Cookie cookie;
            Korisnici k = null;
            if(jsession.getAttribute("username") == null){
                SQLQuery query = session.createSQLQuery("select k.korisnicko_ime,k.lozinka from korisnici k where binary k.korisnicko_ime = :username and binary lozinka = password(:password)");
                String usernameParam = request.getParameter("usernameLogin");
                String passwordParam = request.getParameter("passwordLogin");
                
                query.setParameter("username", usernameParam);
                query.setParameter("password", passwordParam);
                
                List<Object[]> list = query.list();
                k = new Korisnici();
                for(Object[] row:list){
                    k.setKorisnickoIme(row[0].toString());
                    k.setLozinka(row[1].toString());
                }
                
                if(k.getKorisnickoIme() != null && k.getLozinka() != null){
                    username = request.getParameter("usernameLogin");
//                    cookie = new Cookie("Cart","123");
                    jsession.setAttribute("username", username);
//                    cookie.setMaxAge(60);
//                    response.addCookie(cookie);
                    request.setAttribute("username", username);
//                    query = session.createSQLQuery("create table "+jsession.getAttribute("username")+"(id int primary key auto_increment,sifra_proizvoda int,naziv varchar(45),komada int,cena decimal(4,2))");
//                    query.executeUpdate();
                    response.sendRedirect("/M-Electronic/");
                }else{
                    String wrong = "Pogrešno korisničko ime ili lozinka!";
                    request.setAttribute("wrong", wrong);
                    request.getRequestDispatcher("HomePage.jsp").forward(request, response);
                }
            }else{
                if(logout == 1){
//                query = session.createSQLQuery("drop table "+jsession.getAttribute("username")+"");
//                query.executeUpdate();
                jsession.removeAttribute("username");
                logout = 0;
                }
                response.sendRedirect("/M-Electronic/");
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
