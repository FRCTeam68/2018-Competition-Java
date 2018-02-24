package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutoStartCommand extends CommandGroup {
	String target;
	char firstChar;
	char secondChar;
	
    public LeftAutoStartCommand() {
    }	
    
    	
    public void selectAuto() {
    	try {
    		target = DriverStation.getInstance().getGameSpecificMessage();
    		firstChar = target.charAt(0);
    		secondChar = target.charAt(1);
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }
    }
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    
}
