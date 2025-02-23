package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    /*
    // UC1
    @GetMapping("/greet")
    public Greeting getGreeting(){
        return new Greeting("Hello from BridgeLabz");
    }

    @PostMapping("/greet")
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return greeting;
    }

    @PutMapping("/greet")
    public Greeting putGreeting(@RequestBody Greeting greeting){
        return new Greeting("Updated:"+greeting.getMessage());
    }

    @DeleteMapping("/greet")
    public Greeting deleteGreeting(){
        return new Greeting("Greeting deleted");
    }*/

    // UC2
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

   /* @GetMapping("/greetservice")
    public Greeting getGreetings() {
        return new Greeting(greetingService.getGreetingMessage());
    }*/

    //UC3

    // GET Request - Returns a greeting message with optional name inputs
   /* @GetMapping("/greetinput")
    public Greeting getGreeting(@RequestParam(required = false) String firstname,
                                @RequestParam(required = false) String lastname) {
        return new Greeting(greetingService.getGreetingMessage(firstname, lastname));
    }
    //http://localhost:8080/api/greetinput?firstname=Pragya&lastname=Sable


   /* // UC4
    @PostMapping("/savegreeting")
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new Greeting(message);
    }*/

    //UC5
   /* @GetMapping("/findgreeting/{id}")
    public Greeting findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }*/

    @GetMapping("/{id}")
    public Map<String, String> getGreetingById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingById(id));
        return response;
    }
    @GetMapping("/all")
    public List<String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a GET response!");
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a POST response!");
        return response;
    }
    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a PUT response!");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a DELETE response!");
        return response;
    }

    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }
    @PostMapping
    public Map<String, String> postGreeting(@RequestParam(required = false) String firstName,
                                            @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }
    @PutMapping("/{id}")
    public Map<String, String> updateGreeting(@PathVariable Long id, @RequestParam String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.updateGreetingMessage(id, message));
        return response;
    }
    @DeleteMapping("/{id}")
    public Map<String, String> deleteGreeting(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.deleteGreetingById(id));
        return response;
    }



}