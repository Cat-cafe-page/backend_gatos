package com.catcafe.backend_gatos.repositories;
import java.util.List;
import com.catcafe.backend_gatos.models.Gatos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GatosRepository extends MongoRepository<Gatos, String>{
    List<Gatos> findByAñoAdopcion(String añoAdopcion);
}


