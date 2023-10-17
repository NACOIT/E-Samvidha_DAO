package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterStayingWith;

@Repository
public interface MasterStayingWithRepository extends JpaRepository<MasterStayingWith, Long> {

	
	 List<MasterStayingWith> findByIsDelete(Boolean isDelete);
}

