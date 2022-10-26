package elevator.challenge.exception;

public class WrongFloorNrException extends Exception {
    public WrongFloorNrException(){
        super();
    }

    public WrongFloorNrException (int floor){
        super("Wrong floor: " + floor + ". The floor cannot be negative or higher than 55.");
    }

}
