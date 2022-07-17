package edu.aluismarte.diplomado.project.week11.model;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayLoadKey;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStep;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepCompensator;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepHandler;
import edu.aluismarte.diplomado.week2.Homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aluis on 7/17/2022.
 */
public class SagaStepVacationCalculationCalculate implements SagaStep<ExerciseResponse> {


    @Override
    public String getName() {
        return "Vacation Calculation step 2";
    }

    @Override
    public SagaStepHandler<ExerciseResponse> getHandler() {
        return sagaPayload -> {
            ExerciseCommand command = sagaPayload.getProperty(new SagaPayLoadKey<>("command", ExerciseCommand.class));
            Employee employee = sagaPayload.getProperty(new SagaPayLoadKey<>("employee", Employee.class));

            List<DayOfWeek> workdays = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

            Homework homeworkWeek2 = new Homework();

            LocalDate returnDate = homeworkWeek2.calculateDueDate(workdays, new ArrayList<>(), command.getLocalDate(), command.getVacationDays());

            sagaPayload.setResult(ExerciseResponse.builder()
                    .returnDate(returnDate)
                    .build());
        };
    }

    @Override
    public SagaStepCompensator<ExerciseResponse> getCompensator() {
        return null;
    }
}
