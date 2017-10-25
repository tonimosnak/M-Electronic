/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Model.DataBase;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {
    CartBean cartBean = null;
    int value = 0;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = null;
        String action = null;
        action = request.getParameter("action");
        int komadaNaStanju = 0;
        int komadaUKorpu = 0;
        String[] cookiePageParse = null;
        
        Cookie[] pageCookie = request.getCookies();
            for(Cookie cookie : pageCookie){
                if("Page".equals(cookie.getName())){
                    cookiePageParse = cookie.getValue().split(",");
                    System.out.println(cookiePageParse[0]);
                }
            }
        
        try{
            if(request.getParameter("komada") != null && request.getParameter("komadaNaStanju") != null){
                komadaNaStanju = Integer.parseInt(request.getParameter("komadaNaStanju"));
                komadaUKorpu = Integer.parseInt(request.getParameter("komada"));
            }
            if(action != null && !action.equals("")){
                switch(action){
                    case "delete":
                        deleteFromCart(request, response);
                        cartBean = new CartBean();
                        session = request.getSession();
                        cartBean = (CartBean) session.getAttribute("Cart");
                        allItemsCost(request, response);
                        request.setAttribute("Itemslist", cartBean.itemList());
                        break;
                    case "showCart":
                        session = request.getSession();
                        cartBean = new CartBean();
                        if(session.getAttribute("Cart") != null){
                            CartItemBean cartItem = new CartItemBean();
                            cartBean = (CartBean) session.getAttribute("Cart");
                            allItemsCost(request, response);
                            request.setAttribute("Itemslist", cartBean.itemList());
                        }
                        break;
                    case "add":
                        if(komadaUKorpu <= komadaNaStanju && komadaNaStanju > 0 && komadaUKorpu > 0 && request.getParameter("naStanju").equals("Na stanju")){
                            addToCart(request, response);
                            allItemsCost(request, response);
                        }else{
                            session = request.getSession();
                            cartBean = new CartBean();
                            if(session.getAttribute("Cart") != null){
                                CartItemBean cartItem = new CartItemBean();
                                cartBean = (CartBean) session.getAttribute("Cart");
                                allItemsCost(request, response);
                                request.setAttribute("Itemslist", cartBean.itemList());
                            }
                        }
                        
                }
            }
            
            if(action.equals("showCart") || action.equals("delete")){
                try{
                    request.getRequestDispatcher("Cart.jsp").forward(request, response);
                }catch(Exception ex){
                    ex.printStackTrace();
                    response.sendRedirect("./");
                    return;
                }
            }else{
                try{
                    response.sendRedirect("./"+cookiePageParse[1]+"?page="+cookiePageParse[0]+"");
                }catch(Exception ex){
                    ex.printStackTrace();
                    response.sendRedirect("./");
                    return;
                }
            }
            
            cookiePageParse = null;
            
        }catch(Exception  ex){
            ex.printStackTrace();
            try{
                response.sendRedirect("./"+cookiePageParse[1]+"?page="+cookiePageParse[0]+"");
            }catch(Exception ex1){
                ex1.printStackTrace();
                response.sendRedirect("./");
                return;
            }
            
            cookiePageParse = null;
        }
    }
    
    public void addToCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();
        String slika = request.getParameter("slika");
        String naziv = request.getParameter("naziv");
        String opis = request.getParameter("opis");
        String sifraProizvoda = request.getParameter("sifraProizvoda");
        String cena = request.getParameter("cena");
        String komada = request.getParameter("komada");
        
        Object objCartBean = session.getAttribute("Cart");
        
        if(objCartBean != null){
            cartBean = (CartBean) objCartBean;
        }else{
            cartBean = new CartBean();
            session.setAttribute("Cart", cartBean);
        }
        cartBean.addCartItem(slika, naziv, opis, sifraProizvoda, cena, komada);
        request.setAttribute("Itemslist", cartBean.itemList());
        
        decreaseBaseKomada(Integer.parseInt(sifraProizvoda), Integer.parseInt(komada));
    }
    
    public void deleteFromCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();
        int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
        Object objCartBean = session.getAttribute("Cart");
        cartBean = (CartBean) objCartBean;
        cartBean.deleteItem(itemIndex);
        increaseBaseKomada(request,itemIndex);
    }
    
    public void allItemsCost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        cartBean = new CartBean();
        CartItemBean cartItem = new CartItemBean();
        cartBean = (CartBean) session.getAttribute("Cart");
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for(int i=0; i<cartBean.itemList().size(); i++){
            cartItem = (CartItemBean) cartBean.itemList().get(i);
            sum = sum + cartItem.getCena();
        }
        request.setAttribute("sum", df.format(sum));
    }
    
    public void decreaseBaseKomada(int sifraProizvoda,int komada) throws SQLException{
        DataBase base = DataBase.getInstance();
        DatabaseMetaData metaData = base.connection.getMetaData();
        PreparedStatement statement;
        ResultSet result1;
        ResultSet result = metaData.getTables(null, null, "podkategorija%", null);
        String podkategorija = null;
        while(result.next()){
            podkategorija = result.getString(3);
            statement = base.connection.prepareStatement("select komada from "+podkategorija+" where sifra_proizvoda = "+sifraProizvoda+"");
             result1 = statement.executeQuery();
            if(result1.next()){
                value = result1.getInt("komada");
                break;
            }
        }
        
        statement = base.connection.prepareStatement("update "+podkategorija+" set komada = "+(value - komada)+" where sifra_proizvoda = "+sifraProizvoda+"");
        statement.execute();
        
        if(!base.connection.isClosed()){
            base.connection.close();
        }
    }
    
    public void increaseBaseKomada(HttpServletRequest request, int itemIndex) throws SQLException{
        DataBase base = DataBase.getInstance();
        String komada = request.getParameter("komadaCart");
        DatabaseMetaData metaData = base.connection.getMetaData();
        PreparedStatement statement;
        ResultSet result1;
        ResultSet result = metaData.getTables(null, null, "podkategorija%", null);
        while(result.next()){
            statement = base.connection.prepareStatement("select komada from "+result.getString(3)+" where sifra_proizvoda = "+Integer.parseInt(request.getParameter("sifraProizvoda"))+"");
            result1 = statement.executeQuery();
            if(result1.next()){
                statement = base.connection.prepareStatement("update "+result.getString(3)+" set komada = ("+(result1.getInt("komada") + Integer.parseInt(komada))+") where sifra_proizvoda = ("+Integer.parseInt(request.getParameter("sifraProizvoda"))+")");
                statement.execute();
                break;
            }
        }
        
        if(!base.connection.isClosed()){
            base.connection.close();
        }
    }
}
