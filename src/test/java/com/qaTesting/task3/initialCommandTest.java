package com.qaTesting.task3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

import com.qualitytester.maven.quality_testing_example.Robot;
import org.junit.jupiter.api.DisplayName;

class initialCommandTest {

    private Robot robot;

    private final ByteArrayOutputStream outputStreamOutput = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private InputStream standardIn;

    @BeforeEach
    public void init() {
        robot = new Robot();
        System.setOut(new PrintStream(outputStreamOutput));
        standardIn = System.in;
    }

    @AfterEach
    public void resetAll() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }
    
    @DisplayName("Valid Input Command: CommandSequence - i 5, D, R, m 1, U, L, p, q")
    @Test
    public void testInputCommand_initialize_penUp_turnLeft_quit() {
    	
        String userInput = "i 5\nD\nR\nm 1\nU\nL\np\nq\n";
        
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

       
        robot.inputCommand();
        
        Assertions.assertEquals("up",robot.penDirection);
        Assertions.assertEquals("north", robot.robotFace);
 
    }
    
    @DisplayName("Valid Input Command: CommandSequence - i 5, D, m 1 ,R, p, q")
    @Test
    public void testInputCommand_initialize_penDown_turnRight_quit() {
    	
        String userInput = "i 5\nD\nm 1\nR\np\nq\n";
        
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

       
        robot.inputCommand();
        
        Assertions.assertEquals("down",robot.penDirection);
        Assertions.assertEquals("east", robot.robotFace);
        
 
    }
     
    
    @DisplayName("Valid Input Command: CommandSequence - i 5")
    @Test
    public void testInputCommand_initialize_command_I() {
    	
        String userInput = "i 3\nq\n";
        
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

       
        robot.inputCommand();
        
        Assertions.assertEquals("up",robot.penDirection);
        Assertions.assertEquals("north", robot.robotFace);
        
 
    }
    
    
    @DisplayName("Invalid Input Command: CommandSequence - i ")
    @Test
    public void testInputCommand_invalidCommandFormat_command_I() {
      
        String userInput = "i\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Throwable exception = Assertions.assertThrows(StringIndexOutOfBoundsException.class,()->{
        	robot.inputCommand();
    	});
    
    }  
    
    
    @DisplayName("Invalid Input Command: CommandSequence - i 10, m ")
    @Test
    public void testInputCommand_invalidCommandFormat_command_M() {
      
        String userInput = "i 10\nm\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Throwable exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->{
        	robot.inputCommand();
    	});
    
    } 
    
    
    @DisplayName("Invalid Input Command: CommandSequence - i 10, h ")
    @Test
    public void testInputCommand_invalidCommand_H() {
      
        String userInput = "i 10\nh\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Throwable exception = Assertions.assertThrows(NoSuchElementException.class,()->{
        	robot.inputCommand();
    	});
    
    } 
    
    @DisplayName("Invalid Input Command: CommandSequence - i 0.1")
    @Test
    public void testInputCommand_invalidCommand_I() {
      
        String userInput = "i 0.1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Throwable exception = Assertions.assertThrows(NoSuchElementException.class,()->{
        	robot.inputCommand();
    	});
    
    } 
    
//    @DisplayName("Valid Input Command: CommandSequence - i 5, C, q")
//    @Test
//    public void testInputCommand_initialize_printCurrentPosition_quit() {
//    	Robot robot = new Robot();
//        String userInput = "i 0\nC\nq\n";
//        
//        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
//       
//        robot.inputCommand();
//
//        assertArrayEquals(new int[]{0, 0}, robot.robotPosition);
//    }

}
