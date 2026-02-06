package task.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.code.model.Court;

@Repository
public interface CourtRepository extends JpaRepository<Court, Long> {
}
