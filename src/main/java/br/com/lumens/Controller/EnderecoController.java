package br.com.lumens.Controller;

import br.com.lumens.Domain.Endereco;
import br.com.lumens.Domain.Usuario;
import br.com.lumens.Service.EnderecoService;
import br.com.lumens.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;
    private UsuarioService usuarioService;

    public EnderecoController(EnderecoService enderecoService, UsuarioService usuarioService){
        this.enderecoService = enderecoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar/usuario")
    public ResponseEntity<?> listarEnderecoUsuario(@RequestParam("id_user") Long id_user) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id_user);

        if (optionalUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }

      List<Endereco> enderecos = enderecoService.findEnderecosByUsuarioId(optionalUsuario.get().getId_usuario());
        return ResponseEntity.ok(enderecos);
    }


//    @GetMapping("/pesquisar/id")

}
