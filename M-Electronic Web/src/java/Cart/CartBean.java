package Cart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private List list = new ArrayList();
    
    public void addCartItem(String slika, String naziv, String opis, String sifraProizvoda, String cena, String komada){
        CartItemBean item = new CartItemBean();
        try{
            int komadaPars = Integer.parseInt(komada);
            double suma = komadaPars * Double.parseDouble(cena);
            DecimalFormat df = new DecimalFormat("#.##");
            item.setSlika(slika);
            item.setNaziv(naziv);
            item.setOpis(opis);
            item.setSifraProizvoda(Integer.parseInt(sifraProizvoda));
            item.setCena(Double.parseDouble(df.format(suma)));
            item.setKomada(komadaPars);
            list.add(item);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public List itemList(){
        if(list.isEmpty()){
            list.clear();
        }
        return list;
    }
    
    public void deleteItem(int itemIndex){
        try{
            if(!list.isEmpty()){
                list.remove(itemIndex - 1);
            }
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }
}
