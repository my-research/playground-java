package com.wonit.springbootplayground;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeRepository extends JpaRepository<SomeEntity, Long> {

}
