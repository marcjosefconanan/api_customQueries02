package com.api_customQueries02.api_customQueries02.Repositories;


import com.api_customQueries02.api_customQueries02.Entities.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Month,Long> {

}