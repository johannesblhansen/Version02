package org.johannes.training.transport;

import org.johannes.training.domain.Greeting;
import org.johannes.training.domain.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/create/{text}")
    public String createGreetings(@PathVariable("text") String text){
        greetingService.createGreetingAndSaveIt(text);
        return "Hello";
    }

    @RequestMapping(value = "/get/{id}", produces = "application/json")
    public Greeting getGreeting(@PathVariable("id") Long id){
        Greeting greeting = greetingService.getGreeting(id);
        return greeting;
    }

    @RequestMapping(value = "/get", produces = "application/json")
    public List<Greeting> getGreetings(){
        return greetingService.getGreetings();
    }

    @GetMapping("/")
    public String getBase(){
        return "Welcome to the base";
    }


}
