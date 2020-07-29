package qin.com.service;

import qin.com.entity.Course;

import java.util.List;

public interface CourseService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    List<Course> selectAll();
}
