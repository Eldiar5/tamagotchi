package org.example.tamagotchi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ColumnDefault("0")
    @Column(name = "hunger", nullable = false)
    private Integer hunger;

    @ColumnDefault("100")
    @Column(name = "happiness", nullable = false)
    private Integer happiness;

    @ColumnDefault("true")
    @Column(name = "is_alive", nullable = false)
    private Boolean isAlive = false;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "last_updated")
    private Instant lastUpdated;

}