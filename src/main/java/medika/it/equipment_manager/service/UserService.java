package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.entity.SubdivisionEnity;
import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.exception.UserAlreadyExistException;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.User;
import medika.it.equipment_manager.repository.OrgRepo;
import medika.it.equipment_manager.repository.SubdivisionRepo;
import medika.it.equipment_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private SubdivisionRepo subdivisionRepo;
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user, Long subId) throws UserAlreadyExistException {
        SubdivisionEnity sub = subdivisionRepo.findById(subId).get();
        user.setSub(sub);
        user.setSubdivision(sub.getName());
        user.setOrganization(sub.getOrganisation());

//        if (userRepo.findByUsername(user.getUsername()) != null){
//            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
//        }
        return userRepo.save(user);
    }

    public User getOne (Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }
    public Long delete(Long id){
        userRepo.deleteById(id); // должен выдовать сообщение пользователь удален, и у всех девайсов нужно поменять usert
        return id;
    }


}