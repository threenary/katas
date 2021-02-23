package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TripDAOShould {

    @Test
    public void throw_exeption_when_called() {
        assertThrows(CollaboratorCallException.class,
                () -> {
                    new TripDAO().getUserTrips(new User());
                });
    }

}