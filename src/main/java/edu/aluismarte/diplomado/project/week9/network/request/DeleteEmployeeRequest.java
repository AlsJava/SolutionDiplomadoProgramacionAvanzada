package edu.aluismarte.diplomado.project.week9.network.request;

import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteEmployeeRequest {

    private Long id;
}
