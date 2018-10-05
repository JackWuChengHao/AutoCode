package com.xiaowu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private String line;

    private String line1;

    private Blob bollo;

    private String enuma;

    private String numEnuma;

    @TableId(value = "idid", type = IdType.AUTO)
    private Long idid;


    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Blob getBollo() {
        return bollo;
    }

    public void setBollo(Blob bollo) {
        this.bollo = bollo;
    }

    public String getEnuma() {
        return enuma;
    }

    public void setEnuma(String enuma) {
        this.enuma = enuma;
    }

    public String getNumEnuma() {
        return numEnuma;
    }

    public void setNumEnuma(String numEnuma) {
        this.numEnuma = numEnuma;
    }

    public Long getIdid() {
        return idid;
    }

    public void setIdid(Long idid) {
        this.idid = idid;
    }

    @Override
    public String toString() {
        return "Test{" +
        "line=" + line +
        ", line1=" + line1 +
        ", bollo=" + bollo +
        ", enuma=" + enuma +
        ", numEnuma=" + numEnuma +
        ", idid=" + idid +
        "}";
    }
}
