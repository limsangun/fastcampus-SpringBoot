package com.study.todoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.todoserver.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
