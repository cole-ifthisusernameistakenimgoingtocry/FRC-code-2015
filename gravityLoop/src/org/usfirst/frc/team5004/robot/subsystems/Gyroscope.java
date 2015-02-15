package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;

public class Gyroscope extends Subsystem {

	Gyro gyro = new Gyro(RobotMap.gyroPort);
	
	public void init(){
		gyro.initGyro();
	}
	
	public double angle(){
		return gyro.getAngle();
	}
	
	public void reset(){
		gyro.reset();
	}
	
	protected void initDefaultCommand() {
		
	}

}
