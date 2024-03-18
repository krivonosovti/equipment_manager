package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.ValueEntity;
import org.springframework.data.repository.CrudRepository;

public interface ValueRepo extends CrudRepository<ValueEntity,Long> {
}
