package com.vesna.toxic.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chemicals")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class Chemicals {

    @Column
    private String cname;

    @Id
    @Column
    private String casrn;

    @Column
    private String crit_systems;
}