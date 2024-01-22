package medika.it.equipment_manager.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class SubdivisionEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    private Long KPP = null;
    private String organisation;
    private String adress = null;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationEntity org;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sub")
    private List<UserEntity> users;



    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public SubdivisionEnity() {
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

    public Long getKPP() {
        return KPP;
    }

    public void setKPP(Long KPP) {
        this.KPP = KPP;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public OrganizationEntity getOrg() {
        return org;
    }

    public void setOrg(OrganizationEntity org) {
        this.org = org;
    }
}
