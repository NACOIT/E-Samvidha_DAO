package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterContraception;

@Repository
public interface MasterContraceptionRepository extends JpaRepository<MasterContraception, Long> {

	List<MasterContraception> findByIsDelete(Boolean isDelete);

}