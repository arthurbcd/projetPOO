package org.biart.poo.model;

import java.time.LocalDate;
import java.util.List;

import org.biart.poo.observer.Observable;
import org.biart.poo.observer.Observer;
import org.biart.poo.state.FullSessionState;
import org.biart.poo.state.SessionState;;

public class Session implements Observable {

    private String id;
    private String courseId;
    private LocalDate startAt;
    private LocalDate endAt;
    private int maxPlaces;
    private SessionState state;
    private List<Student> students;

    public void subscribe(Student student) {
        if (students.size() < maxPlaces) {
            students.add(student);

            if (students.size() == maxPlaces) {
                setState(new FullSessionState());
            }
        } else {
            System.out.println("Cannot subscribe, session is full.");
        }
    }

    public void unsubscribe(Student student) {
        students.remove(student);
    }

    public void setState(SessionState state) {
        this.state = state;
        notifyObservers(state);
    }

    @Override
    public void addObserver(Observer observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObserver'");
    }

    @Override
    public void removeObserver(Observer observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
    }

    @Override
    public void notifyObservers(Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }

}
