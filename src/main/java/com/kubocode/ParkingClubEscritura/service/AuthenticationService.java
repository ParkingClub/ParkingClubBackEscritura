package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.dto.AuthenticationRequest;
import com.kubocode.ParkingClubEscritura.dto.AuthenticationResponse;
import com.kubocode.ParkingClubEscritura.entity.User;
import com.kubocode.ParkingClubEscritura.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(@Valid AuthenticationRequest authRequest) {
        // Autenticar las credenciales
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);

        // Obtener el usuario y verificar su estado
        User user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getEstado()) {
            throw new RuntimeException("El usuario está deshabilitado y no puede iniciar sesión");
        }

        // Generar el token JWT si el usuario está habilitado
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new AuthenticationResponse(
                jwt,
                user.getId(),
                user.getName(),
                user.getMac(),
                user.getSucursal().getId(),
                user.getSucursal().getEmpresa().getId(),
                user.getRole()
        );
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }
}