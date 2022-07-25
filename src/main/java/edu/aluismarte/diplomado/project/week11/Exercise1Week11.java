package edu.aluismarte.diplomado.project.week11;

import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import edu.aluismarte.diplomado.project.week11.model.SagaStepVacationCalculationCalculate;
import edu.aluismarte.diplomado.project.week11.model.SagaStepVacationCalculationGetEmployee;
import edu.aluismarte.diplomado.project.week11.saga.model.Saga;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayload;

import java.util.List;
import java.util.UUID;

/**
 * El objetivo es implementar el patrón ya con la base hecha.
 * No se hará el ejercicio de implementar el patrón desde cero porque es posible copiarlo de este proyecto
 *
 * El objetivo es entender las piezas que se tienen y su importancia a la hora de separar la lógica
 *
 * Pasos s seguir:
 *  - Crear un empleado ficticio y ponerlo en la SAGA
 *  - Calcular la fecha de retorno
 *  - Retornar la fecha de retorno
 *
 * @author aluis on 6/4/2022.
 */
public class Exercise1Week11 {

    public static Saga<ExerciseResponse> createExerciseSaga(UUID key, ExerciseCommand exerciseCommand) {
        SagaPayload<ExerciseResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(ExerciseCommand.COMMAND_KEY, exerciseCommand);
        return Saga.<ExerciseResponse>builder()
                .name("Hola")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaStepVacationCalculationGetEmployee.class,
                        SagaStepVacationCalculationCalculate.class
                ))
                .build();
    }
}
