package task.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.code.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
