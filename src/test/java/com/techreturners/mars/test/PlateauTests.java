package com.techreturners.mars.test;

import com.techreturners.mars.Plateau;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PlateauTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void validatePlateauWithMaxCoOrdsLimit() throws Exception {
        //Arrange
        Plateau plateau;
        String exception = null;
        //ACT
        plateau = new Plateau(6, 6);

        //Assert
        exceptionRule.expectMessage("Invalid coordinates.");
    }

    @Test
    public void plateauExceptionTestForInvalidCoordinates() throws Exception {
        //Assign
        exceptionRule.expect(Exception.class);

        //Act
        Plateau plateau = new Plateau(3, -3);

        //Assert
        exceptionRule.expectMessage("Invalid coordinates.");
    }

    @Test
    public void validatePlateauWithInvalidCoOrdsLimit() throws Exception {
        //Arrange
        Plateau plateau;

        //ACT
        plateau = new Plateau(-1, 6);

        //ASSERT
        exceptionRule.expectMessage("Invalid Input to Upper CoOrds.");
    }




}
