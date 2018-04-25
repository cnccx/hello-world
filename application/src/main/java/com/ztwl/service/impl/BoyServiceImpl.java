package com.ztwl.service.impl;

import com.ztwl.common.exception.MyException;
import com.ztwl.dao.BoyDao;
import com.ztwl.exception.MyResultEnum;
import com.ztwl.model.BoyPo;
import com.ztwl.service.BoyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class BoyServiceImpl implements BoyService, Serializable {

    protected static Logger logger = LogManager.getLogger(BoyServiceImpl.class);

    @Autowired(required = false)
    private BoyDao boyDao;

    @Override
    public BoyPo add(BoyPo boyPo) {
        return boyDao.save(boyPo);
    }

    @Override
    public void delete(Integer id) {
        boyDao.delete(id);
    }

    @Override
    public List<BoyPo> findByAge(int id) {
        return boyDao.findByAge(id);
    }

    @Override
    public BoyPo save(BoyPo boyPo) {
        return boyDao.save(boyPo);
    }

    @Override
    @Cacheable(value = "usercache", key = "'selectUserById:id_'+#id")
    public BoyPo findOne(Integer id) {
        // 简单校验id
        if (id < 0) {
            throw new MyException(MyResultEnum.BOY_ID_ERROR, new BoyPo());
        }
        return boyDao.findOne(id);
    }

    @Override
    public List<BoyPo> findAll() {
        return boyDao.findAll();
    }

    @Override
    public Iterable<BoyPo> getBoyPageList(Pageable pageable){ return boyDao.findAll(pageable);}

    @Override
    public Iterable<BoyPo> getBoySortList(Sort sort) {
        return boyDao.findAll(sort);
    }
}
