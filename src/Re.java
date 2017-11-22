class Re extends Pezzo1{
    private static int contReBianco=0;
    private static int contReNero=0;

    Re(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contReNero < 1){
                contReNero = 1;
            }
            else {
                System.out.println("Troppi re neri "+contReNero);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contReBianco < 1){
                contReBianco = 1;
            }
            else {
                System.out.println("Troppi re bianchi "+contReBianco);
                System.exit(-1);
            }
        } 
    }

    public int getContReBianco() {
        return contReBianco;
    }

    public int getContReNero() {
        return contReNero;
    }

    
    
    
    
    
    
    
}
