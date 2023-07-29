package com.qaTesting.task3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class RobotFacingDirectionTest {
	
	Robot robot;
	
	@BeforeEach
	public void init() {
		robot = new Robot();
	}
	
	@DisplayName("Test Command L for all 4 direction")
	@Test
	public void testRobotFacingDirection_Command_L() {
		String[][] direction = {{"north","west"},{"east","north"},{"south","east"},{"west","south"}};
		
		for(int i=0; i < 4;i++) {
			Assertions.assertEquals(direction[i][1], robot.changeRobotFaceLeft(direction[i][0]));
		}
	}
	
	
	@DisplayName("Test Command R for all 4 direction")
	@Test
	public void testRobotFacingDirection_Command_R() {
		String[][] direction = {{"north","east"},{"east","south"},{"south","west"},{"west","north"}};
		
		for(int i=0; i < 4;i++) {
			Assertions.assertEquals(direction[i][1], robot.changeRobotFaceRight(direction[i][0]));
		}
	}

}
