package edu.aluismarte.diplomado.project.week11.model;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.saga.model.*;

/**
 * @author aluis on 7/17/2022.
 */
public class SagaStepVacationCalculationGetEmployee implements SagaStep<ExerciseResponse> {

    @Override
    public String getName() {
        return "Vacation Calculation step 1";
    }

    @Override
    public SagaStepHandler<ExerciseResponse> getHandler() {
        return sagaPayload -> {
            ExerciseCommand command = sagaPayload.getProperty(new SagaPayLoadKey<>("command", ExerciseCommand.class));

            Employee employee = Employee.builder()
                    .name("Lalala")
                    .build();

            sagaPayload.addProperty(new SagaPayLoadKey<>("employee", Employee.class), employee);
        };
    }

    @Override
    public SagaStepCompensator<ExerciseResponse> getCompensator() {
        return null;
    }
}
