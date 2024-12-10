package org.leetcodelikeplatform.services;

import lombok.AllArgsConstructor;
import org.leetcodelikeplatform.entities.Question;
import org.leetcodelikeplatform.enums.DifficultyLevel;
import org.leetcodelikeplatform.repositories.QuestionRepository;

import java.util.List;

@AllArgsConstructor
public class QuestionManagementService {
    private QuestionRepository questionRepository;

    public void createQuestion(DifficultyLevel difficultyLevel, int score) {
        Question question = new Question(difficultyLevel,score);
        questionRepository.add(question);
    }

    public List< Question> get(DifficultyLevel difficultyLevel) {
        return  questionRepository.get(difficultyLevel);
    }

    public List < Question> get() {
        return questionRepository.get();
    }
}
