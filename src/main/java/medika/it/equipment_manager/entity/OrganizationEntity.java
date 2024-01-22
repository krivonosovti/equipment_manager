package medika.it.equipment_manager.entity;

import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import org.hibernate.tool.schema.spi.SchemaTruncator;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Long INN;
    private String shortname;
    private Long OGRN = null;
    private String adress = null;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org")
    private List<SubdivisionEnity> subs;

    public List<SubdivisionEnity> getSubs() {
        return subs;
    }

    public void setSubs(List<SubdivisionEnity> subs) {
        this.subs = subs;
    }

    public OrganizationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Long getINN() {
        return INN;
    }

    public void setINN(@NonNull Long INN) {
        this.INN = INN;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getOGRN() {
        return OGRN;
    }

    public void setOGRN(Long OGRN) {
        this.OGRN = OGRN;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
