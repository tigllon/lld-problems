package org.leetcodelikeplatform.repositories;

import org.leetcodelikeplatform.entities.Question;
import org.leetcodelikeplatform.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class QuestionRepository {
    private final HashMap <DifficultyLevel , List< Question>> questions;
    private final List < Question> questionList;

    public QuestionRepository() {
        this.questions = new HashMap<>();
        this.questionList = new ArrayList<>();
    }

    public void add(Question question) {
        questionList.add(question);
        if (!questions.containsKey(question.getDifficultyLevel())) {
            List < Question> questions1 = new ArrayList<>();
            questions.put(question.getDifficultyLevel(),questions1);
        }
        questions.get(question.getDifficultyLevel()).add(question);
    }

    public List < Question> get(DifficultyLevel difficultyLevel) {
        return questions.get(difficultyLevel);
    }

    public List < Question> get() {
        return questionList;
    }

}
