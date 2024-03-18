package medika.it.equipment_manager.model;

import jakarta.persistence.Id;
import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class Device
{
    private Long id;


    private String Brand = null;
    private String model= null;
    private Integer invNumber= null;// - ?
    private Long serialNumber= null;
    private Long mac= null;

    private  String manager = null;

    private Long Kit; // указатель на id

    // private ArrayList<Integer> bunch  = new ArrayList<>(100);  починить ошибку

    private Boolean united = false;
    private Boolean divided = false;
    private String EXTRA = null;

    private List<Сharacteristic> сharacteristics;
    public static Device toModel (DeviceEntity entity)
    {
        Device model = new Device();
        model.setId(entity.getId());
        model.setModel(entity.getModel());
        model.setBrand(entity.getBrand());
        model.setDivided(entity.getDivided());
        model.setKit(entity.getKit());
        model.setUnited(entity.getUnited());
        model.setSerialNumber(entity.getSerialNumber());
        model.setInvNumber(entity.getInvNumber());
        model.setEXTRA(entity.getEXTRA());
        model.setManager(entity.getManager());
        try {
            //model.setSubs(entity.getSubs().stream().map(Subdivision::toModel).collect(Collectors.toList())); // массив сушности в массив моделей
            model.setСharacteristics(entity.getCharacteristics().stream().map(Сharacteristic::toModel).collect(Collectors.toList()));
        }
        catch (Exception e)
        {
            model.setСharacteristics(null);
        }

        return model;
    }

    public Device() {
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Integer invNumber) {
        this.invNumber = invNumber;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getMac() {
        return mac;
    }

    public void setMac(Long mac) {
        this.mac = mac;
    }

    public Long getKit() {
        return Kit;
    }

    public void setKit(Long kit) {
        Kit = kit;
    }

    public Boolean getUnited() {
        return united;
    }

    public void setUnited(Boolean united) {
        this.united = united;
    }

    public Boolean getDivided() {
        return divided;
    }

    public void setDivided(Boolean divided) {
        this.divided = divided;
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA;
    }

    public List<Сharacteristic> getСharacteristics() {
        return сharacteristics;
    }

    public void setСharacteristics(List<Сharacteristic> сharacteristics) {
        this.сharacteristics = сharacteristics;
    }
}
