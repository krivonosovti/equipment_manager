package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.repository.OrgRepo;
import medika.it.equipment_manager.repository.TypeRepo;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class Org {
    private static OrgRepo orgRepo;

    private Long id;

    private String name;

    private Long INN;
    private String shortname;
    private Long OGRN = null;
    private String adress = null;

    private List<Subdivision> subs;

    public static Org toModel (OrganizationEntity entity)
    {
        Org model = new Org();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setINN(entity.getINN());
        model.setShortname(entity.getShortname());
        model.setOGRN(entity.getOGRN());
        model.setAdress(entity.getAdress());
        try {
            model.setSubs(entity.getSubs().stream().map(Subdivision::toModel).collect(Collectors.toList())); // массив сушности в массив моделей
        }
        catch (Exception e)
        {
            model.setSubs(null);
        }
        return model;
    }

    public Org() {
    }

    public List<Subdivision> getSubs() {
        return subs;
    }

    public void setSubs(List<Subdivision> subs) {
        this.subs = subs;
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

    public Long getINN() {
        return INN;
    }

    public void setINN(Long INN) {
        this.INN = INN;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getOGRN() {
        return OGRN;
    }

    public void setOGRN(Long OGRN) {
        this.OGRN = OGRN;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
