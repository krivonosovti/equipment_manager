package medika.it.equipment_manager.controller;

import medika.it.equipment_manager.entity.UserEntity;
import medika.it.equipment_manager.exception.UserAlreadyExistException;
import medika.it.equipment_manager.exception.UserNotFoundException;
import medika.it.equipment_manager.repository.UserRepo;
import medika.it.equipment_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user,Long subId) {
        try {

            userService.registration(user, subId);
            return ResponseEntity.ok("Пользователь успешно сохранен"); //!!!
        }
        catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка");
        }

    }

    @GetMapping
    public ResponseEntity qetOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
