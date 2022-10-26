package elevator.challenge.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {

    private Floor floor;
    private int elevatorsFloor;
    private int currentFloor;
    private int destinationFloor;
    private boolean availability;

    public Elevator (int elevatorsFloor, Floor floor) {
        this.elevatorsFloor = elevatorsFloor;
        this.floor = floor;
        currentFloor = floor.getCurrentFloor();
        destinationFloor = floor.getDestinationFloor();
    }

    @SneakyThrows
    public void run () {
        if (this.getDirection().equals("UP")) {
            System.out.println("Direction: UP");
            for (int i = elevatorsFloor; i <= destinationFloor; i++) {

                if ((i != elevatorsFloor) && (i == currentFloor)) {
                    System.out.println("Current floor: " + i);
                }
            }
        } else if (this.getDirection().equals("DOWN")) {
            System.out.println("Direction: DOWN");
            for (int i = elevatorsFloor; i >= destinationFloor; i--) {

                if ((i != elevatorsFloor) && (i == currentFloor)) {
                    System.out.println("Current floor: " + i);
                }
            }
        }
    }

    public String getDirection () {
        if (currentFloor < destinationFloor) {
            return "UP";
        } else if (currentFloor > destinationFloor) {
            return "DOWN";
        } else {
            return "It is current floor: " + currentFloor;
        }
    }

    public boolean isAvailability () {
        return availability = true;
    }
}
