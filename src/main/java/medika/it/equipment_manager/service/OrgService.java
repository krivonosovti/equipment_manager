package medika.it.equipment_manager.service;


import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;

import medika.it.equipment_manager.model.Org;

import medika.it.equipment_manager.repository.OrgRepo;
import medika.it.equipment_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    private OrgRepo orgRepo;
    
    public Org Reg (OrganizationEntity org){
        orgRepo.save(org);
        return Org.toModel(org);
    }


    public Org getOne (Long id) throws UserNotFoundException {
        OrganizationEntity org = orgRepo.findById(id).get();
        if(org == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Org.toModel(org);
    }

    public Long delete(Long id){
        orgRepo.deleteById(id);
        return id;
    }

}
