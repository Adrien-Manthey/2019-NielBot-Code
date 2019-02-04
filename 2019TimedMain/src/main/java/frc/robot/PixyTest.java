package frc.robot;

import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.Pixy2;
import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.links.I2CLink;
import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.links.Link;
import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.links.SPILink;
import frc.robot.Pixy2Java.src.main.java.io.github.pseudoresonance.pixy2api.links.UARTLink;

public final class PixyTest extends Robot {
    private PixyTest() {
    }
  

    public static void main() {
        I2CLink pixyLink = new I2CLink();
        Pixy2 pixy = Pixy2.createInstance(pixyLink);
        pixy.getVideo();
        
    }
  }
  

