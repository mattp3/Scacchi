class Alfiere extends Pezzo1{
    private static int contAlfiereBianca=0;
    private static int contAlfiereNera=0;

    Alfiere(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contAlfiereNera < 2){
                contAlfiereNera++;
            }
            else {
                System.out.println("Troppi alfieri neri "+contAlfiereNera);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contAlfiereBianca < 2){
                contAlfiereBianca++;
            }
            else {
                System.out.println("Troppi alfieri bianchi "+contAlfiereBianca);
                System.exit(-1);
            }
        }
    }
    
    
    
    
}
