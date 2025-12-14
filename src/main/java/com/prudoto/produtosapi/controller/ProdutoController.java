package com.prudoto.produtosapi.controller;

import com.prudoto.produtosapi.model.Produto;
import com.prudoto.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        System.out.println("Produto salvo: " + produto);
        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
