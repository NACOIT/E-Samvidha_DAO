package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentProduct;
import gov.naco.soch.projection.IndentListProjection;
import gov.naco.soch.projection.IndentProductProjection;

@Repository
public interface IndentProductRepository extends JpaRepository<IndentProduct, Long> {

	Set<IndentProduct> findAllByIndent_IndentIdAndProduct_IdNotIn(Long indentId, List<Long> contractProductIds);

	@Query(nativeQuery = true, value = "select p.product_name as productName,i.indent_id as indentId from\r\n"
			+ "soch.indent i join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p\r\n"
			+ "on (p.id=ip.product_id) where i.indent_id IN :indentIds")
	List<IndentListProjection> findProductsByIndentId(@Param("indentIds") List<Long> indentIds);

	@Query(nativeQuery = true, value = "select ip.id as indentProductId,p.id as productId,pum.uom_name as uom,\r\n"
			+ "p.product_name as productName from soch.product p join soch.indent_product ip on"
			+ "(p.id=ip.product_id) join soch.product_uom_master pum on(pum.id=p.uom_id) where ip.indent_id=:indentId order by p.product_name asc ")
	List<IndentProductProjection> findByIndentId(@Param("indentId") Long indentId);

	@Query(nativeQuery = true, value = "select p.product_name as productname,i.indent_id as indentid from\r\n"
			+ "soch.indent i join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p\r\n"
			+ "on (p.id=ip.product_id) where i.indent_id IN :indentIds")
	List<IndentListProjection> findProductsByIndentIdForSearch(@Param("indentIds") List<Integer> indentIds);

}
