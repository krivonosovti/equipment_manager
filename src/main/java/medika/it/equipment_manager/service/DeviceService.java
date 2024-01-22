package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Device;
import medika.it.equipment_manager.model.User;
import medika.it.equipment_manager.repository.DeviceRepo;
import medika.it.equipment_manager.repository.TypeRepo;
import medika.it.equipment_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;
    @Autowired
    private TypeRepo typeRepo;
    @Autowired
    private UserRepo userRepo;

    public Device RegDevice (DeviceEntity device, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        device.setUser(user);
        device.setManager(user.getUsername());
//        Date now = new Date();
//        todo.setCreated_date(now);
        deviceRepo.save(device);
        return Device.toModel(device);
    }


    public Device getOneById (Long id) throws UserNotFoundException {
        DeviceEntity device = deviceRepo.findById(id).get();
        if(device == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Device.toModel(device);
    }

    public Long delete(Long id){
        deviceRepo.deleteById(id);
        return id;
    }

}
