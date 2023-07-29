package com.qaTesting.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class RobotInitialSetupTest {
	
	Robot robot;
	
	@BeforeEach
	public void init() {
		robot = new Robot();
	}
	
	
	@DisplayName("InitialArray to default settings")
	@Test 
	public void testInitializeArray() {
		
		int nMatrix = 10;
		robot.initialiseArray(nMatrix);
		
		Assertions.assertEquals("up",robot.penDirection);
		Assertions.assertEquals("north", robot.robotFace);
		Assertions.assertEquals(nMatrix, robot.robotMap.length);
	}
	
	@DisplayName("InitialMatrix to default settings")
	@Test
	public void testInitializeMatrix() {
		int nMatrix = 20;
		robot.InitializeMatrix("i " + nMatrix);
		
		Assertions.assertEquals(nMatrix, robot.robotMap.length);
		
	}
	
	@DisplayName("InitialMatrix when nmatrix is zero")
	@Test
	public void testInitializeMatrix_Zero() {
		int nMatrix = 0;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        
		robot.InitializeMatrix("i " + nMatrix);
		
        String expectedOutput = "The given command is not valid. Please enter a positive value!!!";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput.trim(), actualOutput);
	}
	


}
