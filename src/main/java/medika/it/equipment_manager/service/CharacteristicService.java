package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.CharacteristicEntity;
import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Device;
import medika.it.equipment_manager.model.Сharacteristic;
import medika.it.equipment_manager.repository.CharacteristicRepo;
import medika.it.equipment_manager.repository.DeviceRepo;
import medika.it.equipment_manager.repository.TypeRepo;
import medika.it.equipment_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collector;

@Service
public class CharacteristicService {

    @Autowired
    private CharacteristicRepo characteristicRepo;

    public Сharacteristic addC (CharacteristicEntity characteristic){
        characteristicRepo.save(characteristic);
        return Сharacteristic.toModel(characteristic);
    }

    public Сharacteristic getAll () throws UserNotFoundException {
        CharacteristicEntity characteristic = (CharacteristicEntity) characteristicRepo.findAll();
        if(characteristic == null) {
            throw new UserNotFoundException("Пользователи не найдены");
        }
        return Сharacteristic.toModel(characteristic);
    }

    public Long delete(Long id){
        characteristicRepo.deleteById(id);
        return id;
    }

}
