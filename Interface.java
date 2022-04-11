//Cozinhável (carne, batata, rabanada)
//assar, seja num forno ou numa panela de pressão, passando como parametro o tempo que o objeto tem de passar sendo assado
//fritar, numa frigideira com óleo, passando como parametro o tempo que o objeto tem de passar sendo frito

interface cookable{
	void bake (int t);
	void fry (int t);
}

Meat.fry(30);
Potato.bake(15);

----------------------------------------------------------------------------------
//Legível(Livro, Quadrinhos, Carta)
//ler, ler o que está escrito no objeto, passando como parametro o tempo que a leitura vai durar
//interpretar, tirar o significado do que foi lido, retorna uma string contendo o significado do que foi lido

interface readable{
	void read (int t);
	String interpret (void); 
}

Book.read(2);
Book.interpret();
