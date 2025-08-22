package br.com.lumens.Service;

import br.com.lumens.DTO.CadastrarUsuarioDTO;
import br.com.lumens.DTO.UsuarioCompletoDTO;
import br.com.lumens.Domain.Endereco;
import br.com.lumens.Domain.Roles;
import br.com.lumens.Domain.Usuario;
import br.com.lumens.Domain.UsuarioRole;
import br.com.lumens.Repository.EnderecoRepository;
import br.com.lumens.Repository.RoleRepository;
import br.com.lumens.Repository.UsuarioRepository;
import br.com.lumens.Repository.UsuarioRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioRoleRepository usuarioRoleRepository;

    private RoleRepository roleRepository;
    private EnderecoRepository enderecoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioRoleRepository usuarioRoleRepository, RoleRepository roleRepository, EnderecoRepository enderecoRepository){
        this.usuarioRepository = usuarioRepository;
        this.usuarioRoleRepository = usuarioRoleRepository;
        this.roleRepository = roleRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public void cadastrarUsuario(CadastrarUsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setDocumentoPessoal(usuarioDTO.getDocumentoPessoal());
        usuario.setMail(usuarioDTO.getMail());
        usuario.setNumero_tel(usuarioDTO.getNumero_tel());
        usuario.setSenha(usuarioDTO.getSenha());

        List<Roles> roles = roleRepository.findAllById(usuarioDTO.getRolesIds());
        if(roles.isEmpty() || roles == null){
            String error = "Nenhuma Role encontrada!";
            throw new RuntimeException(error);
        }
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public Long pesquisarIdUser(Long id_user){
        Optional<Usuario> usuario = usuarioRepository.findById(id_user);
        return usuario.get().getId_usuario();
    }


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id_user){
        return usuarioRepository.findById(id_user);
    }
    public List<Usuario> findByNome(String nome_user){
        return usuarioRepository.findByNome(nome_user);
    }

    public List<Object[]>  pesquisaUsuarioCompleto(Long idUser){
        return usuarioRepository.pesquisaUsuarioCompleto(idUser);
    }
}
