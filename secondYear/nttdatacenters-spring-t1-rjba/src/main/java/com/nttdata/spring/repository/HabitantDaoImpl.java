package com.nttdata.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class HabitantDaoImpl implements HabitantDaoI{

	@Override
	public List<Habitant> searchByNameAndSurname(String name, String surname, Building building) {
		List<Habitant> habitantList= new ArrayList<>();
		Floor[] floors= building.getFloors();
		for(Floor floor :floors) {
			Apartment[] apartments=floor.getApartments();
			for (Apartment apartment: apartments) {
				List<Habitant> habitants= apartment.getHabitants();
				for(Habitant habitant: habitants) {
					if (habitant.getName().equals(name)&& habitant.getSurname().equals(surname)) {
						habitantList.add(habitant);
					}
				}
			}
		}
		return habitantList;
	}

	@Override
	public void insertHabitant(Habitant habitant, Apartment apartment) {
		List<Habitant> previousHabitants=apartment.getHabitants();
		previousHabitants.add(habitant);
		List<Habitant> updatedHabitants=previousHabitants;
		apartment.setHabitants(updatedHabitants);
	}

	@Override
	public List<Habitant> showAllHabitants(Building building) {
		
		List<Habitant> habitantList= new ArrayList<>();
		Floor[] floors= building.getFloors();
		for(Floor floor :floors) {
			Apartment[] apartments=floor.getApartments();
			for (Apartment apartment: apartments) {
				List<Habitant> habitants= apartment.getHabitants();
				for(Habitant habitant: habitants) {
						habitantList.add(habitant);
					}
				}
			}
		
		return habitantList;
	}

}
