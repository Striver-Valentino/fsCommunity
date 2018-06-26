package club.fsCommunity.mapper;

import club.fsCommunity.pojo.Gameresult;
import club.fsCommunity.pojo.GameresultExample;
import club.fsCommunity.pojo.GameresultKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameresultMapper {
    int countByExample(GameresultExample example);

    int deleteByExample(GameresultExample example);

    int deleteByPrimaryKey(GameresultKey key);

    int insert(Gameresult record);

    int insertSelective(Gameresult record);

    List<Gameresult> selectByExampleWithBLOBs(GameresultExample example);

    List<Gameresult> selectByExample(GameresultExample example);

    Gameresult selectByPrimaryKey(GameresultKey key);

    int updateByExampleSelective(@Param("record") Gameresult record, @Param("example") GameresultExample example);

    int updateByExampleWithBLOBs(@Param("record") Gameresult record, @Param("example") GameresultExample example);

    int updateByExample(@Param("record") Gameresult record, @Param("example") GameresultExample example);

    int updateByPrimaryKeySelective(Gameresult record);

    int updateByPrimaryKeyWithBLOBs(Gameresult record);

    int updateByPrimaryKey(Gameresult record);
}