
package org.usfirst.frc.team5004.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5004.robot.commands.CameraFeed;
import org.usfirst.frc.team5004.robot.commands.Dashboard;
import org.usfirst.frc.team5004.robot.subsystems.Camera;
import org.usfirst.frc.team5004.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5004.robot.subsystems.Fork;
import org.usfirst.frc.team5004.robot.subsystems.Gyroscope;
import org.usfirst.frc.team5004.robot.subsystems.Lift;

/*   ______                                 __    __                      __                                     
    /      \                               /  |  /  |                    /  |                                    
   /$$$$$$  |  ______   ______   __     __ $$/  _$$ |_    __    __       $$ |        _|____    ______    ______  
   $$ | _$$/  /      \ /      \ /  \   /  |/  |/ $$   |  /  |  /  |      $$ |       /      \  /      \  /      \ 
   $$ |/    |/$$$$$$  |$$$$$$  |$$  \ /$$/ $$ |$$$$$$/   $$ |  $$ |      $$ |      /$$$$$$  |/$$$$$$  |/$$$$$$  |
   $$ |$$$$ |$$ |  $$/ /    $$ | $$  /$$/  $$ |  $$ | __ $$ |  $$ |      $$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |
   $$ \__$$ |$$ |     /$$$$$$$ |  $$ $$/   $$ |  $$ |/  |$$ \__$$ |      $$ |_____ $$ \__$$ |$$ \__$$ |$$ |__$$ |
   $$    $$/ $$ |     $$    $$ |   $$$/    $$ |  $$  $$/ $$    $$ |      $$       |$$    $$/ $$    $$/ $$    $$/ 
    $$$$$$/  $$/       $$$$$$$/     $/     $$/    $$$$/   $$$$$$$ |      $$$$$$$$/  $$$$$$/   $$$$$$/  $$$$$$$/  
													     /  \__$$ |                                    $$ |      
                                                         $$    $$/                                     $$ |      
                                                          $$$$$$/                                      $$/       
*/
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Camera camera = new Camera();
	public static final Gyroscope gyro = new Gyroscope();
	public static final Lift lift = new Lift();
	public static final Fork fork = new Fork();
	
	public static OI oi;

    Command autonomousCommand;
    Command cameraFeed;
    Command dashboard;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        cameraFeed = new CameraFeed();
        dashboard = new Dashboard();
        
        camera.init(); //initialize the camera
        gyro.init();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        cameraFeed.start();
        dashboard.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
