package com.github.pedrobonelli.ms_proposta.service;

import com.github.pedrobonelli.ms_proposta.dto.PropostaDTO;
import com.github.pedrobonelli.ms_proposta.dto.UserDTO;
import com.github.pedrobonelli.ms_proposta.model.Proposta;
import com.github.pedrobonelli.ms_proposta.model.User;
import com.github.pedrobonelli.ms_proposta.repository.PropostaRepository;
import com.github.pedrobonelli.ms_proposta.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PropostaRepository propostaRepository;

    public List<UserDTO> findAll(){
        List<UserDTO> lista = new ArrayList<>();
        for(User user : repository.findAll()){
            lista.add(new UserDTO(user));
        }
        return lista;
    }

    public UserDTO findById(Long id){
        return new UserDTO(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID não encontrado")));
    }

    public UserDTO insert(UserDTO dto){
        User user = new User();
        copyDtoToEntity(dto, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO update(Long id, UserDTO dto){
        try{
            User entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new UserDTO(entity);
        } catch(EntityNotFoundException e) {
            throw new IllegalArgumentException("ID não encontrado");
        }
    }

    public void deleteById(Long id){
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Usuário inválido - id: " + id);
        }
    }


    private void copyDtoToEntity(UserDTO dto, User entity){
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
