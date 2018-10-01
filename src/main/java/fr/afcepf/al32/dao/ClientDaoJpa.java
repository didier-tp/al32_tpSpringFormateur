package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Client;

@Component
@Transactional
public class ClientDaoJpa implements IClientDao {
	
	@PersistenceContext()
	private EntityManager entityManager;

	@Override
	public Client rechercherClientAvecComptes(Long numClient) {
		//via le mot clef FETCH , cette requête demande à récupérer d'un coup
		//le client et tous les comptes rattachés (Lazy en général , 
		// comportement proche du eager sur demande avec mot clef FETCH)
		String jpaRequest="SELECT cli FROM Client cli INNER JOIN FETCH cli.comptes "
				          + " WHERE cli.numero = :numClient";
		return entityManager.createQuery(jpaRequest, Client.class)
				            .setParameter("numClient", numClient)
				            .getSingleResult();
	}

	@Override
	public Client findOne(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Client p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
