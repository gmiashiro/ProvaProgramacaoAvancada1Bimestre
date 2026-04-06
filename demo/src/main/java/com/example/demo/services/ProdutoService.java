package com.example.demo.services;

import com.example.demo.enums.StatusProduto;
import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> findById(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        model.setDescricao(produtoModel.getDescricao());
        model.setPreco(produtoModel.getPreco());
        model.setStatus(StatusProduto.valueOf(produtoModel.getStatus().name()));
        return produtoRepository.save(model);
    }
}
