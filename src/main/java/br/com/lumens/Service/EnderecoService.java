package br.com.lumens.Service;

import br.com.lumens.DTO.CadastrarEnderecoDTO;
import br.com.lumens.Domain.Endereco;
import br.com.lumens.Domain.EnderecoRelacionamento;
import br.com.lumens.Repository.EnderecoRelacionamentoRepository;
import br.com.lumens.Repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    private EnderecoRelacionamentoRepository enderecoRelacionamentoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoRelacionamentoRepository enderecoRelacionamentoRepository){
        this.enderecoRepository = enderecoRepository;
        this.enderecoRelacionamentoRepository = enderecoRelacionamentoRepository;
    }

    public void cadastrarEndereco(CadastrarEnderecoDTO endereco){
        //settando as variaveis de endereço
        Endereco endereco_DTO = new Endereco();
        endereco_DTO.setRua(endereco.getRua());
        endereco_DTO.setBairro(endereco.getBairro());
        endereco_DTO.setNumero(endereco.getNumero());
        endereco_DTO.setCep(endereco.getCep());
        endereco_DTO.setLatitude(endereco.getLatitude());
        endereco_DTO.setLongitude(endereco.getLongitude());
        enderecoRepository.save(endereco_DTO);

        //settando as variaveis de relacionamento entre endereço e usuario
        EnderecoRelacionamento enderecoRelacionamento = new EnderecoRelacionamento();
        enderecoRelacionamento.setIdEntidade(endereco.getId_user());
        enderecoRelacionamento.setIdEndereco(findByLatitudeAndLongitude(endereco.getLatitude(), endereco.getLongitude()));
        enderecoRelacionamentoRepository.save(enderecoRelacionamento);
    }
    public List<Endereco> findEnderecosByUsuarioId(Long ids_endereco){
        return enderecoRepository.buscarEnderecosPorUsuario(ids_endereco);
    }
    public Long findByLatitudeAndLongitude(String latitude, String longitude){
        Endereco endereco = enderecoRepository.findByLatitudeAndLongitude(latitude, longitude);
        return endereco.getId_endereco();
    }
}
