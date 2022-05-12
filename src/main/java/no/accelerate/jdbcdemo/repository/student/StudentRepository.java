package no.accelerate.jdbcdemo.repository.student;


import no.accelerate.jdbcdemo.models.Student;
import no.accelerate.jdbcdemo.repository.CrudRepository;

/**
 * Extended Repository specifically for a Student.
 * Any extra functionality a student can have for data access goes here.
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {

}
