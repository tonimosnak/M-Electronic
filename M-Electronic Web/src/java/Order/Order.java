package Order;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "narudzbine")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String korisnicko_ime;
    private String proizvodi;
    private String dostava;
    private String datum;
    private String napomena;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the korisnicko_ime
     */
    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    /**
     * @param korisnicko_ime the korisnicko_ime to set
     */
    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    /**
     * @return the narudzbine
     */
    public String getProizvodi() {
        return proizvodi;
    }

    /**
     * @param narudzbine the narudzbine to set
     */
    public void setProizvodi(String proizvodi) {
        this.proizvodi = proizvodi;
    }

    /**
     * @return the dostava
     */
    public String getDostava() {
        return dostava;
    }

    /**
     * @param dostava the dostava to set
     */
    public void setDostava(String dostava) {
        this.dostava = dostava;
    }

    /**
     * @return the datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }

    /**
     * @return the napomena
     */
    public String getNapomena() {
        return napomena;
    }

    /**
     * @param napomena the napomena to set
     */
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

}
