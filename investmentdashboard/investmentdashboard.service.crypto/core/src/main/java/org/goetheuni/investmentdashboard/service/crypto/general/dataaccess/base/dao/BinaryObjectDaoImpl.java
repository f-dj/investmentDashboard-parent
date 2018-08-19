package org.goetheuni.investmentdashboard.service.crypto.general.dataaccess.base.dao;

import org.goetheuni.investmentdashboard.service.crypto.general.dataaccess.api.BinaryObjectEntity;
import org.goetheuni.investmentdashboard.service.crypto.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
