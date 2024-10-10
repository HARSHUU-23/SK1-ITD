package org.firstinspires.ftc.teamcode.Hardware;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Globals {

    public static boolean IS_IMU = true;
    public static boolean IS_CUSTOMDRIVE = true;
    public static double OpModeLoopTime = 0;


    // Todo arm pose
    public static double armInit = 0.3;
    public static double armUp = 0.13;
    public static double armDown = 0.78;
    public static double armSafe = 0.34;
    public static double armSafeUp = 0.6;
    public static double armLock = 0.86;
    public static double armHalf = 0.5;


    //Todo Yaw Pose
    public static double yawInit = 0.44;
    public static double yawHalf = 0.5;
    public static double yawDrop = 0.44;
    public static double yawLeft = 0.92;
    public static double yawRight = 0.0;
    public static double yawFullLeft = 1;
    public static double yawFullRight = 0;
    public static double yawMidLeft = 0.7;
    public static double yawMidRight = 0.22;


    //Todo Elbow Pose
    public static double elbowInit = 0.5;
    public static double elbowHalf = 0.5;
    public static double elbowExtendLevel1 = 0.2;
    public static double elbowExtendLevel2 = 0.4;
    public static double elbowExtendLevel3 = 0.6;
    public static double elbowExtendLevel4 = 0.8;
    public static double elbowFullExtend = 1.0;
    public static double elbowSafe = 0.5;

    //Todo Bucket Pose
    public static double bucketHalf = 0.5;
    public static double bucketInit = 0.47;
    public static double bucketIn = 0.35;
    public static double bucketOut = 0.8;
    public static double bucketMid = 0.55;
    public static double bucketSafe = 0.47;
    public static double bucketMidSpecimen= 0.28;
    public static double bucketSpecimenIntake= 0.75;
    public static double bucketSpecimenOutake = 0.16;

    //Todo Specimen Pose
    public static double specimenHalf = 0.5;
    public static double specimenGrip = 0.63;
    public static double specimenRelease = 0.2;
    public static double specimenSafe = 0.5;
    public static double specimenInit = 0.5;


    //Todo Lifter pose
    public static int lifterInit = 200;
    public static int lifterTransfer = 580;
    public static int lifterIntakeHeight = 520;
    public static int lifterSpecimenHeight = 300;
    public static int lifterSpecimenOutHeight = 550;
    public static int lifterLowerRungHeight = 700;
    public static int lifterLowChamberHeight1 = 1000;
    public static int lifterLowChamberHeight2 = 1200;
    public static int lifterLowChamberHeight3 = 1400;
    public static int lifterLowBucketHeight1 = 2500;
    public static int lifterLowBucketHeight2 = 3000;
    public static int lifterLowBucketHeight3 = 3500;
    public static int lifterHighChamberHeight1 = 2500;
    public static int lifterHighChamberHeight2 = 2300;
    public static int lifterHighChamberHeight3 = 1880;
    public static int lifterHighBucketHeight1 = 1600;
    public static int lifterHighBucketHeight2 = 6200;
    public static int lifterHighBucketHeight3 = 6300;
    public static int lifterIncrementValue = 25;
    public static int lifterDown = -25;


    //Todo Intake Motor Power Pose
    public static double intakePower = 0.8 ;
    public static double outtakePower = -0.1;
    public static double intakeInitPower = 0.0;

    //Todo Hang Pose
    public static int hangerInit = 0;
    public static int hangerLowerRung = 500;
    public static int hangerHangDone = 1500;
    public static int hangerHigherRung = 2000;

    public static int incVal = 27;

}