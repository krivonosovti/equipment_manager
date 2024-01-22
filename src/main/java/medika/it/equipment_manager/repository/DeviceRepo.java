package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepo extends CrudRepository< DeviceEntity, Long> {
}
