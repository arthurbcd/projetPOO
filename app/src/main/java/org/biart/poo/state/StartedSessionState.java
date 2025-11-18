package org.biart.poo.state;

import java.util.Date;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class StartedSessionState implements SessionState {

    final Teacher teacher;
    final Date startTime = new Date();

    public StartedSessionState(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getNotifyMessage() {
        return "Session started by " + teacher.getName() + " at " + startTime + ".";
    }

    @Override
    public void subscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot subscribe to a started session.");
    }

    @Override
    public void unsubscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot unsubscribe from a started session.");
    }

    @Override
    public void start(Session session, Teacher teacher) {
        throw new IllegalStateException("Session has already started.");
    }

    @Override
    public void cancel(Session session, Teacher teacher) {
        session.setState(new CanceledSessionState(teacher));
    }

    @Override
    public void end(Session session, Teacher teacher) {
        session.setState(new EndedSessionState(teacher));
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getStartTime() {
        return startTime;
    }
}
