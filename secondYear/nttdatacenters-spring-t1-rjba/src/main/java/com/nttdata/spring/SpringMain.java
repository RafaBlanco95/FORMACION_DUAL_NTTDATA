package com.nttdata.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.Building;
import com.nttdata.spring.repository.Floor;
import com.nttdata.spring.repository.Habitant;
import com.nttdata.spring.services.HabitantManagementServiceI;

/**
 * 
 * Clase principal de la aplicación
 * 
 * @author RAFA
 *
 */
@SpringBootApplication
public class SpringMain implements CommandLineRunner {

	/** Inicialización de los servicios */
	@Autowired
	private HabitantManagementServiceI habitantService;

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	/** String builder que se va a mostrar en los logs */
	final StringBuilder sbu = new StringBuilder();

	/**
	 * 
	 * Método principal de la clase
	 * 
	 * @param args argumentos 
	 */
	public static void main(String[] args) {
		// Log de inicio
		LOG.info("Método: main() | TRAZA DE INICIO");

		SpringApplication.run(SpringMain.class, args);

		// Log de final de traza
		LOG.info("Método: main() | FIN DE TRAZA");
	}

	@Override
	public void run(String... args) throws Exception {

		// EMULACIÓN DE UN EDIFICIO CON 2 PLANTAS, 2 APARTAMENTOS POR PLANTA y 2 HABITANTES POR APARTAMENTO
		sbu.append("Método: main() | Inicio de la emulación del edificio");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		
		// Inicialización de las personas que viven en el edificio
		Habitant habitante1 = new Habitant();
		Habitant habitante2 = new Habitant();
		Habitant habitante3 = new Habitant();
		Habitant habitante4 = new Habitant();
		Habitant habitante5 = new Habitant();
		Habitant habitante6 = new Habitant();
		Habitant habitante7 = new Habitant();
		Habitant habitante8 = new Habitant();

		// Asignación de los nombres y apellidos
		habitante1.setName("Rafael");
		habitante1.setSurname("Blanco Aranda");
		habitante2.setName("Juan Alejandro");
		habitante2.setSurname("Téllez Rubio");
		habitante3.setName("Jaime");
		habitante3.setSurname("Negro Mora");
		habitante4.setName("Paula");
		habitante4.setSurname("Martínez Barral");
		habitante5.setName("Joaquín Matías");
		habitante5.setSurname("Aguirre Oceja");
		habitante6.setName("Belén");
		habitante6.setSurname("Aranda López");
		habitante7.setName("María José");
		habitante7.setSurname("Barral Nieto");
		habitante8.setName("Manuel");
		habitante8.setSurname("Martínez Mato");
		
		// Inicialización de los apartamentos
		Apartment apartamento1 = new Apartment();
		Apartment apartamento2 = new Apartment();
		Apartment apartamento3 = new Apartment();
		Apartment apartamento4 = new Apartment();
		
		// Asignación de los habitantes iniciales a los apartamentos
		List<Habitant> habitantesApartamento1 = new ArrayList<>();
		habitantesApartamento1.add(habitante1);
		habitantesApartamento1.add(habitante2);
		apartamento1.setHabitants(habitantesApartamento1);

		List<Habitant> habitantesApartamento2 = new ArrayList<>();
		habitantesApartamento2.add(habitante3);
		habitantesApartamento2.add(habitante4);
		apartamento2.setHabitants(habitantesApartamento2);
		
		List<Habitant> habitantesApartamento3 = new ArrayList<>();
		habitantesApartamento3.add(habitante5);
		habitantesApartamento3.add(habitante6);
		apartamento3.setHabitants(habitantesApartamento3);
		
		List<Habitant> habitantesApartamento4 = new ArrayList<>();
		habitantesApartamento4.add(habitante7);
		habitantesApartamento4.add(habitante8);
		apartamento4.setHabitants(habitantesApartamento4);
		
		// Inicialización de los pisos
		Floor planta1 = new Floor();
		Floor planta2 = new Floor();
		
		// Asignación de los apartamentos a los pisos
		Apartment[] apartamentosPlanta1 = { apartamento1, apartamento2 };
		Apartment[] apartamentosPlanta2 = { apartamento3, apartamento4 };
		
		planta1.setApartaments(apartamentosPlanta1);
		planta2.setApartaments(apartamentosPlanta2);

		// Inicialización del edificio
		Building edificio1 = new Building();
		
		// Asignación de los pisos al edificio
		Floor[] plantasEdificio1 = { planta1, planta2 };
		edificio1.setFloors(plantasEdificio1);
		sbu.append("Método: main() | Fin de la emulación del edificio");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		
		// Consumición de los servicios requeridos por el enunciado 
		
		// Asignación de un tercer inquilino en el apartamento 1 haciendo uso del servicio de habitantes
		Habitant habitante9= new Habitant();
		habitante9.setName("Elnuevo");
		habitante9.setSurname("Inquilino");
		
		habitantService.insertNewHabitant(habitante9, apartamento1);
		sbu.append("Método: main() | Llamada al método insertNewHabitant() de habitantService");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Consulta de todos los habitantes del edificio haciendo uso del servicio de habitantes
		List<Habitant> todosLosHabitantes = habitantService.searchAll(edificio1);
		sbu.append("Método: main() | Llamada al método searchAll() de habitantService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		for (Habitant habitante : todosLosHabitantes) {
			
			sbu.append(habitante.getName());
			sbu.append(" | ");
			sbu.append(habitante.getSurname());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Consulta de todos los habitantes del edificio que se llamen Rafael Blanco Aranda
		List<Habitant> habitantesRafaelBlanco = habitantService.searchByNameAndSurname("Rafael", "Blanco Aranda",
				edificio1);
		sbu.append("Método: main() | Llamada al método searchByNameAndSurname() de habitantService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		for (Habitant habitante : habitantesRafaelBlanco) {
			sbu.append(habitante.getName());
			sbu.append(" | ");
			sbu.append(habitante.getSurname());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}
	}

}
