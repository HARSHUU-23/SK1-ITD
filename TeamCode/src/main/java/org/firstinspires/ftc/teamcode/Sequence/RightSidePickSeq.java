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

public class RightSidePickSeq {

    public RightSidePickSeq(Intake intake, Outtake outtake, Hang hanger) {

        Actions.runBlocking(
                new SequentialAction(
                    intake.YawCommands(Intake.YawState.RIGHT),
                    intake.ArmCommands(Intake.ArmState.DOWN),
                    intake.ElbowCommands(Intake.ElbowState.INIT),
                    outtake.LifterCommands(Outtake.LifterState.TRANSFER),
                    outtake.BucketCommands(Outtake.BucketState.IN))
        );
    }
}
