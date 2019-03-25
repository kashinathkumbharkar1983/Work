package com.kotak.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;

public class PersonRepository implements CrudRepository<Person, String> {

	public static final String PERSONS_KEY = "persons";

	private final HashOperations<String, String, Person> hashOps;

	public PersonRepository(RedisTemplate<String, Person> redisTemplate) {
		this.hashOps = redisTemplate.opsForHash();
	}

	
	public long count() {
		return hashOps.keys(PERSONS_KEY).size();
	}

	public void delete(String emailAddress) {
		hashOps.delete(PERSONS_KEY, emailAddress);
	}

	
	public void delete(Person person) {
		hashOps.delete(PERSONS_KEY,  person.getEmailAddress());
	}

	public void delete(Iterable<? extends Person> persons) {
		for (Person p : persons) {
			delete(p);
		}
	}

	
	public void deleteAll() {
		Set<String> emails = hashOps.keys(PERSONS_KEY);
		for (String email : emails) {
			delete(email);
		}

	}

	
	public boolean exists(String emailAddress) {
		return hashOps.hasKey(PERSONS_KEY,  emailAddress);
	}

	
	public Iterable<Person> findAll() {
		return hashOps.values(PERSONS_KEY);
	}

	
	

	
	public Person findOne(String emailAddress) {
		return hashOps.get(PERSONS_KEY, emailAddress);
	}

	
	public <S extends Person> S save(S person) {
		hashOps.put(PERSONS_KEY, person.getEmailAddress(), person);

		return person;
	}


	@Override
	public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Person> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<Person> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Person> entities) {
		// TODO Auto-generated method stub
		
	}

	

	
}