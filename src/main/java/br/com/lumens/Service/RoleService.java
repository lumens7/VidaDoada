package br.com.lumens.Service;

import br.com.lumens.Domain.Roles;
import br.com.lumens.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository rolesRepository;

    public RoleService(RoleRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Roles cadastrarRole(String nome) {
        Optional<Roles> existente = rolesRepository.findByNome(nome);

        if (existente.isPresent()) {
            return existente.get();
        }

        Roles role = new Roles();
        role.setNome(nome);
        return rolesRepository.save(role);
    }
    public List<Roles> listarRoles(){
        return rolesRepository.findAll();
    }

}
