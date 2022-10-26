package elevator.challenge.model.destinstion.down;

import elevator.challenge.model.destinstion.Destinstion;

public class Down implements Destinstion {
    @Override
    public int floor (int currentFloor, int destinationFloor) {
        return currentFloor - destinationFloor;
    }
}
