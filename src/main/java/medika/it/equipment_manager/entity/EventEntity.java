package medika.it.equipment_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class EventEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long ID;

    private Integer event_type;
    private  Long device_id;

    private Long user_id;

    private Long deliverId;

    private Long gotId;

    private Boolean set;

    private Time startData;
    private Time endTime;
    private Boolean status;

    public EventEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Integer event_type) {
        this.event_type = event_type;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public Long getGotId() {
        return gotId;
    }

    public void setGotId(Long gotId) {
        this.gotId = gotId;
    }

    public Boolean getSet() {
        return set;
    }

    public void setSet(Boolean set) {
        this.set = set;
    }

    public Time getStartData() {
        return startData;
    }

    public void setStartData(Time startData) {
        this.startData = startData;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
