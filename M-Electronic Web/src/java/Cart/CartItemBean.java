package Cart;

import java.io.Serializable;

public class CartItemBean implements Serializable{
    private String slika;
    private String naziv;
    private String opis;
    private int sifraProizvoda;
    private double cena;
    private int komada;

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
     * @return the sifraProizvoda
     */
    public int getSifraProizvoda() {
        return sifraProizvoda;
    }

    /**
     * @param sifraProizvoda the sifraProizvoda to set
     */
    public void setSifraProizvoda(int sifraProizvoda) {
        this.sifraProizvoda = sifraProizvoda;
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
}
