package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX implements PIDOutput { //this class controls the PID for the navX as well as the AHRS class itself
	AHRS navX;
	PIDController turnController;
	double rotateToAngleRate; //this is the output
	double setPoint = 0;
	double last_world_linear_accel_x;
	double last_world_linear_accel_y;
    static double kCollisionThreshold_DeltaG = 0.8f; 
    static final double kTargetAngleDegrees = 90.0f;
	//static double kDefaultCollisionThreshol	d_DeltaG = 0.73f;  

	public NavX() {
		navX = new AHRS(SPI.Port.kMXP);
		navX.setPIDSourceType(PIDSourceType.kDisplacement);
		
		turnController = new PIDController(0.06, 0.008, 0.11, navX, this); //"kill it with the d" -Josh Tatum 2k17
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(2.0f);
		turnController.setContinuous(true);
		turnController.disable();
	}
		
	public void setSetpoint(double setpoint) {
		setPoint = setpoint;
		turnController.setSetpoint(setpoint);
	}
	
	public double getYaw() {
		return -navX.getYaw();
	}
	
	public boolean isCalibrated() {
		return navX.isCalibrating();
	}

	@Override
	public void pidWrite(double output) {		
		rotateToAngleRate = output;
	}
	
	public double getPidOutput() {
		return rotateToAngleRate; 
	}
	
	public double getRoll() {
		return navX.getRoll();
	}
	
	public double getAngle() {
		return navX.getAngle();
	}
	
	public boolean gyroActiveCheck() {
		return navX.isConnected();
	}
	
	public void turnAngle(double angle) {
	
		if (!turnController.isEnabled()) {
			turnController.setSetpoint(kTargetAngleDegrees);
			rotateToAngleRate = 0; // This value will be updated in the pidWrite() method.
			turnController.enable();
		}
		double leftStickValue = rotateToAngleRate;
		double rightStickValue = rotateToAngleRate;
		Robot.driveTrain.drive(leftStickValue,  rightStickValue);
		
	}
}
