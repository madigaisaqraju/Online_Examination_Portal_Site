package com.example.onlineexam.service;

import com.example.onlineexam.entity.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final List<Question> questions = new ArrayList<>();

    public QuestionService() {

        questions.add(new Question(1, "What is Java?",
                "Programming Language", "OS", "Browser", "Database", "A"));

        questions.add(new Question(2, "Which is not OOP concept?",
                "Inheritance", "Encapsulation", "Compilation", "Polymorphism", "C"));

        questions.add(new Question(3, "Which keyword is used to inherit class?",
                "this", "super", "extends", "implements", "C"));

        questions.add(new Question(4, "HTML stands for?",
                "Hyper Trainer Marking Language",
                "Hyper Text Markup Language",
                "High Text Markup Language",
                "None", "B"));

        questions.add(new Question(5, "CSS is used for?",
                "Logic", "Styling", "Database", "Backend", "B"));

        questions.add(new Question(6, "JavaScript is used for?",
                "Styling", "Structure", "Interactivity", "Database", "C"));

        questions.add(new Question(7, "Spring Boot is used for?",
                "Frontend", "Mobile App", "Backend", "Gaming", "C"));

        questions.add(new Question(8, "Which database is NOT used here?",
                "MySQL", "MongoDB", "Oracle", "None", "D"));

        questions.add(new Question(9, "HTTP stands for?",
                "Hyper Transfer Text Protocol",
                "Hyper Text Transfer Protocol",
                "High Transfer Text Protocol",
                "None", "B"));

        questions.add(new Question(10, "Which port does Spring Boot use by default?",
                "3000", "4200", "8080", "9090", "C"));
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public Question getQuestionById(int id) {
        return questions.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
