package com.bill.currency.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class SHEDLOCK {
    @Id
    private Long id;
    private String name;
    private LocalDateTime lockUntil;
    private LocalDateTime lockedAt;
    private String lockedBy;
}
