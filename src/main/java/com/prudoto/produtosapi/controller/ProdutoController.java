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
    public void save(@RequestBody Produto produto) {produtoRepository.save(produto);}

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @GetMapping(params = "nome")
    public List<Produto> findByNome( @RequestParam String nome) {return produtoRepository.findByNome(nome);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){ produtoRepository.deleteById(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }
}
