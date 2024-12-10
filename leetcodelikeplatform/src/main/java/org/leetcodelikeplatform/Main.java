package org.leetcodelikeplatform;

import org.leetcodelikeplatform.enums.DifficultyLevel;
import org.leetcodelikeplatform.repositories.*;
import org.leetcodelikeplatform.services.ContestManagementService;
import org.leetcodelikeplatform.services.LeaderboardManagementService;
import org.leetcodelikeplatform.services.QuestionManagementService;
import org.leetcodelikeplatform.services.UserManagementService;

public class Main {
    public static void main(String[] args) {

        ContestRepository contestRepository = new ContestRepository();
        UserRepository userRepository = new UserRepository();
        AttendeesRepository attendeesRepository = new AttendeesRepository();
        QuestionRepository questionRepository = new QuestionRepository();
        RunningContestRepository runningContestRepository = new RunningContestRepository();

        UserManagementService userManagementService = new UserManagementService(userRepository);
        ContestManagementService contestManagementService = new ContestManagementService(contestRepository,attendeesRepository,userRepository,runningContestRepository,questionRepository);
        QuestionManagementService questionManagementService = new QuestionManagementService(questionRepository);
        LeaderboardManagementService leaderboardManagementService = new LeaderboardManagementService(runningContestRepository,contestRepository);

        userManagementService.createUser("Prakhar");
        userManagementService.createUser("Prateek");
        userManagementService.createUser("Lalu");
        userManagementService.createUser("Pommy");

        questionManagementService.createQuestion(DifficultyLevel.LOW,10);
        questionManagementService.createQuestion(DifficultyLevel.LOW,20);
        questionManagementService.createQuestion(DifficultyLevel.LOW,30);
        questionManagementService.createQuestion(DifficultyLevel.MEDIUM,40);
        questionManagementService.createQuestion(DifficultyLevel.MEDIUM,50);
        questionManagementService.createQuestion(DifficultyLevel.MEDIUM,60);
        questionManagementService.createQuestion(DifficultyLevel.HARD,70);
        questionManagementService.createQuestion(DifficultyLevel.HARD,80);
        questionManagementService.createQuestion(DifficultyLevel.HARD,90);
        contestManagementService.createContest("Mera contest",DifficultyLevel.MEDIUM,userManagementService.getUser("Prakhar"));
        contestManagementService.attendContest(1,"Prateek");
        contestManagementService.attendContest(1,"Lalu");
        contestManagementService.attendContest(1,"Pommy");
//        System.out.println(contestManagementService.getContest(1));
        contestManagementService.runContest(1);
        leaderboardManagementService.getLeaderboard(1);
    }
}