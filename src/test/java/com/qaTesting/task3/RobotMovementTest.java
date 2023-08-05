package com.qaTesting.task3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class RobotMovementTest {
	
	    private Robot robot;

	    @BeforeEach
	    public void init() {
	        robot = new Robot();
	    }
	    
	    
	    @DisplayName("Robot moving forward - facing north, pen down")
	    @Test
	    public void testMove_facingNorth_penDown_command_M() {
	
	        int nMatrix = 10;
	        robot.initialiseArray(nMatrix);

	        int[] robotPosition = { 2, 2 };
	        robot.robotPosition = robotPosition;

	        String[] commandArray = { "m", "2" };
	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "north", "down", robot.robotMap);

	        int[] expectedPosition = { 4, 2 };
	        assertArrayEquals(expectedPosition, newPosition);
	       
	    }
	    
	    @DisplayName("Robot moving forward - facing east, pen down")
	    @Test
	    public void testMove_facingEast_penDown_command_M() {
	
	        int nMatrix = 10;
	        robot.initialiseArray(nMatrix);

	        int[] robotPosition = { 2, 2 };
	        robot.robotPosition = robotPosition;

	        String[] commandArray = { "m", "2" };
	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "east", "down", robot.robotMap);

	        int[] expectedPosition = { 2, 4 };
	        assertArrayEquals(expectedPosition, newPosition);
	      
	    }
	    
	    @DisplayName("Robot moving forward - facing south, pen down")
	    @Test
	    public void testMove_facingSouth_penUp_command_M() {
	
	        int nMatrix = 10;
	        robot.initialiseArray(nMatrix);

	        int[] robotPosition = { 2, 2 };
	        robot.robotPosition = robotPosition;

	        String[] commandArray = { "m", "2" };
	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "south", "up", robot.robotMap);

	        int[] expectedPosition = { 0, 2 };
	        assertArrayEquals(expectedPosition, newPosition);
	      
	    }
	    
	    @DisplayName("Robot moving forward - facing west, pen down")
	    @Test
	    public void testMove_facingWest_penUp_command_M() {
	
	        int nMatrix = 10;
	        robot.initialiseArray(nMatrix);

	        int[] robotPosition = { 2, 2 };
	        robot.robotPosition = robotPosition;

	        String[] commandArray = { "m", "2" };
	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "west", "up", robot.robotMap);

	        int[] expectedPosition = { 2, 0 };
	        assertArrayEquals(expectedPosition, newPosition);
	      
	    }
	    
	    @DisplayName("Robot moving forward - no space")
	    @Test
	    public void testMove_penUp_outOfBoundary() {
	     
	    	String[] direction = {"west","east","south","north"};
	        int nMatrix = 1;
	        robot.initialiseArray(nMatrix);

	      
	        int[] robotPosition = { 1, 1 };
	        robot.robotPosition = robotPosition;
	        
	        for(int i=0;i<4;i++) {
	        String[] commandArray = { "m", "3" };
	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, direction[i], "up", robot.robotMap);
	        
	        int[] expectedPosition = { 1, 1 };
	        assertArrayEquals(expectedPosition, newPosition);
	        }
	      
	    }
	    
	    @DisplayName("Robot moving forward - no space")
	    @Test
	    public void testMove_penUp_outOfBoundary_conditionalMutation() {
	        // Initialize the robotMap with some values
	    	String[] direction = {"east","north"};
	        int nMatrix = 0;
	        robot.initialiseArray(nMatrix);

	        // Set the robot position at (2, 1)
	        int[] robotPosition = { 0, 0};
	        robot.robotPosition = robotPosition;
	        
	        Throwable exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->{
	            for(int i=0;i<4;i++) {
	    	        String[] commandArray = { "m", "0" };
	    	        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, direction[i], "up", robot.robotMap);
	    	    
	    	        }
	    	});
	        
	   
	   
	    }


}

