package in.kunnu.repo;

import org.springframework.data.repository.CrudRepository;

import in.kunnu.entity.Student;

public interface StudentRepository extends  CrudRepository<Student, Integer> {

}
