package com.utn.tp_api.controladores;

import com.utn.tp_api.entidades.BaseEntidad;
import com.utn.tp_api.servicios.BaseServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends BaseEntidad, S extends BaseServicioImpl<E,Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };

    @GetMapping("/page")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\\\"error\\\": \\\"\" + e.getMessage()+\"\\\"}");
        }
    };
}
