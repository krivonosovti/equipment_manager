package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.entity.SubdivisionEnity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Org;
import medika.it.equipment_manager.model.Subdivision;
import medika.it.equipment_manager.repository.OrgRepo;
import medika.it.equipment_manager.repository.SubdivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubdivisionService {

    @Autowired
    private SubdivisionRepo subdivisionRepo;
    @Autowired
    private OrgRepo orgRepo;

    public Subdivision Reg (SubdivisionEnity sub,Long orgId ){
        OrganizationEntity org = orgRepo.findById(orgId).get();
        sub.setOrganisation(org.getShortname());
        sub.setOrg(org);

        subdivisionRepo.save(sub);
        return Subdivision.toModel(sub);
    }


    public Subdivision getOne (Long id) throws UserNotFoundException {
        SubdivisionEnity sub = subdivisionRepo.findById(id).get();
        if(sub == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Subdivision.toModel(sub);
    }

    public Long delete(Long id){
        subdivisionRepo.deleteById(id);
        return id;
    }

}
