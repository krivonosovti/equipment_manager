package medika.it.equipment_manager.repository;

import jakarta.persistence.Id;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepo extends CrudRepository <DeviceTypeEntity, Long> {

}
