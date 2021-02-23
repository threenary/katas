package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserShould {

    private static final User ANOTHER_USER = new User();
    private static User USER = new User();

    @Test
    public void not_be_friends() {
        assertFalse(USER.isFriendWith(ANOTHER_USER));
    }

    @Test
    void be_friend_with() {
        USER.addFriend(ANOTHER_USER);
        boolean isFriendWith = USER.isFriendWith(ANOTHER_USER);

        assertTrue(isFriendWith);
    }
}
