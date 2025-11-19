package dev.engripaye.churchmembersinformationsystem.repository;

import dev.engripaye.churchmembersinformationsystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
