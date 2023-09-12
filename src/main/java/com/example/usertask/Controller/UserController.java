package com.example.usertask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.usertask.Model.User;
import com.example.usertask.Services.UserService;
import com.example.usertask.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestParam;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;





import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.usertask.Exceptions.CustomException;
import com.example.usertask.Exceptions.CustomErrorResponse;

import java.time.LocalDateTime;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private FileUploadController fileUploadController;

    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @Min(1) Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/js/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findByNameAndLastname")
    public List<User> findUsersByNameAndLastname(
            @RequestParam("name") @NotEmpty @Size(max = 50) String name,
            @RequestParam("lastname") @NotEmpty @Size(max = 50) String lastname
    ) {
        return userService.findByNameAndLastname(name, lastname);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> {
                        if (error instanceof FieldError) {
                            FieldError fieldError = (FieldError) error;
                            return fieldError.getField() + ": " + error.getDefaultMessage();
                        } else {
                            return error.getObjectName() + ": " + error.getDefaultMessage();
                        }
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }

        // No validation errors, save the user
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }



    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            // Update user properties here
            // existingUser.setName(user.getName());
            // Update other properties as needed
            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/customexp")
    public ResponseEntity<CustomErrorResponse> example() {
        try {
            // Simulate an error condition
            boolean errorCondition = true;
            if (errorCondition) {
                throw new CustomException("This is custom error message", HttpStatus.OK.value());
            }
            // If no error occurs, return a success response
            return ResponseEntity.status(HttpStatus.OK).body(new CustomErrorResponse("OK", HttpStatus.OK.value(), "Request processed successfully.", LocalDateTime.now()));
        } catch (CustomException ex) {
            // If an error occurs, return a custom error response with status 200 and error as "OK"
            return ResponseEntity.status(HttpStatus.OK).body(new CustomErrorResponse("OK", HttpStatus.OK.value(), ex.getMessage(), LocalDateTime.now()));
        }
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse("OK", HttpStatus.OK.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }
}
