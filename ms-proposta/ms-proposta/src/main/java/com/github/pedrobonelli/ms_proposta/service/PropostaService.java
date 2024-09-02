package com.github.pedrobonelli.ms_proposta.service;

import com.github.pedrobonelli.ms_proposta.dto.FormPropostaDTO;
import com.github.pedrobonelli.ms_proposta.dto.PropostaDTO;
import com.github.pedrobonelli.ms_proposta.dto.UserDTO;
import com.github.pedrobonelli.ms_proposta.model.Proposta;
import com.github.pedrobonelli.ms_proposta.model.User;
import com.github.pedrobonelli.ms_proposta.repository.PropostaRepository;
import com.github.pedrobonelli.ms_proposta.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    @Autowired
    private UserRepository userRepository;

    public PropostaDTO insert(PropostaDTO propostaDTO){
        Proposta entityProposta = new Proposta();
        copyDtoToEntity(propostaDTO, entityProposta);
        entityProposta = repository.save(entityProposta);
        return new PropostaDTO(entityProposta);
    }

    public PropostaDTO insertByForm(FormPropostaDTO formDTO){
        PropostaDTO propostaDTO = new PropostaDTO(formDTO);
        UserDTO userDTO = new UserDTO(formDTO);

//       userDTO = userService.insert(userDTO);

        User user = new User();
        copyUserDtoToEntity(userDTO, user);
        user = userRepository.save(user);
        UserDTO userDTOCompleto = new UserDTO(user);

        propostaDTO.setUserId(userDTOCompleto.getId());

//        propostaDTO = service.insert(propostaDTO);

        Proposta entityProposta = new Proposta();
        copyDtoToEntity(propostaDTO, entityProposta);
        entityProposta = repository.save(entityProposta);

        return new PropostaDTO(entityProposta);
    }

    public List<PropostaDTO> findAll(){
        List<PropostaDTO> lista = new ArrayList<PropostaDTO>();
        for(Proposta entity : repository.findAll()){
            lista.add(new PropostaDTO(entity));
        }
        return lista;
    }

    public PropostaDTO findById(Long id){
        return new PropostaDTO(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID não encontrado.")));
    }

    private void copyDtoToEntity(PropostaDTO dto, Proposta entity){
        entity.setId(dto.getId());
        entity.setAprovado(dto.getAprovado());
        entity.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        entity.setAprovado(dto.getAprovado());
        entity.setValorSolicitado(dto.getValorSolicitado());

        User usuario = userRepository.getReferenceById(dto.getUserId());
        entity.setUsuario(usuario);
    }

    private void copyUserDtoToEntity(UserDTO dto, User entity){
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setCpf(dto.getCpf());
        entity.setRenda(dto.getRenda());
        entity.setTelefone(dto.getTelefone());

//        for(PropostaDTO propostaDTO : dto.getPropostasDTO()){
//            Proposta proposta = propostaRepository.getReferenceById(propostaDTO.getId());
//            entity.getPropostas().add(proposta);
//        }

    }

}
