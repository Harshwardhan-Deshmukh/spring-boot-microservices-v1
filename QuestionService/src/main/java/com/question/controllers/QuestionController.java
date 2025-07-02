package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private final QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question quiz) {
        return questionService.create(quiz);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable Long id) {
        return questionService.get(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable(name = "quizId") Long id) {
        return questionService.findByQuizId(id);
    }
}
