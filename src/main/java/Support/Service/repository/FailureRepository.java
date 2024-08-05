package Support.Service.repository;

import Support.Service.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FailureRepository extends JpaRepository<Failure, Long> {
}
