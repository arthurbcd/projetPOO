package org.biart.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.biart.poo.observer.Observable;
import org.biart.poo.state.OpenSessionState;
import org.biart.poo.state.SessionState;

public class Session extends Observable {

    private final String id;
    private final Course course;
    private final LocalDate startAt;
    private final LocalDate endAt;
    private final int maxPlaces;
    private SessionState state;
    private final List<Student> students;
    private final List<Inscription> inscriptions;

    public Session(String id, Course course, LocalDate startAt, LocalDate endAt, int maxPlaces) {
        this.id = id;
        this.course = course;
        this.startAt = startAt;
        this.endAt = endAt;
        this.maxPlaces = maxPlaces;
        this.state = new OpenSessionState();
        this.students = new ArrayList<>();
        this.inscriptions = new ArrayList<>();
    }

    // Métodos públicos que delegam para o estado
    public void subscribe(Student student) {
        state.subscribe(this, student);

    }

    public void addStudent(Student student) {
        students.add(student);

        // Adiciona inscrição e observer
        Inscription inscription = new Inscription(student, this);
        inscriptions.add(inscription);
        student.addInscription(inscription);
        addObserver(student);

    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void unsubscribe(Student student) {
        if (!students.contains(student)) {
            System.out.println("Student is not enrolled in this session.");
            return;
        }

        state.unsubscribe(this, student);
        removeObserver(student);

        // Remove inscrição
        inscriptions.removeIf(i -> i.getStudent().equals(student));
        student.getInscriptions().removeIf(i -> i.getSession().equals(this));
    }

    public void start(Teacher teacher) {
        state.start(this, teacher);
    }

    public void cancel(Teacher teacher) {
        state.cancel(this, teacher);
    }

    public void end(Teacher teacher) {
        state.end(this, teacher);
    }

    // Métodos utilitários
    public boolean isFull() {
        return students.size() >= maxPlaces;
    }

    public void setState(SessionState state) {
        this.state = state;
        String message = state.getNotifyMessage();

        System.out.println(message);
        notifyObservers(message);
    }

    // Getters
    public String getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public LocalDate getEndAt() {
        return endAt;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public SessionState getState() {
        return state;
    }
}
