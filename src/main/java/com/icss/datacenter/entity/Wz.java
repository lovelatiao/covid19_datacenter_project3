package com.icss.datacenter.entity;

/**
 * @author laohe
 * @company bigdata
 * @create 2022-12-28 9:41
 * 物资实体类
 */
public class Wz {
    private String name;//物资名称
    private Integer cg;//采购数量
    private Integer xb;//下拨数量
    private Integer jz;//捐赠
    private Integer xh;//消耗数量
    private Integer xq;//需求数量
    private Integer kc;//库存
    private String srcName;//修改前物资的名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCg() {
        return cg;
    }

    public void setCg(Integer cg) {
        this.cg = cg;
    }

    public Integer getXb() {
        return xb;
    }

    public void setXb(Integer xb) {
        this.xb = xb;
    }

    public Integer getJz() {
        return jz;
    }

    public void setJz(Integer jz) {
        this.jz = jz;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public Integer getXq() {
        return xq;
    }

    public void setXq(Integer xq) {
        this.xq = xq;
    }

    public Integer getKc() {
        return kc;
    }

    public void setKc(Integer kc) {
        this.kc = kc;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public Wz() {
    }

    public Wz(String name, Integer cg, Integer xb, Integer jz, Integer xh, Integer xq, Integer kc, String srcName) {
        this.name = name;
        this.cg = cg;
        this.xb = xb;
        this.jz = jz;
        this.xh = xh;
        this.xq = xq;
        this.kc = kc;
        this.srcName = srcName;
    }

    @Override
    public String toString() {
        return "Wz{" +
                "name='" + name + '\'' +
                ", cg=" + cg +
                ", xb=" + xb +
                ", jz=" + jz +
                ", xh=" + xh +
                ", xq=" + xq +
                ", kc=" + kc +
                ", srcName='" + srcName + '\'' +
                '}';
    }
}
