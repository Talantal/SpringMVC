package qin.com.mapper;

import org.apache.ibatis.annotations.Param;
import qin.com.entity.Jc;
import qin.com.entity.JcWithBLOBs;

import java.util.List;

public interface JcMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(JcWithBLOBs record);

    int insertSelective(JcWithBLOBs record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JcWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record);

    int updateByPrimaryKey(Jc record);

    List<Jc> selectAll();
}