package com.devent.blog.controller;

import com.devent.blog.model.Post;
import com.devent.blog.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogCotroller {
    private final PostRepository postRepository;

    //Inyeccion de dependencias
    public BlogCotroller(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Metodo que muestra la pagnian raiz
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAllByOrderByCreateTimeDesc());
        return "index";
    }

    //Metodos para hacer post
    @GetMapping("/nuevo")
    public String showForm(Model model) {
        model.addAttribute("post", new Post());
        return "formulario";
    }
    @PostMapping("/guardar")
    public String savePost(@Valid @ModelAttribute("post") Post post, BindingResult result) {

        // Si la validación falla (ej. título vacío), detenemos todo y volvemos a mostrar el form
        if (result.hasErrors()) {
            return "formulario";
        }

        postRepository.save(post);
        return "redirect:/";
    }

    //Metodo para editar el post
    @GetMapping("/editar/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            return "redirect:/";
        }

        //Mandamos el post encontrado al formulario
        model.addAttribute("post", post);
        return "formulario";
    }
    
    //Metodo para eliminar post
    @GetMapping("/eliminar/{id}")
        public String eliminarPost(@PathVariable Long id) {
        postRepository.deleteById(id);
	    return "redirect:/";
    }

    //Metodo para ver le post
    @GetMapping("/post/{id}")
    public String verPost(@PathVariable Long id, Model model) {
        // Si no lo encuentra, redirige al inicio en lugar de romperse
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return "redirect:/";
        }

        model.addAttribute("post", post);
        return "detalle";
    }







}
