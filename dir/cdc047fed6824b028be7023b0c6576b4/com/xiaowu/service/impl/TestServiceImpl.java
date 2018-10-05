package com.xiaowu.service.impl;

import com.xiaowu.entity.Test;
import com.xiaowu.mapper.TestMapper;
import com.xiaowu.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
