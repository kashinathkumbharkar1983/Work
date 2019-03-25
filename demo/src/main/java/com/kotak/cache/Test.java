package com.kotak.cache;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")

public class Test {

    private SimpleJdbcCall jdbcCallGetMWFAllowedServices;

	  @Autowired
	 DataSource ds;

	@RequestMapping("/test/")
	public String test()
	{
		String s="===";
		try {
			s= "test"+ds.getConnection().toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}
	private CrudRepository<Person, String> repository;

	@Autowired
	public void PersonController(CrudRepository<Person, String> repository)
	{
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> persons()
	{
		return repository.findAll();
	}
	@RequestMapping(method = RequestMethod.PUT)
    public Person add(@RequestBody @Valid Person person) {
        return repository.save(person);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person update(@RequestBody @Valid Person person) {
        return repository.save(person);
    }

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

