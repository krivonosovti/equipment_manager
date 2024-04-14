package medika.it.equipment_manager.controller;

import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.entity.EventEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.model.Event;
import medika.it.equipment_manager.service.EventService;
import medika.it.equipment_manager.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/event")
public class EventController {


    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity regEvent(@RequestBody EventEntity event) {
        try {
            return ResponseEntity.ok(eventService.addEvent(event));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
//
//    @GetMapping
//    public ResponseEntity getOnlyType(@RequestParam Long id) {
//        try {
//            return ResponseEntity.ok(typeService.getOne(id));
//        }
//        catch (UserNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        catch (Exception e) {
//            return ResponseEntity.badRequest().body("Ошибка");
//        }
//    }
//
//    @DeleteMapping("/{typeId}")
//    public ResponseEntity deleteTodo(@PathVariable Long typeId) {
//        try {
//            return ResponseEntity.ok(typeService.delete(typeId));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Ошибка");
//        }
//    }

}
