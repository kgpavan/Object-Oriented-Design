
import java.util.Optional;

/**
 * Interface lists out the possible behaviour for all possible student mappers
 */
public interface StudentDataMapper {

	Optional<Student> find(int studentId);

	void insert(Student student) throws DataMapperException;

	void update(Student student) throws DataMapperException;

	void delete(Student student) throws DataMapperException;
}
