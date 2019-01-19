package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class ExtendHooks extends Command 
{
	boolean isFinished = false;
	double speedA = RobotMap.HOOK_MOTOR_1_BACKWARDS*0.8;
	double speedB = RobotMap.HOOK_MOTOR_2_BACKWARDS*0.8;
	
    public ExtendHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {

    }

    
    protected void execute()
   {
    	SmartDashboard.putNumber("speedA Retract", speedA);
    	SmartDashboard.putNumber("speedB Retract", speedB);
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
