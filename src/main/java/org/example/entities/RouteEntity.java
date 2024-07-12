package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {
    private String startAddress;
    private String finishAddress;
    private Integer length;
    private String info;
    private Boolean relevance; //является ли маршрут актуальным, используемым в данный момент для экскурсий
    private List<ExcursionEntity> excursionEntityList;

    public RouteEntity(String startAddress, String finishAddress, Integer length, String info, Boolean relevance, List<ExcursionEntity> excursionEntityList) {
        this.startAddress = startAddress;
        this.finishAddress = finishAddress;
        this.length = length;
        this.info = info;
        this.relevance = relevance;
        this.excursionEntityList = excursionEntityList;
    }

    protected RouteEntity() {
    }

    @Column(name = "start_address")
    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    @Column(name = "finish_address")
    public String getFinishAddress() {
        return finishAddress;
    }

    public void setFinishAddress(String finishAddress) {
        this.finishAddress = finishAddress;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Column(columnDefinition = "text")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getRelevance() {
        return relevance;
    }

    public void setRelevance(Boolean relevance) {
        this.relevance = relevance;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "routeEntity", targetEntity = ExcursionEntity.class)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
