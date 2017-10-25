/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainParameterProducts;

import Controller.Paging;
import Model.HibernateUtil;
import Products.UtikaciIUticnice;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Toni
 */
@WebServlet(name = "podkategorija_utikaci_i_uticnice", urlPatterns = {"/podkategorija_utikaci_i_uticnice"})
public class PodkategorijaUtikaciIUticnice extends HttpServlet {
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
        try{
            String link = "podkategorija_utikaci_i_uticnice";
            String directori = "UtikaciIUticnice";
            boolean infoShow = true;
            int page = Integer.parseInt(request.getParameter("page"));
            
            Session session = HibernateUtil.createSessionFactroy().openSession();
            
            Cookie[] pageCookie = request.getCookies();
            
            for(Cookie cookie : pageCookie){
                if("Page".equals(cookie.getName())){
                    cookie.setValue(String.valueOf(page) + ',' + link);
                    response.addCookie(cookie);
                }
            }
            
            Query queryPage = session.createQuery("from UtikaciIUticnice").setFirstResult((page - 1)*4).setMaxResults(4);
            List<UtikaciIUticnice> result = queryPage.list();
            
            Query query = session.createQuery("from UtikaciIUticnice");
            List<UtikaciIUticnice>lista =  query.list();
            
            Paging paging = new Paging();
            request.setAttribute("directori", directori);
            request.setAttribute("pagingLinksSubcategorie", paging.paging(lista, page));
            request.setAttribute("lastPage", paging.lastPage());
            request.setAttribute("listaProizvodi", result);
            request.setAttribute("infoShow", infoShow);
            request.setAttribute("subcategory", link);
            
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            
            if(session.isOpen()){
                session.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("./");
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
