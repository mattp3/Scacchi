class Cavallo extends Pezzo1{
    private static int contCavalloBianco=0;
    private static int contCavalloNero=0;

    Cavallo(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contCavalloNero < 2){
                contCavalloNero++;
            }
            else {
                System.out.println("Troppi cavalli neri "+contCavalloNero);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contCavalloBianco < 2){
                contCavalloBianco++;
            }
            else {
                System.out.println("Troppi cavalli bianchi "+contCavalloBianco);
                System.exit(-1);
            }
        }
    }

    public int getContCavalloBianco() {
        return contCavalloBianco;
    }

    public int getContCavalloNero() {
        return contCavalloNero;
    }
    
    
    
}
