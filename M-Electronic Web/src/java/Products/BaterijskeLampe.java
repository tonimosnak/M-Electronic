package Products;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "podkategorija_baterijske_lampe")
public class BaterijskeLampe implements Serializable {

    @Id
    private int id;
    private String naziv;
    private double cena;
    private int komada;
    private String slika;
    private String opis;
    private String na_stanju;
    private int sifra_proizvoda;
    private String datum;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     * @return the komada
     */
    public int getKomada() {
        return komada;
    }

    /**
     * @param komada the komada to set
     */
    public void setKomada(int komada) {
        this.komada = komada;
    }

    /**
     * @return the slika
     */
    public String getSlika() {
        return slika;
    }

    /**
     * @param slika the slika to set
     */
    public void setSlika(String slika) {
        this.slika = slika;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the na_stanju
     */
    public String getNa_stanju() {
        return na_stanju;
    }

    /**
     * @param na_stanju the na_stanju to set
     */
    public void setNa_stanju(String na_stanju) {
        this.na_stanju = na_stanju;
    }

    /**
     * @return the sifra_proizvoda
     */
    public int getSifra_proizvoda() {
        return sifra_proizvoda;
    }

    /**
     * @param sifra_proizvoda the sifra_proizvoda to set
     */
    public void setSifra_proizvoda(int sifra_proizvoda) {
        this.sifra_proizvoda = sifra_proizvoda;
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
}
