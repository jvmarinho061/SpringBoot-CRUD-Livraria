package CRUD.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import CRUD.livraria.model.Escritor;
import CRUD.livraria.repository.EscritorRepository;

@Service
public class EscritorService {
    private final EscritorRepository escritorRepository;

    public EscritorService(EscritorRepository escritorRepository) {
        this.escritorRepository = escritorRepository;
    }

    //CRUD básico
    public Escritor cadastrar(Escritor escritor) {
        return escritorRepository.save(escritor);
    }

    public List<Escritor> listarTodos() {
        return escritorRepository.findAll();
    }

    public Optional<Escritor> buscarPorId(Long id) {
        return escritorRepository.findById(id);
    }


    public void deletar(Long id) {
        escritorRepository.deleteById(id);
    }
    //Método adicional para verificar se o email já existe
    public boolean emailExiste(String email) {
        return escritorRepository.findByEmail(email) != null;
    }
}
