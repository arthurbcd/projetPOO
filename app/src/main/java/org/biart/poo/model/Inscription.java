package org.biart.poo.model;

import java.time.LocalDate;

public class Inscription {
    private final Student student;
    private final Session session;
    private final LocalDate inscriptionDate;
    private boolean completed;

    public Inscription(Student student, Session session) {
        this.student = student;
        this.session = session;
        this.inscriptionDate = LocalDate.now();
        this.completed = false;
    }

    public Student getStudent() {
        return student;
    }

    public Session getSession() {
        return session;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
