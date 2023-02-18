package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import frc.robot.util.math.GearRatio;
import frc.robot.util.pid.SparkMaxAngledPIDSubsystem;
import frc.robot.util.pid.SparkMaxPIDSubsystem;

import static com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed;
import static frc.robot.Constants.FourBarWristValues.*;

public class ClimberWristSubsystem extends SparkMaxAngledPIDSubsystem {

    public ClimberWristSubsystem() {
        super(
                "FourBarWrist",
                new GearRatio(WRIST_GEAR_RATIO),
                new CANSparkMax(WRIST_MOTOR_ID, kBrushed),
                kBrushed,
                0.01,
                0,
                0
        );
        setTolerance(1);
    }
}
