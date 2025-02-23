package com.greetingapp.service;

import com.greetingapp.model.Greeting;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

   /* public String getGreetingMessage() {
            return "Hello World";
        }
   /* public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
     }
  }*/

    //UC-04
    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save greeting to repository
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);

        return message;
    }
    //UC5
    // New method to find a greeting by ID
   /* public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }*/
    public String getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .map(Greeting::getMessage)
                .orElse("Greeting not found");
    }
    public List<String> getAllGreetings() {
        return greetingRepository.findAll().stream()
                .map(Greeting::getMessage)
                .toList();
    }

    public String updateGreetingMessage(Long id, String newMessage) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newMessage);
                    greetingRepository.save(greeting);
                    return "Greeting updated successfully";
                })
                .orElse("Greeting not found");
    }

}