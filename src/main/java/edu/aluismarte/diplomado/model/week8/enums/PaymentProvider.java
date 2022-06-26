package edu.aluismarte.diplomado.model.week8.enums;

import edu.aluismarte.diplomado.model.week8.ServiceMastercard;
import edu.aluismarte.diplomado.model.week8.ServicePaypal;
import edu.aluismarte.diplomado.model.week8.ServiceStripe;
import edu.aluismarte.diplomado.model.week8.ServiceVisa;
import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
public enum PaymentProvider {
    STRIPE(new ServiceStripe()),
    PAYPAL(new ServicePaypal()),
    MASTERCARD(new ServiceMastercard()),
    VISA(new ServiceVisa());

    @Getter
    private final PaymentGateway paymentGateway;

}
