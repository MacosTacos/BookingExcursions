package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "excursion_types")
public class ExcursionTypeEntity extends BaseEntity{
    private String name;

    private List<ExcursionEntity> excursionEntityList;

    protected ExcursionTypeEntity() {
    }

    public ExcursionTypeEntity(String name, List<ExcursionEntity> excursionEntityList) {
        this.name = name;
        this.excursionEntityList = excursionEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "excursionTypeEntityList", targetEntity = ExcursionEntity.class, fetch = FetchType.LAZY)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
