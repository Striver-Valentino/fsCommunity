package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Enroll;

public interface EnrollService {

	/**
	 * 添加报名信息（说明有用户在报名页面报名了一个赛事）
	 * @param enroll
	 * @return
	 */
	Map<String,Object> addEnroll(Enroll enroll);
	
	/**
	 * 根据 赛事id 与 用户id 查找 报名信息（可以检查 一个用户 是否 多次 报 同一个 赛事）
	 * @return
	 */
	List<Enroll> selectEnrollByGameIdAndUserId(String gameId,String userId);
	
	/**
	 * 根据 用户id 查找 报名信息
	 * @param enroll
	 * @return
	 */
	List<Enroll> selectEnrollByUserId(String gameId);
	
	/**
	 * 根据 gameId 查找 参赛用户，封装成 layui 表格 需要的 带有 分页信息 的 实体  LayuiTableData
	 * @param gameId
	 * @param page
	 * @param limit
	 * @return
	 */
	LayuiTableData selectUserByGameId(String gameId,Integer page,Integer limit);
	
	/**
	 * 根据 报名信息id 查找 报名信息
	 * @param enroll
	 * @return
	 */
	List<Enroll> selectEnrollByEnrollId(String enrollId);
	
	/**
	 * 更新 报名信息 的 能力 分值
	 * @param enrollId
	 * @param abilityScore
	 * @return
	 */
	Map<String,Object> updateEnrollAbilityScore(String enrollId,Integer abilityScore);
	
	
	
	
}
