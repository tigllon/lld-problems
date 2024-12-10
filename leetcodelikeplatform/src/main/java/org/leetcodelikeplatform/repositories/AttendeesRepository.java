package org.leetcodelikeplatform.repositories;

import org.leetcodelikeplatform.entities.Contest;
import org.leetcodelikeplatform.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendeesRepository {
    private final HashMap <Contest , List<User>> attendees;

    public AttendeesRepository() {
        this.attendees = new HashMap<>();
    }

    public void add(Contest contest, User user) {
        if (!attendees.containsKey(contest)) {
            List < User> userList = new ArrayList<>();
            attendees.put(contest,userList);
        }
        attendees.get(contest).add(user);
    }
}
