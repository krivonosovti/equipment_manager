package medika.it.equipment_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class KitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long devicve_id;
    private Time created_data;

    private Boolean status;

    public KitEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDevicve_id() {
        return devicve_id;
    }

    public void setDevicve_id(Long devicve_id) {
        this.devicve_id = devicve_id;
    }

    public Time getCreated_data() {
        return created_data;
    }

    public void setCreated_data(Time created_data) {
        this.created_data = created_data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
