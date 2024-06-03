package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.config.JwtService;
import co.essejacques.springschoolmanagement.data.entity.User;
import co.essejacques.springschoolmanagement.mobile.dtos.JwtAuthResponse;
import co.essejacques.springschoolmanagement.mobile.dtos.LoginDto;
import co.essejacques.springschoolmanagement.services.interfaces.IAuthService;
import co.essejacques.springschoolmanagement.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
@Tag(name = "Authenticator", description = "Authenticator API")
public class AuthController {
    private final IAuthService authService;
    private final IUserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @GetMapping("user-details")
    public Optional<User> userDetails(HttpServletRequest request, HttpServletResponse response){
      String token = jwtService.getTokenFormRequest(request);
      String username = jwtService.getUsername(token);
      return userService.findUserByEmail(username);
    }
}
