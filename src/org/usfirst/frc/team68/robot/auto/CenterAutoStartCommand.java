package org.usfirst.frc.team68.robot.auto;

import java.io.File;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveBrakeMode;
import org.usfirst.frc.team68.robot.commands.DriveCoastMode;
import org.usfirst.frc.team68.robot.commands.DriveShiftHigh;
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
    		System.out.println("Strategy picked: " + strat);
    		
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }
    	
    	//Choose path
    	if(firstChar == 'L') {
        	System.out.println("Switch ---- Target: L");
        	File leftCSV = new File(RobotMap.CenterLeftL);
        	File rightCSV = new File(RobotMap.CenterLeftR);

        	System.out.println("Center in!");
        	addSequential(new DriveShiftHigh());
	    	addSequential(new IntakeToggleClamp());
	    	addSequential(new IntakeDownPosition());
	    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
	    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
	    	addSequential(new IntakeAutoOut());
	    	addSequential(new IntakeUpPosition());
	    }
        	
        if(firstChar == 'R') {
        	System.out.println("Switch ---- Target: R");
        	File leftCSV = new File(RobotMap.CenterRightL);
        	File rightCSV = new File(RobotMap.CenterRightR);

        	addSequential(new DriveBrakeMode());
        	addSequential(new DriveShiftHigh());
	    	addSequential(new IntakeToggleClamp());
	    	addSequential(new IntakeDownPosition());
	    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
	    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));

	    	addSequential(new IntakeAutoOut());
	    	addSequential(new WaitCommand(0.5));
	    	addSequential(new IntakeUpPosition());

        }
    	
    	
    }
}
