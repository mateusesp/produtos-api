package io.github.mateusesp.produtosapi.service;

import io.github.mateusesp.produtosapi.model.Produto;
import io.github.mateusesp.produtosapi.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Transactional
@Validated
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Produto findById(UUID id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

    public void update(UUID id, Produto produto) {
        produtoRepository.findById(id).ifPresent(p -> {
            p.setDescricao(produto.getDescricao());
            p.setNome(produto.getNome());
            p.setPreco(produto.getPreco());
        });
    }
}
