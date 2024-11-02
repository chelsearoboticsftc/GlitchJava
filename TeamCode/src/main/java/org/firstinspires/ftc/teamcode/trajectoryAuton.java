package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class trajectoryAuton extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Trajectory goForward = drivetrain.trajectoryBuilder(new Pose2d(0,0,0))
                .forward(100)
                .build();
        drivetrain.followTrajectory(goForward);

        Trajectory lineToPosition = drivetrain.trajectoryBuilder(new Pose2d(10,0,0))
                .lineTo(new Vector2d(0,0))
                .build();
        drivetrain.followTrajectory(lineToPosition);

        Trajectory strafeLeft = drivetrain.trajectoryBuilder(new Pose2d(0,0,0))
                .lineTo(new Vector2d(0,0))
                .build();


    }
}

