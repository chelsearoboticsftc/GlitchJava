package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    DcMotorEx slideMotor;
    DcMotorEx armMotor;
    DcMotorEx intakeMotor;
    DigitalChannel frontTouch;
    DigitalChannel backTouch;
    DigitalChannel linearSlideTouch;

    public Arm(HardwareMap hardwareMap){
        this.slideMotor = hardwareMap.get(DcMotorEx.class,"Slide_motor");
        this.armMotor = hardwareMap.get(DcMotorEx.class,"Arm_rotater_motor");
        this.intakeMotor = hardwareMap.get(DcMotorEx.class,"intakeMotor");
        this.frontTouch = hardwareMap.get(DigitalChannel.class, "frontTouch");
        this.backTouch = hardwareMap.get(DigitalChannel.class, "backTouch");
        this.linearSlideTouch = hardwareMap.get(DigitalChannel.class, "linearSlideTouch");

        //set what motor does when unpowered
        armMotor.setZeroPowerBehavior(ArmConstants.ARM_ZERO_POWER_MODE);
        slideMotor.setZeroPowerBehavior(ArmConstants.SLIDE_ZERO_POWER_MODE);
        intakeMotor.setZeroPowerBehavior(ArmConstants.INTAKE_ZERO_POWER_MODE);

        //set motor directions
        armMotor.setDirection(ArmConstants.ARM_DIRECTION);
        slideMotor.setDirection(ArmConstants.SLIDE_DIRECTION);
        intakeMotor.setDirection(ArmConstants.INTAKE_DIRECTION);

        //reset encoder values to zero
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }

    public int getArmPosition(){
        return armMotor.getCurrentPosition();
    }

    public double getArmVelocity(){
        return armMotor.getVelocity();
    }

    public int getSlidePosition(){
        return armMotor.getCurrentPosition();
    }

    public double getSlideVelocity(){
        return armMotor.getVelocity();
    }

    public int getIntakePosition(){
        return armMotor.getCurrentPosition();
    }

    public double getIntakeVelocioty(){
        return armMotor.getVelocity();
    }

    public void setArmMotorPower(double power){
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setPower(power);
    }

    public void setSlideMotorPower(double power){
        slideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slideMotor.setPower(power);
    }

    public void setIntakeMotorPower(double power){
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setPower(power);
    }

    public void setArmMotorPositon(int positon){
        armMotor.setTargetPosition(positon);
        armMotor.setVelocity(ArmConstants.ARM_SPEED_TICKS_PER_SECOND);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setSlideMotorPositon(int positon) {
        slideMotor.setTargetPosition(positon);
        slideMotor.setVelocity(ArmConstants.SLIDE_SPEED_TICKS_PER_SECOND);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public boolean isFrontTouched(){
        return frontTouch.getState();
    }

    public boolean isBackTouched(){
        return backTouch.getState();
    }

    public boolean isSlideTouched(){
        return linearSlideTouch.getState();
    }


}
