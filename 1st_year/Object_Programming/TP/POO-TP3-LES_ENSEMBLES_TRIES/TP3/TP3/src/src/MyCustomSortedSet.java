package src;

public class MyCustomSortedSet extends MyCustomSet{
	//Constructors
	public MyCustomSortedSet() {
		super();
	}
	public MyCustomSortedSet(MyCustomSortedSet m) {
		super(m);
	}
	
	//Methods
	public void add(int x) {
		int i;
		if(!this.contains(x)&&this.size()==0)Liste.add(x);
		else if(!this.contains(x)&&this.size()>0) {
			for(i=0;i<this.size();i++) {
				if(this.get(i)>x) {
					Liste.add(i,x);
					return;
				}
			}
			Liste.add(x);
		}
	}
	public MyCustomSortedSet union(MyCustomSortedSet e) {
		MyCustomSortedSet r=new MyCustomSortedSet(this) ;
		for(int i=0;i<e.size();i++)if(!this.contains(e.get(i)))r.add(e.get(i));
		return r;
	}
	public MyCustomSortedSet intersection(MyCustomSortedSet e) {
		MyCustomSortedSet r=new MyCustomSortedSet() ;
		for(int i=0;i<e.size();i++)if(this.contains(e.get(i)))r.add(e.get(i));
		return r;
	}
	public MyCustomSortedSet difference(MyCustomSortedSet e) {
		MyCustomSortedSet r=new MyCustomSortedSet() ;
		for(int i=0; i<this.size();i++)if(!e.contains(get(i)))r.add(get(i));
		return r;
	}
	public boolean subset(MyCustomSortedSet e) {
		for(int i=0;i<e.size();i++)if(!this.contains(e.get(i)))return false;
		return true;
	}
	public int nearest(int x) {
		int a=0;
		int l=this.size()-1;
		int d=(a+l)/2;
	    while(a<=l){
	      if(this.get(d)<x)a=d+1;
	      else if(this.get(d)==x)return x;
	      else l=d-1;
	      d=(a+l)/2;
	    }
	    if(l<0)return this.get(a);
	    else if(a>(size()-1))return this.get(l);
	    else
	    {
	    	if(x-get(l)<get(a)-x)return this.get(l);
	    	else return this.get(a);
	    }
	}
}
