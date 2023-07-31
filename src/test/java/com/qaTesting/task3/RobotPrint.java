package com.qaTesting.task3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qualitytester.maven.quality_testing_example.Robot;

class RobotPrint {
	
	private Robot robot;

	
	@Test
	public void testPrintArray() {
		int nMatrix = 2;
		
	    String[][] map = {
	            {"*", "*"},
	            {null, null}
	            
	    };
		
		robot.setRobotMap(map);
		
		robot.printArray(nMatrix);
		
		  Assertions.assertEquals("*",robot.robotMap[0][0]);
		  Assertions.assertEquals("*",robot.robotMap[0][1]);
		  Assertions.assertEquals(null,robot.robotMap[1][0]);
		  Assertions.assertEquals(null,robot.robotMap[1][1]);
		
	}


	@Test
	public void testPrintArray_RobotMap_null() {
		int nMatrix = 0;
		
	    String[][] map = {
	          null
	    };
	    
	    Throwable exception = Assertions.assertThrows(NullPointerException.class,()->{
	    	robot.setRobotMap(map);
	    	
	    	robot.printArray(nMatrix);
		});
		 
	
	}

	
	@Test
	public void testPrintArray_RobotMap_negativeValue() {
		int nMatrix = 0;
		
	    String[][] map = {
	    		{"-1","-1"}
	    };
	    
	    Throwable exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->{
	    	robot.setRobotMap(map);
	    	
	    	robot.printArray(nMatrix);
		});
		 
	
	}



	
		


}
