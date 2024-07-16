package org.gourmetgate.gourmetgate.db;

import java.util.function.Consumer;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.util.Assertions;
import org.jooq.DSLContext;

import org.gourmetgate.gourmetgate.persistence.PersistenceProperties.DialectProperty;
import org.gourmetgate.gourmetgate.persistence.PersistenceProperties.JdbcMappingNameProperty;
import org.gourmetgate.gourmetgate.persistence.PersistenceProperties.PasswordProperty;
import org.gourmetgate.gourmetgate.persistence.PersistenceProperties.UsernameProperty;

public class Environment {

  public void runWithConfig(Consumer<DSLContext> task) {
    Assertions.assertNotNull(task);
    BEANS.get(JooqEnvironmentService.class).runInJooq(task,
        CONFIG.getPropertyValue(JdbcMappingNameProperty.class),
        CONFIG.getPropertyValue(DialectProperty.class),
        CONFIG.getPropertyValue(UsernameProperty.class),
        CONFIG.getPropertyValue(PasswordProperty.class));
  }
}
