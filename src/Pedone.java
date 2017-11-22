class Pedone extends Pezzo1{
    private static int contPedoneBianco=0;
    private static int contPedoneNero=0;

    Pedone(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contPedoneNero < 8){
                contPedoneNero++;
            }
            else {
                System.out.println("Troppi pedoni neri "+contPedoneNero);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contPedoneBianco < 8){
                contPedoneBianco++;
            }
            else {
                System.out.println("Troppi pedoni bianchi "+contPedoneBianco);
                System.exit(-1);
            }
        }
    }
    
}
