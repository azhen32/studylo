package com.azhen.service;

import com.azhen.domain.Authorities;
import com.azhen.dto.EUTreeNode;

import java.util.List;

/**
 * Created by azhen on 17-2-4.
 */
public interface AuthorityService {
    List<EUTreeNode> getAuthList(Long parentId);

    Authorities save(Authorities auth);

    Integer update(Authorities auth);

    Integer delete(Authorities auth);

}
