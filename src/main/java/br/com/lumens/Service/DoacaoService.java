package br.com.lumens.Service;

import br.com.lumens.Domain.Doacao;
import br.com.lumens.Repository.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    private DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository){
        this.doacaoRepository = doacaoRepository;
    }
    public void cadastrarDoacao(Doacao doacao){
        doacao.setStatusDoacao(Doacao.StatusDoacao.CADASTRADA);
        doacaoRepository.save(doacao);
    }
    public List<Doacao> findAll(){
        return doacaoRepository.findAll();
    }
    public Optional<Doacao> findById(Long id_doacao){
        return doacaoRepository.findById(id_doacao);
    }
    public List<Doacao> findByNome(String nome_doacao){
        return doacaoRepository.findByNome(nome_doacao);
    }
}
