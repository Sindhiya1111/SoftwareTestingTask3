package com.qaTesting.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class TrackRobotTest {
	
	Robot robot;
	private int nMatrix = 4;
	
	@BeforeEach()
	public void init() {
		robot = new Robot();
		
	}
	
	
	
	 @Test
	    public void testTrackRobotWithPenUp() {
	  
			robot.initialiseArray(nMatrix);
	        robot.robotMap[1][1] = "*";
	        robot.robotMap[2][2] = "*";

	        int oldX = 1;
	        int oldY = 1;
	        int newX = 3;
	        int newY = 3;
	        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "up", robot.robotMap);

	        assertArrayEquals(robot.robotMap, updatedMap);
	    }
	 
	 @Test
	    public void testTrackRobotWithPenDown() {
	     
	        robot.initialiseArray(nMatrix);
	        robot.robotMap[1][1] = "*";
	        robot.robotMap[2][2] = "*";

	        // Call the method to be tested
	        int oldX = 1;
	        int oldY = 1;
	        int newX = 3;
	        int newY = 3;
	        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down",robot.robotMap);

	        assertTrue(updatedMap[1][1].equals("*") && updatedMap[2][2].equals("*") && updatedMap[3][3].equals("*"));
	    }
	 
	 @Test
	    public void testTrackRobotWithNoTurn() {
	     
	        robot.initialiseArray(nMatrix);
	        robot.robotMap[1][1] = "*";

	        int oldX = 3;
	        int oldY = 3;
	        int newX = 1;
	        int newY = 1;
	        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down", robot.robotMap);

	        assertTrue(updatedMap[3][3].equals("*") && updatedMap[2][2].equals("*") && updatedMap[1][1].equals("*"));
	    }

}
