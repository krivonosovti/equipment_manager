package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.entity.ValueEntity;

public class Value {
    private Long Id;

    private String Value;


    public static Value toModel(ValueEntity entity)
    {
        Value model = new Value();
        model.setValue(entity.getValue());
        model.setId(entity.getId());
        return model;
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
