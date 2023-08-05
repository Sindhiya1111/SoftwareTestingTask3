package com.qaTesting.task3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class DataPathTest {
	Robot robot;
	
	@BeforeEach
	public void init() {
		robot = new Robot();
	}
	
	@DisplayName("DataFlowTesting command L function Path 1")
	@Test
	public void dataFlow_changeDirection_command_L_Path1() {
		// 1->2->4->6
		String currentDirection = "east";
		String expectedDirection = "north";
		
		Assertions.assertEquals(expectedDirection, robot.changeRobotFaceLeft(currentDirection));
		}
	
	@DisplayName("DataFlowTesting command L function Path 2")
	@Test
	public void dataFlow_changeDirection_command_L_Path2() {
		// 1->2->4
		String currentDirection = "west";
		String expectedDirection = "south";
		
		Assertions.assertEquals(expectedDirection, robot.changeRobotFaceLeft(currentDirection));
		}
	
	@DisplayName("DataFlowTesting command L function Path 3")
	@Test
	public void dataFlow_changeDirection_command_L_Path3() {
		// 1->2
		String currentDirection = "north";
		String expectedDirection = "west";
		
		Assertions.assertEquals(expectedDirection, robot.changeRobotFaceLeft(currentDirection));
		}
	
    @DisplayName("DataFlowTesting command M function Robot facing North Path 1")
    @Test
    public void dataFlow_move_facingNorth_command_M_Path1() {
    	//1->2->3
        int nMatrix = 10;
        robot.initialiseArray(nMatrix);

        int[] robotPosition = { 2, 2 };
        robot.robotPosition = robotPosition;

        String[] commandArray = { "m", "2" };
        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "north", "down", robot.robotMap);

        int[] expectedPosition = { 4, 2 };
        assertArrayEquals(expectedPosition, newPosition);
       
    }
    
    @DisplayName("DataFlowTesting command M function Robot facing South Path 2")
    @Test
    public void dataFlow_move_facingSouth_command_M_Path2() {
    	//1->2->6->7
        int nMatrix = 10;
        robot.initialiseArray(nMatrix);

        int[] robotPosition = { 2, 2 };
        robot.robotPosition = robotPosition;

        String[] commandArray = { "m", "2" };
        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "south", "up", robot.robotMap);

        int[] expectedPosition = { 0, 2 };
        assertArrayEquals(expectedPosition, newPosition);
      
    }
    
    
    @DisplayName("DataFlowTesting command M function Robot facing East Path 3")
    @Test
    public void dataFlow_move_facingEast_command_M_Path3() {
    	//1->2->6->10->11
        int nMatrix = 10;
        robot.initialiseArray(nMatrix);

        int[] robotPosition = { 2, 2 };
        robot.robotPosition = robotPosition;

        String[] commandArray = { "m", "2" };
        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "east", "down", robot.robotMap);

        int[] expectedPosition = { 2, 4 };
        assertArrayEquals(expectedPosition, newPosition);
      
    }
    
    @DisplayName("DataFlowTesting command M function Robot facing West Path 4")
    @Test
    public void dataFlow_move_facingWest_command_M_Path4() {
    	//1->2->->6->10->14->15
        int nMatrix = 10;
        robot.initialiseArray(nMatrix);

        int[] robotPosition = { 2, 2 };
        robot.robotPosition = robotPosition;

        String[] commandArray = { "m", "2" };
        int[] newPosition = robot.move(robot.robotPosition, commandArray, nMatrix, "west", "up", robot.robotMap);

        int[] expectedPosition = { 2, 0 };
        assertArrayEquals(expectedPosition, newPosition);
      
    }
}