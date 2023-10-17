package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoMember;

@Repository
public interface NgoMemberRepository  extends JpaRepository<NgoMember, Long>, CustomRepository {
	List<NgoMember> findByIsDelete(Boolean isDelete);

}
