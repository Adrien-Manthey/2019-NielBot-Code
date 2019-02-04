/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.opencv.core.Mat;
import frc.robot.PixyTest;
import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

      //Joystick Declerations (comment out for RemoteDrive)
      Joystick J1 = new Joystick(0);
      Joystick J2 = new Joystick(1);
      //Remote Decleration (comment out for JoyDrive)
      XboxController R_C_1 = new XboxController(0);
      // Drive Train Motor Controllers Declerations (same for both Controller types, do not change)
      Spark F_L_D = new Spark(0);
      Spark F_R_D = new Spark(3);
      Spark B_L_D = new Spark(2);
      Spark B_R_D = new Spark(1);
  
      //Mechanum Drive Train Decleration (Same for both Controller Types , please do not change)
      MecanumDrive Robo_Drive = new MecanumDrive(F_L_D,B_L_D,F_R_D,B_R_D);
  
      //Setting up Pnumatics , please do not alter or change unless your commenting out stuff your not useing
          //Setting up Compressor
      Compressor Comp = new Compressor(0);
  
          //Setting up Solenoids , solenoids are named based on there port #
      Solenoid S0 = new Solenoid(0); // Currently being used for the hatch intake
      //Solenoid S1 = new Solenoid(1); //Currently Unused
      //Solenoid S2 = new Solenoid(2); //Currently Unused
      //Solenoid S3 = new Solenoid(3); //Currently Unused


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    // Camera stuff, do not adjust unless you know what your doing
    //CameraServer.getInstance().addAxisCamera("10.42.29.90"); //axis camera
		CameraServer.getInstance().startAutomaticCapture(); //USB camera
		Mat image = new Mat();
		CameraServer.getInstance().getVideo().grabFrame(image);



    

    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // MechanumDrive for Remote drive (comment out for Joydrive)
    Robo_Drive.driveCartesian(R_C.getX(GenericHID.Hand.kLeft), -1*R_C.getY(GenericHID.Hand.kLeft), R_C.getX(GenericHID.Hand.kRight));
    // MechanumDrive for JoyDrive(comment out for MechanumDrive)(needs to be tested again, needs some adjustments)
    Robo_Drive.driveCartesian(Left_Joy.getX(), -1*Left_Joy.getY(), Left_Joy.getZ());

    //Pnumatics for Hatch Pannel intake system useing Remote drive (Comment out for JoyDrive)
    c.setClosedLoopControl(true);

		if(R_C.getRawButton(1)) {
			S0.set(true);
			Timer.delay(0.001);

    }
    else if(R_C.getRawButton(2)){
      S0.set(false);
      Timer.delay(0.001);
    }

		else {

    }
    //Pnumatics for Hatch Pannel intake system useing JoyDrive (Comment out for Remote Drive)
    /**
    c.setClosedLoopControl(true);

    if(J1.getRawButton(1)) {
      S0.set(true);
      Timer.delay(0.001);
    }

    else if(J2.getRawButton(1)) {
      SO.set(false);
      Timer.delay(0.001);
    }

    else{
      
    }
     */

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
