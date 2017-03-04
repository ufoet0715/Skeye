package com.xqls.bean;

public class BlockBean {

	private Integer blockId;

    private Integer praentId;

    private String blockName;

    private String blockUrl;

    private Integer blockState;

    private Integer reserved1;

    private String reserved2;

    private String tenantNo;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getPraentId() {
        return praentId;
    }

    public void setPraentId(Integer praentId) {
        this.praentId = praentId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockUrl() {
        return blockUrl;
    }

    public void setBlockUrl(String blockUrl) {
        this.blockUrl = blockUrl;
    }

    public Integer getBlockState() {
        return blockState;
    }

    public void setBlockState(Integer blockState) {
        this.blockState = blockState;
    }

    public Integer getReserved1() {
        return reserved1;
    }

    public void setReserved1(Integer reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public String getTenantNo() {
        return tenantNo;
    }

    public void setTenantNo(String tenantNo) {
        this.tenantNo = tenantNo;
    }
}