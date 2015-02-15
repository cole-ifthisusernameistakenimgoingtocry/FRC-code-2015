package org.usfirst.frc.team5004.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //drivetrain motors:
	public static int frontLeft = 2;
	public static int frontRight = 1;
	public static int backLeft = 3;
	public static int backRight = 4;
	
	//lift motors:
	public static int leftPulley = 5;
	public static int rightPulley = 6;
	public static int fork = 7;
	
	//gyroscope:
	public static int gyroPort = 0;
}
