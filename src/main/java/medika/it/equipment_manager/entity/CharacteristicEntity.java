package medika.it.equipment_manager.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class CharacteristicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String  title;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceEntity device;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ValueEntity value;
    public CharacteristicEntity() {
    }


    public ValueEntity getValue() {
        return value;
    }

    public void setValue(ValueEntity value) {
        this.value = value;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public DeviceEntity getDevice() {
        return device;
    }

    public void setDevice(DeviceEntity device) {
        this.device = device;
    }
}
