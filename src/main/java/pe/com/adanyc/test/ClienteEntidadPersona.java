package pe.com.adanyc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pe.com.adanyc.domain.Persona;

public class ClienteEntidadPersona {
	static Logger LOG = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// Inicia la transaccion
		tx.begin();
		// No se debe especificar el id de la base de datos
		Persona persona1 = new Persona("Alex", "Cabello", "acabellox@mail.com", "941112223");
		LOG.debug("Objeto a persistir: " + persona1);
		// Persistimos el objeto
		em.persist(persona1);
		// Terminamos la transaccion
		tx.commit();
		LOG.debug("Objeto persistido: " + persona1);
		// Cerramos
		em.close();
	}
}
