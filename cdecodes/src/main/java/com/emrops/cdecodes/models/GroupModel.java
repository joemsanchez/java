package com.emrops.cdecodes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name= "groups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;
    private String col1;
    private String col2;
    private Integer col3;
    private String col4;

    public GroupModel(){
    }

    public Long getGroup_id() {
        return this.group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getCol1() {
        return this.col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return this.col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public Integer getCol3() {
        return this.col3;
    }

    public void setCol3(Integer col3) {
        this.col3 = col3;
    }

    public String getCol4() {
        return this.col4;
    }

    public void setCol4(String col4) {
        this.col4 = col4;
    }

}
