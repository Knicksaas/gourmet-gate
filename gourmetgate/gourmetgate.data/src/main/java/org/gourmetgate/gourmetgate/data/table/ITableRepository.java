package org.gourmetgate.gourmetgate.data.table;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.common.IStatusRepository;

public interface ITableRepository extends
  ICrudRepository<TableDo>,
  IStatusRepository<TableStatus> {
}
