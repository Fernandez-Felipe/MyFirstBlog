package com.Project.demo.App.Controller;

import com.Project.demo.App.Exceptions.SpringBlogException;
import com.Project.demo.App.Service.PostService;
import com.Project.demo.App.domain.Post;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;


@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @ExceptionHandler(SpringBlogException.class)
    public ModelAndView handleSpringBlogException(SpringBlogException ex){
        ModelAndView model = new ModelAndView("error");
        model.addObject("exception",ex);
        return model;
    }

    //Te envia a la pagina principal y cargar todos los posteos
    @GetMapping
    public String postPage(Model model){

        model.addAttribute("posts",postService.findAllPost());

        return "posts";

    }

    //Se crea un objeto post y se lo coloc como atributo paraposteriormente ir a la pagina addpost
    @GetMapping("/add")
    public String addPostPage(Model model){

        model.addAttribute("post", new Post());
        return "addpost";
    }

    //Con esto se guarda un Posteo y se redirecciona a la pagina principal
    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors){

        if(errors.hasErrors()){
            return "addpost";
        }

        postService.addPost(post);
        return "redirect:/posts";
    }

    //Subir Archivos
    @PostMapping("/uploadMyFile")
    public String handleFileUpload(@RequestParam("myFile")MultipartFile file){

        if(!file.isEmpty()){

            String name = file.getOriginalFilename();

            try{

                byte[] bytes = file.getBytes();
                Files.write(new File(name).toPath(), bytes);

            }catch (Exception ex){

            }
        }
        return "redirect:/fileUpload";
    }

    @GetMapping("/{id}")
    public String onePostPage(Model model, @PathVariable Integer id ){
        model.addAttribute("posts",postService.findOnePost(id));
        return "onePost";
    }

}
