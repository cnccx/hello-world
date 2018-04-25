package com.ztwl.service;

import com.ztwl.model.BoyPo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author Administrator
 */
public interface BoyService {

    BoyPo add(BoyPo boyPo);

    void delete(Integer id);

    List<BoyPo> findByAge(int id);

    BoyPo save(BoyPo boyPo);

    BoyPo findOne(Integer id);

    List<BoyPo> findAll();

    Iterable<BoyPo> getBoyPageList(Pageable pageable);

    Iterable<BoyPo> getBoySortList(Sort sort);
}
