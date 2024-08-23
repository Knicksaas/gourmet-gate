package org.gourmetgate.gourmetgate.data.table;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.stream.Stream;

public interface ITableRepository extends ICrudRepository<TableDo> {

  Stream<TableDo> all(long limit);

  long getTableCount();
}
