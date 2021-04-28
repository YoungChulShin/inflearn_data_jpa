package stud.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
