package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrgRepo extends CrudRepository< OrganizationEntity, Long> {
}
