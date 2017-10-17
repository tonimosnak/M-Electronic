package Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "korisnici")
public class Korisnici {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String ime;
    private String prezime;
    
    @Column(name = "korisnicko_ime")
    private String korisnickoIme = null;
    
    private String lozinka = null;
    private String email;
    
    @Column (name = "broj_telefona")
    private String brojTelefona;
    
    @Column (name = "mesto_i_postanski_broj")
    private String mestoIPostanskiBroj;
    
    @Column (name = "ulica_i_broj")
    private String ulicaIBroj;
    

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the brojTelefona
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * @param brojTelefona the brojTelefona to set
     */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the mestoIPostanskiBroj
     */
    public String getMestoIPostanskiBroj() {
        return mestoIPostanskiBroj;
    }

    /**
     * @param mestoIPostanskiBroj the mestoIPostanskiBroj to set
     */
    public void setMestoIPostanskiBroj(String mestoIPostanskiBroj) {
        this.mestoIPostanskiBroj = mestoIPostanskiBroj;
    }

    /**
     * @return the ulicaIBroj
     */
    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    /**
     * @param ulicaIBroj the ulicaIBroj to set
     */
    public void setUlicaIBroj(String ulicaIBroj) {
        this.ulicaIBroj = ulicaIBroj;
    }
    
}
