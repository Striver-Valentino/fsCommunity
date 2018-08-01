package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Enroll;

public interface EnrollService {

	
	Map<String,Object> addEnroll(Enroll enroll);
	
	
	List<Enroll> selectEnrollByGameIdAndUserId(String gameId,String userId);
	
	
	List<Enroll> selectEnrollByUserId(String gameId);
	
	
	LayuiTableData selectUserByGameId(String gameId,Integer page,Integer limit);
	
	
	List<Enroll> selectEnrollByEnrollId(String enrollId);
	
	
	Map<String,Object> updateEnrollAbilityScore(String enrollId,Integer abilityScore);
	
	
	
	
}
