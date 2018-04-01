package org.usfirst.frc.team68.robot.auto;
	
import java.io.File;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveShiftHigh;
import org.usfirst.frc.team68.robot.commands.DriveShiftLow;
import org.usfirst.frc.team68.robot.commands.DrivetrainDriveTrajectory;
import org.usfirst.frc.team68.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team68.robot.commands.IntakeDownPosition;
import org.usfirst.frc.team68.robot.commands.IntakeManualOut;
import org.usfirst.frc.team68.robot.commands.IntakeToggleClamp;
import org.usfirst.frc.team68.robot.commands.IntakeUpPosition;
import org.usfirst.frc.team68.robot.commands.LiftSetPosition;
import org.usfirst.frc.team68.robot.commands.TurnToAngle;
import org.usfirst.frc.team68.robot.commands.ZeroEncoders;

import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends CommandGroup {
	String target;
	char firstChar;
	char secondChar;
	String strat;
	
    public DriveStraight(String strategy) {
    }	
    
    public void PutStrat(String strategy) {
    	this.strat = strategy;
    }
    	
    public void selectAuto() {
    	try {
    		target = DriverStation.getInstance().getGameSpecificMessage();
    		firstChar = target.charAt(0);
    		System.out.println("Auto Pick" + strat);
    		
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }
    	
    	File leftCSV = new File("/home/lvuser/paths/DriveStraight/DriveStraight_left_detailed.csv");
	    File rightCSV = new File("/home/lvuser/paths/DriveStraight/DriveStraight_right_detailed.csv");    
	    addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV, false));
	        	
    	
    	
    }
}
