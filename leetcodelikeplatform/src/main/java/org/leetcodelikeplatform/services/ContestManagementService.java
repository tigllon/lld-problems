package org.leetcodelikeplatform.services;

import lombok.AllArgsConstructor;
import org.leetcodelikeplatform.entities.Contest;
import org.leetcodelikeplatform.entities.Question;
import org.leetcodelikeplatform.entities.User;
import org.leetcodelikeplatform.enums.DifficultyLevel;
import org.leetcodelikeplatform.repositories.*;

import java.util.List;

@AllArgsConstructor
public class ContestManagementService {
    private ContestRepository contestRepository;
    private AttendeesRepository attendeesRepository;
    private UserRepository userRepository;
    private RunningContestRepository runningContestRepository;
    private QuestionRepository questionRepository;
    public void createContest(String name, DifficultyLevel difficultyLevel, User creator) {
        Contest contest = new Contest(name,difficultyLevel,creator);
        contestRepository.add(contest);
        attendeesRepository.add(contest,creator);
    }
    public List< Contest> getContest(DifficultyLevel difficultyLevel) {
        return contestRepository.get(difficultyLevel);
    }

    public List < Contest> getContest() {
        return contestRepository.get();
    }

    public void attendContest(int id, String name) {
        User user = userRepository.get(name);
        Contest contest = contestRepository.get(id);
        attendeesRepository.add(contest,user);
    }

    public void runContest(int id) {
        Contest contest = contestRepository.get(id);
        runningContestRepository.add(contest, userRepository.get());
        runningContestRepository.assignQuestion(contest, questionRepository.get(contest.getDifficultyLevel()));
    }

    public Contest getContest(int id) {
        return contestRepository.get(id);
    }
}
