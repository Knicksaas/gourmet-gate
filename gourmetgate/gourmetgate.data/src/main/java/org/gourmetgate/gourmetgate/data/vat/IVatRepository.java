package org.gourmetgate.gourmetgate.data.vat;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.lookup.ILookupRepository;

public interface IVatRepository extends ICrudRepository<VatDo>, ILookupRepository<VatDo> {
}
