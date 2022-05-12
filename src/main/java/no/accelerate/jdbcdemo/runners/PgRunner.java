package no.accelerate.jdbcdemo.runners;

import no.accelerate.jdbcdemo.repository.student.StudentRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * This class is a dedicated runner to execute the run() method once Spring Boot
 *  has completed a component scan and registered all beans.
 *
 *  Allows us to use beans that require injection.
 */
@Component
public class PgRunner implements ApplicationRunner {

    // --- Dependency injection pattern
    private final StudentRepository studentRepository;

    public PgRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // ---

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println((studentRepository.findById(1)).name());
    }
}
