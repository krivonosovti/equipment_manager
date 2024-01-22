package medika.it.equipment_manager.entity;


import jakarta.persistence.*;


@Entity
public class DeviceTypeEntity {
    @Id
    private Long Id;

   // private String hdd;

    private Integer type;
    private String EXTRA = null;

    public DeviceTypeEntity() {
    }


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private DeviceEntity device;

    public DeviceEntity getDevice() {
        return device;
    }

    public void setDevice(DeviceEntity device) {
        this.device = device;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA;
    }


}
