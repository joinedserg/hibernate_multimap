package Something.Something.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Something.Something.dao.MediaDaoEntity;
import Something.Something.tt.Some;


@Service("storageServiceUser")
public class MediaServiceEntity {
	@Autowired
    private MediaDaoEntity dao;
    
    @Transactional
    public void save(Some entity, String name) {
        dao.save(entity);
    }
    
    @Transactional
    public void update(Some entity) {
        dao.update(entity);
        
        System.out.println("");
    }
    
    
    @Transactional
    public void delete(Some entity) {
        dao.delete(entity);
    }
    
    
    public<T extends Some> List<T> getAll(Class classType) {
        return dao.getAll(classType);
    }
	
	public Some findById(Integer idEntity) {
		return dao.findById(idEntity);
	}
}
