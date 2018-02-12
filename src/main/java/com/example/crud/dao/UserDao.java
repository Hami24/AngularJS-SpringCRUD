package com.example.crud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crud.model.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<User> getAllUsers(){
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from User").list();
	}
	
	public User getUserById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from User where id=:id");
		query.setParameter("id", id);
		return (User) query.uniqueResult();
		
	}
	
	public void addOrUpdateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
}
