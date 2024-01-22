package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.CharacteristicEntity;
import org.springframework.data.repository.CrudRepository;

public interface CharacteristicRepo extends CrudRepository <CharacteristicEntity, Long> {
}
