package org.usfirst.frc.team68.robot.auto;

import java.io.File;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveBrakeMode;
import org.usfirst.frc.team68.robot.commands.DriveShiftHigh;
import org.usfirst.frc.team68.robot.commands.DriveShiftLow;
import org.usfirst.frc.team68.robot.commands.DrivetrainDriveTrajectory;
import org.usfirst.frc.team68.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team68.robot.commands.IntakeDownPosition;
import org.usfirst.frc.team68.robot.commands.IntakeToggleClamp;
import org.usfirst.frc.team68.robot.commands.IntakeUpPosition;
import org.usfirst.frc.team68.robot.commands.LiftCommandGroupAutonCross;
import org.usfirst.frc.team68.robot.commands.LiftCommandGroupAutonStraight;
import org.usfirst.frc.team68.robot.commands.LiftSetPosition;
import org.usfirst.frc.team68.robot.commands.ZeroEncoders;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
/**
 *
 */
public class LeftAutoStartCommand extends CommandGroup {
	String target;
	char firstChar;
	char secondChar;
	String strat;
	
    public LeftAutoStartCommand(String strategy) {
    }	
    
    public void PutStrat(String strategy) {
    	this.strat = strategy;
    }
    	
    public void selectAuto() {
    	try {
    		target = DriverStation.getInstance().getGameSpecificMessage();
    		firstChar = target.charAt(0);
    		secondChar = target.charAt(1);
    		System.out.println("Strategy picked: " + strat);
    		
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }

    	//SW Strat
    	if (strat == "SW") {
			if(firstChar == 'L') {
	    		System.out.println("Switch ---- Target: L");
	    		File leftCSV = new File(RobotMap.LeftSwitchL);
	    		File rightCSV = new File(RobotMap.LeftSwitchR);
	
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addSequential(new IntakeDownPosition());
		    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
		    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));
		    	addSequential(new WaitCommand(.25));
		    	addSequential(new IntakeAutoOut());
		    	addSequential(new IntakeUpPosition());
	    	}
    	
	    	else if(firstChar == 'R') {
	    		System.out.println("Switch ---- Target: R");
	    		System.out.println("Driving Straight");
	    		File leftCSV = new File(RobotMap.DriveStraightL);
	    	    File rightCSV = new File(RobotMap.DriveStraightR);    
	    	    addSequential(new DriveShiftHigh());
	    	    addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));
	    		
	    	}
    	}
    	
    	if (strat == "SC/SC") {
    		if (secondChar == 'L') {
    			File leftCSVA = new File(RobotMap.LeftScaleLeft);
		    	File rightCSVA = new File(RobotMap.LeftScaleRight);
		    	
		    	addSequential(new DriveBrakeMode());
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addParallel(new LiftCommandGroupAutonStraight());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA, false));
    		}
    		
    		else if (secondChar == 'R') {
	    		File leftCSVA = new File(RobotMap.LeftSideCrossScaleLeft);
		    	File rightCSVA = new File(RobotMap.LeftSideCrossScaleRight);
	    		
		    	addSequential(new DriveBrakeMode());
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	
		    	addParallel(new LiftCommandGroupAutonCross());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA, false));
    		}
    	}
    	
    	//SC Strat
    	if (strat == "SC") {
			if(secondChar == 'L') {
	    		System.out.println("Scale ---- Target: L");
	    		File leftCSVA = new File(RobotMap.LeftScaleLeft);
		    	File rightCSVA = new File(RobotMap.LeftScaleRight);
		    	
		    	addSequential(new DriveBrakeMode());
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addParallel(new LiftCommandGroupAutonStraight());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA, false));
		   }
    	
	    	else if(secondChar == 'R') {
	    		System.out.println("Scale ---- Target: R");
	    		File leftCSV = new File(RobotMap.DriveStraightL);
	    	    File rightCSV = new File(RobotMap.DriveStraightR);    
	    	    addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));	  
	    	}
    	}
    	
    	//SC/SW Strat
    	
    	if (strat == "SC/SW") {
	    	if(secondChar == 'L') {
	    		System.out.println("Scale ---- Target: L");
	    		File leftCSVA = new File(RobotMap.LeftScaleLeft);
		    	File rightCSVA = new File(RobotMap.LeftScaleRight);
		    	
		    	addSequential(new DriveBrakeMode());
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addParallel(new LiftCommandGroupAutonStraight());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA, false));
	    	}
			
	    	else if(firstChar == 'L') {
	    		System.out.println("Switch ---- Target: L");
	    		File leftCSV = new File(RobotMap.LeftSwitchL);
	    		File rightCSV = new File(RobotMap.LeftSwitchR);
	
		    	addSequential(new DriveBrakeMode());
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addSequential(new IntakeDownPosition());
		    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
		    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));
		    	addSequential(new WaitCommand(.25));
		    	addSequential(new IntakeAutoOut());
		    	addSequential(new IntakeUpPosition());
	    	}
			
	    	else {
	    		File leftCSV = new File(RobotMap.DriveStraightL);
	    	    File rightCSV = new File(RobotMap.DriveStraightR);    
	    	    addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));	    	}
    		}
    }
}
