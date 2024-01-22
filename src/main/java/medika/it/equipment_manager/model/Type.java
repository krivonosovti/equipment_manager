package medika.it.equipment_manager.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import org.springframework.lang.NonNull;

public class Type {

    private Long Id;

    private Integer type;
    private String EXTRA = null;

    public static Type toModel(DeviceTypeEntity type)
    {
        Type model = new Type();
        model.setEXTRA(type.getEXTRA());
        model.setType(type.getType());
        model.setId(type.getId());

        return model;
    }

    public Type() {
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
