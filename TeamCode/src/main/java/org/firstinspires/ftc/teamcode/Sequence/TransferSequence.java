package org.firstinspires.ftc.teamcode.Sequence;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;

import org.firstinspires.ftc.teamcode.Subsystem.Hang;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Outtake;

import java.util.ArrayList;
import java.util.List;

public class TransferSequence {
    private List<Action> Transfer = new ArrayList<>();
    public TransferSequence(Intake intake, Outtake outtake, Hang hanger) {
//        Transfer.clear();
//        Transfer.add(
        Actions.runBlocking(

                new SequentialAction(
                        intake.ElbowCommands(Intake.ElbowState.INIT),
                        intake.IntakeMotorCommands(Intake.IntakeMotorState.OFF),
                        outtake.LifterCommands(Outtake.LifterState.INTAKE_HEIGHT),
                        outtake.BucketCommands(Outtake.BucketState.IN),
                        new ParallelAction(
                                intake.YawCommands(Intake.YawState.DROP),
                                intake.ArmCommands(Intake.ArmState.UP)
                                )

                )
        );
    }
}
