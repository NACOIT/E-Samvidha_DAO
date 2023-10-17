package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtPep;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.GoodsRequest;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.projection.ContractListProjection;
import gov.naco.soch.projection.DispatchHistorySearchProjection;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.FacilityListColumnProjection;
import gov.naco.soch.projection.FacilityListProjection;
import gov.naco.soch.projection.IndentListSearchprojection;
import gov.naco.soch.projection.ProductSearchProjection;
import gov.naco.soch.projection.StockAdjustHistorySearchProjection;
import gov.naco.soch.projection.TIDispensationExpectedList;
import gov.naco.soch.projection.UnregisteredSourceReceiptHistoryProjection;

@SuppressWarnings("unchecked")
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Object[]> getObjectList(String listQuery) {
		List<Object[]> list = entityManager.createNativeQuery(listQuery).getResultList();
		return list;
	}

	@Override
	public List<Object[]> userAdvanceSearch(String searchQuery, Map<String, String> searchValue, Long currentUserId,
			Long currentFacilityId, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("firstname".equals(obj.getName())) {
				nativeQuery.setParameter("firstname", "%" + searchValue.get("firstname").trim() + "%");
			}
			if ("lastname".equals(obj.getName())) {
				nativeQuery.setParameter("lastname", "%" + searchValue.get("lastname").trim() + "%");
			}
			if ("username".equals(obj.getName())) {
				nativeQuery.setParameter("username", "%" + searchValue.get("username").trim() + "%");
			}
			if ("mobilenumber".equals(obj.getName())) {
				nativeQuery.setParameter("mobilenumber", "%" + searchValue.get("mobilenumber").trim() + "%");
			}
			if ("email".equals(obj.getName())) {
				nativeQuery.setParameter("email", "%" + searchValue.get("email").trim() + "%");
			}
			if ("role".equals(obj.getName())) {
				nativeQuery.setParameter("role", "%" + searchValue.get("role").trim() + "%");
			}
			if ("currentuser".equals(obj.getName())) {
				nativeQuery.setParameter("currentuser", currentUserId);
			}
			if ("currentfacility".equals(obj.getName())) {
				nativeQuery.setParameter("currentfacility", currentFacilityId);
			}
		}
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	public int userActualCount(String query, Map<String, String> searchValue, Long currentUserId,
			Long currentFacilityId) {
		Query nativeQuery = entityManager.createNativeQuery(query);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("firstname".equals(obj.getName())) {
				nativeQuery.setParameter("firstname", "%" + searchValue.get("firstname") + "%");
			}
			if ("lastname".equals(obj.getName())) {
				nativeQuery.setParameter("lastname", "%" + searchValue.get("lastname") + "%");
			}
			if ("username".equals(obj.getName())) {
				nativeQuery.setParameter("username", "%" + searchValue.get("username") + "%");
			}
			if ("mobilenumber".equals(obj.getName())) {
				nativeQuery.setParameter("mobilenumber", "%" + searchValue.get("mobilenumber") + "%");
			}
			if ("email".equals(obj.getName())) {
				nativeQuery.setParameter("email", "%" + searchValue.get("email") + "%");
			}
			if ("role".equals(obj.getName())) {
				nativeQuery.setParameter("role", "%" + searchValue.get("role") + "%");
			}
			if ("currentuser".equals(obj.getName())) {
				nativeQuery.setParameter("currentuser", currentUserId);
			}
			if ("currentfacility".equals(obj.getName())) {
				nativeQuery.setParameter("currentfacility", currentFacilityId);
			}
		}
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	public int actualCount(String query) {
		Object count = entityManager.createNativeQuery(query).getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	public List<TiOstBeneficiary> findBeneficiaryListForSearch(String searchQuery) {
		List<TiOstBeneficiary> list = entityManager.createNativeQuery(searchQuery, TiOstBeneficiary.class)
				.getResultList();
		return list;
	}

	public List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<TIDispensationExpectedList> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(TIDispensationExpectedList.class)).getResultList();

		return list;
	}

	public List<Facility> facilitySearch(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, Facility.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<Facility> list = nativeQuery.getResultList();
		return list;
	}

	@Override
	public List<ProductSearchProjection> findProductsByAdvanceSearch(String searchQuery,
			Map<String, String> searchValue) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("productname".equals(obj.getName())) {
				nativeQuery.setParameter("productname", "%" + searchValue.get("productname").trim() + "%");
			}
			if ("code".equals(obj.getName())) {
				nativeQuery.setParameter("code", "%" + searchValue.get("shortcode").trim() + "%");
			}
			if ("uom".equals(obj.getName())) {
				nativeQuery.setParameter("uom", Long.valueOf(searchValue.get("uom")));
			}
			if ("producttype".equals(obj.getName())) {
				nativeQuery.setParameter("producttype", Long.valueOf(searchValue.get("producttype")));
			}
			if ("facilitytype".equals(obj.getName())) {
				nativeQuery.setParameter("facilitytype", Long.valueOf(searchValue.get("facilitytype")));
			}
			if ("status".equals(obj.getName())) {
				nativeQuery.setParameter("status", Boolean.valueOf(searchValue.get("status")));
			}
		}
		List<ProductSearchProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(ProductSearchProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<Object[]> findLacListByAdvanceSearch(String searchQuery, Pageable pageable) {
		// List<LinkedFacilityBeneficiary> list =
		// entityManager.createNativeQuery(searchQuery,
		// LinkedFacilityBeneficiary.class).getResultList();
		Query query = entityManager.createNativeQuery(searchQuery);
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<LinkedFacilityBeneficiary> findLacBenListByAdvanceSearch(String searchQuery,Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, LinkedFacilityBeneficiary.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<LinkedFacilityBeneficiary> list = nativeQuery.getResultList();
		return list;
	}

	@Override
	public List<Object[]> regimenAdvanceSearch(String searchQuery, Map<String, String> searchValue) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("constituent".equals(obj.getName())) {
				nativeQuery.setParameter("constituent", Long.valueOf(searchValue.get("constituent")));
			}
			if ("regimenname".equals(obj.getName())) {
				nativeQuery.setParameter("regimenname", "%" + searchValue.get("name").trim() + "%");
			}
			if ("adultpedid".equals(obj.getName())) {
				nativeQuery.setParameter("adultpedid", Long.valueOf(searchValue.get("adultorped")));
			}
			if ("lineid".equals(obj.getName())) {
				nativeQuery.setParameter("lineid", Long.valueOf(searchValue.get("line")));
			}
		}
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Object[]> divisionAdvanceSearch(String searchQuery, Map<String, String> searchValue) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("divisionname".equals(obj.getName())) {
				nativeQuery.setParameter("divisionname", "%" + searchValue.get("name").trim() + "%");
			}
			if ("code".equals(obj.getName())) {
				nativeQuery.setParameter("code", "%" + searchValue.get("code").trim() + "%");
			}
			if ("facilitytype".equals(obj.getName())) {
				nativeQuery.setParameter("facilitytype", Long.valueOf(searchValue.get("facilityType")));
			}
		}
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Object[]> roleAdvanceSearch(String searchQuery, Map<String, String> searchValue) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("facilitytype".equals(obj.getName())) {
				nativeQuery.setParameter("facilitytype", Long.valueOf(searchValue.get("facilityType")));
			}
			if ("name".equals(obj.getName())) {
				nativeQuery.setParameter("name", "%" + searchValue.get("name").trim() + "%");
			}
			if ("primary".equals(obj.getName())) {
				nativeQuery.setParameter("primary", Boolean.valueOf(searchValue.get("primary")));
			}
		}
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Object[]> findIctcreferralsByAdvanceSearchs(String searchQuery, Pageable page) {
		Query query = entityManager.createNativeQuery(searchQuery);

		query.setFirstResult((int) page.getOffset());
		query.setMaxResults(page.getPageSize());
		// List<Object[]> list =
		// entityManager.createNativeQuery(searchQuery).getResultList();
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<ArtDispensation> dispensationAdvanceSerach(String searchQuery) {
		List<ArtDispensation> list = entityManager.createNativeQuery(searchQuery, ArtDispensation.class)
				.getResultList();
		return list;
	}

	@Override
	public List<ArtPepDispensation> pepDispensationAdvanceSearch(String searchQuery) {
		List<ArtPepDispensation> list = entityManager.createNativeQuery(searchQuery, ArtPepDispensation.class)
				.getResultList();
		return list;
	}

	@Override
	public List<LabTestSampleBatch> getReceiveSamplesListByAdvanceSearch(String searchQuery) {
		List<LabTestSampleBatch> list = entityManager.createNativeQuery(searchQuery, LabTestSampleBatch.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityAggregateStockProjection> findUsingSearchValue(String searchQuery) {
		List<FacilityAggregateStockProjection> list = entityManager.createNativeQuery(searchQuery)
				.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(FacilityAggregateStockProjection.class)).getResultList();
		return list;
	}

	@Override
	public long findCountBeneficiaryList(String query) {
		Object count = entityManager.createNativeQuery(query).getResultList().get(0);
		String countString = String.valueOf(count);
		return Long.parseLong(countString);
	}

	@Override
	public List<LabTestSample> getRecordResultsListByAdvanceSearch(String searchQuery) {
		List<LabTestSample> list = entityManager.createNativeQuery(searchQuery, LabTestSample.class).getResultList();
		return list;
	}

	@Override
	public List<ArtBeneficiaryDueList> artBeneficiaryDueListAdvanceSearch(String searchQuery) {
		List<ArtBeneficiaryDueList> list = entityManager.createNativeQuery(searchQuery, ArtBeneficiaryDueList.class)
				.getResultList();
		return list;
	}

	@Override
	public List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		List<TIDispensationExpectedList> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(TIDispensationExpectedList.class)).getResultList();
		return list;
	}

	@Override
	public List<ArtBeneficiaryQueue> artBeneficiaryQueueAdvanceSearch(String searchQuery) {
		List<ArtBeneficiaryQueue> list = entityManager.createNativeQuery(searchQuery, ArtBeneficiaryQueue.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityDispatch> findFacilityDispatchBySearchValue(String searchQuery) {
		List<FacilityDispatch> list = entityManager.createNativeQuery(searchQuery, FacilityDispatch.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityReceipt> findReceiptHistoryBySearchValue(String searchQuery) {
		List<FacilityReceipt> list = entityManager.createNativeQuery(searchQuery, FacilityReceipt.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityReceipt> findFacilityReceiptBySearchValue(String searchQuery) {
		List<FacilityReceipt> list = entityManager.createNativeQuery(searchQuery, FacilityReceipt.class)
				.getResultList();
		return list;
	}

	@Override
	public List<Receipt> findReceiptHistoryBySearchQuery(String searchQuery) {
		List<Receipt> list = entityManager.createNativeQuery(searchQuery, Receipt.class).getResultList();
		return list;
	}

	public List<IndentListSearchprojection> findIndentBySearchValue(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<IndentListSearchprojection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(IndentListSearchprojection.class)).getResultList();
		return list;
	}

	@Override
	public List<FacilityDispatch> findBysearchValue(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, FacilityDispatch.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<FacilityDispatch> list = nativeQuery.getResultList();
		return list;
	}

	@Override
	public List<ContractListProjection> findContractBySearchValue(String searchQuery, Pageable paging) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) paging.getOffset());
		nativeQuery.setMaxResults(paging.getPageSize());
		List<ContractListProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(ContractListProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<UnregisteredSourceReceiptHistoryProjection> findUnregisteredSourceHistoryBySearchQuery(
			String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		@SuppressWarnings("deprecation")
		List<UnregisteredSourceReceiptHistoryProjection> list = nativeQuery
				.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(UnregisteredSourceReceiptHistoryProjection.class))
				.getResultList();
		return list;
	}

	@Override
	public List<GoodsRequest> findGoodsRequestBySearchValue(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, GoodsRequest.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<GoodsRequest> list = nativeQuery.getResultList();
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<DispatchHistorySearchProjection> findDispatchBySearchValue(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<DispatchHistorySearchProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(DispatchHistorySearchProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<DispatchHistorySearchProjection> findDispatchHistoryBySearchValue(String searchQuery,
			Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<DispatchHistorySearchProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(DispatchHistorySearchProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<FacilityDispatch> findFacilityDispatchHistoryBySearch(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, FacilityDispatch.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<FacilityDispatch> list = nativeQuery.getResultList();
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<StockAdjustHistorySearchProjection> findStockAdjustHistory(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<StockAdjustHistorySearchProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(StockAdjustHistorySearchProjection.class))
				.getResultList();
		return list;
	}

	@Override
	public List<GoodsRequest> findGoodsRequestForSacsBySearchValue(String searchQuery) {
		List<GoodsRequest> list = entityManager.createNativeQuery(searchQuery, GoodsRequest.class).getResultList();
		return list;
	}

	@Override
	public List<ProductDosage> findProductDosage(String searchQuery) {
		List<ProductDosage> list = entityManager.createNativeQuery(searchQuery, ProductDosage.class).getResultList();
		return list;
	}

	@Override
	public List<Object[]> productDosageAdvanceSearch(String searchQuery, Map<String, String> searchValue) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			if ("productid".equals(obj.getName())) {
				nativeQuery.setParameter("productid", Long.valueOf(searchValue.get("productId")));
			}
			if ("shortcode".equals(obj.getName())) {
				nativeQuery.setParameter("shortcode", "%" + searchValue.get("shortCode").trim() + "%");
			}
			if ("dosage".equals(obj.getName())) {
				nativeQuery.setParameter("dosage", Long.valueOf(searchValue.get("dosagePerMonth")));
			}
			if ("category".equals(obj.getName())) {
				nativeQuery.setParameter("category", Long.valueOf(searchValue.get("categoryName")));
			}
			if ("weightband".equals(obj.getName())) {
				nativeQuery.setParameter("weightband", Long.valueOf(searchValue.get("weightBand")));
			}
		}
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Object[]> beneficiaryAdvanceSearch(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId) {
		Query nativeQuery = generateNativeQueryForBeneficiary(searchQuery, searchValueMap, facilityId, categoryId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	@Override
	public int beneficiaryResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId) {
		Query nativeQuery = generateNativeQueryForBeneficiary(searchQuery, searchValueMap, facilityId, categoryId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public int lacTotalCount(String searchQuery, Pageable pageable) {
		Query query = entityManager.createNativeQuery(searchQuery);
		Object count = query.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	private Query generateNativeQueryForBeneficiary(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Long facilityId, Long categoryId) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {

			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}

			if ("categoryId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("categoryId", categoryId);
			}

			if ("fullName".equalsIgnoreCase(obj.getName())) {
				String fullName = checkIfUnderscore(searchValueMap.getFirst("fullName"));
				nativeQuery.setParameter("fullName", fullName );
			}
			if ("preArtNumber".equalsIgnoreCase(obj.getName())) {
				String preartNumber = checkIfUnderscore(searchValueMap.getFirst("preArtNumber"));
				nativeQuery.setParameter("preArtNumber", preartNumber );
			}
			if ("artNumber".equalsIgnoreCase(obj.getName())) {
				String artNumber = checkIfUnderscore(searchValueMap.getFirst("artNumber"));
				nativeQuery.setParameter("artNumber", artNumber );
			}
			if ("mobileNumber".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("mobileNumber", searchValueMap.getFirst("mobileNumber"));
			}
			if ("uid".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("uid", searchValueMap.getFirst("uid") );
			}

		}
		return nativeQuery;
	}

	public String checkIfUnderscore(String search) {
		if (search != null && search.contains("_")) {
			search = search.replaceAll("_", "\\\\_");
		}
		return search;

	}

	@Override
	public Integer findCount(String searchQuery) {
		Object count = entityManager.createNativeQuery(searchQuery).getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public Long findReceiptHistoryCount(String countQuery) {
		Object count = entityManager.createNativeQuery(countQuery).getSingleResult();
		String countString = String.valueOf(count);
		return Long.valueOf(countString);
	}

	@Override
	public Long findDispatchSearchCount(String countQuery) {
		Object count = entityManager.createNativeQuery(countQuery).getSingleResult();
		String countString = String.valueOf(count);
		return Long.valueOf(countString);
	}

	@Override
	public Long findUnregisteredSourceHistoryCountBySearchQuery(String countQuery) {
		Object count = entityManager.createNativeQuery(countQuery).getSingleResult();
		String countString = String.valueOf(count);
		return Long.valueOf(countString);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<FacilityListColumnProjection> facilityCommonSearch(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		// List<FacilityListProjection> list = nativeQuery.getResultList();
		List<FacilityListColumnProjection> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class).setResultTransformer(Transformers.aliasToBean(FacilityListColumnProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<ArtPep> artBeneficiaryPepAdvanceSearch(String searchQuery) {
		List<ArtPep> list = entityManager.createNativeQuery(searchQuery, ArtPep.class).getResultList();
		return list;
	}
	
	@Override
	public List<Object[]> dsrcBeneficiaryAdvanceSearch(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId) {
		Query nativeQuery = generateNativeQueryForDsrcBeneficiary(searchQuery, searchValueMap, facilityId, categoryId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	private Query generateNativeQueryForDsrcBeneficiary(String searchQuery,
			MultiValueMap<String, String> searchValueMap, Long facilityId, Long categoryId) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {			
			
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}

			if ("categoryId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("categoryId", categoryId);
			}

			if ("fullName".equalsIgnoreCase(obj.getName())) {
				String fullName = checkIfUnderscore(searchValueMap.getFirst("fullName"));
				nativeQuery.setParameter("fullName", "%" + fullName + "%");
			}
			if ("dsrcCode".equalsIgnoreCase(obj.getName())) {
				String dsrcCode = checkIfUnderscore(searchValueMap.getFirst("dsrcCode"));
				nativeQuery.setParameter("dsrcCode","%" + dsrcCode + "%");
			}
			if ("gender".equalsIgnoreCase(obj.getName())) {				
				Integer genderId = Integer.parseInt(searchValueMap.getFirst("gender"));
				nativeQuery.setParameter("gender", genderId);
			}
			if ("mobileNumber".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("mobileNumber","%" + searchValueMap.getFirst("mobileNumber")  + "%");
			}
			if ("uid".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("uid","%" + searchValueMap.getFirst("uid") + "%");
			}
		}
		return nativeQuery;
	}

	@Override
	public int dsrcBeneficiaryResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId) {
		Query nativeQuery = generateNativeQueryForDsrcBeneficiary(searchQuery, searchValueMap, facilityId, categoryId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public List<Object[]> dsrcBeneficiaryInwardRefAdvSrch(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRef(searchQuery, searchValueMap, facilityId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}
	
	@Override
	public int dsrcBeneficiaryInwardRefResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRef(searchQuery, searchValueMap, facilityId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}
	
	private Query generateNativeQueryForDsrcInwrdRef(String searchQuery,
			MultiValueMap<String, String> searchValueMap, Long facilityId) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);		
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {			
			
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}

			if ("fullName".equalsIgnoreCase(obj.getName())) {
				String fullName = checkIfUnderscore(searchValueMap.getFirst("fullName"));
				nativeQuery.setParameter("fullName", "%" + fullName + "%");
			}
			if ("dsrcCode".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dsrcCode","%" + searchValueMap.getFirst("dsrcCode") + "%");				
			}
			if ("gender".equalsIgnoreCase(obj.getName())) {				
				Integer genderId = Integer.parseInt(searchValueMap.getFirst("gender"));
				nativeQuery.setParameter("gender", genderId);
			}
			if ("mobileNumber".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("mobileNumber","%" + searchValueMap.getFirst("mobileNumber")  + "%");
			}
			if ("uid".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("uid","%" + searchValueMap.getFirst("uid") + "%");
			}
			if ("facilityName".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityName","%" + searchValueMap.getFirst("facilityName") + "%");
			}
			if ("facilityType".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityType","%" + searchValueMap.getFirst("facilityType") + "%");
			}
			if ("edd".equalsIgnoreCase(obj.getName())) {
				LocalDate lcledd = null; 
				String eddDate = searchValueMap.getFirst("edd");
				if (eddDate != null) {
					lcledd = LocalDate.parse(eddDate);
					nativeQuery.setParameter("edd",lcledd);
				}
				
			}
			
			if ("lclFollowUpdate".equalsIgnoreCase(obj.getName())) {
				LocalDate lclFollowUpdate = null; 
				String followUpdate = searchValueMap.getFirst("followUpdate");
				if (followUpdate != null) {
					lclFollowUpdate = LocalDate.parse(followUpdate);
					nativeQuery.setParameter("lclFollowUpdate",lclFollowUpdate);
				}
				
			}
			
			if ("lclfollowUpEnddate".equalsIgnoreCase(obj.getName())) {
				LocalDate lclfollowUpEnddate = null; 
				String followUpEnddate = searchValueMap.getFirst("followUpTodate");
				if (followUpEnddate != null) {
					lclfollowUpEnddate = LocalDate.parse(followUpEnddate);
					nativeQuery.setParameter("lclfollowUpEnddate",lclfollowUpEnddate);
				}
				
			}
			
			if ("lclfollowUpMisseddate".equalsIgnoreCase(obj.getName())) {
				LocalDate lclfollowUpMisseddate = null; 
				String followUpMisseddate = searchValueMap.getFirst("followUpMisseddate");
				if (followUpMisseddate != null) {
					lclfollowUpMisseddate = LocalDate.parse(followUpMisseddate);
					nativeQuery.setParameter("lclfollowUpMisseddate",lclfollowUpMisseddate);
				}
				
			}
		}
		return nativeQuery;
	}
	
	@Override
	public int getdsrcOngoingTreatmentAdvSrchCount(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForOngoingTreatment(searchQuery, searchValueMap, facilityId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public List<Object[]> getdsrcOngoingTreatmentAdvSrch(String searchQuery,
			MultiValueMap<String, String> searchValueMap, Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForOngoingTreatment(searchQuery, searchValueMap,facilityId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	private Query generateNativeQueryForOngoingTreatment(String searchQuery,
			MultiValueMap<String, String> searchValueMap, Long facilityId) {
		
        Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {
			
						
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
			
			if ("startdateOfDiagnosis".equalsIgnoreCase(obj.getName())) {				
				LocalDate lclstartDate = null;
				String startDate = searchValueMap.getFirst("dateOfDiagnosisFrom");
				if (startDate != null) {
					lclstartDate = LocalDate.parse(startDate);
					nativeQuery.setParameter("startdateOfDiagnosis", lclstartDate);
				}				
			}
			
			if ("enddateOfDiagnosis".equalsIgnoreCase(obj.getName())) {
				LocalDate lclendDate = null;
				String endDate = searchValueMap.getFirst("dateOfDiagnosisEnd");
				if (endDate != null) {
					lclendDate = LocalDate.parse(endDate);
					nativeQuery.setParameter("enddateOfDiagnosis", lclendDate);
				}					
			}
		
		if ("fullName".equalsIgnoreCase(obj.getName())) {
			String fullName = checkIfUnderscore(searchValueMap.getFirst("fullName"));
			nativeQuery.setParameter("fullName", "%" + fullName + "%");
		}
		if ("dsrcCode".equalsIgnoreCase(obj.getName())) {
			nativeQuery.setParameter("dsrcCode","%" + searchValueMap.getFirst("dsrcCode") + "%");				
		}
		if ("gender".equalsIgnoreCase(obj.getName())) {				
			Integer genderId = Integer.parseInt(searchValueMap.getFirst("gender"));
			nativeQuery.setParameter("gender", genderId);
		}
		if ("mobileNumber".equalsIgnoreCase(obj.getName())) {
			nativeQuery.setParameter("mobileNumber","%" + searchValueMap.getFirst("mobileNumber")  + "%");
		}
		if ("uid".equalsIgnoreCase(obj.getName())) {
			nativeQuery.setParameter("uid","%" + searchValueMap.getFirst("uid") + "%");
		}
		}
		return nativeQuery;
	}
	
		@Override
	public List<Object[]> dsrcBeneficiaryInwardRefList(String searchQuery, Long facilityId, Pageable pageable) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRefList(searchQuery, facilityId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	@Override
	public int dsrcBeneficiaryInwardRefListCount(String searchQuery, Long facilityId, Pageable pageable) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRefList(searchQuery, facilityId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}
	
	private Query generateNativeQueryForDsrcInwrdRefList(String searchQuery, Long facilityId) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
	
		for (Parameter<?> obj : nativeQuery.getParameters()) {				
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
         }
		return nativeQuery;
	}
	
	private Query generateNativeQueryForDsrcInwrdRefBasicSrch(String searchQuery, Long facilityId, String searchParam) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
	
		for (Parameter<?> obj : nativeQuery.getParameters()) {				
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
			
			if ("searchParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("searchParam", searchParam);
			}
			
			if ("basicsearchParam".equalsIgnoreCase(obj.getName())) {
				String searchText = "%" + searchParam + "%";
				nativeQuery.setParameter("basicsearchParam", searchText);
			}
         }
		return nativeQuery;
	}

	@Override
	public List<Object[]> dsrcBeneficiaryInwardRefBasicSrch(String searchQuery, Long facilityId, Pageable pageable,
			String searchParam) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRefBasicSrch(searchQuery, facilityId,searchParam);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	@Override
	public int dsrcBeneficiaryInwardRefBasicSrchCount(String searchQuery, Long facilityId, Pageable pageable,
			String searchParam) {
		Query nativeQuery = generateNativeQueryForDsrcInwrdRefBasicSrch(searchQuery, facilityId,searchParam);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}
	
	@Override
	public List<Object[]> getDsrcDueListResult(String searchQuery, Pageable pageable, Long facilityId, LocalDate lcledd) {
		Query nativeQuery = generateNativeQueryForDueListResult(searchQuery,facilityId,lcledd);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	private Query generateNativeQueryForDueListResult(String searchQuery, Long facilityId, LocalDate lcledd) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {				
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
			
			if ("edd".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("edd", lcledd);
			}
         }
		return nativeQuery;
	}

	@Override
	public int getDsrcDueListResultCount(String searchQuery, Pageable pageable, Long facilityId, LocalDate lcledd) {
		Query nativeQuery = generateNativeQueryForDueListResult(searchQuery,facilityId,lcledd);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public List<Object[]> getDsrcDueListBasicSrchResult(String searchQuery, Pageable pageable, Long facilityId,
			LocalDate lcledd, String searchParams, String searchText) {
		Query nativeQuery = generateNativeQueryForDueListBasicSrch(searchQuery,facilityId,lcledd,searchParams,searchText);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}

	@Override
	public int getDsrcDueListBasicSrchResultCount(String searchQuery, Pageable pageable, Long facilityId, LocalDate lcledd,
			String searchParams, String searchText) {
		Query nativeQuery = generateNativeQueryForDueListBasicSrch(searchQuery,facilityId,lcledd,searchParams,searchText);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	private Query generateNativeQueryForDueListBasicSrch(String searchQuery, Long facilityId, LocalDate lcledd,
			String searchParams, String searchText) {
            Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {				
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
			
			if ("edd".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("edd", lcledd);
			}
			
			if ("searchParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("searchParam", searchParams);
			}
			
			if ("searchBasic".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("searchBasic", searchText);
			}
			
			
         }
		return nativeQuery;
	}

	@Override
	public int getdsrcCompletedTreatmentAdvSrchCount(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForOngoingTreatment(searchQuery, searchValueMap, facilityId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	@Override
	public List<Object[]> getdsrcCompletedTreatmentAdvSrch(String searchQuery,
			MultiValueMap<String, String> searchValueMap, Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForOngoingTreatment(searchQuery, searchValueMap,facilityId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}
	@Override
	public List<Object[]> getAllViralLoadPreviouDispatchedSamplesByAdvanceSearch(String searchQuery,Pageable pageable) {
		Query query = entityManager.createNativeQuery(searchQuery);
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object[]> list = query.getResultList();
		return list;
	}
	
		@Override
	public List<Object[]> hiv2LabsTestResultAdvanceSearch(String searchQuery, MultiValueMap<String, String> paramsMap,
			Pageable pageable, Long facilityId) {
		Query nativeQuery = generateNativeQueryForHiv2LabAdvSrch(searchQuery,paramsMap, facilityId);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		return nativeQuery.getResultList();
	}
	
	@Override
	public List<Object[]> artBeneficiaryQueueListAdvanceSearch(String searchQuery, Pageable pageable) {
//		List<ArtBeneficiaryQueue> list = entityManager.createNativeQuery(searchQuery, ArtBeneficiaryQueue.class)
//				.getResultList();
//		return list;
		Query query = entityManager.createNativeQuery(searchQuery);
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object[]> list = query.getResultList();
		return list;
		
	}
	
	@Override
	public int queueListTotalCount(String searchQuery, Pageable pageable) {
		Query query = entityManager.createNativeQuery(searchQuery);
		Object count = query.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	private Query generateNativeQueryForHiv2LabAdvSrch(String searchQuery, MultiValueMap<String, String> paramsMap, Long facilityId) {
      
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		
		for (Parameter<?> obj : nativeQuery.getParameters()) {	
			
			if ("facilityId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("facilityId", facilityId);
			}
			
			if ("stateId".equalsIgnoreCase(obj.getName())) {				
				String state = paramsMap.getFirst("state");
				Long stateId = Long.parseLong(state);
				nativeQuery.setParameter("stateId", stateId);
			}
			
			if ("districtId".equalsIgnoreCase(obj.getName())) {
				String district = paramsMap.getFirst("district");
				Long districtId = Long.parseLong(district);
				nativeQuery.setParameter("districtId", districtId);
			}
			
			if ("resultDate".equalsIgnoreCase(obj.getName())) {
				LocalDate lclresultDate = null;
				String resultDate = paramsMap.getFirst("resultDate");
				if (resultDate != null) {
					lclresultDate = LocalDate.parse(resultDate);
					nativeQuery.setParameter("resultDate", lclresultDate);
				}					
			}
			
			if ("ictcId".equalsIgnoreCase(obj.getName())) {
				String ictc = paramsMap.getFirst("ictc");
				Long ictcFacId = Long.parseLong(ictc);
				nativeQuery.setParameter("ictcId", ictcFacId);
			}			
         }
		return nativeQuery;

	}

	@Override
	public int hiv2LabsTestResultCount(String searchQuery, MultiValueMap<String, String> paramsMap, Pageable pageable , Long facilityId) {
		Query nativeQuery = generateNativeQueryForHiv2LabAdvSrch(searchQuery, paramsMap,facilityId);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}
	
	@Override
	public List<Object[]> findPrisonByAdvanceSearch(String searchQuery, Pageable pageable , Integer facilityId) {
		Query query = entityManager.createNativeQuery(searchQuery);
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object[]> list = query.getResultList();
		return list;
		
//		List<Object[]> list = entityManager.createNativeQuery(searchQuery, PrisonQuestionnierResult.class).getResultList();
//		return list;
	}	
	
	@Override
	public int findPrisonCountByAdvanceSearch(String searchQuery,Pageable pageable, Integer facilityId) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		Object count = nativeQuery.getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);		
	}

}
