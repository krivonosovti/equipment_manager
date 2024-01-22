package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.entity.SubdivisionEnity;
import medika.it.equipment_manager.repository.OrgRepo;
import medika.it.equipment_manager.repository.SubdivisionRepo;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class Subdivision {


    private Long id;
    private String name;
    private Long KPP = null;
    private String organisation;
    private String adress = null;

    private List<User> users;
    public static Subdivision toModel (SubdivisionEnity entity)
    {
        Subdivision model = new Subdivision();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setOrganisation(entity.getOrganisation());
        model.setKPP(entity.getKPP());
        model.setAdress(entity.getAdress());
        //entity.getDevices().stream().map(Device::toModel).collect(Collectors.toList())
        try {
            model.setUsers(entity.getUsers().stream().map(User::toModel).collect(Collectors.toList()));
        }
        catch (Exception e)
        {
            model.setUsers(null);
        }
        return model;
    }


    public Subdivision() {
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getKPP() {
        return KPP;
    }

    public void setKPP(Long KPP) {
        this.KPP = KPP;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
