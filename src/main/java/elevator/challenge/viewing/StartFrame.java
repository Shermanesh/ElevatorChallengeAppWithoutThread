package elevator.challenge.viewing;

import elevator.challenge.controller.StartFrameController;
import elevator.challenge.model.Floor;
import lombok.Getter;
import lombok.Setter;
import java.awt.*;
import java.util.List;
import javax.swing.*;

/****Java GUI for button imitation****/
@Getter
@Setter
public class StartFrame extends JFrame {

    private List<Integer> floorList = new Floor().getFloorList();
    private JLabel empty = new JLabel();
    private JLabel currentFloorLabel = new JLabel("CURRENT FLOOR");
    private JLabel destinationFloorLabel = new JLabel("DESTINATION FLOOR");
    private JButton startButton = new JButton("START");
    private JComboBox currentFloorBox = new JComboBox(floorList.toArray((new Integer[0])));
    private JComboBox destinationFloorBox = new JComboBox(floorList.toArray((new Integer[0])));

    public StartFrame () {
        startButton.addActionListener(
                new StartFrameController(this.startButton, this.currentFloorBox, this.destinationFloorBox));

        this.setLayout(new GridLayout(2, 3));
        this.add(empty);
        this.add(currentFloorLabel);
        this.add(destinationFloorLabel);
        this.add(startButton);
        this.add(currentFloorBox);
        this.add(destinationFloorBox);

        this.setTitle("START THE ELEVATOR");
        this.setSize(500, 150);
        this.setLocation(500, 300);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
