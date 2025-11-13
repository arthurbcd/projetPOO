package org.biart.poo.model;

public class Student {
    String id;
    String name;    
    String email;

    public void subscribe(Session session) {
        session.subscribe(this);
    }

}
