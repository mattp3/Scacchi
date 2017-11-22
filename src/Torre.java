class Torre extends Pezzo1{
    private static int contTorreBianca=0;
    private static int contTorreNera=0;

    Torre(char x, char y, char colore) {
        super(x, y, colore);
        if(colore == 'N'){
            if(contTorreNera < 2){
                contTorreNera++;
            }
            else {
                System.out.println("Troppe torri nere "+contTorreNera);
                System.exit(-1);
            }
        }
        else if(colore == 'B'){
            if(contTorreBianca < 2){
                contTorreBianca++;
            }
            else {
                System.out.println("Troppe torri bianche "+contTorreBianca);
                System.exit(-1);
            }
        }
    }  
}
