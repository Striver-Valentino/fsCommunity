package club.fsCommunity.mapper;

import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameMapper {
    int countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(String id);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExampleWithBLOBs(GameExample example);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExampleWithBLOBs(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKeyWithBLOBs(Game record);

    int updateByPrimaryKey(Game record);
}