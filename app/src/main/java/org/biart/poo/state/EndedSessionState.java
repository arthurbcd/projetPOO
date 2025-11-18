package org.biart.poo.state;

import java.util.Date;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class EndedSessionState implements SessionState {

    final Teacher teacher;
    final Date endTime = new Date();

    public EndedSessionState(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getNotifyMessage() {
        return "Session has ended by " + teacher.getName() + " at " + endTime + ".";
    }

    @Override
    public void subscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot subscribe to an ended session.");
    }

    @Override
    public void unsubscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot unsubscribe from an ended session.");
    }

    @Override
    public void start(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot start an ended session.");
    }

    @Override
    public void cancel(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot cancel an ended session.");
    }

    @Override
    public void end(Session session, Teacher teacher) {
        throw new IllegalStateException("Session has already ended.");
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getEndTime() {
        return endTime;
    }

}
