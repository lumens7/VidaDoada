package br.com.lumens.Config;

import br.com.lumens.Service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {


    @Bean
    public CommandLineRunner initRoles(RoleService rolesService) {
        return args -> {
            String[] roles = { "ROLE_USUARIO", "ROLE_ADMIN", "ROLE_ENTIDADE" };

            for (String roleNome : roles) {
                rolesService.cadastrarRole(roleNome);
            }

            System.out.println("Roles pré-definidas cadastradas com sucesso pela camada de serviço!");
        };
    }
}
