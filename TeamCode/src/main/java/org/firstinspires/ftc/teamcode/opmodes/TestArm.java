package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ArmConstants;

public class TestArm extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        int armPosition = 0;
        int slidePosition = 0;
        double armVelocity = 0;
        double slideVelocity = 0;
        double armMaxVelocity = 0;
        double slideMaxVelocity = 0;

        Arm arm = new Arm(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            armPosition = arm.getArmPosition();
            slidePosition = arm.getSlidePosition();

            if((gamepad1.x) &&
               (armPosition < ArmConstants.ARM_MAX_POSITION_TICKS))
            {
                arm.setArmMotorPower(.8);
            }else if((gamepad1.a) &&
                     (armPosition> ArmConstants.ARM_MINIMUM_POSITION_TICKS))
            {
                arm.setArmMotorPower(-.8);
            }else {
                arm.setArmMotorPower(0);
            }

            if((gamepad1.b) &&
               (slidePosition > ArmConstants.SLIDE_MINIMUM_POSITION_TICKS))
            {
                arm.setSlideMotorPower(-.8);
            }else if((gamepad1.y) &&
                     (slidePosition< ArmConstants.ARM_MINIMUM_POSITION_TICKS)){
                arm.setSlideMotorPower(.8);
            }else{
                arm.setSlideMotorPower(0);
            }

            armVelocity = arm.getArmVelocity();
            if (armVelocity > armMaxVelocity){
                armMaxVelocity = armVelocity;
            }

            slideVelocity = arm.getSlideVelocity();
            if (slideVelocity > slideMaxVelocity){
                slideMaxVelocity = slideVelocity;
            }

            telemetry.addData("armposition",armPosition);
            telemetry.addData("armMaxVelocity",armMaxVelocity);
            telemetry.addData("slidePosition",slidePosition);
            telemetry.addData("slideMaxVelocity",slideMaxVelocity);

        }
    }
}
