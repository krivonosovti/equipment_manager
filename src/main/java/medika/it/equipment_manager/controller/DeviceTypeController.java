package medika.it.equipment_manager.controller;


import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.DeviceTypeEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.DeviceService;
import medika.it.equipment_manager.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/type")
public class DeviceTypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping
    public ResponseEntity regType(@RequestBody DeviceTypeEntity type, @RequestParam Long deviceId) {
        try {
            return ResponseEntity.ok(typeService.RegType(type,deviceId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOnlyType(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(typeService.getOne(id));
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity deleteTodo(@PathVariable Long typeId) {
        try {
            return ResponseEntity.ok(typeService.delete(typeId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
