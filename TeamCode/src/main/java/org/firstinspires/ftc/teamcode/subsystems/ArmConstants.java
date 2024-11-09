package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ArmConstants {
    final static public DcMotor.ZeroPowerBehavior ARM_ZERO_POWER_MODE= DcMotor.ZeroPowerBehavior.BRAKE;
    final static public DcMotor.ZeroPowerBehavior SLIDE_ZERO_POWER_MODE= DcMotor.ZeroPowerBehavior.BRAKE;
    final static public DcMotor.ZeroPowerBehavior INTAKE_ZERO_POWER_MODE= DcMotor.ZeroPowerBehavior.BRAKE;
    final static public DcMotorSimple.Direction ARM_DIRECTION = DcMotorSimple.Direction.FORWARD;
    final static public DcMotorSimple.Direction SLIDE_DIRECTION = DcMotorSimple.Direction.FORWARD;
    final static public DcMotorSimple.Direction INTAKE_DIRECTION = DcMotorSimple.Direction.FORWARD;

    final static public double ARM_SPEED_TICKS_PER_SECOND = 2240;//80% NOMINAL
    final static public double SLIDE_SPEED_TICKS_PER_SECOND = 2240;//80% NOMINAL
    final static public double INTAKE_SPEED_TICKS_PER_SECOND = 480;//80% NOMINAL

    final static public int ARM_MAX_POSITION_TICKS=100;
    final static public int ARM_MINIMUM_POSITION_TICKS=0;
    final static public int SLIDE_MAX_POSITION_TICKS=100;
    final static public int SLIDE_MINIMUM_POSITION_TICKS=0;
}
