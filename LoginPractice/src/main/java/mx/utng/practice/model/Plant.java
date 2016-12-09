package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant {
	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	private String color;

	public Plant(String name, String color) {
		super();
		this.name = name;
		this.color = color;
		
	}
	
	public Plant(){
		this("","");
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	
	
}
