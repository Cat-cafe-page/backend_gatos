package com.catcafe.backend_gatos.controllers;

import java.util.List;
import com.catcafe.backend_gatos.models.Gatos;
import com.catcafe.backend_gatos.repositories.GatosRepository;
import com.catcafe.backend_gatos.exceptions.GatoNotFoundException;
import com.catcafe.backend_gatos.exceptions.GatoAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

@RestController //arquitectura REST
public class GatosController {
    //Conectar a la base de datos
    private final GatosRepository gatosRepository;

    public GatosController(GatosRepository gatosRepository){
        this.gatosRepository = gatosRepository;
    }

    //urls y sus metodos
    @GetMapping("/")
    String messageRoot() {
        return "Bienvenido a Cat Cafe";
    }

    //Controlador para traer todos lo gatos
    @GetMapping("/gatos")
    List<Gatos> getGatos(){
        List<Gatos> gatos = gatosRepository.findAll();
        if(gatos.isEmpty()){
            throw new GatoNotFoundException("No existen registros de gatos");
        }
        return gatos;
    }

    // Controlador para traer un gato por su id
    @GetMapping("/gato/{id}")
    Gatos getGatoById(@PathVariable String id) {
        return gatosRepository.findById(id)
                .orElseThrow(() -> new GatoNotFoundException("No se encontro registro del gato con el id" + id));

    }

    //Controlador para traer gatos por año de adopcion
    @GetMapping("/gatos/{añoAdopcion}")
    List<Gatos> getGatosByAño(@PathVariable String añoAdopcion){
        List<Gatos> gatos = gatosRepository.findByAñoAdopcion(añoAdopcion);
        if(gatos.isEmpty()){
            throw new GatoNotFoundException("No se adoptaron gatos en el año" + añoAdopcion);
        }
        return gatos;
    }

    //Controlador para crear el registro de un gato
    @PostMapping("/createGato")
    Gatos newGato(@RequestBody Gatos gato){
        if(gatosRepository.existsById(gato.getNombre())==true){
            throw new GatoAlreadyExistsException("Ya existe un gato con este nombre");
        }
        return gatosRepository.save(gato);
    }

    //Controlador para eliminar un gato por su Id
    @DeleteMapping("/deleteGato/{id}")
    String deleteBy(@PathVariable String id){
        gatosRepository.findById(id).orElseThrow(() -> new GatoNotFoundException("No se encontro registro del gato"));
        gatosRepository.deleteById(id);
        return "Registro eliminado exitosamente.";
    }

    //Controlador para editar informacion del gato por id
    @PutMapping("/updateGato/{id}")
    Gatos newGato(@PathVariable String id, @RequestBody Gatos gato){
        gatosRepository.findById(id).orElseThrow(() -> new GatoNotFoundException("No se encontro el registro del gato"));
        gatosRepository.deleteById(id);
        return gatosRepository.save(gato);
    }
}
