package org.sid.repository;


import org.sid.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface TaskRepository extends JpaRepository<Task,Long> {
}
