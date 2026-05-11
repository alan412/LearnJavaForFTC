package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;


@TeleOp
public class Exercise_21_1 extends OpMode {
    private AprilTagProcessor aprilTagProcessor;
    private VisionPortal visionPortal;
    SparkFunOTOS sparkfunOTOS;

    @Override
    public void init() {
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        sparkfunOTOS = hardwareMap.get(SparkFunOTOS.class, "otos");
        configureOTOS();
        aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName, aprilTagProcessor);
    }

    private void configureOTOS() {
        sparkfunOTOS.setLinearUnit(DistanceUnit.INCH);
        sparkfunOTOS.setAngularUnit(AngleUnit.DEGREES);
        sparkfunOTOS.setOffset(new SparkFunOTOS.Pose2D(0, 0, 0));
        sparkfunOTOS.setLinearScalar(1.0);
        sparkfunOTOS.setAngularScalar(1.0);
        sparkfunOTOS.resetTracking();
        sparkfunOTOS.setPosition(new SparkFunOTOS.Pose2D(0,0,0));
        sparkfunOTOS.calibrateImu(255, false);
    }

    @Override
    public void loop() {
        List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections();
        StringBuilder idsFound = new StringBuilder();

        SparkFunOTOS.Pose2D pose2D = sparkfunOTOS.getPosition();
        for (AprilTagDetection detection : currentDetections) {
            sparkfunOTOS.setPosition(convertFromAprilTag(detection.metadata.fieldPosition, detection.ftcPose, pose2D.h));
            idsFound.append(detection.id);
            idsFound.append(' ');
        }
        telemetry.addData("April Tags", idsFound);
        SparkFunOTOS.Pose2D pos = sparkfunOTOS.getPosition();
        telemetry.addData("X (inch)", pos.x);
        telemetry.addData("Y (inch)", pos.y);
        telemetry.addData("Heading (degrees)", pos.h);
    }
    private SparkFunOTOS.Pose2D convertFromAprilTag(VectorF fieldPosition, AprilTagPoseFtc pose, double heading){
        SparkFunOTOS.Pose2D pose2D = new SparkFunOTOS.Pose2D();

        pose2D.x = fieldPosition.get(0) + pose.x;
        pose2D.y = fieldPosition.get(1) + pose.y;
        pose2D.h = heading;
        // TODO: Convert from Camera position to Robot Center
        // this is different for every robot so you'll have to do this.
        return pose2D;
    }
}
