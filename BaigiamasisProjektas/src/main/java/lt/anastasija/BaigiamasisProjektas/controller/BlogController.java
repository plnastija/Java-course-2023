package lt.anastasija.BaigiamasisProjektas.controller;

import lt.anastasija.BaigiamasisProjektas.models.Post;
import lt.anastasija.BaigiamasisProjektas.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogMainAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String company_name, @RequestParam String position, @RequestParam String email, @RequestParam String answer, @RequestParam String full_text, @RequestParam int salary, @RequestParam LocalDate date_of_application, Model model) {
        Post post = new Post(title, company_name, position, email,answer, full_text, salary, date_of_application);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String company_name, @RequestParam String position, @RequestParam String email, @RequestParam String answer, @RequestParam String full_text, @RequestParam int salary, @RequestParam LocalDate date_of_application, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setCompany_name(company_name);
        post.setPosition(position);
        post.setEmail(email);
        post.setAnswer(answer);
        post.setFull_text(full_text);
        post.setSalary(salary);
        post.setDate_of_application(date_of_application);
        postRepository.save(post);
        return "redirect:/blog";

    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}

