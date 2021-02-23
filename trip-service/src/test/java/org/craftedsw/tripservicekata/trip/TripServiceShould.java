package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TripServiceShould {

    private static final User LOGGED_USER = new User();
    private static final User GUEST_USER = null;
    private static final Trip TRIP_TO_PATAGONIA = new Trip();

    @Mock
    private TripDAO tripDAO;

    private TripService tripService;

    @BeforeEach
    public void setUp(){
        tripService = new TripService(LOGGED_USER, tripDAO);
    }

    @Test
    public void throw_user_not_logged_exception() {
        tripService = new TripService(GUEST_USER, tripDAO);
        assertThrows(UserNotLoggedInException.class,
                () -> {
                    tripService.getTripsByUser(aUser());
                });
    }

    @Test
    public void return_empty_trip_list_when_user_is_not_friend() {
        List<Trip> friendTrips = tripService.getTripsByUser(aUser());

        assertThat(friendTrips, empty());
    }

    @Test
    public void return_trips_when_logged_in_user_is_friend() {
        User friendUser = aUser();
        friendUser.addFriend(LOGGED_USER);
        friendUser.addTrip(TRIP_TO_PATAGONIA);
        when(tripDAO.getUserTrips(any(User.class))).thenReturn(aTripsList(TRIP_TO_PATAGONIA));

        List<Trip> friendTrips = tripService.getTripsByUser(friendUser);

        assertThat(friendTrips, hasSize(1));
    }

    @Test
    void return_empty_trip_list_when_logged_in_user_is_not_friend() {
        User userWithFriends = aUser();
        User anotherUser = aUser();
        userWithFriends.addFriend(anotherUser);

        List<Trip> friendTrips = tripService.getTripsByUser(userWithFriends);

        assertThat(friendTrips, empty());
    }

    private User aUser() {
        return new User();
    }

    private List<Trip> aTripsList(Trip trip){
        List<Trip> listOfTrips = new ArrayList<>();
        listOfTrips.add(trip);
        return listOfTrips;
    }

}
