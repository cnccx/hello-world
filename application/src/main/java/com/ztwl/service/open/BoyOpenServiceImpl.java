package com.ztwl.service.open;

import com.alibaba.dubbo.config.annotation.Service;
import com.ztwl.facade.BoyOpenService;
import com.ztwl.model.Words;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Service(interfaceClass = BoyOpenService.class,version = "1.0.0")
@Component
public class BoyOpenServiceImpl implements BoyOpenService {
    @Override
    public Words sayHello() {
        Words words = new Words();
        words.setFirst("hello");
        words.setSecond("world");
        return words;
    }
}
