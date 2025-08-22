package br.com.lumens.Controller;

import br.com.lumens.DTO.CadastrarDisponibilidadeDTO;
import br.com.lumens.DTO.CadastrarEnderecoDTO;
import br.com.lumens.DTO.CadastrarUsuarioDTO;
import br.com.lumens.DTO.UsuarioCompletoDTO;
import br.com.lumens.Domain.Endereco;
import br.com.lumens.Domain.Usuario;
import br.com.lumens.Service.DisponibilidadeService;
import br.com.lumens.Service.EnderecoService;
import br.com.lumens.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    private UsuarioService usuarioService;
    private EnderecoService enderecoService;
    private DisponibilidadeService disponibilidadeService;

    public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService, DisponibilidadeService disponibilidadeService){
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
        this.disponibilidadeService = disponibilidadeService;
    }

    @PostMapping("/cadastrar/usuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CadastrarUsuarioDTO usuario){
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok("Usuário Salvo com Sucesso!");
    }
    @PostMapping("/cadastrar/endereco")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody CadastrarEnderecoDTO cadastrarEnderecoDTO){
        enderecoService.cadastrarEndereco(cadastrarEnderecoDTO);
        return ResponseEntity.ok("Endereço Salvo e vinculado com o usuário com Sucesso!");
    }

    @PostMapping("/cadastrar/disponibilidade")
    public ResponseEntity<?> cadastrarDisponibilidade(@RequestBody CadastrarDisponibilidadeDTO cadastrarDisponibilidadeDTO){
        disponibilidadeService.cadastrarDisponibilidade(cadastrarDisponibilidadeDTO);
        return ResponseEntity.ok("Disponibilidade Salva e vinculado com o usuário com Sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios(){
        List<Usuario> users = usuarioService.findAll();
        if (users == null || users.isEmpty()){
            String erro = "Nenhum usuário encontrado!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.ok(users);
    }
    @GetMapping("/pesquisar/id")
    public ResponseEntity<?> pesquisarId(@RequestParam("id_user")Long id_user){
        Optional<Usuario> usuarioId = usuarioService.findById(id_user);
        if (usuarioId == null || usuarioId.isEmpty()){
            String erro = "Nenhum usuário encontrado!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
        return ResponseEntity.ok(usuarioId);
    }

    @GetMapping("/pesquisar/nome")
    public ResponseEntity<?> pesquisarNome(@RequestParam("nome_user")String nome_user){
        List<Usuario> usuarioNome = usuarioService.findByNome(nome_user);
        if (usuarioNome == null || usuarioNome.isEmpty()){
            String erro = "Nenhum usuário encontrado!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
        return ResponseEntity.ok(usuarioNome);
    }
    @GetMapping("pesquisar/completa")
    public ResponseEntity<?> pesquisaUsuarioCompleto(@RequestParam("idUser") Long idUser){
        List<Object[]>  usuariocompleto = usuarioService.pesquisaUsuarioCompleto(idUser);

        if (usuariocompleto.isEmpty() || usuariocompleto == null){
            String erro = "Nenhum usuário encontrado!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
        return ResponseEntity.ok(usuariocompleto);

    }

}
