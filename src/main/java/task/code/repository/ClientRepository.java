package task.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.code.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
