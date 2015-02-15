package org.usfirst.frc.team5004.robot.subsystems;

import java.util.Arrays;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.commands.MecanumDrive;
import org.usfirst.frc.team5004.robot.RobotMap;


/* This is the subsystem for the mecanum drivetrain.
 * 
 */

public class DriveTrain extends Subsystem {

	//CAN talon controllers for each drivetrain motor
	CANTalon m1 = new CANTalon(RobotMap.frontLeft); //front left
	CANTalon m2 = new CANTalon(RobotMap.backLeft); //back left
	CANTalon m3 = new CANTalon(RobotMap.backRight); //back right
	CANTalon m4 = new CANTalon(RobotMap.frontRight); //front right
	
	//distance between the front right wheel and the center of the robot (needed for equations)
	//(X distance + Y distance)
	int K = (1 + 1);
	
	double Vx = 0.0; //desired X (forward/backward) velocity
	double Vy = 0.0; //desired Y (left/right) velocity
	double Vr = 0.0; //desired rotational velocity
	
	public void drive(){ //the main drive function
		Vy = Robot.oi.joyDriver1.getX();
		Vx = -Robot.oi.joyDriver1.getY();
		Vr = Robot.oi.joyDriver1.getTwist();
		
		//calculate the speed of each wheel
		double wheels [] = {
			(Vx + Vy + Vr),
			(Vx - Vy + Vr),
			-(Vx + Vy - Vr),
			-(Vx - Vy - Vr),	
		};
		
		//make sure motor values are never greater than 100% so we don't break the motors
		for(int i = 0; i < wheels.length; i++){
			wheels[i] = Math.min(Math.max(wheels[i], -1.0), 1.0);
		}
		
		//set each motor to the desired speed
		m1.set(wheels[0]);
		m2.set(wheels[1]);
		m3.set(wheels[2]);
		m4.set(wheels[3]);
	}
	
	public void simpleDrive(){ //a different drive mode that only uses two motors
		Vy = Robot.oi.joyDriver1.getX();
		Vx = -Robot.oi.joyDriver1.getY();
		
		//calculate the speed of each wheel
		double wheels [] = {
			(Vx - Vy),
			-(Vx + Vy)	
		};
		
		//make sure motor values are never greater than 100% so we don't break the motors
		for(int i = 0; i < wheels.length; i++){
			wheels[i] = Math.min(Math.max(wheels[i], -1.0), 1.0);
		}
		
		//set each motor to the desired speed
		m1.set(wheels[0]);
		m4.set(wheels[1]);
	}
	
	//stop all motors in case shit gets real
	public void killMotors(){
		m1.set(0.0);
		m2.set(0.0);
		m3.set(0.0);
		m4.set(0.0);
	}
	
	//always run the standard drive command when nothing else is happening
    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
}

