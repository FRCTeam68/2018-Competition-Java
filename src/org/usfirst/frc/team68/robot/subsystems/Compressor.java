package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Compressor extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Compressor compressor;

    
    public static Compressor getCompressor() {
    	if (compressor == null) {
    		compressor = new Compressor();
    	}
    	return compressor;
    }
    
    // Constructor
    private Compressor() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}
