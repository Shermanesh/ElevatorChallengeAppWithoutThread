package elevator.challenge.model;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {

    private Floor floor;
    private int elevatorsFloor;
    private int currentFloor;
    private int destinationFloor;
    private boolean availability = true;

    private List<Elevator> elevatorsMotion = new ArrayList<>();

    public Elevator (int elevatorsFloor, Floor floor) {
        this.elevatorsFloor = elevatorsFloor;
        this.floor = floor;
        currentFloor = floor.getCurrentFloor();
        destinationFloor = floor.getDestinationFloor();
    }

    public List<Elevator> getElevatorsMotion () {
        int floor;
        if (this.getDirection().equals("UP")) {
            System.out.println("Direction: UP");
            for (int i = elevatorsFloor; i <= destinationFloor; i++) {
                floor = +i;
                System.out.println("Floor: " + floor);
                if ((i != elevatorsFloor) && (i == currentFloor)) {
                    System.out.println("Current floor: " + i);
                }
            }
        } else if (this.getDirection().equals("DOWN")) {
            System.out.println("Direction: DOWN");
            for (int i = elevatorsFloor; i >= destinationFloor; i--) {
                floor = +i;
                System.out.println("Floor: " + floor);
                if ((i != elevatorsFloor) && (i == currentFloor)) {
                    System.out.println("Current floor: " + i);
                }
            }
        }
        return elevatorsMotion;
    }

//    public void addElevator (Elevator elevator){
//        this.elevators.add(elevator);
//        for (Elevator el : this.elevators)
//            System.out.println(el);
//    }

    public String getDirection () {
        if (currentFloor < destinationFloor) {
            return "UP";
        } else if (currentFloor > destinationFloor) {
            return "DOWN";
        } else {
            return "It is current floor: " + currentFloor;
        }
    }
}
