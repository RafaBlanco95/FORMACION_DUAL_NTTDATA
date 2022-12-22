package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.Building;
import com.nttdata.spring.repository.Habitant;
import com.nttdata.spring.repository.HabitantDaoI;

/**
 * 
 * Clase de implementación de la interfaz del servicio de gestión de los habitantes del edificio
 * 
 * @author RAFA
 *
 */
@Service
public class HabitantManagementServiceImpl implements HabitantManagementServiceI{

	/** Dao para tratar con los habitantes */
	@Autowired
	private HabitantDaoI habitantDao;
	
	
	@Override
	public void insertNewHabitant(Habitant habitant, Apartment apartment) {
		habitantDao.insertHabitant(habitant, apartment);
		
	}

	@Override
	public List<Habitant> searchAll(Building building) {
		return habitantDao.showAllHabitants(building);
		
	}

	@Override
	public List<Habitant> searchByNameAndSurname(String name, String surname, Building building) {
		
		return habitantDao.searchByNameAndSurname(name, surname, building);
	}

}
