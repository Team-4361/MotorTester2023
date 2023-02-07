package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.math.filter.SlewRateLimiter;

public class PIDMotor extends CANSparkMax {

    private SparkMaxPIDController pid;
    private SlewRateLimiter rateLimiter = new SlewRateLimiter(4);

    public PIDMotor(int deviceId, MotorType type) {
        super(deviceId, type);
        pid = this.getPIDController();
    }

    @Override
    public void set(double speed) {
        super.set(rateLimiter.calculate(speed));
    }

    @Override
    public void stopMotor() {
        this.set(0);
    }

    public void setRPM(double speed) {
        
        pid.setReference(speed, CANSparkMax.ControlType.kVelocity, 0);
    }
}
