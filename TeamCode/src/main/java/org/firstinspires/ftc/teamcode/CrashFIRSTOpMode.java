package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class CrashFIRSTOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeft = null;
        DcMotor frontRight = null;
        DcMotor backLeft = null;
        DcMotor backRight = null;

        telemetry.addData("Status","Initialized");
        telemetry.update();
        //Here we are linking the motor objects to the hardware map/robit config
            frontLeft   = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight  = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight   = hardwareMap.get(DcMotor.class, "backRight");

            //Here we are setting the motor directions for positive power
            frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
            frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
            backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("Status","Running");

            //Read gamepad input
            double drive = gamepad1.left_stick_y * -1;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            double[] speeds = {
                    (drive+strafe+turn), //Front left motor -> 0
                    (drive-strafe-turn), // Front right motor -> 1
                    (drive-strafe+turn), // Rear left motor -> 2
                    (drive+strafe-turn) // Rear right motor -> 3
            };

            double max = 0;
            for(int i = 0; i < speeds.length;i++) {
            if (speeds[i] > Math.abs(max)) {
                max = Math.abs(speeds[i]);
                }
            }

            //If and only if max is greater than one then normalize to the range of [-1,1]
            if(max > 1){
                for(int i = 0; i < speeds.length;i++) {
                    speeds[i] /= max; // speeds [i] = speeds[i] = speeds[i]/max;
                }
            }

            frontLeft.setPower(speeds[0]);
            frontRight.setPower(speeds[1]);
            backLeft.setPower(speeds[2]);
            backRight.setPower(speeds[3]);

            telemetry.update();
        }
    }
}