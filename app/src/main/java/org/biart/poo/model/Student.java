package org.biart.poo.model;

import java.util.ArrayList;
import java.util.List;

import org.biart.poo.observer.Observer;

public class Student implements Observer {
    private String id;
    private String name;
    private String email;
    private final List<Inscription> inscriptions;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.inscriptions = new ArrayList<>();
    }

    public void addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for student " + name + ": " + message);
    }

    public boolean hasCompleted(Course course) {
        for (Inscription inscription : inscriptions) {
            if (inscription.getSession().getCourse().equals(course) && inscription.isCompleted()) {
                return true;
            }
        }
        return false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
}
