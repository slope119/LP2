public class ElipApp{
	public static void main(String[] args){
		Elip e1= new Elip(1,1, 6,3);
		e1.print();
	}
}

class Elip{
	int x,y;
	int d1,d2;
	Elip(int x, int y, int d1, int d2){
		this.x=x;
		this.y=y;
		this.d1=d1;
		this.d2=d2;
	}
	void print(){
		System.out.format("Elipse com diametros %d e %d na posicao (%d,%d)",this.d1,this.d2,this.x,this.y);
	}
}