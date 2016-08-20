package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.ProjektDao;
import com.capgemini.domain.ProjektEntity;

@Repository
public class ProjektDaoImpl extends AbstractDao<ProjektEntity, Long> implements ProjektDao {

}
