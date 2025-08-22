package br.com.lumens.Controller;

import br.com.lumens.Domain.Roles;
import br.com.lumens.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Roles>> listarRoles(){
        List<Roles> roles = roleService.listarRoles();
        return ResponseEntity.ok(roles);
    }

}
