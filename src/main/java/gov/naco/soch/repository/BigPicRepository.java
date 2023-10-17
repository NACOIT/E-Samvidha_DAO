package gov.naco.soch.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface BigPicRepository {
	

    Set<Long> getPlhivDaigonsedBenediicaryList(String searchQuery, 
    		Timestamp dateFrom, Timestamp dateTo, Integer stateId , List<Integer> genderParam,
    		List<Integer> typologyParam);
    
    BigInteger getEverregisteredPlhivTillYearWithFilter(String string, Timestamp dateTo, Integer stateId,
			List<Integer> genderParam, List<Integer> typologyParam);
    

    BigInteger getOnArtPlhivTillYearWithFilter(String string, Timestamp dateTo, Integer stateId,
			List<Integer> genderParam, List<Integer> typologyParam);
	
    BigInteger getVirallySuppessedPlhivTillYearWithFilter(String string, Timestamp dateFrom, Timestamp dateTo,
			Integer stateId, List<Integer> genderParam, List<Integer> typologyParam);
	
    BigInteger getVlTestedPlhivWithFilter(String string, Timestamp dateFrom, Timestamp dateTo,
			Integer stateId, List<Integer> genderParam, List<Integer> typologyParam);
	



}
