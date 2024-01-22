package medika.it.equipment_manager.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Brand = null;
    private String model= null;
    private Integer invNumber= null;// - ?
    private Long serialNumber= null;
    private Long mac= null;
    private String manager = null;
    private Long Kit; // указатель на id

   // private ArrayList<Integer> bunch  = new ArrayList<>(100);  починить ошибку (автоматически уйдет когда буду ставить отношение один ко многим)
    private Boolean united = false;
    private Boolean divided = false;
    private String EXTRA = null;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



    public void setUser(UserEntity user) {
        this.user = user;
    }

    public DeviceEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Integer invNumber) {
        this.invNumber = invNumber;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getMac() {
        return mac;
    }

    public void setMac(Long mac) {
        this.mac = mac;
    }

    public Long getKit() {
        return Kit;
    }

    public void setKit(Long kit) {
        Kit = kit;
    }

    public Boolean getUnited() {
        return united;
    }

    public void setUnited(Boolean united) {
        this.united = united;
    }

    public Boolean getDivided() {
        return divided;
    }

    public void setDivided(Boolean divided) {
        this.divided = divided;
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA;
    }


}
