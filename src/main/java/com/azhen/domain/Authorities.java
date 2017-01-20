package com.azhen.domain;

import java.math.BigDecimal;

public class Authorities {
    private Integer id;

    private String name;

    private String displayName;

    private String authoritiesType;

    private BigDecimal authoritiesId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
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
}