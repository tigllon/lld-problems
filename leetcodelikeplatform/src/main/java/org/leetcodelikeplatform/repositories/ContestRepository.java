package org.leetcodelikeplatform.repositories;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.leetcodelikeplatform.entities.Contest;
import org.leetcodelikeplatform.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ContestRepository {
    private final List<Contest> contestList ;
    HashMap < Integer,Contest> contestHashMap;
    private final HashMap <DifficultyLevel , List < Contest>> contests;

    public ContestRepository () {
        contests = new HashMap<>();
        contestHashMap = new HashMap<>();
        contestList = new ArrayList<>();
    }
    public void add(Contest contest) {
        contestList.add(contest);
        contestHashMap.put(contest.getId(),contest);
        if (!contests.containsKey(contest.getDifficultyLevel())) {
            List < Contest> contests1 = new ArrayList<>();
            contests.put(contest.getDifficultyLevel() , contests1);
        }
        contests.get(contest.getDifficultyLevel()).add(contest);
    }

    public List <Contest> get(DifficultyLevel difficultyLevel) {
        return contests.get(difficultyLevel);
    }

    public List < Contest> get() {
        return contestList;
    }

    public Contest get(Integer id) {
        return contestHashMap.get(id);
    }

}
