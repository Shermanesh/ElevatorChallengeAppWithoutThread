package elevator.challenge;

import elevator.challenge.controller.StartFrameController;
import elevator.challenge.model.Elevator;
import elevator.challenge.model.Floor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class ElevatorSystemTest {
    Floor floorUP = new Floor(0, 35);
    Floor floorDOWN = new Floor(35, 0);
    Elevator elevatorUP = new Elevator(0, floorUP);
    Elevator elevatorDOWN = new Elevator(0, floorDOWN);
    StartFrameController startFrameController = new StartFrameController();

    /************** Elevator.class Tests ***************/
    @Test
    void getDirectionTest () {
        assertEquals("UP", elevatorUP.getDirection());
        assertEquals("DOWN", elevatorDOWN.getDirection());
    }

    @Test
    void isAvailabilityTest () {
    }

    /************** StartFrameController.class Tests **************/
    @Test
    void getNonLinearElevatorMotionTest () {

    }

    @Test
    void getLinearElevatorMotionTest () {
    }
}