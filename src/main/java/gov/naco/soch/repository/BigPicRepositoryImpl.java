package gov.naco.soch.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class BigPicRepositoryImpl implements BigPicRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Set<Long> getPlhivDaigonsedBenediicaryList(String searchQuery, Timestamp dateFrom,
			Timestamp dateTo, Integer stateId, List<Integer> genderParam, List<Integer> typologyParam) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {	
			if ("dateFrom".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateFrom", dateFrom);
			}
			if ("dateTo".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateTo", dateTo);
			}
			if ("stateId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("stateId", stateId);
			}
			
			if ("genderParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("genderParam", genderParam);
			}
			
			if ("typologyParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("typologyParam", typologyParam);
			}
						
         }
		return new HashSet<Long>(nativeQuery.getResultList());
	}
	
	@Override
	public BigInteger getEverregisteredPlhivTillYearWithFilter(String searchQuery,
			Timestamp dateTo, Integer stateId, List<Integer> genderParam, List<Integer> typologyParam) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {	
			
			if ("dateTo".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateTo", dateTo);
			}
			if ("stateId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("stateId", stateId);
			}
			
			if ("genderParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("genderParam", genderParam);
			}
			
			if ("typologyParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("typologyParam", typologyParam);
			}
						
         }
	
		return (BigInteger)nativeQuery.getSingleResult();
	}
	
	@Override
	public BigInteger getOnArtPlhivTillYearWithFilter(String searchQuery,
			Timestamp dateTo, Integer stateId, List<Integer> genderParam, List<Integer> typologyParam) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {	
			
			if ("dateTo".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateTo", dateTo);
			}
			if ("stateId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("stateId", stateId);
			}
			
			if ("genderParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("genderParam", genderParam);
			}
			
			if ("typologyParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("typologyParam", typologyParam);
			}
						
         }
		return (BigInteger)nativeQuery.getSingleResult();
	}
	
	@Override
	public BigInteger getVirallySuppessedPlhivTillYearWithFilter(String searchQuery, Timestamp dateFrom,
			Timestamp dateTo, Integer stateId, List<Integer> genderParam, List<Integer> typologyParam) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		for (Parameter<?> obj : nativeQuery.getParameters()) {	
			if ("dateFrom".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateFrom", dateFrom);
			}
			if ("dateTo".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("dateTo", dateTo);
			}
			if ("stateId".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("stateId", stateId);
			}
			
			if ("genderParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("genderParam", genderParam);
			}
			
			if ("typologyParam".equalsIgnoreCase(obj.getName())) {
				nativeQuery.setParameter("typologyParam", typologyParam);
			}
						
         }
		return (BigInteger)nativeQuery.getSingleResult();
	}

	@Override
	public BigInteger getVlTestedPlhivWithFilter(String searchQuery, Timestamp dateFrom, Timestamp dateTo, Integer stateId,
			List<Integer> genderParam, List<Integer> typologyParam) {
		
			Query nativeQuery = entityManager.createNativeQuery(searchQuery);
			for (Parameter<?> obj : nativeQuery.getParameters()) {	
				if ("dateFrom".equalsIgnoreCase(obj.getName())) {
					nativeQuery.setParameter("dateFrom", dateFrom);
				}
				if ("dateTo".equalsIgnoreCase(obj.getName())) {
					nativeQuery.setParameter("dateTo", dateTo);
				}
				if ("stateId".equalsIgnoreCase(obj.getName())) {
					nativeQuery.setParameter("stateId", stateId);
				}
				
				if ("genderParam".equalsIgnoreCase(obj.getName())) {
					nativeQuery.setParameter("genderParam", genderParam);
				}
				
				if ("typologyParam".equalsIgnoreCase(obj.getName())) {
					nativeQuery.setParameter("typologyParam", typologyParam);
				}
							
	         }
			return (BigInteger)nativeQuery.getSingleResult();
	}

}
