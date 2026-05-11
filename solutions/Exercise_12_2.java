package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard8;

@Autonomous()
public class Exercise_12_2 extends OpMode {
    enum State {
        START,
        GO_UNTIL_DISTANCE,
        TURN_SERVO,
        DONE
    }

    ProgrammingBoard8 board = new ProgrammingBoard8();
    State state = State.START;
    double lastStepTime;

    @Override
    public void init() {
        board.init(hardwareMap);
        state = State.START;
    }

    @Override
    public void loop() {
        telemetry.addData("State", state);
        switch (state) {
            case START:
                board.setMotorSpeed(0.5);
                board.setServoPosition(0.0);
                resetRuntime();
                state = State.GO_UNTIL_DISTANCE;
                break;
            case GO_UNTIL_DISTANCE:
                if ((board.getDistance(DistanceUnit.CM) < 10) || (getRuntime() > 5.0)) {
                    board.setMotorSpeed(0.0);
                    state = State.TURN_SERVO;
                }
                break;
            case TURN_SERVO:
                board.setServoPosition(0.5);
                state = State.DONE;
                break;
            default:
                telemetry.addData("Auto", "Finished");
        }
    }
}
