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
		double angle = gyro.getAngle();
		return angle - 360 * Math.floor(angle / 360);
	}
	
	public double halfAngle(){
		double angle = gyro.getAngle();
		angle -= 360 * Math.floor(angle / 360);
		
		if(angle > 180){
			angle -= 360;
		}
		
		return angle;
	}
	
	public void reset(){
		gyro.reset();
	}
	
	protected void initDefaultCommand() {
		
	}

}
