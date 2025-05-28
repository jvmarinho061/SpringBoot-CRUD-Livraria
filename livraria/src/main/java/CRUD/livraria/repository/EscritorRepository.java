package CRUD.livraria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CRUD.livraria.model.Escritor;

@Repository
public interface EscritorRepository extends JpaRepository<Escritor, Long> // Interface para CRUD de Escritor
{
 Escritor findByCpf(String cpf); // Método para encontrar Escritor por CPF

  Escritor findByEmail(String email); // Método para encontrar Escritor por Email
}


