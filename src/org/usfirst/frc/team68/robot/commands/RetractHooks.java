package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class RetractHooks extends Command 
{
	boolean isFinished = false;
	double speedA = RobotMap.HOOK_MOTOR_1_FORWARDS;
	double speedB = RobotMap.HOOK_MOTOR_2_FORWARDS;

	
    public RetractHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    protected void execute()
   {
    	/*if (Robot.endGame.getSwitchA() == false) {
    		speedA = 0;
    	}
    	
    	else {
    		speedA = RobotMap.HOOK_MOTOR_1_FORWARDS;
    	}
    	
    	if (Robot.endGame.getSwitchB() == false) {
    		speedB = 0;
    	}
    	
    	else {
    		speedB = RobotMap.HOOK_MOTOR_2_FORWARDS;
    	}*/
    	Robot.endGame.setHookSpeed(speedA, speedB);
    	
    	
    	//isFinished = true;
   }

   
    protected boolean isFinished() 
   {
        return isFinished;
   }

    
    protected void end() 
   {
     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP, RobotMap.HOOK_MOTOR_1_STOP);

    }

    
    protected void interrupted() 
    {

     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP, RobotMap.HOOK_MOTOR_1_STOP);
     	
    }
}
