package medika.it.equipment_manager.controller;


import medika.it.equipment_manager.entity.OrganizationEntity;
import medika.it.equipment_manager.entity.SubdivisionEnity;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.service.OrgService;
import medika.it.equipment_manager.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub")
public class SubdivisionController {
    @Autowired
    private SubdivisionService subdivisionService;

    @PostMapping
    public ResponseEntity regDevice(@RequestBody SubdivisionEnity sub, Long orgId) {
        try {
            return ResponseEntity.ok(subdivisionService.Reg(sub,orgId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity qetOneDevice(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(subdivisionService.getOne(id));
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
            return ResponseEntity.ok(subdivisionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
