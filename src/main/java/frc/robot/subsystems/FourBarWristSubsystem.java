package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.EncoderType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FourBarWristSubsystem extends SubsystemBase {
    private CANSparkMax wristMotor;
    private RelativeEncoder wristEncoder;

    public FourBarWristSubsystem() {
        wristMotor = new CANSparkMax(8, CANSparkMaxLowLevel.MotorType.kBrushed);
        wristEncoder = wristMotor.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 8192);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("FourBar: Wrist Encoder", wristEncoder.getPosition());
        SmartDashboard.putNumber("FourBar: Wrist RPM", wristEncoder.getVelocity());
    }

    public void setPower(double power) {
        wristMotor.set(power);
    }

    public void resetEncoder() {
        wristEncoder.setPosition(0);
    }
}
