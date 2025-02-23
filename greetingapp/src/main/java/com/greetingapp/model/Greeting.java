
package com.greetingapp.model;



import jakarta.persistence.*;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String message;
    private long id;
    public Greeting(){

    }

    public Greeting(String message) {
        this.message = message;
    }
    public Long getId() {
        return id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
