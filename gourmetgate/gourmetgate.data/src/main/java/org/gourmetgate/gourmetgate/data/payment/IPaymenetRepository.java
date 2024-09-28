package org.gourmetgate.gourmetgate.data.payment;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.Optional;

public interface IPaymenetRepository extends ICrudRepository<PaymentDo> {

  Optional<PaymentDo> getByExtId(String extId);

  Optional<PaymentDo> getByOrderId(String orderId);
}
