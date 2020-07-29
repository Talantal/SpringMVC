package qin.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qin.com.entity.Classse;
import qin.com.mapper.ClassseMapper;
import qin.com.service.ClassseService;

import java.util.List;


@Service("classseServiceImpl")
public class ClassseServiceImpl implements ClassseService {

    @Autowired
    private ClassseMapper classseMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByList(String[] deleteids) {
        return classseMapper.deleteByList(deleteids);
    }

    @Override
    public int insert(Classse record) {
        return classseMapper.insert(record);
    }

    @Override
    public int insertSelective(Classse record) {
        return classseMapper.insertSelective(record);
    }

    @Override
    public Classse selectByPrimaryKey(Integer id) {
        return classseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classse record) {
        return classseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classse record) {
        return classseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Classse> selectAll() {
        return classseMapper.selectAll();
    }
}
