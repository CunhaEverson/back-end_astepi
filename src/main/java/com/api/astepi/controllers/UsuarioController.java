package com.api.astepi.controllers;


import com.api.astepi.dtos.UsuarioDto;
import com.api.astepi.models.UsuarioModel;
import com.api.astepi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto,usuarioModel);
        usuarioModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }
    @GetMapping
    public ResponseEntity<Page<UsuarioModel>> getAllUsuario(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable (value = "id") UUID id){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.finByID(id);
        if(!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable (value = "id")UUID id){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.finByID(id);
        if(!usuarioModelOptional .isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        usuarioService.delete(usuarioModelOptional .get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id")UUID id,@RequestBody @Valid UsuarioDto usuarioDto){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.finByID(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        var usuarioModel = usuarioModelOptional.get();
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setCpf(usuarioDto.getCpf());
        usuarioModel.setCelular(usuarioDto.getCelular());
        usuarioModel.setEmail(usuarioDto.getEmail());
        usuarioModel.setMatricula(usuarioDto.getMatricula());
        usuarioModel.setCargo(usuarioDto.getCargo());
        usuarioModel.setStatus(usuarioDto.isStatus());
        usuarioModel.setNomeLogin(usuarioDto.getNomeLogin());
        usuarioModel.setSenha(usuarioDto.getSenha());
        usuarioModel.setDataNascimento(usuarioDto.getDataNascimento());
        usuarioModel.setProfissao(usuarioDto.getProfissao());
        usuarioModel.setEstadoCivil(usuarioDto.isEstadoCivil());
        usuarioModel.setNacionalidade(usuarioDto.getNacionalidade());
        usuarioModel.setNaturalidade(usuarioDto.getNaturalidade());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));
    }
}