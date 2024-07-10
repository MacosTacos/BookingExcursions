package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity {
    private Long id;
    private String startAddress;
    private String finishAddress;
    private Integer length;
    private String info;
    private List<ExcursionEntity> excursionEntityList;

    @Id
    @SequenceGenerator(
            name = "route_sequence",
            sequenceName = "route_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "route_sequence"
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

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

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "routeEntity", targetEntity = ExcursionEntity.class)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
