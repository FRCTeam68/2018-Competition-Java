package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveWithXboxJoysticks;
import org.usfirst.frc.team68.robot.commands.LiftManual;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
	
	private WPI_TalonSRX liftMotor;
    private DigitalInput limitSwitchUp;
    private DigitalInput limitSwitchDown;
    private Counter counterUp;
    private Counter counterDown;
	
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
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
		
		liftMotor.setSensorPhase(true); 
		liftMotor.configNominalOutputForward(0, 0);
		liftMotor.configNominalOutputReverse(0, 0);
		liftMotor.configPeakOutputForward(1,0); 
		liftMotor.configPeakOutputReverse(-1,0); 
//		liftMotor.configNeutralDeadband(0.001, 0);
		liftMotor.selectProfileSlot(RobotMap.LIFT_PID_SLOT, 0);
		liftMotor.config_kF(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_F, 0);
		liftMotor.config_kP(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_P, 0);
		liftMotor.config_kI(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_I, 0);
		liftMotor.config_kD(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_D, 0);
		
		limitSwitchUp = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH_UP);
		limitSwitchDown = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH_DOWN);

	}

	@Override
	public void initDefaultCommand() {
		// TODO Auto-generated method stub
		//Needs to be fixed somehow. Not sure what happened
		setDefaultCommand(new LiftManual());
	}
	public void setLiftSpeed(double speed) {
		SmartDashboard.putNumber("LiftSpeed", speed);
/*    	if(this.getSwitchUp() || this.getSwitchDown()) {
    		speed = 0;
    	}
*/
		liftMotor.set(speed/2);
	}
	public void setControlModePercentOutput() {
		liftMotor.set(ControlMode.PercentOutput, 0);
	}
	
	public void setPosition(double position) {
		liftMotor.set(ControlMode.Position, position);
	}
	
	public double getPosition() {
		double position = 0;
		position = liftMotor.getSelectedSensorPosition(0);
		return position;
	}
	
	public void zeroEncoder() {
		liftMotor.setSelectedSensorPosition(0, 0, 10);
	}
	
    public boolean getSwitchUp() {
        return limitSwitchUp.get();
    }
    
    public boolean getSwitchDown() {
        return limitSwitchDown.get();
    }
	
}
