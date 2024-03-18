package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.KitEntity;
import org.springframework.data.repository.CrudRepository;

public interface KitRepo extends CrudRepository <KitEntity, Long> {
}
