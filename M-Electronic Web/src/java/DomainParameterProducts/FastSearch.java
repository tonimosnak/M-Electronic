/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainParameterProducts;

import Model.DataBase;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni
 */
@WebServlet(name = "FastSearch", urlPatterns = {"/FastSearch"})
public class FastSearch extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        String pretraga =  request.getParameter("pretraga");
        boolean infoShow = true;
        boolean productsExist = true;
        
        if(!pretraga.equals("")){
            
            List<FastSearchBeans> productsList = new ArrayList();
            
            FastSearchBeans product = null;
            DataBase base = DataBase.getInstance();
            DatabaseMetaData md = base.connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "podkategorija%", null);
            
            while(rs.next()){
                
                PreparedStatement statementProducts = base.connection.prepareStatement("select * from "+rs.getString(3)+" where naziv like '%"+pretraga+"%' or cena like '%"+pretraga+"%' or komada like '%"+pretraga+"%' or opis like '%"+pretraga+"%' or sifra_proizvoda like '%"+pretraga+"%' or slika like '%"+pretraga+"%' or na_stanju like '%"+pretraga+"%'");
                
                ResultSet resultProducts = statementProducts.executeQuery();
                
                while(resultProducts.next()){
                    product = new FastSearchBeans();
                    product.setNaziv(resultProducts.getString("naziv"));
                    product.setCena(resultProducts.getDouble("cena"));
                    product.setKomada(resultProducts.getInt("komada"));
                    product.setSlika(resultProducts.getString("slika"));
                    product.setOpis(resultProducts.getString("opis"));
                    product.setNa_stanju(resultProducts.getString("na_stanju"));
                    product.setSifra_proizvoda(resultProducts.getInt("sifra_proizvoda"));
                    product.setKomada(resultProducts.getInt("komada"));
                    productsList.add(product);
                }
                
            }
            
            request.setAttribute("listaProizvodi", productsList);
            base.connection.close();
        }else{
            productsExist = false;
        }
        
        request.setAttribute("fastSearchPaging", productsExist);
        
        
        
        request.setAttribute("infoShow", infoShow);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FastSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FastSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
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
