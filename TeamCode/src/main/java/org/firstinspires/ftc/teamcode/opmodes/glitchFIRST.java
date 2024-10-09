package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class glitchFIRST extends LinearOpMode {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    @Override
    public void runOpMode() throws InterruptedException {
        Telemetry.Item item = telemetry.addData("status", "initialized");
        telemetry.update();
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();


        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.addData("message", "glitch");
            //read gamepad inptut
            double drive = gamepad1.left_stick_y *-1;
            double strafe = gamepad1.left_stick_x*-1;
            double turn = gamepad1.right_stick_x*-.5;

            telemetry.addData("drive", drive);
            telemetry.addData("strafe", strafe);
            telemetry.addData("turn", turn);
            double[]  speeds = {
                    (drive + strafe + turn),
                    (drive - strafe - turn),
                    (drive - strafe + turn),
                    (drive + strafe - turn)

            };

            double max = 0;
            for (int i = 0; i < speeds.length; i++) {
                if (speeds[i] > Math.abs(max)) {
                    max = Math.abs(speeds[i]);
                }
            }

            //if and only max is greater than 1 then normalize to the range
            if(max > 1){
            for (int i = 0; i < speeds.length; i++) {
                speeds[i] /= max;
                }
            }
            frontLeft.setPower(speeds[1]);
            frontRight.setPower(speeds[0]);
            backRight.setPower(speeds[2]);
            backLeft.setPower(speeds[3]);

            telemetry.update();

        }

    }
}
