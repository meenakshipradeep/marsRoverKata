package com.techreturners.mars.test;

import com.techreturners.mars.Plateau;
import com.techreturners.mars.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class MarsRoverTests {

    @Test
    public void initandValidateRoverMovementFirstRequirement() {
        //ARRANGE, ACT and ASSERT
        Assert.assertThat(new Rover(3, 3, "E").execute("MMRMMRMRRM"), is("5 1 E"));
    }

    @Test
    public void initandValidateRoverMovementSecondRequirement() {
        //ARRANGE
        // Rover rover = new Rover(1,2,"N");
        //ACT                           and ASSERT
        Assert.assertThat(new Rover(1, 2, "N").execute("LMLMLMLMM"), is("1 3 N"));
    }

    @Test
    public void validatePlateauWithMaxCoOrdsLimit() throws Exception {
        //Arrange
        Plateau plateau;
        String exception = null;
        //ACT
        try {
            plateau = new Plateau(6, 6);
        } catch (Exception e) {
            exception = e.getMessage();
        }
        //ASSERT
        assertEquals("Invalid Input to Upper CoOrds.", exception);
    }

    @Test
    public void validatePlateauWithInvalidCoOrdsLimit() throws Exception {
        //Arrange
        Plateau plateau;
        String exception = null;
        //ACT
        try {
            plateau = new Plateau(-1, 6);
        } catch (Exception e) {
            exception = e.getMessage();
        }
        //ASSERT
        assertEquals("Invalid Input to Upper CoOrds.", exception);
    }


    //test implement Rover behaviours

    @Test
    public void validateMovementRoverRightfromNorthDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "N");
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("R"), is("4 2 E"));
    }
    @Test
    public void validateMovementRoverLeftfromNorthFacingDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "N");
        //ACT
        //turn left from W should change the orientation to S
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("L"), is("4 2 W"));
    }
    @Test
    public void validateMovementRoverRightfromSouthDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "S");
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("R"), is("4 2 W"));
    }
    @Test
    public void validateMovementRoverLeftfromSouthFacingDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "S");
        //ACT
        //turn left from W should change the orientation to S
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("L"), is("4 2 E"));
    }


    @Test
    public void validateMovementRoverRightfromEastDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "E");
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("R"), is("4 2 S"));
    }
    @Test
    public void validateMovementRoverLeftfromEastFacingDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "E");
        //ACT
        //turn left from W should change the orientation to S
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("L"), is("4 2 N"));
    }
    @Test
    public void validateMovementRoverRightfromWestDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "W");
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("R"), is("4 2 N"));
    }
    @Test
    public void validateMovementRoverLeftfromWestFacingDirection() {
        //ARRANGE
        Rover rover = new Rover(4, 2, "W");
        //ACT
        //turn left from W should change the orientation to S
        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("L"), is("4 2 S"));
    }
    @Test
    public void validateMovementRoverMoveForward() {
        //ARRANGE
        Rover rover = new Rover(2, 3, "S");
        //ACT
        //turn right from S should change the orientation to W

        //ACT                           and ASSERT
        Assert.assertThat(rover.execute("M"), is("2 2 S"));
    }

}
