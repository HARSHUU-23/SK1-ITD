package org.firstinspires.ftc.teamcode.OpMode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Sequence.DropHeightSequence;
import org.firstinspires.ftc.teamcode.Sequence.DropSequence;
import org.firstinspires.ftc.teamcode.Sequence.InitSequence;
import org.firstinspires.ftc.teamcode.Sequence.LeftSidePickSeq;
import org.firstinspires.ftc.teamcode.Sequence.PickSeq;
import org.firstinspires.ftc.teamcode.Sequence.PickSequence;
import org.firstinspires.ftc.teamcode.Sequence.RightSidePickSeq;
import org.firstinspires.ftc.teamcode.Sequence.SpecimenHangSeq;
import org.firstinspires.ftc.teamcode.Sequence.SpecimenPick;
import org.firstinspires.ftc.teamcode.Sequence.TransferSequence;
import org.firstinspires.ftc.teamcode.Subsystem.Hang;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Outtake;

@TeleOp(name="Basic Teleop", group="TeleOp")
public class BasicTeleop extends LinearOpMode {

    private RobotHardware robot;
    private Intake intake;
    private Outtake outtake;
    private Hang hanger;
    private MecanumDrive mecanumDrive;
    private boolean dpadLeftToggle = false;
    private boolean dpadRightToggle = false;
    private boolean aToggle = false;
    private boolean xToggle = false;


    @Override
    public void runOpMode() {

        robot = new RobotHardware();
        robot.init(hardwareMap, telemetry);
        intake = new Intake(robot);
        outtake = new Outtake(robot);
        hanger = new Hang(robot);
        mecanumDrive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        new InitSequence(intake, outtake, hanger);

        waitForStart();

        while (opModeIsActive()) {


            double drive = -gamepad1.left_stick_y*0.5;
            double strafe = -gamepad1.left_stick_x*0.5;
            double turn = -gamepad1.right_stick_x*0.3;

            PoseVelocity2d driveCommand = new PoseVelocity2d(new Vector2d(drive, strafe), turn);

            mecanumDrive.setDrivePowers(driveCommand);

            // Todo: Intake sequence
            if (gamepad1.a) {
                new PickSequence(intake, outtake, hanger);
            }


            // Todo: Elbow control
            if (gamepad1.a&& !aToggle) {
                robot.elbow.setPosition(robot.elbow.getPosition() + 0.05);
                aToggle = true;
            } else if (gamepad1.a) {
                aToggle = false;
            }

            if (gamepad1.x && !xToggle) {
                robot.elbow.setPosition(robot.elbow.getPosition() - 0.05);
                xToggle = true;
            } else if (gamepad1.x) {
                xToggle = false;
            }


            // Todo: Transfer sequence
            if (gamepad1.y) {
                new TransferSequence(intake, outtake, hanger);
            }

            // Todo: Drop Height adjustment
            if (gamepad1.left_bumper) {
                new DropHeightSequence(intake, outtake, hanger);
            }

            // Todo: Drop sequence
            if (gamepad1.right_bumper) {
                new DropSequence(intake, outtake, hanger);
            }


            // Todo: Specimen Pick
            if (gamepad1.left_trigger>0.3) {
                new SpecimenPick(intake, outtake, hanger);
            }

            // Todo: Specimen Release
            if (gamepad1.right_trigger>0.3) {
                new SpecimenHangSeq(intake, outtake, hanger);
            }
            // Todo: Pick
            if (gamepad1.start) {
                new PickSeq(intake, outtake, hanger);
            }

            // Todo: Init sequence
            if (gamepad1.back) {
                new InitSequence(intake, outtake, hanger);
            }

            // Todo: Lifter control
            if (gamepad1.dpad_up) {
                robot.lifter.setTargetPosition(robot.lifter.getCurrentPosition() + 50);
                robot.lifter.setPower(1.0);
            }

            if (gamepad1.dpad_down) {
                robot.lifter.setTargetPosition(robot.lifter.getCurrentPosition() - 50);
                robot.lifter.setPower(1.0);
            }
            // Todo: Yaw Arm control
            if (gamepad1.dpad_left && !dpadLeftToggle) {
                robot.yawArm.setPosition(robot.yawArm.getPosition() + 0.05);
                dpadLeftToggle = true;
            } else if (!gamepad1.dpad_left) {
                dpadLeftToggle = false;
            }

            if (gamepad1.dpad_right && !dpadRightToggle) {
                robot.yawArm.setPosition(robot.yawArm.getPosition() - 0.05);
                dpadRightToggle = true;
            } else if (!gamepad1.dpad_right) {
                dpadRightToggle = false;
            }

            // Todo: Telemetry for all states
            telemetry.addData("Intake Motor Power", robot.intakeMotor.getPower());
            telemetry.addData("Yaw Arm Position", robot.yawArm.getPosition());
            telemetry.addData("Arm Position", robot.arm.getPosition());
            telemetry.addData("Specimen Position", robot.specimen.getPosition());
            telemetry.addData("Elbow Position", robot.elbow.getPosition());
            telemetry.addData("Lifter Position", robot.lifter.getCurrentPosition());
            telemetry.addData("Bucket Position", robot.bucket.getPosition());
            telemetry.addData("Left Hang Position", robot.leftHang.getCurrentPosition());
            telemetry.addData("Right Hang Position", robot.rightHang.getCurrentPosition());
            telemetry.addData("Dekho Ye Current:",robot.lifter.getCurrent(CurrentUnit.AMPS));
            telemetry.update();
        }
    }
}
