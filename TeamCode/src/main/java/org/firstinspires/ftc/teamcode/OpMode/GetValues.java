package org.firstinspires.ftc.teamcode.OpMode;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.Sequence.GetValuesInitSequence;
import org.firstinspires.ftc.teamcode.Subsystem.Hang;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Outtake;

@TeleOp(name = "GetValues", group = "TeleOp")
public class GetValues extends LinearOpMode {


    private RobotHardware robot;

    private Intake intake;
    private Outtake outtake;
    private Hang hanger;

    // todo: Toggle state variables
    private boolean aToggle = false;
    private boolean bToggle = false;
    private boolean xToggle = false;
    private boolean yToggle = false;
    private boolean dpadUpToggle = false;
    private boolean dpadDownToggle = false;
    private boolean dpadLeftToggle = false;
    private boolean dpadRightToggle = false;
    private boolean leftBumperToggle = false;
    private boolean rightBumperToggle = false;
    private boolean leftTriggerToggle = false;
    private boolean rightTriggerToggle = false;
    private boolean leftStickButtonToggle = false;
    private boolean rightStickButtonToggle = false;
    private boolean startToggle = false;
    private boolean backToggle = false;

    @Override
    public void runOpMode() {

        robot = new RobotHardware();
        robot.init(hardwareMap,telemetry);
        intake = new Intake(robot);
        outtake = new Outtake(robot);
        hanger = new Hang(robot);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        while(opModeInInit()){
            new GetValuesInitSequence(intake,outtake,hanger);
        }

        waitForStart();

        while (opModeIsActive()) {


            // Todo: Arm
            if (gamepad1.a && !aToggle) {
                robot.arm.setPosition(robot.arm.getPosition() + 0.01);
                aToggle = true;
            } else if (!gamepad1.a) {
                aToggle = false;
            }

            if (gamepad1.y && !yToggle) {
                robot.arm.setPosition(robot.arm.getPosition() - 0.01);
                yToggle = true;
            } else if (!gamepad1.y) {
                yToggle = false;
            }

            // Todo: Bucket control
            if (gamepad1.x && !xToggle) {
                robot.bucket.setPosition(robot.bucket.getPosition() + 0.01);
                xToggle = true;
            } else if (!gamepad1.x) {
                xToggle = false;
            }

            if (gamepad1.b && !bToggle) {
                robot.bucket.setPosition(robot.bucket.getPosition() - 0.01);
                bToggle = true;
            } else if (!gamepad1.b) {
                bToggle = false;
            }

            //Todo: Lifter control
            if (gamepad1.dpad_up && !dpadUpToggle) {
                robot.lifter.setTargetPosition(robot.lifter.getCurrentPosition() + 30);
                robot.lifter.setPower(1.0);
                dpadUpToggle = true;
            } else if (!gamepad1.dpad_up) {
                dpadUpToggle = false;
            }

            if (gamepad1.dpad_down && !dpadDownToggle) {
                robot.lifter.setTargetPosition(robot.lifter.getCurrentPosition() - 30);
                robot.lifter.setPower(1.0);
                dpadDownToggle = true;
            } else if (!gamepad1.dpad_down) {
                dpadDownToggle = false;
            }

            // Todo: Yaw Arm control
            if (gamepad1.dpad_left && !dpadLeftToggle) {
                robot.yawArm.setPosition(robot.yawArm.getPosition() + 0.01);
                dpadLeftToggle = true;
            } else if (!gamepad1.dpad_left) {
                dpadLeftToggle = false;
            }

            if (gamepad1.dpad_right && !dpadRightToggle) {
                robot.yawArm.setPosition(robot.yawArm.getPosition() - 0.01);
                dpadRightToggle = true;
            } else if (!gamepad1.dpad_right) {
                dpadRightToggle = false;
            }

            // Todo: Specimen control
            if (gamepad1.left_bumper && !leftBumperToggle) {
                robot.specimen.setPosition(robot.specimen.getPosition() + 0.01);
                leftBumperToggle = true;
            } else if (!gamepad1.left_bumper) {
                leftBumperToggle = false;
            }

            if (gamepad1.right_bumper && !rightBumperToggle) {
                robot.specimen.setPosition(robot.specimen.getPosition() - 0.01);
                rightBumperToggle = true;
            } else if (!gamepad1.right_bumper) {
                rightBumperToggle = false;
            }

            // Todo: Elbow control
            if (gamepad1.left_trigger > 0.5 && !leftTriggerToggle) {
                robot.elbow.setPosition(robot.elbow.getPosition() + 0.01);
                leftTriggerToggle = true;
            } else if (gamepad1.left_trigger <= 0.5) {
                leftTriggerToggle = false;
            }

            if (gamepad1.right_trigger > 0.5 && !rightTriggerToggle) {
                robot.elbow.setPosition(robot.elbow.getPosition() - 0.01);
                rightTriggerToggle = true;
            } else if (gamepad1.right_trigger <= 0.5) {
                rightTriggerToggle = false;
            }

            // Todo: Hang control
            if (gamepad1.left_stick_button && !leftStickButtonToggle) {
                robot.leftHang.setTargetPosition(robot.leftHang.getCurrentPosition() + 50);
                robot.rightHang.setTargetPosition(robot.rightHang.getCurrentPosition() + 50);
                robot.leftHang.setPower(1.0);
                robot.rightHang.setPower(1.0);
                leftStickButtonToggle = true;
            } else if (!gamepad1.left_stick_button) {
                leftStickButtonToggle = false;
            }

            if (gamepad1.right_stick_button && !rightStickButtonToggle) {
                robot.leftHang.setTargetPosition(robot.leftHang.getCurrentPosition() - 50);
                robot.rightHang.setTargetPosition(robot.rightHang.getCurrentPosition() - 50);
                robot.leftHang.setPower(1.0);
                robot.rightHang.setPower(1.0);
                rightStickButtonToggle = true;
            } else if (!gamepad1.right_stick_button) {
                rightStickButtonToggle = false;
            }

            // Todo: Intake motor control
            if (gamepad1.start && !startToggle) {
                robot.intakeMotor.setPower(Math.min(1.0, robot.intakeMotor.getPower() + 0.1));
                startToggle = true;
            } else if (!gamepad1.start) {
                startToggle = false;
            }

            if (gamepad1.back && !backToggle) {
                robot.intakeMotor.setPower(Math.max(-1.0, robot.intakeMotor.getPower() - 0.1));
                backToggle = true;
            } else if (!gamepad1.back) {
                backToggle = false;
            }

            if (gamepad1.start && !startToggle &&gamepad1.left_bumper) {
                robot.intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                robot.intakeMotor.setPower(Math.min(1.0, robot.intakeMotor.getPower() + 0.1));
                startToggle = true;
            } else if (!gamepad1.start) {
                startToggle = false;
            }

            if (gamepad1.back && !backToggle && gamepad1.left_bumper) {
                robot.intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                robot.intakeMotor.setPower(Math.max(-1.0, robot.intakeMotor.getPower() - 0.1));
                backToggle = true;
            } else if (!gamepad1.back) {
                backToggle = false;
            }

            // Todo: Telemetry
            telemetry.addData("Intake Motor Power", robot.intakeMotor.getPower());
            telemetry.addData("Yaw Arm Position", robot.yawArm.getPosition());
            telemetry.addData("Arm Position", robot.arm.getPosition());
            telemetry.addData("Specimen Position", robot.specimen.getPosition());
            telemetry.addData("Elbow Position", robot.elbow.getPosition());
            telemetry.addData("Lifter Position", robot.lifter.getCurrentPosition());
            telemetry.addData("Bucket Position", robot.bucket.getPosition());
            telemetry.addData("Left Hang Position", robot.leftHang.getCurrentPosition());
            telemetry.addData("Right Hang Position", robot.rightHang.getCurrentPosition());
            telemetry.update();
        }
    }
}
