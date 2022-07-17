package edu.aluismarte.diplomado.project.week11.command;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.week10.command.Command;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayLoadKey;
import lombok.*;

import java.time.LocalDate;

/**
 * @author aluis on 7/17/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExerciseCommand extends Command<ExerciseResponse> {

    public static final SagaPayLoadKey<ExerciseCommand> COMMAND_KEY = new SagaPayLoadKey<>("command", ExerciseCommand.class);
    public static final SagaPayLoadKey<Employee> EMPLOYEE_KEY = new SagaPayLoadKey<>("employee", Employee.class);

    private LocalDate localDate;
    private int vacationDays;
    private boolean explote;
}
