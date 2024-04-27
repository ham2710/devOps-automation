package com.to;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "BAND")
@Data
public class Band {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "band_name")
    private String bandName;
	
	@ManyToMany
    @JoinTable(
            name = "BAND_MUSICIAN",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id")

    )
    private List<Musician> musicians = new ArrayList<>();
	
	
	public Band(String bandName){
		this.bandName=bandName;
	}
	
}
