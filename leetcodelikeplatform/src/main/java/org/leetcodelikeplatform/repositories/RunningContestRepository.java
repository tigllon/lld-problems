package org.leetcodelikeplatform.repositories;

import org.leetcodelikeplatform.entities.Contest;
import org.leetcodelikeplatform.entities.Question;
import org.leetcodelikeplatform.entities.User;
import org.leetcodelikeplatform.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RunningContestRepository {
    private final HashMap<Contest, HashMap<User, List<Question>>> contests;

    public RunningContestRepository() {
        this.contests = new HashMap<>();
    }

    public void add(Contest contest, List < User> users) {
        contests.put(contest, new HashMap<>());
        for (User user : users) {
            contests.get(contest).put(user , new ArrayList<>());
        }
    }

    public void assignQuestion(Contest contest, List < Question> questionList) {
        int count = questionList.size();
        int totalQuestionPerUser = 1 + (int)(Math.random() * ((count -1) + 1));
        for (User user : contests.get(contest).keySet()) {
            List < Question> questionList1 = new ArrayList<>();
            for (int i=0;i<totalQuestionPerUser;i++) {
                questionList1.add(questionList.get((int)(Math.random()*count)));
            }
            contests.get(contest).get(user).addAll(questionList1);
        }
    }

    public HashMap< User , List < Question>> get(Contest contest) {
        return contests.get(contest);
    }
}
