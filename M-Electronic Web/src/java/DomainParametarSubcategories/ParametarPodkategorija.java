/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainParametarSubcategories;

import Model.HibernateUtil;
import Subcategories.Elektrika;
import Subcategories.ElektronskeKomponente;
import Categories.Kategorije;
import Subcategories.ElementiZaMontazu;
import Subcategories.InstrumentiIAlat;
import Subcategories.IzvoriNapajanja;
import Subcategories.Kablovi;
import Subcategories.OptoElementi;
import Subcategories.PotrosniMaterijal;
import Subcategories.Svetlo;
import Subcategories.Transformatori;
import Subcategories.Zvuk;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Toni
 */
@WebServlet(name = "ParametarPodkategorija", urlPatterns = {"/ParametarPodkategorija"})
public class ParametarPodkategorija extends HttpServlet {

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
            HttpSession jsession = request.getSession();
            if(jsession.getAttribute("username") != null){
                System.out.println(jsession.getAttribute("username").toString());
            }
            
            int number = Integer.parseInt(request.getParameter("id"));
            
            Kategorije kategorija = (Kategorije) session.get(Kategorije.class,number);
            
            switch(number){
                case 1:
                   List<Elektrika> lista1 = kategorija.getElektrika();
                   request.setAttribute("listaPodKategorija", lista1);
                   break;
                case 2:
                   List<ElektronskeKomponente> lista2 = kategorija.getElektronskeKomponente();
                   request.setAttribute("listaPodKategorija", lista2);
                   break;
                case 3:
                   List<ElementiZaMontazu> lista3 = kategorija.getElementiZaMontazu();
                   request.setAttribute("listaPodKategorija", lista3);
                   break;
                case 4:
                   List<InstrumentiIAlat> lista4 = kategorija.getInstrumentiIAlat();
                   request.setAttribute("listaPodKategorija", lista4);
                   break;
                case 5:
                   List<IzvoriNapajanja> lista5 = kategorija.getIzvoriNapajanja();
                   request.setAttribute("listaPodKategorija", lista5);
                   break;
                case 6:
                   List<Kablovi> lista6 = kategorija.getKablovi();
                   request.setAttribute("listaPodKategorija", lista6);
                   break;
                case 7:
                   List<OptoElementi> lista7 = kategorija.getOptoElementi();
                   request.setAttribute("listaPodKategorija", lista7);
                   break;
                case 8:
                   List<PotrosniMaterijal> lista8 = kategorija.getPotrosniMaterijal();
                   request.setAttribute("listaPodKategorija", lista8);
                   break;
                case 9:
                   List<Svetlo> lista9 = kategorija.getSvetlo();
                   request.setAttribute("listaPodKategorija", lista9);
                   break;
                case 10:
                   List<Transformatori> lista10 = kategorija.getTransformatori();
                   request.setAttribute("listaPodKategorija", lista10);
                   break;
                case 11:
                   List<Zvuk> lista11 = kategorija.getZvuk();
                   request.setAttribute("listaPodKategorija", lista11);
                   break; 
            }
            
            request.setAttribute("page", "1");
            
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
