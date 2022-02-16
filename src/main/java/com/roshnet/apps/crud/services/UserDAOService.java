package com.roshnet.apps.crud.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.roshnet.apps.crud.models.User;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDAOService {

  @PersistenceContext
  private EntityManager entityManager;

  EntityManagerFactory entityManagerFactory;

  public long insert(User user) {
    entityManager.persist(user);
    return user.getId();
  }

  // To fix: .createEntityManager() throws NPE
  public String getRoleByName(String name) {
    EntityManager em =  entityManagerFactory.createEntityManager();
    Query query = em.createQuery("SELECT e FROM user e WHERE e.name = :username");
    query.setParameter("username", name);
    Object res = query.getSingleResult();
    em.close();
    return res.toString();
  }

}
