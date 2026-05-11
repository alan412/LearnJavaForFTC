package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard8;

@Autonomous()
public class Exercise_12_1 extends OpMode {
    enum State {
        START,
        QUARTER_SPEED,
        HALF_SPEED,
        THREE_QUARTERS_SPEED,
        FULL_SPEED,
        DONE
    }

    ProgrammingBoard8 board = new ProgrammingBoard8();
    State state = State.START;
    double lastStepTime;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void start() {
        state = State.START;
    }

    @Override
    public void loop() {
        telemetry.addData("State", state);
        switch (state) {
            case START:
                board.setMotorSpeed(0.250);
                state = State.QUARTER_SPEED;
                lastStepTime = getRuntime();
                break;
            case QUARTER_SPEED:
                if (getRuntime() > lastStepTime + .250) {
                    board.setMotorSpeed(0.500);
                    state = State.HALF_SPEED;
                    lastStepTime = getRuntime();
                }
                break;
            case HALF_SPEED:
                if (getRuntime() > lastStepTime + .250) {
                    board.setMotorSpeed(0.750);
                    state = State.THREE_QUARTERS_SPEED;
                    lastStepTime = getRuntime();
                }
                break;
            case THREE_QUARTERS_SPEED:
                if (getRuntime() > lastStepTime + .250) {
                    board.setMotorSpeed(1.00);
                    state = State.FULL_SPEED;
                }
                break;
            case FULL_SPEED:
                if (board.isTouchSensorPressed()) {
                    board.setMotorSpeed(0.0);
                    state = State.DONE;
                }
                break;
            default:
                telemetry.addData("Auto", "Finished");
        }
    }
}
