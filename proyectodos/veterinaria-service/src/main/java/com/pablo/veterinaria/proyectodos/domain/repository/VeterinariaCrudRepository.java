package src.main.java.com.pablo.veterinaria.proyectodos.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinaria;

public interface VeterinariaCrudRepository extends MongoRepository<Veterinaria, String> {
}
