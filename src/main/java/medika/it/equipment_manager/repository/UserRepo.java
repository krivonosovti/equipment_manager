package medika.it.equipment_manager.repository;

import medika.it.equipment_manager.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<UserEntity, Long> {
//    UserEntity findByUsername(String user);
}