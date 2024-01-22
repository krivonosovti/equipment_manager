package medika.it.equipment_manager.model;

import medika.it.equipment_manager.entity.UserEntity;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class User {
    private Long id;

    private String username;

    private String surname;

    private String patronymic = null;

    private String organization;


    private String subdivision;

    private String position = null;

    private List<Device> devices = null;



    public static User toModel (UserEntity entity)
    {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        model.setOrganization(entity.getOrganization());
        model.setSubdivision(entity.getSubdivision());
        model.setPosition(entity.getPosition());
        model.setDevices(entity.getDevices().stream().map(Device::toModel).collect(Collectors.toList())); // массив сушности в массив моделей


        return model;
    }
    public User() {

    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}