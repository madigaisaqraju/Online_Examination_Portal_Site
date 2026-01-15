package com.example.onlineexam.controller;

import com.example.onlineexam.entity.Question;
import com.example.onlineexam.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ExamController {

    private final QuestionService service;

    public ExamController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable int id) {
        return service.getQuestionById(id);
    }
}
