package org.biart.poo.state;

import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public interface SessionState {
    /// La message pour notifier l'état actuel de la session.
    String getNotifyMessage();

    /// Inscrit un étudiant à la session.
    void subscribe(Session session, Student student);

    /// Désinscrit un étudiant de la session.
    void unsubscribe(Session session, Student student);

    /// Démarre la session.
    void start(Session session, Teacher teacher);

    /// Annule la session.
    void cancel(Session session, Teacher teacher);

    /// Termine la session.
    void end(Session session, Teacher teacher);
}
