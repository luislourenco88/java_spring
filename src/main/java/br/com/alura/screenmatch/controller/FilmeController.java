package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";

    }


    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";

    }
    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados){

       // System.out.println(dados);
        var filme = new Filme(dados);
        repository.save(filme);
       // System.out.println(filmes);

       return "redirect:/filmes";

    }
    @DeleteMapping
    public String removeFilme(Long id){
        repository.deleteById(id);
        return "redirect:/filmes";

    }

}
