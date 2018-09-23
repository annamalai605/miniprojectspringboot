package com.example.Project;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	@SuppressWarnings("null")
	public void registerUser(UserDto user) {
		Session sessionObj = null;
		SessionFactory sessionFactoryObj = null;
		try {
			// Create session factory object
			Configuration configObj = new Configuration();
			configObj.configure("hibernate.cfg.xml");
			configObj.addAnnotatedClass(Users.class);
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configObj.getProperties()).build();
			// Creating Hibernate SessionFactory Instance
			sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			// getting session object from session factory
			Session session = sessionFactoryObj.openSession();
			Users users = new Users();
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			users.setPassword(user.getPassword());
			users.setUserName(user.getUsername());
			// getting transaction object from session object
			session.beginTransaction();
			session.save(users);
			System.out.println("Inserted Successfully");
			session.getTransaction().commit();
			session.close();
			sessionFactoryObj.close();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public List<Users> loginUser(String userName) {
		Session sessionObj = null;
		SessionFactory sessionFactoryObj = null;
		try {
			// Create session factory object
			Configuration configObj = new Configuration();
			configObj.configure("hibernate.cfg.xml");
			configObj.addAnnotatedClass(Users.class);
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configObj.getProperties()).build();
			// Creating Hibernate SessionFactory Instance
			sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			// getting session object from session factory
			Session session = sessionFactoryObj.openSession();
			session.beginTransaction();
			Query query = session.createQuery("From Users u where u.userName=:userName");
			query.setParameter("userName", userName);
			List<Users> usersList = query.getResultList();
			session.getTransaction().commit();
			session.close();
			sessionFactoryObj.close();
			return usersList;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return null;
	}

	public void createNote(NoteDto noteDto) {
		Session sessionObj = null;
		SessionFactory sessionFactoryObj = null;
		try {
			// Create session factory object
			Configuration configObj = new Configuration();
			configObj.configure("hibernate.cfg.xml");
			configObj.addAnnotatedClass(Users.class);
			configObj.addAnnotatedClass(Notes.class);
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configObj.getProperties()).build();
			// Creating Hibernate SessionFactory Instance
			sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			// getting session object from session factory
			Session session = sessionFactoryObj.openSession();
			Notes note = new Notes();
			note.setNoteDesc(noteDto.getNoteDesc());
			note.setNoteName(noteDto.getNoteName());
			note.setUpdatedUser(noteDto.getUpdatedUser());
			// getting transaction object from session object
			session.beginTransaction();
			session.save(note);
			System.out.println("Note Inserted Successfully");
			session.getTransaction().commit();
			session.close();
			sessionFactoryObj.close();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public List<Notes> viewNotes(String userName) {
		Session sessionObj = null;
		SessionFactory sessionFactoryObj = null;
		try {
			// Create session factory object
			Configuration configObj = new Configuration();
			configObj.configure("hibernate.cfg.xml");
			configObj.addAnnotatedClass(Users.class);
			configObj.addAnnotatedClass(Notes.class);
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configObj.getProperties()).build();
			// Creating Hibernate SessionFactory Instance
			sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			// getting session object from session factory
			Session session = sessionFactoryObj.openSession();
			session.beginTransaction();
			Query query = session.createQuery("From Notes n where n.updatedUser=:updatedUser");
			query.setParameter("updatedUser", userName);
			List<Notes> notesList = query.getResultList();
			session.getTransaction().commit();
			session.close();
			sessionFactoryObj.close();
			return notesList;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return null;
	}

}
