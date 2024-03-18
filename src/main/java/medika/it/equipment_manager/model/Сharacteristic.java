package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.CharacteristicEntity;

import medika.it.equipment_manager.entity.ValueEntity;
import medika.it.equipment_manager.repository.ValueRepo;
import medika.it.equipment_manager.model.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;
@Component
public class Сharacteristic {
    @Autowired
    private static ValueRepo valueRepo;
    private Long Id;
    private String title;

    private Value value;

   // ValueEntity value1 = valueRepo.findById(1L).get();

    public static Сharacteristic toModel(CharacteristicEntity entity) {
        Сharacteristic model = new Сharacteristic();
        Long id = entity.getId();
        model.setId(id);
        try {
            ValueEntity value1 = valueRepo.findById(entity.getId()).get();
         model.setValue(Value.toModel(value1));
        } catch (Exception e)
        {
            model.setValue(null);
        }
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

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
