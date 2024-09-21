package estructura_de_datos.iterators.comparator.comparator2objects;

import java.util.Comparator;

public class NameComparator implements Comparator <Object> {

	@Override
	public int compare(Object obj1, Object obj2){
		String name1 = null;
		String name2 = null;

		if ( obj1 instanceof Student )
			name1 = ( ( Student ) obj1 ).getName();
		else if ( obj1 instanceof Professor )
			name1 = ( ( Professor ) obj1 ).getName();

		if ( obj2 instanceof Student )
			name2 = ( ( Student ) obj2 ).getName();
		else if ( obj2 instanceof Professor )
			name2 = ( ( Professor ) obj2 ).getName();

		if ( name1 != null && name2 != null ) return name1.compareTo(name2);
		else if ( name1 != null ) return -1;
		else if ( name2 != null ) return 1;
		return 0;
	}


}
