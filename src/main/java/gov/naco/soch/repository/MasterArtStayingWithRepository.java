package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtStayingWith;

@Repository
public interface MasterArtStayingWithRepository extends JpaRepository<MasterArtStayingWith, Long> {

	List<MasterArtStayingWith> findByIsDelete(Boolean isDelete);

}
