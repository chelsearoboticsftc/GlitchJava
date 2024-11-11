package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.util.Encoder;

public class ClimberConstants {
    final static public DcMotor.ZeroPowerBehavior CLIMB_ZERO_POWER_MODE = DcMotor.ZeroPowerBehavior.BRAKE;
    final static public DcMotor.Direction CLIMB_MOTOR_DIRECTION = DcMotor.Direction.FORWARD;
    final static public double CLIMBER_SPEED_TICKS_PER_S = 2240;
    final static public int CLIMBER_MAX_POSITION_TICKS = 7500;
    final static public int CLIMBER_MIN_POSITION_TICKS = 0;

    final static public double CLIMB_VELOCITY_F = 13.32;
    final static public double CLIMB_VELOCITY_P = 1.32;
    final static public double CLIMB_VELOCITY_I = .132;
    final static public double CLIMB_VELOCITY_D = 0;
    final static public double CLIMB_POSITION_P = 5;

}
