package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class WinchDown extends Command 
{
	boolean isFinished = false;

	
    public WinchDown() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_1_FORWARDS, RobotMap.WINCH_MOTOR_2_FORWARDS);
   
    	isFinished = true;
   }

   
    protected boolean isFinished() 
   {
        return isFinished;
   }

    
    protected void end() 
   {
    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_STOP, RobotMap.WINCH_MOTOR_STOP);

    }

    
    protected void interrupted() 
    {

    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_STOP, RobotMap.WINCH_MOTOR_STOP );
   	
    }
}
