//Cozinhável (carne, batata, rabanada)
//assar, seja num forno ou numa panela de pressão, passando como parametro o tempo que o objeto tem de passar sendo assado
//fritar, numa frigideira com óleo, passando como parametro o tempo que o objeto tem de passar sendo frito

interface cookable{
	void bake (int t);
	void fry (int t);
}
 

 *Exemplo*

if(food == "Meat"){
	if(method == "Fried"){
		Meat.fry(30);
	}
	else if(method == "Baked"){
		Meat.bake(15);
	}
}
else if(food == "Potatot"){
	if(method == "Fried"){
		Potato.fry(30);
	}
	else if(method == "Baked"){
		Potato.bake(15);
	}
}
else if(food == "FrenchToast"){
	if(method == "Fried"){
		FrenchToast.fry(30);
	}
	else if(method == "Baked"){
		FrenchToast.bake(15);
	}
}




----------------------------------------------------------------------------------
//Legível(Livro, Quadrinhos, Carta)
//ler, ler o que está escrito no objeto, passando como parametro o tempo que a leitura vai durar
//interpretar, tirar o significado do que foi lido, retorna uma string contendo o significado do que foi lido

interface readable{
	void read (int t);
	String interpret (void); 
}

ArrayList<Book> livros = new ArrayList<Book>()

String l;
l = **pegar uma string equivalente ao nome de um livro desejado**;
for (Books livro: livros){
	if(livro == "l"){
		livro.read(10);
		livro.interpret();
	}
}
