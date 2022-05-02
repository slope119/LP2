    1 public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corl);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
    2 public void paint1 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corl);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corfocus);
        g2d.drawRect(this.x - 5,this.y - 5,this.w + 10,this.h +10);
        g2d.setPaint(new Color(0,0,0));
        g2d.fillRect(this.x + this.w-10,this.y + this.h-10,10 ,10);

    }
    3 public int fdifx(int prx){
        return(this.x - prx);
    }
    4 public int fdify(int pry){
        return(this.y - pry);
    }
    5 public void movew(){
        this.y -= 15;
    }
    6 public void movea(){
        this.x -= 15;
    }
    7 public void moves(){
        this.y += 15;
    }
    8 public void moved(){
        this.x += 15;
    }
    9 public void resizeu(){
        this.x-=5;
        this.y-=5;
        this.w+=10;
        this.h+=10;
    }
    10 public void resized(){
        if(this.w > 20 && this.h > 20){
            this.x+=5;
            this.y+=5;
            this.w-=10;
            this.h-=10;
        }
    }
    11 public void recolor(int r1, int g, int b, int r2, int g2, int b2){
        this.corl = new Color(r1,g,b);
        this.corf = new Color(r2,g2,b2);
    }
    12 public void drag(int dx, int dy, int difx, int dify){
        this.x = dx + difx;
        this.y = dy + dify;

    }
    13 public boolean clicked(int prx, int pry){
        if((this.x <= prx) && (this.y <= pry) && (this.w + this.x > prx) && (this.h + this.y > pry)){
            return true;
        }
        else{
            return false;
        }
    }
    14 public boolean clickeds(int prx, int pry){
        if(((this.x + this.w - 10) <= prx) && ((this.y + this.h - 10) <= pry) && ((this.y + this.h - 10 + 10) > pry) && ((this.x + this.w - 10 + 10) > prx)){
            return true;
        }
        else{
            return false;
        }
    }
    15 public void resize(int x, int y){
        if(x - this.x >= 20){
            this.w = x - this.x;
        }
        else{

        }
        if(y - this.y >= 20){
            this.h = y - this.y;
        }
        else{

        }
    }
