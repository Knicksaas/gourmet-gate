package org.gourmetgate.gourmetgate.db.setup.table;

import org.gourmetgate.gourmetgate.db.setup.IDatabaseObject;

public interface IGenerateTable extends IDatabaseObject {

  String getSchemaName();

  String createSQLInternal();

}
