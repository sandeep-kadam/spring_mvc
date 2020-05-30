package com.sk.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.util.StringUtils;
import com.sk.spring.entity.Customer;


@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	//it will inject session factory objection defined in spring xml configuration
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//It will automatically begin and commit transaction
	@Transactional
	public List<Customer> getCustomers(String customerName) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = null;
		
		//create your query
		/****IMP NOTE :: in query table must be same as Entity Name
				e.g. Entity Name is Customer & if customer as a table name given it will not work
				if table name is Customer then only it will work.
		//sort by firstName 
		Query<Customer> query = currentSession.createQuery("from Customer order by firstName" , Customer.class);
		*/
		
		if(!StringUtils.isNullOrEmpty(customerName) && customerName.trim().length() > 0) {
			query = currentSession.createQuery("from Customer where lower(firstName) like :customerName or lower(lastName) like:customerName"
									,Customer.class);
			query.setParameter("customerName", "%"+customerName.toLowerCase()+"%");
		} else {
			query = currentSession.createQuery("from Customer order by firstName" , Customer.class);
		}
		
		//execute your query and store the result
		List<Customer> customerList = query.getResultList();

		//return your result
		return customerList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/insert customer details into customer table
		//currentSession.save(customer);
		
		//insert or update according to primary key value if
		//primary key empty/null then insert operation will be performed
		//otherwise update operation will be performed
		currentSession.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		//now retrieve customer details from DB through customerId
		Customer customer = currentSession.get(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery(" delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
		
	}

	
}
