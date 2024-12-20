package io.github.mateusesp.produtosapi.controller;

import io.github.mateusesp.produtosapi.model.Produto;
import io.github.mateusesp.produtosapi.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(path = "{id}")
    public Produto findById(@PathVariable(name = "id") UUID id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        return produtoService.save(produto);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable(name = "id") UUID id,
                       @RequestBody Produto produto) {
        produtoService.update(id, produto);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        produtoService.delete(id);
    }
}
