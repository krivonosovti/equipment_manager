package medika.it.equipment_manager.controller;

import medika.it.equipment_manager.entity.DeviceEntity;
import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.DeviceService;
import medika.it.equipment_manager.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrgService orgService;

    @PostMapping
    public ResponseEntity regDevice(@RequestBody OrganizationEntity org) {
        try {
            return ResponseEntity.ok(orgService.Reg(org));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity qetOneDevice(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(orgService.getOne(id));
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
            return ResponseEntity.ok(orgService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
