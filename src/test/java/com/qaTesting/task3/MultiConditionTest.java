package com.qaTesting.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class MultiConditionTest {
	
	Robot robot;
	
	
	@BeforeEach()
	public void init() {
		robot = new Robot();
		
	}

//	if (oldX > newX || oldY > newY) 
	
	@Test
	void testMulipleCondition_FT() {
		
		robot.initialiseArray(4);
        robot.robotMap[1][1] = "*";
        robot.robotMap[2][2] = "*";
        
		int oldX = 1;
        int oldY = 4;
        int newX = 3;
        int newY = 3;
        
        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down", robot.robotMap);

        
        assertTrue(updatedMap[2][2].equals("*"));
        assertTrue(updatedMap[1][1].equals("*"));
        
        
	}
	
	 @Test
	    public void testTrackRobotWithNoTurn() {
	     
	        robot.initialiseArray(4);
	        robot.robotMap[1][1] = "*";

	        int oldX = 3;
	        int oldY = 3;
	        int newX = -1;
	        int newY = 1;
	        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down", robot.robotMap);

	        
	        assertTrue(updatedMap[2][2].equals("*"));
	        
	    }
	 
	 @Test
	    public void testTrackRobotWithNoTurn1() {
	     
	        robot.initialiseArray(4);
	        robot.robotMap[1][1] = "*";

	        int oldX = 3;
	        int oldY = 3;
	        int newX = -1;
	        int newY = -1;
	        String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down", robot.robotMap);

	        
	        assertTrue(updatedMap[2][2].equals("*"));
	        
	        
	    }
	 
	 @Test
	    public void testTrackRobotWithNoTurn2() {
	     
	        robot.initialiseArray(2);
	        robot.robotMap[1][1] = "*";

	        int oldX = 3;
	        int oldY = 3;
	        int newX = -1;
	        int newY = -1;
	        
	       
	        Throwable exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->{
	            String[][] updatedMap = robot.trackRobot(oldX, oldY, newX, newY, "down", robot.robotMap);
	            assertTrue(updatedMap[2][2].equals("*"));
	    	});
	        
	        
	        
	    }
	


}
