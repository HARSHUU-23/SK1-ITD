package org.firstinspires.ftc.teamcode.Sequence;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;

import org.firstinspires.ftc.teamcode.Subsystem.Hang;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Outtake;

import java.util.ArrayList;
import java.util.List;

public class SpecimenHangSeq {
    private List<Action> SpecimenHang = new ArrayList<>();
    public SpecimenHangSeq(Intake intake, Outtake outtake, Hang hanger) {
//        SpecimenHang.clear();
//        SpecimenHang.add(
        Actions.runBlocking(

                new SequentialAction(
                        outtake.LifterCommands(Outtake.LifterState.HIGH_CHAMBER_HEIGHT1),
                        new SleepAction(1.5),
                        new ParallelAction(
                        outtake.BucketCommands(Outtake.BucketState.MID_OUT_SPECIMEN),
                        outtake.LifterCommands(Outtake.LifterState.HIGH_CHAMBER_HEIGHT2)),

                        new SleepAction(0.5),

                        new ParallelAction(
                                outtake.BucketCommands(Outtake.BucketState.SPECIMEN_OUTAKE),
                                outtake.LifterCommands(Outtake.LifterState.HIGH_CHAMBER_HEIGHT1)
                        ),
                        outtake.SpecimenCommands(Outtake.SpecimenState.RELEASE),
                        outtake.BucketCommands(Outtake.BucketState.INIT),
                        outtake.SpecimenCommands(Outtake.SpecimenState.INIT),
                        intake.ArmCommands(Intake.ArmState.SAFE),
                        outtake.LifterCommands(Outtake.LifterState.INIT)

                )
        );
    }
}
