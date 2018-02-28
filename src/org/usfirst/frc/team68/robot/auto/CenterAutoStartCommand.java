package org.usfirst.frc.team68.robot.auto;

import java.io.File;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DrivetrainDriveTrajectory;
import org.usfirst.frc.team68.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team68.robot.commands.IntakeManualOut;
import org.usfirst.frc.team68.robot.commands.LiftSetPosition;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
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
		strat = strategy;
    }	
    
    	
    public void selectAuto() {
    	try {
    		target = DriverStation.getInstance().getGameSpecificMessage();
    		firstChar = target.charAt(0);
    		
    	} catch (Exception e) {
            System.out.println("NO TARGET!");
            target = "None";
        }
    	
    	if(firstChar == 'L') {
    		System.out.println("Switch ---- Target: L");
    		File leftCSV = new File("CenterLeft_left_detailed.csv");
    		File rightCSV = new File("CenterLeft_right_detailed.csv");

    		addParallel(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
    		addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
    		addSequential(new IntakeAutoOut());
    	}
    	
    	else if(firstChar == 'R') {
    		System.out.println("Switch ---- Target: R");
    		File leftCSV = new File("CenterRight_left_detailed.csv");
    		File rightCSV = new File("CenterRight_right_detailed.csv");
    		
    		addParallel(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
    		addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
    		addSequential(new IntakeAutoOut());
    	}
    	
    	else {
    		System.out.println("Switch ---- Auto-Run");
/*    		addSequential(new DriveXInchesCommand(140,0.5)); */
    	}
    	
    }
}
