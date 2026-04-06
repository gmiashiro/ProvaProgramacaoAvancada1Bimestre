package com.example.demo.controllers;

import com.example.demo.models.ProdutoModel;
import com.example.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> requeste = produtoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> findById(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        return produtoService.atualizarProduto(id, produtoModel);
    }
}
