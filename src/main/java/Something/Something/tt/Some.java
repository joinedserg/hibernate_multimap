package Something.Something.tt;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;



public class Some {
	
	public Some() {
		mmapl = new MultiValueMap();
	}

	public Some(int i) {
		id = i;

		mmapl = new MultiValueMap();
		//TODO: after save you can add something, without it, all don't work
		mmapl.put(-10, this);
	}
	
	private Integer id;	
	private MultiMap mmapl;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MultiMap getMmapl() {
		return mmapl;
	}

	public void setMmapl(MultiMap mmapl) {
		this.mmapl = mmapl;
	}
	
	public void addMapElem(Some value, Integer key) {
		mmapl.put(key, value);
	}
	
	public void addSecMapElem(Some value) {
		mmapl.put(new Integer(4), value);		
	}
	
	@Override
	public boolean equals(Object other) {		
		if(other == null) {
			return false;
		}
		if(other == this) {
			return true;
		}
		if(!(other instanceof Some)) {
			return false; 
		}
		
		Some otherSome = (Some)other;
		
		if(otherSome.getId() != this.getId()) {
			return false;
		}
		return true;
	}
	    
}
