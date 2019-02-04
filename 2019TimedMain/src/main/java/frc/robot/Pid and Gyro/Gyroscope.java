package org.usfirst.frc.team4229.robot.subsystems;
import org.usfirst.frc.team4229.robot.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Gyroscope extends Subsystem {
	
	public ADXRS453Gyro gyroSPI;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Gyroscope(){
		super();
		gyroSPI = new ADXRS453Gyro();
		gyroSPI.startThread();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void log() {
		SmartDashboard.putNumber("GyroAngle", gyroSPI.getAngle());
		SmartDashboard.putNumber("GyroPos", gyroSPI.getPos());
		SmartDashboard.putNumber("GyroRate", gyroSPI.getRate());
		SmartDashboard.putNumber("GyroTemp", gyroSPI.getTemp());
    }
}

