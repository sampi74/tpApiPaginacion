package com.utn.tp_api.controladores;

import com.utn.tp_api.entidades.Autor;
import com.utn.tp_api.servicios.AutorServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServicioImpl> {
}
