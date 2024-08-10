package Support.Service.controller;

import Support.Service.dto.JwtAuthResponse;
import Support.Service.dto.LoginDto;
import Support.Service.dto.SignUpDto;
import Support.Service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        JwtAuthResponse response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody SignUpDto signUpDto) {
        String response = authService.signUp(signUpDto);
        return ResponseEntity.ok(response);
    }
}