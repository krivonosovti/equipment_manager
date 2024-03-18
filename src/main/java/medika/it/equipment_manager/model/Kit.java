package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.EventEntity;
import medika.it.equipment_manager.entity.KitEntity;

import java.sql.Time;

public class Kit {


    private  Long ID;

    private  Long device_id;

    private Boolean status;


    public static Kit toModel (KitEntity entity)
    {
        Kit model = new Kit();
        model.setID(entity.getId());
        model.setDevice_id(entity.getDevicve_id());
        model.setStatus(entity.getStatus());
        return model;
    }

    public Kit() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
