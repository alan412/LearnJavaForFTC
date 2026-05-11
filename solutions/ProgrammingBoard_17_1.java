package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.TestAnalogInput;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;
import org.firstinspires.ftc.teamcode.mechanisms.TestMotor;

import java.util.ArrayList;

public class ProgrammingBoard_17_1 {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    private double ticksPerRotation;
    private Servo servo;
    private AnalogInput pot;
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;
    private IMU imu;

    /**
     * This initializes our programming board and gets it ready for use.
     * It MUST be called before any of the other methods
     *
     * @param hwMap the hardware map from the opMode
     */
    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
        servo = hwMap.get(Servo.class, "servo");
        pot = hwMap.get(AnalogInput.class, "pot");

        colorSensor = hwMap.get(ColorSensor.class, "sensor_color_distance");
        distanceSensor = hwMap.get(DistanceSensor.class, "sensor_color_distance");
        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation =
                new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);

        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    /**
     * @return whether the touch sensor is pressed or not
     */
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    /**
     * @param speed the speed (-1.0 to 1.0) where negative is backwards
     */
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    /**
     * @return returns the number of rotations from the encoder
     */
    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    /**
     * @param position the position (0.0-1.0) for the servo
     */
    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    /**
     * @return the angle (0 - 270) the potentiometer is pointed to
     */
    public double getPotAngle() {
        return Range.scale(pot.getVoltage(), 0, pot.getMaxVoltage(), 0, 270);
    }

    /**
     * @return the amount red (0-255) the color sensor sees
     */

    public int getAmountRed() {
        return colorSensor.red();
    }

    /**
     * @param du what units to return distance in
     * @return distance seen by distance sensor
     */

    public double getDistance(DistanceUnit du) {
        return distanceSensor.getDistance(du);
    }

    /**
     * @param angleUnit what units to return the angle in
     * @return the heading (Z axis of the IMU)
     */
    public double getHeading(AngleUnit angleUnit) {
        return imu.getRobotYawPitchRollAngles().getYaw(angleUnit);
    }

    /**
     * @return a list of tests for the hardware on the board - used by TestWiring
     */

    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new TestMotor("PB Motor", 0.5, motor));
        tests.add(new TestAnalogInput("PB Pot", pot, 0, 270));
        return tests;
    }
}
