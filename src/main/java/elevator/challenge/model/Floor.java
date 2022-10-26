package elevator.challenge.model;

import elevator.challenge.exception.WrongFloorNrException;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

    private final int firsrtFloor = 0;
    private final int officeFloor = 35;
    private final int lastFloor = 55;
    private final List<Integer> floorList = new ArrayList<>();
    private int currentFloor;
    private int destinationFloor;

    //Validation_CurrentFloor
    public int getCurrentFloor () {
        if (currentFloor < firsrtFloor || currentFloor > lastFloor)
            getException(currentFloor);
        return currentFloor;
    }

    //Validation_DestinationFloor
    public int getDestinationFloor () {
        if (destinationFloor < firsrtFloor || destinationFloor > lastFloor)
            getException(destinationFloor);
        return destinationFloor;
    }

    private void getException (int floor) {
        try {
            throw new WrongFloorNrException(floor);
        } catch (WrongFloorNrException e) {
            e.printStackTrace();
        }
    }

    //List for GUI
    public List<Integer> getFloorList () {
        for (int i = firsrtFloor; i <= lastFloor; i++)
            floorList.add(i);
        return floorList;
    }
}
