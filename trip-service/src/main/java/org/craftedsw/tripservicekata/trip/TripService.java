package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

import java.util.Collections;
import java.util.List;

public class TripService {

    private final User loggedInUser;
    private final TripDAO tripDAO;

    public TripService(User loggedInUser, TripDAO tripDAO) {
        this.loggedInUser = loggedInUser;
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User friend) throws UserNotLoggedInException {
        validate();

        if (friend.isFriendWith(loggedInUser)) {
            return tripDAO.getUserTrips(friend);
        }
        return Collections.emptyList();
    }

    private void validate() {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
    }
}
