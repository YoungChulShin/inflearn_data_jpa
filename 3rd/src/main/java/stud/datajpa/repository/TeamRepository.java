package stud.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.datajpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
