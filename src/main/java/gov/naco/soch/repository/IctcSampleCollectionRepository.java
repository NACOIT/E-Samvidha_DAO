package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.IctcSampleCollection;

public interface IctcSampleCollectionRepository extends JpaRepository<IctcSampleCollection, Long> {

	Optional<IctcSampleCollection> findByBarcode(String barcode);

	@Query(value = "select s.* from soch.ictc_sample_collection s where s.barcode IN :barcodes", nativeQuery = true)
	List<IctcSampleCollection> findBySampleBatchBarcodes(@Param("barcodes") List<String> barcodes);

}
