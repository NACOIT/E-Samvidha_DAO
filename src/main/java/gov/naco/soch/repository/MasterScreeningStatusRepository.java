package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterScreeningStatus;

@Repository
public interface MasterScreeningStatusRepository extends JpaRepository< MasterScreeningStatus, Long> {

	List< MasterScreeningStatus> findByIsDelete(Boolean isDelete);

}