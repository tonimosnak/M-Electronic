package Categories;

import Subcategories.Elektrika;
import Subcategories.ElektronskeKomponente;
import Subcategories.ElementiZaMontazu;
import Subcategories.InstrumentiIAlat;
import Subcategories.IzvoriNapajanja;
import Subcategories.Kablovi;
import Subcategories.OptoElementi;
import Subcategories.PotrosniMaterijal;
import Subcategories.Svetlo;
import Subcategories.Transformatori;
import Subcategories.Zvuk;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kategorije")
public class Kategorije implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String naziv;
    
    @OneToMany(targetEntity = ElektronskeKomponente.class,mappedBy = "kategorija")
    private List<ElektronskeKomponente> elektronskeKomponente;
    
    @OneToMany(targetEntity = Elektrika.class,mappedBy = "kategorija")
    private List<Elektrika> elektrika;
    
    @OneToMany(targetEntity = ElementiZaMontazu.class,mappedBy = "kategorija")
    private List<ElementiZaMontazu> elementiZaMontazu;
    
    @OneToMany(targetEntity = InstrumentiIAlat.class,mappedBy = "kategorija")
    private List<InstrumentiIAlat> instrumentiIAlat;
    
    @OneToMany(targetEntity = IzvoriNapajanja.class,mappedBy = "kategorija")
    private List<IzvoriNapajanja> izvoriNapajanja;
    
    @OneToMany(targetEntity = Kablovi.class,mappedBy = "kategorija")
    private List<Kablovi> kablovi;
    
    @OneToMany(targetEntity = OptoElementi.class,mappedBy = "kategorija")
    private List<OptoElementi> optoElementi;
    
    @OneToMany(targetEntity = PotrosniMaterijal.class,mappedBy = "kategorija")
    private List<PotrosniMaterijal> potrosniMaterijal;
    
    @OneToMany(targetEntity = Svetlo.class,mappedBy = "kategorija")
    private List<Svetlo> svetlo;
    
    @OneToMany(targetEntity = Transformatori.class,mappedBy = "kategorija")
    private List<Transformatori> transformatori;
    
    @OneToMany(targetEntity = Zvuk.class,mappedBy = "kategorija")
    private List<Zvuk> zvuk;
    
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
     * @return the elektrika
     */
    public List<Elektrika> getElektrika() {
        return elektrika;
    }

    /**
     * @param elektrika the elektrika to set
     */
    public void setElektrika(List<Elektrika> elektrika) {
        this.elektrika = elektrika;
    }

    /**
     * @return the elektronskeKomponente
     */
    public List<ElektronskeKomponente> getElektronskeKomponente() {
        return elektronskeKomponente;
    }

    /**
     * @param elektronskeKomponente the elektronskeKomponente to set
     */
    public void setElektronskeKomponente(List<ElektronskeKomponente> elektronskeKomponente) {
        this.elektronskeKomponente = elektronskeKomponente;
    }

    /**
     * @return the elementiZaMontazu
     */
    public List<ElementiZaMontazu> getElementiZaMontazu() {
        return elementiZaMontazu;
    }

    /**
     * @param elementiZaMontazu the elementiZaMontazu to set
     */
    public void setElementiZaMontazu(List<ElementiZaMontazu> elementiZaMontazu) {
        this.elementiZaMontazu = elementiZaMontazu;
    }

    /**
     * @return the instrumentiIAlat
     */
    public List<InstrumentiIAlat> getInstrumentiIAlat() {
        return instrumentiIAlat;
    }

    /**
     * @param instrumentiIAlat the instrumentiIAlat to set
     */
    public void setInstrumentiIAlat(List<InstrumentiIAlat> instrumentiIAlat) {
        this.instrumentiIAlat = instrumentiIAlat;
    }

    /**
     * @return the izvoriNapajanja
     */
    public List<IzvoriNapajanja> getIzvoriNapajanja() {
        return izvoriNapajanja;
    }

    /**
     * @param izvoriNapajanja the izvoriNapajanja to set
     */
    public void setIzvoriNapajanja(List<IzvoriNapajanja> izvoriNapajanja) {
        this.izvoriNapajanja = izvoriNapajanja;
    }

    /**
     * @return the kablovi
     */
    public List<Kablovi> getKablovi() {
        return kablovi;
    }

    /**
     * @param kablovi the kablovi to set
     */
    public void setKablovi(List<Kablovi> kablovi) {
        this.kablovi = kablovi;
    }

    /**
     * @return the optoElementi
     */
    public List<OptoElementi> getOptoElementi() {
        return optoElementi;
    }

    /**
     * @param optoElementi the optoElementi to set
     */
    public void setOptoElementi(List<OptoElementi> optoElementi) {
        this.optoElementi = optoElementi;
    }

    /**
     * @return the potrosniMaterijal
     */
    public List<PotrosniMaterijal> getPotrosniMaterijal() {
        return potrosniMaterijal;
    }

    /**
     * @param potrosniMaterijal the potrosniMaterijal to set
     */
    public void setPotrosniMaterijal(List<PotrosniMaterijal> potrosniMaterijal) {
        this.potrosniMaterijal = potrosniMaterijal;
    }

    /**
     * @return the svetlo
     */
    public List<Svetlo> getSvetlo() {
        return svetlo;
    }

    /**
     * @param svetlo the svetlo to set
     */
    public void setSvetlo(List<Svetlo> svetlo) {
        this.svetlo = svetlo;
    }

    /**
     * @return the transformatori
     */
    public List<Transformatori> getTransformatori() {
        return transformatori;
    }

    /**
     * @param transformatori the transformatori to set
     */
    public void setTransformatori(List<Transformatori> transformatori) {
        this.transformatori = transformatori;
    }

    /**
     * @return the zvuk
     */
    public List<Zvuk> getZvuk() {
        return zvuk;
    }

    /**
     * @param zvuk the zvuk to set
     */
    public void setZvuk(List<Zvuk> zvuk) {
        this.zvuk = zvuk;
    }

}
