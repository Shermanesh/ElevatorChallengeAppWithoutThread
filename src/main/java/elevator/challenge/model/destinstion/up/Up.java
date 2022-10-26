package elevator.challenge.model.destinstion.up;

import elevator.challenge.model.destinstion.Destinstion;

public class Up implements Destinstion {
    @Override
    public int floor (int currentFloor, int destinationFloor) {
        return destinationFloor - currentFloor;
    }
}
