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
	
	boolean relativeMode = false;

	//CAN talon controllers for each drivetrain motor
	CANTalon m1 = new CANTalon(RobotMap.frontLeft); //front left
	CANTalon m2 = new CANTalon(RobotMap.backLeft); //back left
	CANTalon m3 = new CANTalon(RobotMap.backRight); //back right
	CANTalon m4 = new CANTalon(RobotMap.frontRight); //front right
	
	double[] in = {0.0, 0.0, 0.0}; //joystick inputs. 0 = forward/backward, 1 = left/right 2 = rotation
	
	double angle;
	double magnitude;
	
	public void drive(){ //the main drive function
		
		in[0] = -Robot.oi.joyDriver1.getY();
		in[1] = Robot.oi.joyDriver1.getX();
		in[2] = Robot.oi.joyDriver1.getTwist();
		
		for(int i = 0; i < in.length; i++){ //dead zone for joysticks
			if(in[i] > -0.2 && in[i]< 0.2){
				in[i] = 0.0;
			}
		}
		
		if(relativeMode){
			double angle = Robot.gyro.angle() * (Math.PI / 180);
			in[0] = in[0] * Math.cos(angle) + in[1] * Math.sin(angle);
			in[1] = in[1] * Math.cos(angle) - in[0] * Math.sin(angle);
		}
		
		//calculate the speed of each wheel
		double wheels [] = {
			(in[0] + in[1] + in[2]) * 0.5,
			(in[0] - in[1] + in[2]) * 0.5,
			-((in[0] + in[1] - in[2]) * 0.5),
			-((in[0] - in[1] - in[2]) * 0.5),	
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
	
	public void toggleRelative(){
		relativeMode = !relativeMode;
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

