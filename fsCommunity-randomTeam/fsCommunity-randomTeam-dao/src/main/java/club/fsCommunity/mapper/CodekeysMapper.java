package club.fsCommunity.mapper;

import club.fsCommunity.pojo.Codekeys;
import club.fsCommunity.pojo.CodekeysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodekeysMapper {
    int countByExample(CodekeysExample example);

    int deleteByExample(CodekeysExample example);

    int deleteByPrimaryKey(String id);

    int insert(Codekeys record);

    int insertSelective(Codekeys record);

    List<Codekeys> selectByExample(CodekeysExample example);

    Codekeys selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Codekeys record, @Param("example") CodekeysExample example);

    int updateByExample(@Param("record") Codekeys record, @Param("example") CodekeysExample example);

    int updateByPrimaryKeySelective(Codekeys record);

    int updateByPrimaryKey(Codekeys record);
}