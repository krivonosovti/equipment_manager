package medika.it.equipment_manager.controller;

import jakarta.persistence.PostRemove;
import medika.it.equipment_manager.entity.CharacteristicEntity;
import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.ValueEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.CharacteristicService;
import medika.it.equipment_manager.service.DeviceService;
import medika.it.equipment_manager.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/characteristic")
public class CharacteristicController {
    @Autowired
    private CharacteristicService characteristicService;
    @Autowired
    private ValueService valueService;

    @PostMapping("/value")
    public  ResponseEntity addValue (@RequestBody ValueEntity value, @RequestParam Long characteristicId)
    {
        try {
             return  ResponseEntity.ok(valueService.addValue(value, characteristicId));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity addCharacteristic(@RequestBody CharacteristicEntity character,@RequestParam Long deviceId ) {
        try {
            return ResponseEntity.ok(characteristicService.addC(character, deviceId));
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
