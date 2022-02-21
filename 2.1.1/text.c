#include <stdio.h>

typedef struct{
	int x,y;
	int size;
	char face[20];
}text;

void print (text* t){
	printf("O texto escrito e: '%s' na posicao %d %d com fonte de tamanho %d. ", t->face,t->x,t->y,t->size);
}

int main(){
	text t;
	t.x=10;
	t.y=10;
	t.size=26;
	printf("Insira um texto: ");
	fgets(t.face,20,stdin); 
	print(&t);
}