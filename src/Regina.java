class Regina extends Pezzo1{
    private static int contReginaBianca=0;
    private static int contReginaNera=0;
       
    Regina(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contReginaNera < 1){
                contReginaNera = 1;
            }
            else {
                System.out.println("Troppe regine nere "+contReginaNera);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contReginaBianca < 1){
                contReginaBianca = 1;
            }
            else {
                System.out.println("Troppe regine bianche "+contReginaBianca);
                System.exit(-1);
            }
        } 
    }
    
    public int getContReginaBianca() {
        return contReginaBianca;
    }

    public int getContReginaNera() {
        return contReginaNera;
    }    
}
