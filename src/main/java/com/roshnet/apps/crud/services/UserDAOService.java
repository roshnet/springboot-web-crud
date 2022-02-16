package com.roshnet.apps.crud.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.roshnet.apps.crud.models.User;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDAOService {

  @PersistenceContext
  private EntityManager entityManager;

  public long insert(User user) {
    entityManager.persist(user);
    return user.getId();
  }

}
