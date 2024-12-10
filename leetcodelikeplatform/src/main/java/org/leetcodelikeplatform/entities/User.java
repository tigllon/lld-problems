package org.leetcodelikeplatform.entities;

import lombok.*;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @NonNull
    private final String name; // we are considering name to  be unique across all users
    private int score  = 1500;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
