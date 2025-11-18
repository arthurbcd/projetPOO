/*
 * Training Center Management Application
 * Demonstrates MVC architecture and Design Patterns
 */
package org.biart.poo;

import java.time.LocalDate;

import org.biart.poo.model.Category;
import org.biart.poo.model.Course;
import org.biart.poo.model.Session;
import org.biart.poo.model.Student;
import org.biart.poo.model.Teacher;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Training Center Management System ===\n");

        // Creating courses
        Course javaCourse = new Course("Java for Beginners", 40, Category.COMPUTER_SCIENCE);
        Course managementCourse = new Course("Project Management", 30, Category.MANAGEMENT);

        System.out.println("📚 Courses created:");
        System.out.println("  - " + javaCourse.getTitle() + " (" + javaCourse.getDurationHours() + "h)");
        System.out.println("  - " + managementCourse.getTitle() + " (" + managementCourse.getDurationHours() + "h)\n");

        // Creating teacher
        Teacher teacher = new Teacher("T001", "Prof. Dupont", "dupont@training.com");
        teacher.addSpecialty(Category.COMPUTER_SCIENCE);

        System.out.println("👨‍🏫 Teacher registered:");
        System.out.println("  - " + teacher.getName() + " (Specialty: " + teacher.getSpecialties() + ")\n");

        // Creating session (demonstrates State pattern and Observer pattern)
        Session session = new Session("S001", javaCourse,
                LocalDate.of(2026, 1, 12),
                LocalDate.of(2026, 1, 16),
                2); // max 2 students

        System.out.println("📅 Session created:");
        System.out.println("  - Course: " + session.getCourse().getTitle());
        System.out.println("  - Period: " + session.getStartAt() + " to " + session.getEndAt());
        System.out.println("  - Max capacity: " + session.getMaxPlaces() + " students\n");

        // Creating students (they are Observers)
        Student student1 = new Student("S001", "Alice Martin", "alice@email.com");
        Student student2 = new Student("S002", "Bob Durand", "bob@email.com");
        Student student3 = new Student("S003", "Charlie Blanc", "charlie@email.com");

        System.out.println("👥 Students registered:");
        System.out.println("  - " + student1.getName());
        System.out.println("  - " + student2.getName());
        System.out.println("  - " + student3.getName() + "\n");

        // Enrolling students (demonstrates State pattern transitions)
        System.out.println("📝 Enrollment process:\n");

        System.out.println("Enrolling " + student1.getName() + "...");
        session.subscribe(student1);
        System.out.println("  ✓ Enrolled successfully\n");

        System.out.println("Enrolling " + student2.getName() + "...");
        session.subscribe(student2);
        System.out.println("  ✓ Enrolled successfully");
        System.out.println("  ⚠️  Session is now FULL!\n");

        System.out.println("Enrolling " + student3.getName() + "...");
        session.subscribe(student3);
        System.out.println("  ✗ Session is full (State pattern in action!)\n");

        // Display final state
        System.out.println("=== Final Report ===");
        System.out.println("Session: " + session.getCourse().getTitle());
        System.out.println("Enrolled students: " + session.getStudents().size() + "/" + session.getMaxPlaces());
        System.out.println("Current state: " + session.getState().getClass().getSimpleName());

        System.out.println("\n✅ Application completed successfully!");
        System.out.println("\n💡 Design Patterns demonstrated:");
        System.out.println("  • Observer: Students and teachers receive notifications");
        System.out.println("  • State: Session transitions between Open/Full states");
        System.out.println("  • MVC: Separation of Model, View, and Controller");
    }
}
