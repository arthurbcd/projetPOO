package org.biart.poo.state;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class OpenSessionState implements SessionState {

    @Override
    public String getNotifyMessage() {
        return "Session is now open for subscriptions.";
    }

    @Override
    public void subscribe(Session session, Student student) {
        session.addStudent(student);

        if (session.isFull()) {
            session.setState(new FullSessionState());
        }

        System.out.println("Student " + student.getName() + " subscribed to the session.");
    }

    @Override
    public void unsubscribe(Session session, Student student) {
        session.removeStudent(student);
        System.out.println("Student " + student.getName() + " unsubscribed from the session.");
    }

    @Override
    public void start(Session session, Teacher teacher) {
        session.setState(new StartedSessionState(teacher));
        System.out.println("Session started.");

    }

    @Override
    public void cancel(Session session, Teacher teacher) {
        session.setState(new CanceledSessionState(teacher));
        System.out.println("Session canceled.");
    }

    @Override
    public void end(Session session, Teacher teacher) {
        throw new IllegalStateException("Cannot end a session that hasn't started.");
    }
}
