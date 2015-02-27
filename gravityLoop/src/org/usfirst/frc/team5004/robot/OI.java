package org.usfirst.frc.team5004.robot;

import org.usfirst.frc.team5004.robot.commands.ToggleRelativeMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * this class contains all of the joysticks and buttons on the robot
 */
public class OI {
    public Joystick joyDriver1 = new Joystick(0);
    public Joystick joySecondary1 = new Joystick(1);
    
    public JoystickButton forkOpen = new JoystickButton(joySecondary1, 3),
    						forkClose = new JoystickButton(joySecondary1, 4),
    						resetGyro = new JoystickButton(joyDriver1, 3),
    						toggleRelative = new JoystickButton(joyDriver1, 2);
    
    public OI(){
        toggleRelative.whenPressed(new ToggleRelativeMode());
    }
    
}