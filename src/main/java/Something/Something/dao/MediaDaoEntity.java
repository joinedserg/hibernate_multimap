package Something.Something.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

//import org.hibernate.jpa.internal.TransactionImpl;

//import org.hibernate.jpa.spi.HibernateEntityManagerImplementor;
import org.springframework.stereotype.Repository;

import org.springframework.orm.hibernate5.*;

import Something.Something.tt.*;

@Repository
public class MediaDaoEntity {

    @PersistenceContext
    private EntityManager em;
    
	public void save(Some entity) {
		em.persist(entity);
	}

	public<T extends Some> List<T> getAll(Class classType) { 
		List<T> list = em.createQuery("from " + classType.getSimpleName(), classType).getResultList();
		return list;
	}
	
	public void delete(Some entity) {String hqlDelete = "delete from Some where entity_id1 = :id";
        int deletedEntities = em.createQuery(hqlDelete)
                .setParameter("id", entity.getId())
                .executeUpdate();
	}
	
	public void update(Some entity) {
		em.merge(entity);
		//em.flush();
		//em.clear();
		//em.close();
	}
	
	public Some findById(Integer idEntity) {
		return em.find(Some.class, idEntity);
	}
}
