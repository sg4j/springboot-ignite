package com.petclinic.repository.springdatajpa.postgres;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.petclinic.entity.postgres.Vet;

public interface SpringDataVetRepository extends CrudRepository<Vet, Integer> {

	public Collection<Vet> findByLastName(String lastName) throws DataAccessException;
	public Vet findById(Integer id) throws DataAccessException;;
}
