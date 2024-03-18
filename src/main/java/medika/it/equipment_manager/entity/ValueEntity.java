package medika.it.equipment_manager.entity;

import jakarta.persistence.*;

import java.util.function.LongFunction;

@Entity
public class ValueEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Value;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private CharacteristicEntity characteristic;

    public ValueEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public void setCharacteristic(CharacteristicEntity characteristic) {
        this.characteristic = characteristic;
    }

    public CharacteristicEntity getCharacteristic() {
        return characteristic;
    }
}