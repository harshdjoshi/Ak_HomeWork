package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 500260501 on 13/11/2017.
 */
@TeleOp(name="Gamepad Drive", group="Teleop")
//@Disabled
public class ServoClawTeleop extends OpMode
{


    DcMotor leftWheel;
    DcMotor rightWheel;
    DcMotor liftMotor;

    Servo leftClaw;
    Servo rightClaw;

    double leftWheelPower;
    double rightWheelPower;

    @Override
    public void init()
    {
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");
        liftMotor = hardwareMap.dcMotor.get("lift_motor");

        leftClaw = hardwareMap.servo.get("left_claw");
        rightClaw = hardwareMap.servo.get("right_claw");

        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop()
    {

        leftWheelPower = gamepad1.left_stick_y;
        rightWheelPower = gamepad1.right_stick_y;

        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);

        //Controlling the claw with the bumpers
        if(gamepad1.left_bumper)
        {
            leftClaw.setPosition(0.3);
            rightClaw.setPosition(0.7);
        }
        if(gamepad1.right_bumper)
        {
            leftClaw.setPosition(0.7);
            rightClaw.setPosition(0.3);
        }

        //Controlling the lift mechanism using y and a buttons
        if(gamepad1.y)
        {
               liftMotor.setPower(1.0);
        }
        else if(gamepad1.a)
        {
                liftMotor.setPower(-1.0);
        }
        else
        {
            liftMotor.setPower(0);
        }
    }
}
