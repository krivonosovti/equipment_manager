package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.EventEntity;
import medika.it.equipment_manager.model.Event;
import medika.it.equipment_manager.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event addEvent (EventEntity event)
    {
        //event.setStartData(Time.valueOf());
        eventRepo.save(event);
        return Event.toModel(event);
    }


    public Event getEvent(Long EventId) {
        EventEntity event = new EventEntity();
        event = eventRepo.findById(EventId).get();
        return Event.toModel(event);
    }

}
