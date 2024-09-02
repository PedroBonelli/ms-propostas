package com.github.pedrobonelli.ms_proposta.controller;

import com.github.pedrobonelli.ms_proposta.dto.FormPropostaDTO;
import com.github.pedrobonelli.ms_proposta.dto.PropostaDTO;
import com.github.pedrobonelli.ms_proposta.dto.UserDTO;
import com.github.pedrobonelli.ms_proposta.model.User;
import com.github.pedrobonelli.ms_proposta.service.PropostaService;
import com.github.pedrobonelli.ms_proposta.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService service;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<PropostaDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PropostaDTO> insert(@RequestBody @Valid FormPropostaDTO formDTO){

//        PropostaDTO propostaDTO = new PropostaDTO(formDTO);
//        UserDTO userDTO = new UserDTO(formDTO);
//        userDTO = userService.insert(userDTO);
//        propostaDTO.setUserId(userDTO.getId());
//        propostaDTO = service.insert(propostaDTO);

        PropostaDTO propostaDTO = service.insertByForm(formDTO);


        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(propostaDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(propostaDTO);
    }

}
