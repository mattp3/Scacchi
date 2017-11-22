class Pezzo1{
    protected char x; //a-h(colonna)
    protected char y; //1-8(riga)
    protected char colore;//nero o bianco
    
    Pezzo1(char x, char y , char colore) {
        if(y>='1' && y<='8' && x >= 'a' && x <= 'h'){
            if(colore=='N' || colore == 'B'){
                this.x = x;
                this.y = y; 
                this.colore = colore;
            }
            else{
                System.out.println("Colore sbagliato (Nero o Bianco) "+colore);
                System.exit(-1);
            }
        }
        else{
            System.out.println("Posizione sbagliata(a-h)(1-8) "+x+y);
            System.exit(-1);
        }
    } 

    Pezzo1(char x, char y) {
        if(y>='1' && y<='8' && x>= 'a' && x<= 'h')
        {
            this.x = x;
            this.y = y;  
        } 
    }
    public char getColore() {
        return colore;
    }

    public char getX() {
        return x;
    }

    public char getY() {
        return y;
    }   
}
