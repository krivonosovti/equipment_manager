package medika.it.equipment_manager.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import medika.it.equipment_manager.entity.EventEntity;
import medika.it.equipment_manager.entity.KitEntity;
import medika.it.equipment_manager.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/kit")
public class KitController {

    @Autowired
    private KitService kitService;

    @PostMapping
    public ResponseEntity regEvent(@RequestBody KitEntity kit) {
        try {
            return ResponseEntity.ok(kitService.addkit(kit));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }



}
