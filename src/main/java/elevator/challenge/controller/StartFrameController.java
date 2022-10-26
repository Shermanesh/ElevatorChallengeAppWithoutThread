package elevator.challenge.controller;

import elevator.challenge.model.Elevator;
import elevator.challenge.model.Floor;
import lombok.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class StartFrameController implements ActionListener {

    public static final String NO_CHOICE = "Please choose the current and destination floor.";
    public static final String THE_SAME_FLOOR = "Wrong destination floor. It is your current floor.";

    //GUI properties
    private JButton startButton;
    private JComboBox currentFloorBox;
    private JComboBox destinationFloorBox;

    private int elevatorsFloor = 0; //The elevator starts from the first floor by default
    private int officeFloor = new Floor().getOfficeFloor();
    private int currentFloor;
    private int destinationFloor;

    public StartFrameController (JButton startButton, JComboBox currentFloorBox, JComboBox destinationFloorBox) {
        this.startButton = startButton;
        this.currentFloorBox = currentFloorBox;
        this.destinationFloorBox = destinationFloorBox;
    }

    @SneakyThrows
    @Override
    public void actionPerformed (ActionEvent e) {
        currentFloor = (int) Objects.requireNonNull(currentFloorBox.getSelectedItem());
        destinationFloor = (int) Objects.requireNonNull(destinationFloorBox.getSelectedItem());

        if (currentFloor == 0 && destinationFloor == 0) {
            getAlert(NO_CHOICE);
        } else if (currentFloor == destinationFloor) {
            getAlert(THE_SAME_FLOOR);
        } else if (e.getSource() == startButton) {
            if (((currentFloor > elevatorsFloor) && (currentFloor > destinationFloor)) ||
                    (elevatorsFloor != 0 && (currentFloor < elevatorsFloor) && (currentFloor < destinationFloor))) {
                System.out.println("Current floor: " + currentFloor + ". Destination floor: " + destinationFloor + ".");
                getNonLinearElevatorMotion();
            } else {
                System.out.println("Current floor: " + currentFloor + ". Destination floor: " + destinationFloor + ".");
                getLinearElevatorMotion();
            }
        }
    }

    private void getAlert (String message) {
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, message, "Alert", JOptionPane.WARNING_MESSAGE);
    }

    /*The elevator has non-linear motion. It is supposed to go up/down from elevatorsFloor to the currentFloor
    and then back down/up to destinationFloor.*/

    private Elevator getNonLinearElevatorMotion (){
        Elevator elevator = new Elevator(elevatorsFloor, (new Floor(elevatorsFloor, currentFloor)));
        return elevator;
    }

    /*The elevator has linear motion. It is supposed to go up/down from elevatorsFloor to the currentFloor
    and then continue to destinationFloor.*/
    private Elevator getLinearElevatorMotion () {
        Elevator elevator = new Elevator(elevatorsFloor, new Floor(currentFloor, destinationFloor));
        return elevator;
    }
}






