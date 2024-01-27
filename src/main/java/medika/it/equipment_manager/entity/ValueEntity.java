package medika.it.equipment_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.function.LongFunction;

@Entity
public class ValueEntity {
    @Id
    private Long Id;

    private String Value;

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
}