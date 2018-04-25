package com.ztwl.controller;

import com.ztwl.common.utils.RedisUtils;
import com.ztwl.model.BoyDto;
import com.ztwl.model.BoyPo;
import com.ztwl.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/boy")
public class BoyController {

    @Autowired
    private BoyService boyService;

    @Autowired(required = false)
    private RedisUtils redisUtils;

    @RequestMapping(value = "/boydetail/{id}")
    public BoyDto detail(@PathVariable("id") Integer id) {

        BoyPo boyPo = boyService.findOne(id);
        BoyDto boyDto = new BoyDto();
        boyDto.setAge(boyPo.getAge());
        boyDto.setBoyName(boyPo.getName());
        return boyDto;
    }

    @RequestMapping("/all")
    public List<BoyPo> findAll() {
        return boyService.findAll();
    }

    @RequestMapping("/auth/hello")
    public String hello(){
        System.out.println("111111 hello");
        return "hello";
    }

    @RequestMapping("/auth/hello123")
    public String hello123(){
        System.out.println("111111 hello123");
        return "hello123";
    }

    /**
     * 增加
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/add")
    public BoyPo add(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        BoyPo boyPo = new BoyPo();
        boyPo.setAge(age);
        boyPo.setName(name);
        return boyService.add(boyPo);
    }

    @RequestMapping("/pagelist")
    public ResponseEntity<?> getList(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="10") int size ) {

        Pageable pageable = new PageRequest(page, size);
        return new ResponseEntity<Object>(boyService.getBoyPageList(pageable), HttpStatus.OK);
    }

    @GetMapping("/sortlist")
    public ResponseEntity<?> getSortList(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="10") int size ) {

        Sort sort = new Sort(Sort.Direction.DESC, "age");
        // Pageable pageable = new PageRequest(page, size);
        return new ResponseEntity<Object>(boyService.getBoySortList(sort), HttpStatus.OK);
    }

    /**
     * 更新
     * @param id
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/update/{id}")
    public BoyPo update(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        BoyPo boyPo = new BoyPo();
        boyPo.setId(id);
        boyPo.setAge(age);
        boyPo.setName(name);
        return boyService.save(boyPo);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        boyService.delete(id);
    }

    /**
     * id查找
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public BoyPo findOne(@PathVariable(name = "id") Integer id){
        return boyService.findOne(id);
    }

    /**
     * age查找
     * @param age
     * @return
     */
    @RequestMapping("/findByAge/{id}")
    public List<BoyPo> findByAge(@PathVariable(name = "id")int age){
        return boyService.findByAge(age);
    }

    /**
     * 添加数据到redis中
     */
	@RequestMapping(value = "/addRedis", method = RequestMethod.GET)
	public void add(){
		System.out.println("================addRedis=================");
		this.redisUtils.hmSet("a","test:aaa","123456");
		BoyPo boyPo = new BoyPo();
        boyPo.setId(22);
        boyPo.setName("xiaoming");
        boyPo.setAge(5);

		this.redisUtils.add("boyPo:1",boyPo);
		this.redisUtils.set("boySet:1",boyPo);
		this.redisUtils.zAdd("boyZset:1",boyPo,100);
		List<BoyPo> list = new ArrayList<>();
		list.add(boyPo);
		this.redisUtils.lPush("boyList:1",list);
	}

    @RequestMapping(value = "/test_exception")
	public Object exception() {
	    // 自定义一个非法的id
	    int id = -1;
        return boyService.findOne(id);
    }
}
