package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Climber;
import org.firstinspires.ftc.teamcode.subsystems.ClimberConstants;

@TeleOp
public class TestClimber extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        int climberPosition = 0;
        double climberVelocity = 0;
        double climberMaxVelocity = 0;

        Climber climber=new Climber(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
            climberPosition = climber.getClimberPosition();

            if((gamepad1.a)) //&&
               //(climberPosition < ClimberConstants.CLIMBER_MAX_POSITION_TICKS))
            {
                climber.setClimberPower(0.8);
            }else if((gamepad1.b)) //&&
                     //(climberPosition > ClimberConstants.CLIMBER_MIN_POSITION_TICKS))
            {
                climber.setClimberPower(-0.8);
            }else{
                climber.setClimberPower(0);
            }

            climberVelocity=climber.getClimberVelocity();
            if(Math.abs(climberVelocity)>climberMaxVelocity){
                climberMaxVelocity = Math.abs(climberVelocity);
            }

            telemetry.addData("climberPosition",climberPosition);
            telemetry.addData("climberMaxVelocity",climberMaxVelocity);
            telemetry.update();

        }
    }
}
