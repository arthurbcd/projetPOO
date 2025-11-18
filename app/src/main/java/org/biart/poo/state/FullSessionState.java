package org.biart.poo.state;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class FullSessionState implements SessionState {
    @Override
    public String getNotifyMessage() {
        return "Session is full. No more subscriptions allowed.";
    }

    @Override
    public void subscribe(Session session, Student student) {
        throw new IllegalStateException("Cannot subscribe to a full session.");
    }

    @Override
    public void unsubscribe(Session session, Student student) {
        session.removeStudent(student);
        session.setState(new OpenSessionState());
    }

    @Override
    public void start(Session session, Teacher teacher) {
        session.setState(new StartedSessionState(teacher));
    }

    @Override
    public void cancel(Session session, Teacher teacher) {
        session.setState(new CanceledSessionState(teacher));
    }

    @Override
    public void end(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot end a session that hasn't started.");
    }
}
