package com.azhen.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Authorities {
    private Long id;

    private Long parentId;

    private Boolean isParent;

    private String authoritiesType;

    private BigDecimal authoritiesId;

    private Integer sortOrder;

    private Byte status;

    private String displayName;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public String getAuthoritiesType() {
        return authoritiesType;
    }

    public void setAuthoritiesType(String authoritiesType) {
        this.authoritiesType = authoritiesType == null ? null : authoritiesType.trim();
    }

    public BigDecimal getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(BigDecimal authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}