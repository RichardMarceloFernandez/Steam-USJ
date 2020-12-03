package br.edu.usj.ads.lpii.steam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Devs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id; 

    @Column
    String nomeDev;

    @Column
    String ceo;

    @Column
    String paisSede;

    @Column
    String anoFundacao;


    
}
