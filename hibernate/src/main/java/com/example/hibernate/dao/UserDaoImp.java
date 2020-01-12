package com.example.hibernate.dao;

import com.example.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager em;

    public User getUserById(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate condition = builder.equal(root.get("id"), id);

        query.select(root).where(condition);

        return em.createQuery(query).getSingleResult();
    }


    public void addUser(User user) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getUser() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<User> list = session.createCriteria(User.class).list();
        return list;
    }

    public User findById(int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    public User update(User val, int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        user.setCountry(val.getCountry());
        user.setName(val.getName());
        session.update(user);
        return user;
    }

    public void delete(int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }

    @Override
    public User updateCountry(User val, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        user.setCountry(val.getCountry());
        return user;
    }
}