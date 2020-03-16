package hw.lesson.microgram51.controller;


import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.PostRepo;
import hw.lesson.microgram51.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @GetMapping("/user/all")
    public String root(Model model) {
        model.addAttribute("user", userRepo.findAll());
        return "user";
    }


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        // merge
        User userN = userRepo.findById(user.id).orElse(user);
        for (Post t : user.posts) {
            if (userN.posts.stream().filter(x -> {
                return Objects.equals(x.id, t.id);
            }).count() == 0)
                userN.posts.add(t);
        }

        // save
        List<Post> tasks = userN.posts;
        for (Post t : tasks)
            postRepo.save(t);

        userRepo.save(userN);

        return userN;
    }

    @DeleteMapping("/user/{id}")
    public Optional<User> deleteUser(@PathVariable String id) {
        Optional<User> user = userRepo.findById(id);
        userRepo.deleteById(id);

        return user;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        Optional<User> user = userRepo.findById(id);

        return user;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        return userRepo.findAll(sort);
    }
    @GetMapping("/user {name}")
    public User getUserByName(String name) {
       return userRepo.findByName(name);
    }
    @GetMapping("/user {email}")
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
