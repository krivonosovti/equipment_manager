package medika.it.equipment_manager.controller;

import medika.it.equipment_manager.entity.CharacteristicEntity;
import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.CharacteristicService;
import medika.it.equipment_manager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characteristic")
public class CharacteristicController {
    @Autowired
    private CharacteristicService characteristicService;

    @PostMapping
    public ResponseEntity addCharacteristic(@RequestBody CharacteristicEntity character) {
        try {
            return ResponseEntity.ok(characteristicService.addC(character));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity qetAllCharacteristic() {
        try {
            return ResponseEntity.ok(characteristicService.getAll());
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
            return ResponseEntity.ok(characteristicService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
