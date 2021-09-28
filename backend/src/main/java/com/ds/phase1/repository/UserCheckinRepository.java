package com.ds.phase1.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.ds.phase1.model.UserCheckin;

public interface UserCheckinRepository extends CassandraRepository<UserCheckin,String>{

	UserCheckin findByUserName(String userName);
}
