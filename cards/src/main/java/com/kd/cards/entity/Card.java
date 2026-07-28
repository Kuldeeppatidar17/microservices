package com.kd.cards.entity;


import com.kd.cards.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cards")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private Double creditLimit;

    @Column(nullable = false)
    private Double availableAmount;

    @Column(nullable = false)
    private Long mobileNumber;
}
