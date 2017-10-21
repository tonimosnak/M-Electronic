package Subcategories;

import Categories.Kategorije;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kategorija_elektronske_komponente")
public class ElektronskeKomponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String naziv;
    
    private String slika;
    
    private String pod_kategorija;
    
    @ManyToOne(targetEntity = Kategorije.class)
    private Kategorije kategorija;
    

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
     * @return the kategorija
     */
    public Kategorije getKategorija() {
        return kategorija;
    }

    /**
     * @param kategorija the kategorija to set
     */
    public void setKategorija(Kategorije kategorija) {
        this.kategorija = kategorija;
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
     * @return the pod_kategorija
     */
    public String getPod_kategorija() {
        return pod_kategorija;
    }

    /**
     * @param pod_kategorija the pod_kategorija to set
     */
    public void setPod_kategorija(String pod_kategorija) {
        this.pod_kategorija = pod_kategorija;
    }
}
