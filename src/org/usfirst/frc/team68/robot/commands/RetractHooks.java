package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class RetractHooks extends Command 
{
	boolean isFinished = false;

	
    public RetractHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_BACKWARDS);

    	isFinished = true;
   }

   
    protected boolean isFinished() 
   {
        return isFinished;
   }

    
    protected void end() 
   {

    }

    
    protected void interrupted() 
    {

     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP);
     	
    }
}
