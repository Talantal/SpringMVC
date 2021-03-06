package qin.com.mapper;

import org.apache.ibatis.annotations.Param;
import qin.com.entity.Classse;

import java.util.List;

public interface ClassseMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Classse record);

    int insertSelective(Classse record);

    Classse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classse record);

    int updateByPrimaryKey(Classse record);

    List <Classse> selectAll();//查询所有班级信息
}