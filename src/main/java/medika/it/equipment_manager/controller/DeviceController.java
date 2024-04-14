package medika.it.equipment_manager.controller;


import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity regDevice(@RequestBody DeviceEntity device, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(deviceService.RegDevice(device, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity qetOneDevice(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(deviceService.getOneById(id));
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(deviceService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}