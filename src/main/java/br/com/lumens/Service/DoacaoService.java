package br.com.lumens.Service;

import br.com.lumens.Domain.Doacao;
import br.com.lumens.Repository.DoacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DoacaoService {
    private DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository){
        this.doacaoRepository = doacaoRepository;
    }
    public void cadastrarDoacao(Doacao doacao){
        doacaoRepository.save(doacao);
    }
}
