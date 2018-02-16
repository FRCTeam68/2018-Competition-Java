package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	private WPI_TalonSRX liftMotor;
	
	private static Lift lift;
	
	public static Lift getLift() {
		if (lift == null) {
			lift = new Lift();
	}
	return lift;
}
	
	private Lift()
	{
		liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTORS);
	
	}

	@Override
	public void initDefaultCommand() {
		// TODO Auto-generated method stub
		//Needs to be fixed somehow. Not sure what happened
	}
	public void setLiftSpeed(double speed) {
		liftMotor.set(speed);
	}
	
}
