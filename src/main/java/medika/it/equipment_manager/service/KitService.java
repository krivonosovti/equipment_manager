package medika.it.equipment_manager.service;

import medika.it.equipment_manager.entity.EventEntity;
import medika.it.equipment_manager.entity.KitEntity;
import medika.it.equipment_manager.model.Event;
import medika.it.equipment_manager.model.Kit;
import medika.it.equipment_manager.repository.EventRepo;
import medika.it.equipment_manager.repository.KitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitService {

    @Autowired
    private KitRepo kitRepo;
    private EventRepo eventRepo;

    public Kit addkit (KitEntity kit)
    {
        //event.setStartData(Time.valueOf());
        kitRepo.save(kit);
        return Kit.toModel(kit);
    }

    public Event getEvent(Long EventId) {
        EventEntity event = new EventEntity();
        event = eventRepo.findById(EventId).get();
        return Event.toModel(event);
    }
}
