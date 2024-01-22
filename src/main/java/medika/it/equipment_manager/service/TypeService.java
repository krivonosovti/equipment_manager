package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Device;
import medika.it.equipment_manager.model.Type;
import medika.it.equipment_manager.repository.DeviceRepo;
import medika.it.equipment_manager.repository.TypeRepo;
import medika.it.equipment_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//  Варя
@Service
public class TypeService {
    @Autowired
    private DeviceRepo deviceRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    TypeRepo typeRepo;

    public Type RegType (DeviceTypeEntity type, Long deviceId){
        DeviceEntity device = deviceRepo.findById(deviceId).get();
        type.setDevice(device);
        device.setInvNumber(type.getType());
        typeRepo.save(type);
        return Type.toModel(type);
    }
    public Type getOne (Long id) throws UserNotFoundException {
        DeviceTypeEntity type = typeRepo.findById(id).get();
        if(type == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Type.toModel(type);
    }

    public Long delete(Long id){
        typeRepo.deleteById(id);
        return id;
    }
}
