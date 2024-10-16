package org.gourmetgate.gourmetgate.db.setup;

import java.util.Set;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.jooq.DSLContext;

import org.gourmetgate.gourmetgate.db.Environment;
import org.gourmetgate.gourmetgate.db.helper.DatabaseHelper;
import org.gourmetgate.gourmetgate.db.setup.schema.IDatabaseSchema;
import org.gourmetgate.gourmetgate.db.setup.table.IGenerateTable;
import org.gourmetgate.gourmetgate.db.setup.table.data.IDataInitializer;
import org.gourmetgate.gourmetgate.persistence.PersistenceProperties.DatabaseAddSamplesProperty;

public class DbSetup {

  public static void main(String[] args) {
    new Environment().runWithConfig(new DbSetup()::setup);
  }

  public void setup(DSLContext context) {
    createDatabase(context);
    insertData(context);
  }

  private void createDatabase(DSLContext context) {
    createSchemas(context);
    createTables(context);
  }

  private void createTables(DSLContext context) {
    Set<String> tables = BEANS.get(DatabaseHelper.class).getTableNames(context);
    for (IGenerateTable table : BEANS.all(IGenerateTable.class)) {
      executeCreateSQL(context, tables, table);
    }
  }

  private void createSchemas(DSLContext context) {
    Set<String> schemas = BEANS.get(DatabaseHelper.class).getSchemaNames(context);
    for (IDatabaseSchema schema : BEANS.all(IDatabaseSchema.class)) {
      executeCreateSQL(context, schemas, schema);
    }
  }

  private void executeCreateSQL(DSLContext context, Set<String> databaseObjects, IDatabaseObject databaseObjectToGenerate) {
    if (databaseObjects.contains(databaseObjectToGenerate.getName())) {
      return; // already exists
    }

    databaseObjectToGenerate.setContext(context);
    context.execute(databaseObjectToGenerate.getCreateSQL());
  }

  private void insertData(DSLContext context) {
    for (IDataInitializer table : BEANS.all(IDataInitializer.class)) {
      // insert initial data (minimal data, required to run the application)
      table.initialize(context);

      // insert sample data (for development / demo)
      if (CONFIG.getPropertyValue(DatabaseAddSamplesProperty.class)) {
        table.addSamples(context);
      }
    }
  }
}
