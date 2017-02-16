package Something.Something;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


//import org.apache.commons.collections.MultiHashMap;
//import org.apache.commons.collections.MultiMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Something.Something.service.MediaServiceEntity;
import Something.Something.tt.Some;

@SuppressWarnings("unused")
public class App 
{
	
	public static void outInf(Some s) {
		System.out.println("beg id=" + s.getId() + " left");
        for(Object key: s.getMmapl().keySet()) {
        	System.out.println("  key part: " + key.toString());        	
        	for(Some el : (ArrayList<Some>)s.getMmapl().get(key)) {
        		System.out.println("    value: " + el.getId());
        	}        			
        }
        System.out.println("end id=" + s.getId() + "\n\n");
	}
	
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        MediaServiceEntity serviceEntity = (MediaServiceEntity) context.getBean("storageServiceUser");
        
        Some s1 = new Some(1);
        Some s2 = new Some(2);
        
        serviceEntity.save(s1, "s1");
        serviceEntity.save(s2, "s2");
        
        s1.addMapElem(s2, 2);
        
        serviceEntity.update(s1);        
        System.out.println("\n");
        Some s10 = serviceEntity.findById(s1.getId());
        outInf(s10);
    }
}
