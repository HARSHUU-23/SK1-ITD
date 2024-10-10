package org.firstinspires.ftc.teamcode.Sequence;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;

import org.firstinspires.ftc.teamcode.Subsystem.Hang;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Outtake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InitSequence {
//    private LinkedList<Action> Init = new LinkedList<>();
    public InitSequence(Intake intake, Outtake outtake, Hang hanger) {
//        Init.clear();
//        Init.add(
        Actions.runBlocking(
                new SequentialAction(
                        new ParallelAction(
                                hanger.hangCommands(Hang.HangState.INIT),
                                outtake.LifterCommands(Outtake.LifterState.INIT),
                                intake.IntakeMotorCommands(Intake.IntakeMotorState.OFF)),

                        intake.YawCommands(Intake.YawState.INIT),
                        intake.ArmCommands(Intake.ArmState.INIT),
                        intake.ElbowCommands(Intake.ElbowState.INIT),
                        outtake.BucketCommands(Outtake.BucketState.INIT),
                        outtake.SpecimenCommands(Outtake.SpecimenState.INIT)
                )
        );
    }
}
