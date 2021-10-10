package com.techreturners.mars;

public class Rover {
    //has a MarRoverPos on the plateau and receive a String of commands
    //behaviours for Mars Rover turn Left , turn Right, Move
    private int roverId;
    private MarRoverPos MarRoverPos;
    private String commands;
    private int roverCount;
    com.techreturners.mars.MarRoverPos.Orientation Direction;

    public Rover() {
    }

    //has a MarRoverPos on the plateau
    public Rover(int x, int y, String orient) {
        this.MarRoverPos = new MarRoverPos(x, y, orient);
        this.roverId = ++roverCount;
        Direction = Direction.valueOf(orient);
    }

    public String execute(String command) {
        for (char c : command.toCharArray()) {
            if (c == 'L') {
                Direction = Direction.left();
            } else if (c == 'R') {
                // turnRight();
                Direction = Direction.right();
            } else if (c == 'M') {
                moveRover();
            }
        }
        // return current Rover Position
        return MarRoverPos.getCoOrdX() + " " + MarRoverPos.getCoOrdY() + " " + Direction.value();
    }

    private void moveRover() {
        if (this.Direction.value() == "N") {
            this.MarRoverPos.setCoOrdY(MarRoverPos.getCoOrdY() + 1);
        } else if (this.Direction.value() == "E") {
            this.MarRoverPos.setCoOrdX(MarRoverPos.getCoOrdX() + 1);
        } else if (this.Direction.value() == "S") {
            this.MarRoverPos.setCoOrdY(MarRoverPos.getCoOrdY() - 1);
        } else if (this.Direction.value() == "W") {
            this.MarRoverPos.setCoOrdX(MarRoverPos.getCoOrdX() - 1);
        }
    }

}
