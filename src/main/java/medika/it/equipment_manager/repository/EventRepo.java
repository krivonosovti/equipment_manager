package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository <EventEntity, Long> {
}
