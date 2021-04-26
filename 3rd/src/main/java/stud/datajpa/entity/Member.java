package stud.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(of = {"id", "username", "age"})
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  private String username;

  private int age;

  @ManyToOne
  @JoinColumn(name = "team_id") // 이게 foreign key name
  private Team team;


  protected Member() {
  }

  public Member(String username) {
    this.username = username;
  }

  public void changeTeam(Team newTeam) {
    this.team = newTeam;
    newTeam.getMembers().add(this);
  }
}
