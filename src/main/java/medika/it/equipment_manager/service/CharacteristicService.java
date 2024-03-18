package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.*;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Device;
import medika.it.equipment_manager.model.Type;
import medika.it.equipment_manager.model.Value;
import medika.it.equipment_manager.model.Сharacteristic;
import medika.it.equipment_manager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collector;

@Service
public class CharacteristicService {

    @Autowired
    private CharacteristicRepo characteristicRepo;

    @Autowired
    private DeviceRepo deviceRepo;


    public Сharacteristic addC (CharacteristicEntity characteristic, Long deviceId)
    {
        DeviceEntity device = deviceRepo.findById(deviceId).get();
        characteristic.setDevice(device);
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
