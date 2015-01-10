
package org.usfirst.frc.team3944.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private TPAJoystick joystick;
    private TPARobotDrive robotDrive;
    private DriveTrainTester driveTrainTester;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	joystick = new TPAJoystick(RobotMap.joystickOnePort);
        robotDrive = new TPARobotDrive(RobotMap.frontLeftPort, RobotMap.rearLeftPort, RobotMap.frontRightPort, RobotMap.rearRightPort, joystick);
        robotDrive.setInvertedMotor(TPARobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(TPARobotDrive.MotorType.kRearRight, true);
        
        driveTrainTester = new DriveTrainTester(joystick, robotDrive);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	robotDrive.mecanumDrive_Polar();
    }
    
    @Override
    public void testInit() {
        driveTrainTester.reset();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	driveTrainTester.run();
    }
    
}
