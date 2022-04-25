abstract class vegetal{
	int tamanho;
	Color cor;
	String instrução;
	void cultivo(int t, String instrução);
	boolean qualidade(Color cor, int tamanho);	
}

class couve extends vegetal{
	void cultivo(int t, String inst){

	}
	boolean qualidade(Color cor, int tamanho){
		
	}
}
class couveflor extends vegetal{
	void cultivo(int t, String inst);
	boolean qualidade(Color cor, int tamanho){
		
	}
}
class batata extends vegetal{
	void cultivo(int t, String inst);
	boolean qualidade(Color cor, int tamanho){
		
	}
}

//vegetal é uma superclasse que pode englobar várias outras subclasses, como as citadas acima. dentre seus métodos temos cultivo, que recebe a duraçao e intrução para ser
//realizado e o metodo booleano qualidade, que recebe como parametro cor e tamanho e retorna se o vegetal está ou nao saudavel 

//coloquei vegetal como classe pois resolvi ''agrupar'' todas as caracteristicas em comum em uma unica super classe, como tamanho, cor e instruções de cultivo, que seria unico de cada vegetal (subclasse)

//um caso de uso seria uma lista ArrayList<vegetal> vegie = new ArrayList<vegetal>(); onde contém diversos tipos diferentes de vegetais armazenados com suas respectivas instruções
//de cultivo com tamanho e cor adequados para estarem maduros

*****************************************************************************

interface cozinhavel{
	void cozinhar (int t);
	void refogar (int t);
}

class batata implements cozinhavel{
	void cozinhar (int t){

	}
	void refogar (int t){

	}
}

class carne implements cozinhavel{
	void cozinhar (int t){

	}
	void refogar (int t){

	}
}

//cozinhavel é uma interface que implementa os métodos cozinhar e refogar que recebem como parametro uma quantidade inteira de tempo t

//coloquei cozinhavel como interface pois ela implementa somente métodos em comum de diversas classes, comportamentos em comum de diferentes alimentos 

//um caso de uso seriam as subclasses puxarem um dos métodos em comum com a interface que elas implementam
