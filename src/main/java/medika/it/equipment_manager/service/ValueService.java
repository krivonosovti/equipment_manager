package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.CharacteristicEntity;
import medika.it.equipment_manager.entity.ValueEntity;
import medika.it.equipment_manager.model.Value;
import medika.it.equipment_manager.repository.CharacteristicRepo;
import medika.it.equipment_manager.repository.ValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueService {
    @Autowired
    private CharacteristicRepo characteristicRepo;
    @Autowired
    private ValueRepo valueRepo;
    public Value addValue (ValueEntity value, Long characteristicId){

        CharacteristicEntity characteristic = characteristicRepo.findById(characteristicId).get();
        value.setCharacteristic(characteristic);
        // characteristic.setValue(value);
        valueRepo.save(value);
        return Value.toModel(value);
    }
}
