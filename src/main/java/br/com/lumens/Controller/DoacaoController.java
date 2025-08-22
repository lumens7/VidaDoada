package br.com.lumens.Controller;

import br.com.lumens.Domain.Doacao;
import br.com.lumens.Service.DoacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doar")
public class DoacaoController {

    private DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService){
        this.doacaoService = doacaoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarDoacao(@RequestBody Doacao doacao){
        doacaoService.cadastrarDoacao(doacao);
        return ResponseEntity.ok("Cadastro Realizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarDoacao(){
        List<Doacao> doacoes = doacaoService.findAll();
        if(doacoes.isEmpty()){
            String erro = "Nenhuma doação Encontrada!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
        return ResponseEntity.ok(doacoes);
    }

    @GetMapping("/pesquisar/id")
    public ResponseEntity<?> pesquisarId(@RequestParam("id_doacao")Long id_doacao){
        Optional<Doacao> doacaoId = doacaoService.findById(id_doacao);
        if(doacaoId.isEmpty()){
            String erro = "Nenhuma doação Encontrada!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.ok(doacaoId);
    }

    @GetMapping("/pesquisar/nome")
    public ResponseEntity<?> pesquisarNome(@RequestParam("nome_doacao")String nome_doacao){
        List<Doacao> doacaoNome = doacaoService.findByNome(nome_doacao);
        if(doacaoNome == null || doacaoNome.isEmpty()){
            String erro = "Nenhuma doação Encontrada!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.ok(doacaoNome);
    }
}
