package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSyphilisStatus;

@Repository
public interface MasterSyphilisStatusRepository extends JpaRepository<MasterSyphilisStatus, Long> {

	List<MasterSyphilisStatus> findByIsDelete(Boolean isDelete);

}