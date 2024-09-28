package org.gourmetgate.gourmetgate.persistence.payment;

import org.gourmetgate.gourmetgate.data.payment.IPaymenetRepository;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Payment;
import org.gourmetgate.gourmetgate.persistence.tables.records.PaymentRecord;
import org.jooq.Field;

import java.util.Optional;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class PaymentRepository extends AbstractRepository<Payment, PaymentRecord, PaymentDo> implements IPaymenetRepository {

  @Override
  public Payment getTable() {
    return Payment.PAYMENT;
  }

  @Override
  public Field<String> getIdColumn() {
    return Payment.PAYMENT.PAYMENT_ID;
  }

  @Override
  public Optional<PaymentDo> getByExtId(String extId) {
    return Optional.ofNullable(
        jooq()
          .selectFrom(getTable())
          .where(getTable().PAYMENT_EXT_ID.eq(extId))
          .fetchOne())
      .map(this::fromRecordToDo);
  }

  @Override
  public Optional<PaymentDo> getByOrderId(String orderId) {
    return Optional.ofNullable(
        jooq()
          .selectFrom(getTable())
          .where(getTable().ORDER_ID.eq(orderId))
          .fetchOne())
      .map(this::fromRecordToDo);
  }

  @Override
  protected DoEntityBeanMappings<PaymentDo, PaymentRecord> mappings() {
    return new DoEntityBeanMappings<PaymentDo, PaymentRecord>()
      .with(PaymentDo::paymentId, PaymentRecord::getPaymentId, PaymentRecord::setPaymentId)
      .with(PaymentDo::paymentExtId, PaymentRecord::getPaymentExtId, PaymentRecord::setPaymentExtId)
      .with(PaymentDo::orderId, PaymentRecord::getOrderId, PaymentRecord::setOrderId)
      .with(PaymentDo::status, PaymentRecord::getStatus, PaymentRecord::setStatus);
  }
}
