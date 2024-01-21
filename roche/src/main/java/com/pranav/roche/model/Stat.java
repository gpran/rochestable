package com.pranav.roche.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import lombok.*;

//import java.sql.Timestamp;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "fizbuzz")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int db_id;
    @Getter @Setter
    private int int1;
    @Getter @Setter
    private int int2;
    @Getter @Setter
    private int limit;
    @Getter @Setter
    private String str1;
    @Getter @Setter
    private String str2;   
    @Getter @Setter
    private long count;

  }