package club.fsCommunity.mapper;

import club.fsCommunity.pojo.TeamVs;
import club.fsCommunity.pojo.TeamVsExample;
import club.fsCommunity.pojo.TeamVsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamVsMapper {
    int countByExample(TeamVsExample example);

    int deleteByExample(TeamVsExample example);

    int deleteByPrimaryKey(TeamVsKey key);

    int insert(TeamVs record);

    int insertSelective(TeamVs record);

    List<TeamVs> selectByExampleWithBLOBs(TeamVsExample example);

    List<TeamVs> selectByExample(TeamVsExample example);

    TeamVs selectByPrimaryKey(TeamVsKey key);

    int updateByExampleSelective(@Param("record") TeamVs record, @Param("example") TeamVsExample example);

    int updateByExampleWithBLOBs(@Param("record") TeamVs record, @Param("example") TeamVsExample example);

    int updateByExample(@Param("record") TeamVs record, @Param("example") TeamVsExample example);

    int updateByPrimaryKeySelective(TeamVs record);

    int updateByPrimaryKeyWithBLOBs(TeamVs record);

    int updateByPrimaryKey(TeamVs record);
}