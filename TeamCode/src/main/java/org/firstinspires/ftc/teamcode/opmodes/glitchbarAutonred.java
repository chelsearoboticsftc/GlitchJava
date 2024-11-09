package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class glitchbarAutonred extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        Pose2d startingPose = new Pose2d(-39.5,-62,Math.toRadians(90));
        Vector2d wayPoint1 = new Vector2d(-34,-24);
        Pose2d parkPosition = new Pose2d(-21,-11,0);

        TrajectoryVelocityConstraint velocityConstraint;

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence glitchbarAutonred = drivetrain.trajectorySequenceBuilder(startingPose)
                        .forward(5)
                        .strafeRight(40)
                        .forward(5)
                .build();
        waitForStart();

        drivetrain.followTrajectorySequence(glitchbarAutonred);

    }
}