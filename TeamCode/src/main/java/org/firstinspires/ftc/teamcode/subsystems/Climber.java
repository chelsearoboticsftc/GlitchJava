package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climber {
   DcMotorEx climbMotor;

    public Climber(HardwareMap hardwareMap){
        this.climbMotor=hardwareMap.get(DcMotorEx.class,"Hook_motor");

        climbMotor.setZeroPowerBehavior(ClimberConstants.CLIMB_ZERO_POWER_MODE);

        climbMotor.setDirection(ClimberConstants.CLIMB_MOTOR_DIRECTION);

        climbMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public int getClimberPosition(){
        return climbMotor.getCurrentPosition();
    }

    public double getClimberVelocity(){
        return climbMotor.getVelocity();
    }

    public void setClimberPower(double power){
        climbMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        climbMotor.setPower(power);
    }

    public void setClimberPosition(int position){
        climbMotor.setTargetPosition(position);
        climbMotor.setVelocity(ClimberConstants.CLIMBER_SPEED_TICKS_PER_S);
        climbMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
