package com.cloud.gentebuenagente.microservicio_proveedores.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/proveedores")
public class proveedorescontroller {

    @GetMapping("/hola")
    public ResponseEntity<String> getNombreCompleto() {
       return ResponseEntity.ok("Hola mundo");
    }
    
}

