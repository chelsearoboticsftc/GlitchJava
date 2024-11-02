package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Odometry;

@TeleOp
public class TestOdoPods extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status:","Initialized");
        telemetry.update();

        Odometry odometry = new Odometry(hardwareMap);

        odometry.init();

        waitForStart();

        while(opModeIsActive()){

            odometry.updatePositions();

            if(gamepad1.x){
                odometry.resetEncoderCounts();
            }

            telemetry.addData("Left Opopod Count", odometry.getLeftEncoderCounts());
            telemetry.addData("Right Opopod Count", odometry.getRightEncoderCounts());
            telemetry.addData("Center Opopod Count", odometry.getCenterEncoderCounts());
            telemetry.update();
        }



    }
}
