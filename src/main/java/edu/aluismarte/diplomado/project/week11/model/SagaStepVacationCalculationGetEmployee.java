package edu.aluismarte.diplomado.project.week11.model;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStep;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepCompensator;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepHandler;
import edu.aluismarte.diplomado.project.week12.service.LogEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/17/2022.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class SagaStepVacationCalculationGetEmployee implements SagaStep<ExerciseResponse> {

    private final LogEventService logEventService;

    @Override
    public String getName() {
        return "Vacation Calculation step 1";
    }

    @Override
    public SagaStepHandler<ExerciseResponse> getHandler() {
        return sagaPayload -> {
            ExerciseCommand command = sagaPayload.getProperty(ExerciseCommand.COMMAND_KEY);
            log.debug(command.toString());

            Employee employee = Employee.builder()
                    .name("Lalala")
                    .build();

            sagaPayload.addProperty(ExerciseCommand.EMPLOYEE_KEY, employee);
        };
    }

    @Override
    public SagaStepCompensator<ExerciseResponse> getCompensator() {
        return null;
    }
}
