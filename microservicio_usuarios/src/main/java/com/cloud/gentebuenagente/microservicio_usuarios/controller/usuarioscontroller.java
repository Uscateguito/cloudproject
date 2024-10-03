package com.cloud.gentebuenagente.microservicio_usuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class usuarioscontroller {

    @GetMapping("/hola")
    public ResponseEntity<String> getNombreCompleto() {
       return ResponseEntity.ok("Hola mundo");
    }
    
}

