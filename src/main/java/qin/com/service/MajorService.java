package qin.com.service;

import org.apache.ibatis.annotations.Param;
import qin.com.entity.Major;

import java.util.List;

public interface MajorService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
    List<Major> selectAll();
}
