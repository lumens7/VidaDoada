package br.com.lumens.Controller;

import br.com.lumens.Domain.Doacao;
import br.com.lumens.Service.DoacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
