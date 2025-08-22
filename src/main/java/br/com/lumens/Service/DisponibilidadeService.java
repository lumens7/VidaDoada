package br.com.lumens.Service;

import br.com.lumens.DTO.CadastrarDisponibilidadeDTO;
import br.com.lumens.Domain.Disponibilidade;
import br.com.lumens.Domain.DisponibilidadeRelacionamento;
import br.com.lumens.Repository.DisponibilidadeRelacionamentoRepository;
import br.com.lumens.Repository.DisponibilidadeRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Service
public class DisponibilidadeService {
    private DisponibilidadeRepository disponibilidadeRepository;
    private DisponibilidadeRelacionamentoRepository disponibilidadeRelacionamentoRepository;
    private UsuarioService usuarioService;
    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository, DisponibilidadeRelacionamentoRepository disponibilidadeRelacionamentoRepository, UsuarioService usuarioService){
        this.disponibilidadeRepository = disponibilidadeRepository;
        this.disponibilidadeRelacionamentoRepository = disponibilidadeRelacionamentoRepository;
        this.usuarioService = usuarioService;
    }

    public void cadastrarDisponibilidade(CadastrarDisponibilidadeDTO cadastrarDisponibilidadeDTO){
        Disponibilidade disponibilidade = new Disponibilidade();
        disponibilidade.setDiaSemana(cadastrarDisponibilidadeDTO.getDiaSemana());
        disponibilidade.setHoraInicio(cadastrarDisponibilidadeDTO.getHoraInicio());
        disponibilidade.setHoraFim(cadastrarDisponibilidadeDTO.getHoraFim());
        disponibilidade.setId_user(usuarioService.pesquisarIdUser(cadastrarDisponibilidadeDTO.getId_user()));
        disponibilidadeRepository.save(disponibilidade);

        DisponibilidadeRelacionamento disponibilidadeRelacionamento = new DisponibilidadeRelacionamento();
        disponibilidadeRelacionamento.setId_disponibilidade(pesquisarPorTodosCampos(cadastrarDisponibilidadeDTO.getId_user(),
                cadastrarDisponibilidadeDTO.getDiaSemana(),
                cadastrarDisponibilidadeDTO.getHoraInicio(),
                cadastrarDisponibilidadeDTO.getHoraFim()
        ));
        disponibilidadeRelacionamento.setId_entidade(cadastrarDisponibilidadeDTO.getId_user());
        disponibilidadeRelacionamentoRepository.save(disponibilidadeRelacionamento);
    }
    public Long pesquisarPorTodosCampos(Long id_user, DayOfWeek diaSemana, LocalTime horaInicio, LocalTime horaFim){
        Disponibilidade disponibilidade = disponibilidadeRepository.pesquisarPorTodosCampos(id_user, diaSemana, horaInicio, horaFim);
        return disponibilidade.getId_disponibilidade();
    }
    public List<Disponibilidade> buscarDisponibilidadePorUsuario(Long idUser){
        return disponibilidadeRepository.buscarDisponibilidadePorUsuario(idUser);
    }
}
