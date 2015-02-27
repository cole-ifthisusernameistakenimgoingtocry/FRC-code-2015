package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard extends Command {

    public Dashboard() {

    }

    protected void initialize() {
    }

    protected void execute() {
    	SmartDashboard.putNumber("gyro angle", Robot.gyro.angle());
    	SmartDashboard.putData("reset gyro", new ResetGyro());
    	SmartDashboard.putData("toggle relative driving mode", new ToggleRelativeMode());
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
