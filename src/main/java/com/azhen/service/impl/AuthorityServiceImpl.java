package com.azhen.service.impl;

import com.azhen.domain.Authorities;
import com.azhen.domain.AuthoritiesExample;
import com.azhen.dto.EUTreeNode;
import com.azhen.mapper.AuthoritiesMapper;
import com.azhen.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by azhen on 17-2-4.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthoritiesMapper authoritiesMapper;
    @Override
    public List<EUTreeNode> getAuthList(Long parentId) {
        AuthoritiesExample example = new AuthoritiesExample();
        AuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusEqualTo((byte)0x01);
        List<Authorities> list = authoritiesMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for(Authorities auth : list) {
            EUTreeNode treeNode = new EUTreeNode(auth.getId(),auth.getDisplayName(),auth.getIsParent()? "closed":"open");
            resultList.add(treeNode);
        }
        return resultList;
    }

    @Override
    public Authorities save(Authorities child) {
        Authorities parent = authoritiesMapper.selectByPrimaryKey(child.getParentId());
        Date now = new Date();
        if(!parent.getIsParent()) {
            parent.setIsParent(true);
            parent.setUpdateTime(now);
        }
        child.setCreateTime(now);
        child.setUpdateTime(now);
        child.setStatus((byte)0x01);
        child.setIsParent(false);
        authoritiesMapper.updateByPrimaryKeySelective(parent);
        int result = authoritiesMapper.insert(child);
        return child;
    }

    @Override
    public Integer update(Authorities auth) {
       return authoritiesMapper.updateByPrimaryKeySelective(auth);
    }

    @Override
    public Integer delete(Authorities auth) {
        auth = authoritiesMapper.selectByPrimaryKey(auth.getId());
        auth.setStatus((byte)0x00);
        Integer result = authoritiesMapper.updateByPrimaryKeySelective(auth);

        AuthoritiesExample example = new AuthoritiesExample();
        AuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(auth.getParentId());
        criteria.andStatusEqualTo((byte)0x01);
        Integer num = authoritiesMapper.countByExample(example);
        if(0 == num) {
            Authorities parent = new Authorities();
            parent.setId(auth.getParentId());
            parent.setIsParent(false);
            authoritiesMapper.updateByPrimaryKeySelective(parent);
        }
        return result;
    }


}
