package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;
    @Column(nullable = false)
    private String equipmentType;
    @Column(nullable = false)
    private Long officeId;
    @Column(nullable = false)
    private boolean assigned;
    @Column()
    private Long userId;

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return assigned == equipment.assigned &&
                Objects.equals(equipmentId, equipment.equipmentId) &&
                Objects.equals(equipmentType, equipment.equipmentType) &&
                Objects.equals(officeId, equipment.officeId) &&
                Objects.equals(userId, equipment.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, equipmentType, officeId, assigned, userId);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentType='" + equipmentType + '\'' +
                ", officeId=" + officeId +
                ", assigned=" + assigned +
                ", userId=" + userId +
                '}';
    }
}
