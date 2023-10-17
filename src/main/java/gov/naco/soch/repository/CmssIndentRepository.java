package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssIndent;

@Repository
public interface CmssIndentRepository extends JpaRepository<CmssIndent, Long> {

}
