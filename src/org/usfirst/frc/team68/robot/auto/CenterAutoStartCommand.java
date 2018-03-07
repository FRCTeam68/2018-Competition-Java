package org.usfirst.frc.team68.robot.auto;

import java.io.File;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveShiftLow;
import org.usfirst.frc.team68.robot.commands.DrivetrainDriveTrajectory;
import org.usfirst.frc.team68.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team68.robot.commands.IntakeDownPosition;
import org.usfirst.frc.team68.robot.commands.IntakeManualOut;
import org.usfirst.frc.team68.robot.commands.IntakeToggleClamp;
import org.usfirst.frc.team68.robot.commands.IntakeUpPosition;
import org.usfirst.frc.team68.robot.commands.LiftSetPosition;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CenterAutoStartCommand extends CommandGroup {
	String target;
	char firstChar;
	char secondChar;
	String strat;
	
    public CenterAutoStartCommand(String strategy) {
    	
    }	
    
    public void PutStrat(String strategy) {
    	this.strat = strategy;
    }
    
    public void selectAuto() {
    	// Get target
    	try {
    		target = DriverStation.getInstance().getGameSpecificMessage();
    		firstChar = target.charAt(0);
    		System.out.println(strat);
    		System.out.println("Strategy pickeda: " + strat);
    		
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }
    	
    	//Choose path
    	if(firstChar == 'L') {
        	System.out.println("Switch ---- Target: L");
        	File leftCSV = new File("/home/lvuser/paths/CenterLeft/CenterLeft_left_detailed.csv");
        	File rightCSV = new File("/home/lvuser/paths/CenterLeft/CenterLeft_right_detailed.csv");

        	System.out.println("Center in!");
	    	addSequential(new IntakeToggleClamp());
	    	addSequential(new IntakeDownPosition());
	    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
	    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
	    	addSequential(new WaitCommand(.25));
	    	addSequential(new IntakeAutoOut());
	    	addSequential(new IntakeUpPosition());
	    }
        	
        if(firstChar == 'R') {
        	System.out.println("Switch ---- Target: R");
        	File leftCSV = new File("/home/lvuser/paths/CenterRight/CenterRight_left_detailed.csv");
        	File rightCSV = new File("/home/lvuser/paths/CenterRight/CenterRight_right_detailed.csv");

	    	addSequential(new IntakeToggleClamp());
	    	addSequential(new IntakeDownPosition());
	    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
	    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
	    	addSequential(new WaitCommand(.25));
	    	addSequential(new IntakeAutoOut());
	    	addSequential(new IntakeUpPosition());
        }
    	
    	
    }
}
