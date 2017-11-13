package com.wugq.taotao.test.service.impl;


import com.wugq.taotao.test.mapper.SysUserMapper;
import com.wugq.taotao.test.pojo.SysUser;
import com.wugq.taotao.test.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserMapper sysUserMapper;


	@Override
	public SysUser getById(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
}
