package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class SensorDatas implements Serializable {
    private int ID; //主键  自增
    private int BOAT_ID;
    private String BOAT_CODE; //船的代码
    private String BOAT_NAME; //船的名字
    private int DEVICE_ID;
    private String DEVICE_CODE;
    private String DEVICE_NAME;
    private String P1;
    private String P2;
    private String P3;
    private String P4;
    private String P5;
    private String P6;
    private String P7;
    private String P8;
    private String P9;
    private String P10;
    private String P11;
    private String P12;
    private String P13;
    private String T1;
    private String T2;
    private String T3;
    private String T4;
    private String T5;
    private String T6;
    private String T7;
    private String T8;
    private String T9;
    private String V1;
    private String TIME;
    private Integer IS_DELETE;
    private LocalDateTime CREATED_AT;
    private LocalDateTime UPDATED_AT;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBOAT_ID() {
        return BOAT_ID;
    }

    public void setBOAT_ID(int BOAT_ID) {
        this.BOAT_ID = BOAT_ID;
    }

    public int getDEVICE_ID() {
        return DEVICE_ID;
    }

    public void setDEVICE_ID(int DEVICE_ID) {
        this.DEVICE_ID = DEVICE_ID;
    }

    public String getBOAT_CODE() {
        return BOAT_CODE;
    }

    public void setBOAT_CODE(String BOAT_CODE) {
        this.BOAT_CODE = BOAT_CODE;
    }

    public String getBOAT_NAME() {
        return BOAT_NAME;
    }

    public void setBOAT_NAME(String BOAT_NAME) {
        this.BOAT_NAME = BOAT_NAME;
    }


    public String getDEVICE_CODE() {
        return DEVICE_CODE;
    }

    public void setDEVICE_CODE(String DEVICE_CODE) {
        this.DEVICE_CODE = DEVICE_CODE;
    }

    public String getDEVICE_NAME() {
        return DEVICE_NAME;
    }

    public void setDEVICE_NAME(String DEVICE_NAME) {
        this.DEVICE_NAME = DEVICE_NAME;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String p2) {
        P2 = p2;
    }

    public String getP3() {
        return P3;
    }

    public void setP3(String p3) {
        P3 = p3;
    }

    public String getP4() {
        return P4;
    }

    public void setP4(String p4) {
        P4 = p4;
    }

    public String getP5() {
        return P5;
    }

    public void setP5(String p5) {
        P5 = p5;
    }

    public String getP6() {
        return P6;
    }

    public void setP6(String p6) {
        P6 = p6;
    }

    public String getP7() {
        return P7;
    }

    public void setP7(String p7) {
        P7 = p7;
    }

    public String getP8() {
        return P8;
    }

    public void setP8(String p8) {
        P8 = p8;
    }

    public String getP9() {
        return P9;
    }

    public void setP9(String p9) {
        P9 = p9;
    }

    public String getP10() {
        return P10;
    }

    public void setP10(String p10) {
        P10 = p10;
    }

    public String getP11() {
        return P11;
    }

    public void setP11(String p11) {
        P11 = p11;
    }

    public String getP12() {
        return P12;
    }

    public void setP12(String p12) {
        P12 = p12;
    }

    public String getP13() {
        return P13;
    }

    public void setP13(String p13) {
        P13 = p13;
    }

    public String getT1() {
        return T1;
    }

    public void setT1(String t1) {
        T1 = t1;
    }

    public String getT2() {
        return T2;
    }

    public void setT2(String t2) {
        T2 = t2;
    }

    public String getT3() {
        return T3;
    }

    public void setT3(String t3) {
        T3 = t3;
    }

    public String getT4() {
        return T4;
    }

    public void setT4(String t4) {
        T4 = t4;
    }

    public String getT5() {
        return T5;
    }

    public void setT5(String t5) {
        T5 = t5;
    }

    public String getT6() {
        return T6;
    }

    public void setT6(String t6) {
        T6 = t6;
    }

    public String getT7() {
        return T7;
    }

    public void setT7(String t7) {
        T7 = t7;
    }

    public String getT8() {
        return T8;
    }

    public void setT8(String t8) {
        T8 = t8;
    }

    public String getT9() {
        return T9;
    }

    public void setT9(String t9) {
        T9 = t9;
    }

    public String getV1() {
        return V1;
    }

    public void setV1(String v1) {
        V1 = v1;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public Integer getIS_DELETE() {
        return IS_DELETE;
    }

    public void setIS_DELETE(Integer IS_DELETE) {
        this.IS_DELETE = IS_DELETE;
    }

    public LocalDateTime getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(LocalDateTime CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public LocalDateTime getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(LocalDateTime UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }
}
