package org.biart.poo.state;

import java.util.Date;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class CanceledSessionState implements SessionState {
    private final Teacher teacher;
    private final Date cancelTime = new Date();

    public CanceledSessionState(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getNotifyMessage() {
        return "Session has been canceled by " + teacher.getName() + " at " + cancelTime + ".";
    }

    @Override
    public void cancel(Session session, Teacher teacher) {
        throw new IllegalStateException("Session is already canceled.");
    }

    @Override
    public void subscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot subscribe to a canceled session.");
    }

    @Override
    public void unsubscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot unsubscribe from a canceled session.");
    }

    @Override
    public void start(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot start a canceled session.");
    }

    @Override
    public void end(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot end a canceled session.");
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getCancelTime() {
        return cancelTime;
    }
}
