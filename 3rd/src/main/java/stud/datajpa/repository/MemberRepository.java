package stud.datajpa.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stud.datajpa.dto.MemberDto;
import stud.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

  List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

  @Query("select m from Member m where m.username = :username and m.age = :age")
  List<Member> findUser(@Param("username") String username, @Param("age") int age);

  @Query("select m.username from Member m")
  List<String> findUsernameList();

  @Query("select new stud.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
  List<MemberDto> findMemberDto();

  @Query("select m from Member m where m.username in :names")
  List<Member> findByNames(@Param("names") List<String> names);


  // 결과가 없으몀 empty list
  List<Member> findListByUsername(String username);

  // 결과가 없으면 null
  // 결과가 2개 이상이면 IncorrectDataSizeException
  Member findMemberByUsername(String username);
  Optional<Member> findOptionalByUsername(String username);
}
