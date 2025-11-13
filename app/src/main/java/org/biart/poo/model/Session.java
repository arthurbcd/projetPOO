package org.biart.poo.model;
import java.time.LocalDate;
import java.util.List;
import org.biart.poo.state.SessionState;

public class Session {

    String id;
    String courseId;
    LocalDate startAt;
    LocalDate endAt;
    int maxPlaces;
    SessionState state;
    List<Student> students;

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

}
