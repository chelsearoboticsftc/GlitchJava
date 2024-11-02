package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

@Autonomous
public class SmurfNeutSamplesRed extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        Pose2d startingPose = new Pose2d(-39.5,-62,Math.toRadians(90));
        Vector2d wayPoint1 = new Vector2d(-34,-24);
        Pose2d parkPosition = new Pose2d(-21,-11,0);

        TrajectoryVelocityConstraint velocityConstraint;

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence smurfNeutralSamples = drivetrain.trajectorySequenceBuilder(startingPose)
                .forward(2)
                .strafeLeft(18)
                .strafeRight(4)
                .splineToConstantHeading(wayPoint1,Math.toRadians(90))
                .forward(12)
                //Neutral sample 1
                .strafeLeft(14)
                .back(40)
                .forward(40)
                //Neutral sample 2
                .strafeLeft(10)
                .back(42)
                .forward(42)
                //Neutral sample 3
                .strafeLeft(4.5)
                .back(40)
                .forward(2)
                //Clean up!
                .strafeRight(25)
                .back(10)
                .strafeLeft(15)
                //Park!
                .splineToLinearHeading(parkPosition,0)
                .build();

        waitForStart();

        drivetrain.followTrajectorySequence(smurfNeutralSamples);

    }
}
