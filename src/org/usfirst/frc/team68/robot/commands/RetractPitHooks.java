package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class RetractPitHooks extends Command 
{
	boolean isFinished = false;

	
    public RetractPitHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_PITSPEED_BACKWARDS, RobotMap.HOOK_MOTOR_1_PITSPEED_BACKWARDS);
   
    	isFinished = true;
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
