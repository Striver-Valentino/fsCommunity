package club.fsCommunity.mapper;

import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.EnrollExample;
import club.fsCommunity.pojo.EnrollKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnrollMapper {
    int countByExample(EnrollExample example);

    int deleteByExample(EnrollExample example);

    int deleteByPrimaryKey(EnrollKey key);

    int insert(Enroll record);

    int insertSelective(Enroll record);

    List<Enroll> selectByExampleWithBLOBs(EnrollExample example);

    List<Enroll> selectByExample(EnrollExample example);

    Enroll selectByPrimaryKey(EnrollKey key);

    int updateByExampleSelective(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByExampleWithBLOBs(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByExample(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByPrimaryKeySelective(Enroll record);

    int updateByPrimaryKeyWithBLOBs(Enroll record);

    int updateByPrimaryKey(Enroll record);
}