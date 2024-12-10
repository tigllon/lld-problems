package org.leetcodelikeplatform.services;

import lombok.AllArgsConstructor;
import org.leetcodelikeplatform.entities.Contest;
import org.leetcodelikeplatform.entities.Question;
import org.leetcodelikeplatform.entities.User;
import org.leetcodelikeplatform.repositories.ContestRepository;
import org.leetcodelikeplatform.repositories.RunningContestRepository;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class LeaderboardManagementService {
    private RunningContestRepository runningContestRepository;
    private ContestRepository contestRepository;
    public void getLeaderboard(int id) {
        Contest contest = contestRepository.get(id);
        HashMap <User, List< Question>> userListHashMap = runningContestRepository.get(contest);
        for (User user : userListHashMap.keySet()) {
            int sum = 0;
            System.out.println(userListHashMap.get(user));
            for (Question question : userListHashMap.get(user)) {
                sum+=question.getScore();
            }
            System.out.println(user.getName() + " "+ sum);
        }
    }
}
