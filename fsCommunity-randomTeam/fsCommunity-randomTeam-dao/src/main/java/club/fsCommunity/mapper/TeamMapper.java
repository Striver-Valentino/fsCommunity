package club.fsCommunity.mapper;

import club.fsCommunity.pojo.Team;
import club.fsCommunity.pojo.TeamExample;
import club.fsCommunity.pojo.TeamKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {
    int countByExample(TeamExample example);

    int deleteByExample(TeamExample example);

    int deleteByPrimaryKey(TeamKey key);

    int insert(Team record);

    int insertSelective(Team record);

    List<Team> selectByExampleWithBLOBs(TeamExample example);

    List<Team> selectByExample(TeamExample example);

    Team selectByPrimaryKey(TeamKey key);

    int updateByExampleSelective(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByExampleWithBLOBs(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKeyWithBLOBs(Team record);

    int updateByPrimaryKey(Team record);
}