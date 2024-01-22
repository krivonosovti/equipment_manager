package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.CharacteristicEntity;
import medika.it.equipment_manager.entity.UserEntity;

import java.util.stream.Collectors;

public class Сharacteristic {
    private Long Id;
    private String title;

    public static Сharacteristic toModel (CharacteristicEntity entity)
    {
        Сharacteristic model = new Сharacteristic();
       // model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        return model;
    }
    public Сharacteristic() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
