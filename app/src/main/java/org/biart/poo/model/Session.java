package org.biart.poo.model;
import java.time.LocalDate;
import java.util.List;
import org.biart.poo.state.SessionState;
import org.biart.poo.observer.Observable;;

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
        }
    }

    public void unsubscribe(Student student) {
        students.remove(student);
    }

    public void setState(SessionState state) {
        this.state = state;
    }

    @Override
    public void addObservable(Observable Observable) {
        
        throw new UnsupportedOperationException("Unimplemented method 'addObservable'");
    }

    @Override
    public void removeObservable(Observable Observable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObservable'");
    }

    @Override
    public void notifyObservable(Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservable'");
    }

}
