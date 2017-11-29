package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Akanksha.Joshi on 2017-11-12.
 */
@TeleOp(name="Gamepad Drive", group="Training")
public class ServoClawTeleop extends OpMode
{

    DcMotor leftWheel;
    DcMotor rightWheel;

    Servo leftClaw;
    Servo rightClaw;


    double leftWheelPower;
    double rightWheelPower;

    @Override
    public void init() {
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");

        leftClaw = hardwareMap.servo.get("left_claw");
        rightClaw = hardwareMap.servo.get("right_claw");

        rightWheel.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        leftWheelPower = gamepad1.left_stick_y;
        rightWheelPower = gamepad1.right_stick_y;

        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);

        if (gamepad1.x)
        {
            leftClaw.setPosition(1);
            rightClaw.setPosition(1);
        }
        else
        {
            leftClaw.setPosition(0);
            rightClaw.setPosition(0);
        }
    }
}
