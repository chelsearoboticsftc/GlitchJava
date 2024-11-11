package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class LowBasketRed extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        int slidePosition = 0;
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);
        Arm arm = new Arm(hardwareMap);

        Pose2d startingPose = new Pose2d(-39.5,-62,Math.toRadians(180));
        Pose2d wayPoint1 = new Pose2d(-40,-12,Math.toRadians(110));
        Pose2d parkPosition = new Pose2d(-21,-11,0);

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence lowBasketRed = drivetrain.trajectorySequenceBuilder(startingPose)
                .forward(8)
                .waitSeconds(2)
                .addTemporalMarker(()->arm.setIntakePower(1))
                .waitSeconds(1)
                .back(6)
                .addTemporalMarker(()->arm.setIntakePower(0))
                .build();

        TrajectorySequence getNeutralSample = drivetrain.trajectorySequenceBuilder(lowBasketRed.end())
                .strafeRight(10)
                .turn(Math.toRadians(-70))
                .splineToLinearHeading(wayPoint1,Math.toRadians(90))
                .build();

        waitForStart();

        while(opModeIsActive()){
            arm.setIntakePower(-0.25);
            arm.setSlideMotorPositon(8500);
            arm.setArmMotorPositon(0);
            arm.isSlideMotorBusy();
            arm.isArmMotorBusy();
            if((!arm.isSlideMotorBusy())&&
               (!arm.isArmMotorBusy())){
                break;
            }
        }
        drivetrain.followTrajectorySequence(lowBasketRed);

        while(opModeIsActive()){
            arm.setSlideMotorPositon(2000);
            arm.isSlideMotorBusy();
            if(!arm.isSlideMotorBusy()){
                break;
            }
        }

        drivetrain.followTrajectorySequence(getNeutralSample);

    }
}
