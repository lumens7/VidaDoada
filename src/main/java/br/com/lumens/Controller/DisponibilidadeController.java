package br.com.lumens.Controller;

import br.com.lumens.Domain.Disponibilidade;
import br.com.lumens.Domain.Usuario;
import br.com.lumens.Service.DisponibilidadeService;
import br.com.lumens.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {
    private DisponibilidadeService disponibilidadeService;
    private UsuarioService usuarioService;
    public DisponibilidadeController(DisponibilidadeService disponibilidadeService, UsuarioService usuarioService){
        this.disponibilidadeService = disponibilidadeService;
        this.usuarioService = usuarioService;
    }
    @GetMapping("/listar/usuario")
    public ResponseEntity<?> listarDisponibilidadeUsuario(@RequestParam("id_user")Long id_usuario){
        Optional<Usuario> optionalUsuario = usuarioService.findById(id_usuario);

        if(optionalUsuario.isEmpty() || optionalUsuario == null){
            String erro = "Nenhum usuário encontrado!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
        List<Disponibilidade> disponibilidades = disponibilidadeService.buscarDisponibilidadePorUsuario(id_usuario);
        return ResponseEntity.ok(disponibilidades);
    }
}
