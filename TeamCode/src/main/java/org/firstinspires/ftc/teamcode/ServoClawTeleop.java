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
    //double liftMotorPower;


    boolean isYPressed;
    boolean isAPressed;

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

        leftWheelPower = -gamepad1.left_stick_y;
        rightWheelPower = -gamepad1.right_stick_y;

        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);

        //Controlling the claw with the bumpers
        if(gamepad1.left_trigger > 0.01)
        {
            leftClaw.setPosition(0.4);
            rightClaw.setPosition(0.6);
        }
        if(gamepad1.right_trigger > 0.01)
        {
            leftClaw.setPosition(0.6);
            rightClaw.setPosition(0.4);
        }

        //Controlling the claw with the x and b buttons
        if(gamepad1.x)
        {
            leftClaw.setPosition(0.4);
            rightClaw.setPosition(0.6);
        }
        if(gamepad1.b)
        {
            leftClaw.setPosition(0.6);
            rightClaw.setPosition(0.4);
        }

        //Controlling the lift mechanism using y and a buttons
        if(gamepad1.y)
        {
               //isYPressed = true;
               liftMotor.setPower(1.0);
        }
        else if(gamepad1.a)
        {
            //isAPressed = true;
            liftMotor.setPower(-1.0);
        }
        else
        {
            liftMotor.setPower(0);
        }

    }
}
