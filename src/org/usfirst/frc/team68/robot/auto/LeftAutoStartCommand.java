package org.usfirst.frc.team68.robot.auto;

import java.io.File;

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
import org.usfirst.frc.team68.robot.commands.ZeroEncoders;

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
	    		File leftCSV = new File("/home/lvuser/paths/LeftSwitch/LeftSwitch_left_detailed.csv");
	    		File rightCSV = new File("/home/lvuser/paths/LeftSwitch/LeftSwitch_right_detailed.csv");
	
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addSequential(new IntakeDownPosition());
		    	addSequential(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
		    	addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
		    	addSequential(new WaitCommand(.25));
		    	addSequential(new IntakeAutoOut());
		    	addSequential(new IntakeUpPosition());
	    	}
    	
	    	else if(firstChar == 'R') {
	    		System.out.println("Switch ---- Target: R");
	    		/*File leftCSV = new File("/home/lvuser/paths/CenterRight/CenterRight_left_detailed.csv");
	    		File rightCSV = new File("/home/lvuser/paths/CenterRight/CenterRight_right_detailed.csv");
	    		
	    		addParallel(new LiftSetPosition(RobotMap.LIFT_NORMAL_SWITCH));
	    		addSequential(new DrivetrainDriveTrajectory(leftCSV, rightCSV));
	    		addSequential(new IntakeDownPosition());
	    		addSequential(new IntakeAutoOut());*/
	    	}
    	}
    	
    	//SC Strat
    	if (strat == "SC") {
			if(secondChar == 'L') {
	    		System.out.println("Scale ---- Target: L");
	    		File leftCSVA = new File("/home/lvuser/paths/LeftScaleA/LeftScaleA_left_detailed.csv");
		    	File rightCSVA = new File("/home/lvuser/paths/LeftScaleA/LeftScaleA_left_detailed.csv");
		    	
		    	//ScaleB
		    	File leftCSVB = new File("/home/lvuser/paths/LeftScaleB/LeftScaleB_left_detailed.csv");
		    	File rightCSVB = new File("/home/lvuser/paths/LeftScaleB/LeftScaleB_right_detailed.csv");
		    	
	    		addSequential(new DriveShiftHigh());
		    	addSequential(new IntakeToggleClamp());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA));
		    	addSequential(new LiftSetPosition(RobotMap.LIFT_HIGH_SCALE));
		    	addSequential(new DriveShiftLow());
		    	addSequential(new ZeroEncoders());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVB, rightCSVB));
		    	addSequential(new IntakeDownPosition());
		    	addSequential(new WaitCommand(.25));
		    	addSequential(new IntakeAutoOut());	
		    	addSequential(new IntakeUpPosition());
		   }
    	
	    	else if(secondChar == 'R') {
	    		System.out.println("Scale ---- Target: R");
	    		/*File leftCSVA = new File("/home/lvuser/paths/LeftScaleA/LeftScaleA_left_detailed.csv");
		    	File rightCSVA = new File("/home/lvuser/paths/LeftScaleA/LeftScaleA_left_detailed.csv");
		    	
		    	//ScaleB
		    	File leftCSVB = new File("/home/lvuser/paths/LeftScaleB/LeftScaleB_left_detailed.csv");
		    	File rightCSVB = new File("/home/lvuser/paths/LeftScaleB/LeftScaleB_right_detailed.csv");
		    	
		    	addSequential(new IntakeToggleClamp());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVA, rightCSVA));
		    	addSequential(new LiftSetPosition(RobotMap.LIFT_HIGH_SCALE));
		    	addSequential(new DriveShiftLow());
		    	addSequential(new ZeroEncoders());
		    	addSequential(new DrivetrainDriveTrajectory(leftCSVB, rightCSVB));
		    	addSequential(new IntakeDownPosition());
		    	addSequential(new WaitCommand(.25));
		    	addSequential(new IntakeAutoOut());
		    	addSequential(new IntakeUpPosition());*/
	    	}
    	}
    	
    	else {
    		System.out.println("Switch ---- Auto-Run");
    		addSequential(new DriveStraight(null));
    	}
    	
    }
}
