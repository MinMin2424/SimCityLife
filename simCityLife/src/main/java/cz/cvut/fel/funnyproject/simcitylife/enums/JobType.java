package cz.cvut.fel.funnyproject.simcitylife.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JobType {
    STUDENT(0),
    HOMELESS(0),
    TEACHER(100);

    private final double salary;
}
