public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.print();
        r1.area();
        r1.drag(20,30);
    }
}
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    int area(){
        int a;
        a= this.w * this.h;
        System.out.format("A area do retangulo e: %d\n", a);
        return a;
    }
    void drag(int dx,int dy){

        int nx,ny;
        nx=dx+this.x;
        ny=dy+this.y;
        System.out.format("As novas coordenadas do retangulo sao (%d,%d)",nx,ny);
    }
}