package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


import mx.utng.practice.model.Plant;

import mx.utng.practice.repository.PlantRepository;

@Named
@ViewScoped
public class PlantController {
	@Autowired
	private PlantRepository plantRepository;
	private Plant plant = new Plant();
	private List<Plant> plants;

	private boolean editMode= false;
	
	@PostConstruct
	public void init(){
		setPlants(plantRepository.findAll());
	}
	
	public void save(){
		plantRepository.save(plant);
		if(!editMode){
			getPlants().add(plant);
		}
		plant= new Plant();
		setEditMode(false);
	}
	
	public void delete(Plant plant){
		plantRepository.delete(plant);
		plants.remove(plant);
		
	}
	public void update(Plant plant){
		setPlant(plant);
		setEditMode(true);
		
	}

	public PlantRepository getPlantRepository() {
		return plantRepository;
	}

	public void setPlantRepository(PlantRepository plantRepository) {
		this.plantRepository = plantRepository;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}


	
}
