/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Model.DataBase;
import Model.HibernateUtil;
import Order.MailSend;
import Order.Order;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class Shop extends HttpServlet {
    MailSend mail = new MailSend();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        boolean notLogedIn = false;        
        HttpSession session = request.getSession();
        Cart cart = new Cart();
        CartBean cartBean = new CartBean();
        CartBean cartItems = new CartBean();
        cartBean = (CartBean) session.getAttribute("Cart");
        String action = request.getParameter("action");
        if(session.getAttribute("username")!= null && cartBean != null && !cartBean.itemList().isEmpty()){
            if(!action.equals("") && action != null){
                if(action.equals("continue")){
                    request.getRequestDispatcher("Delivery.jsp").forward(request, response);
                }else if(action.equals("buy") && cartBean != null && !cartBean.itemList().isEmpty()){
                    Object objCartItem = session.getAttribute("Cart");
                    if(objCartItem != null){
                        cartItems = (CartBean) objCartItem;
                        String username = String.valueOf(session.getAttribute("username"));
                        onDataBase(cartItems, username, request);
                        String komentar = request.getParameter("komentar");
                        request.getRequestDispatcher("ShopSuccess.jsp").forward(request, response);
                    }
                }
            }
            
        }else{
            if(cartBean != null){
                request.setAttribute("Itemslist", cartBean.itemList());
                cart.allItemsCost(request, response);
            }
            request.setAttribute("notLogedIn", notLogedIn);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onDataBase(CartBean cartItems, String username, HttpServletRequest request) throws SQLException, MessagingException{
        Session hibernateSession = HibernateUtil.createSessionFactroy().openSession();
        HttpSession session = request.getSession();
        StringBuilder build = new StringBuilder();
        Order order = new Order();
        
        CartBean cartBean = (CartBean) session.getAttribute("Cart");
        String delivery = request.getParameter("dostava");
        switch(delivery){
            case "1":
                order.setDostava("Kurirskom službom");
                break;
            case "2":
                order.setDostava("Preporučeno pismo");
                break;
            case "3":
                order.setDostava("Preuzimanje u radnji");
        }
        
        order.setKorisnicko_ime(username);
        order.setDatum(String.valueOf(new Date(new java.util.Date().getTime())));
        order.setNapomena(request.getParameter("napomena"));
        for(int i=0; i<cartBean.itemList().size(); i++){
            CartItemBean cartItem = (CartItemBean) cartBean.itemList().get(i);
            build.append(cartItem.getSifraProizvoda());
            build.append(",");
            build.append(cartItem.getKomada());
            build.append(";");
        }
        build.substring(0, build.length()-1);
        order.setProizvodi(build.toString());
        
        sendMail(request);
        
        if(hibernateSession.isOpen()){
            hibernateSession.save(order);
            hibernateSession.close();
        }
        session.removeAttribute("Cart");
    }
    
    public void sendMail(HttpServletRequest request) throws SQLException, MessagingException{
        DataBase data = DataBase.getInstance();
        HttpSession jsession = request.getSession();
        String fromEmail = "toni.mosnak.1991@gmail.com";
        String username = "toni.mosnak.1991";
        String password = "tonimosnak1991";
        String subject = "Narudžbina";
        String message = "Vaša narudžbina je realizovana. Bićete kontaktirani u roku od 24 časa.";
        
        PreparedStatement statement = data.connection.prepareStatement("select * from korisnici where korisnicko_ime = ?");
        statement.setString(1, String.valueOf(jsession.getAttribute("username")));
        ResultSet result = statement.executeQuery();
        if(result.next()){
            mail.mailSend(username, password, subject, message, result.getString("email"), fromEmail);
        }
    }

}

