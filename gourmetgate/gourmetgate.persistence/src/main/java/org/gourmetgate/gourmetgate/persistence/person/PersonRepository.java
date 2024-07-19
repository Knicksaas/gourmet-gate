package org.gourmetgate.gourmetgate.persistence.person;

import org.eclipse.scout.rt.platform.util.StringUtility;
import org.gourmetgate.gourmetgate.data.person.IPersonRepository;
import org.gourmetgate.gourmetgate.data.person.PersonDo;
import org.gourmetgate.gourmetgate.data.person.PersonRestrictionDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Person;
import org.gourmetgate.gourmetgate.persistence.tables.records.PersonRecord;
import org.jooq.Field;

import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.noCondition;

public class PersonRepository extends AbstractRepository<Person, PersonRecord, PersonDo> implements IPersonRepository {

  @Override
  public Person getTable() {
    return Person.PERSON;
  }

  @Override
  public Field<String> getIdColumn() {
    return Person.PERSON.PERSON_ID;
  }

  @Override
  public Stream<PersonDo> search(PersonRestrictionDo restrictions) {
    Person personTab = Person.PERSON.as("p");
    return jooq()
        .select()
        .from(personTab)
        .where(StringUtility.hasText(restrictions.getFirstName()) ? personTab.FIRST_NAME.likeIgnoreCase('%' + restrictions.getFirstName() + '%') : noCondition(),
            StringUtility.hasText(restrictions.getLastName()) ? personTab.LAST_NAME.likeIgnoreCase('%' + restrictions.getLastName() + '%') : noCondition())
        .limit(100)
        .fetchStream()
        .map(r -> r.into(personTab))
      .map(this::fromRecordToDo);
  }

  @Override
  protected DoEntityBeanMappings<PersonDo, PersonRecord> mappings() {
    return new DoEntityBeanMappings<PersonDo, PersonRecord>().with(PersonDo::personId, PersonRecord::getPersonId)
        .with(PersonDo::lastName, PersonRecord::getLastName, PersonRecord::setLastName)
        .with(PersonDo::firstName, PersonRecord::getFirstName, PersonRecord::setFirstName)
        .with(PersonDo::salary, PersonRecord::getSalary, PersonRecord::setSalary)
        .with(PersonDo::external, PersonRecord::getExternal, PersonRecord::setExternal);
  }
}
