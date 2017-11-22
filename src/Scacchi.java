
import java.io.*;
import java.util.Scanner;

class Scacchi{
    public static void main(String[] args) throws IOException  {
        System.out.println("Inserisci il nome del file senza .txt ");
        Scanner input = new Scanner (System.in);
        String nomefile = input.nextLine();
        File f = new File(nomefile+".txt");
        String content;
        String scelta; 
        char[] next = null;
        int contaScacchi = 0;
        int contCavallo=0,contRe=0,contPedone=0,contAlfiere=0,contTorre=0,contRegina=0;
        Pezzo1[] p = new Pezzo1[64];
        Regina[] regina = new Regina[2];
        Re[] re = new Re[2];
        Alfiere[] alfiere = new Alfiere[4];
        Cavallo[] cavallo = new Cavallo[4];
        Torre[] torre = new Torre[4];
        Pedone[] pedone = new Pedone[16];
        
        
        if (f.exists())             System.out.println("Il file " + f + " esiste già");
        else if (f.createNewFile()) System.out.println("Il file " + f + " è stato creato");
        else                        System.out.println("Il file " + f + " non può essere creato");
        do{
            try (BufferedReader in = new BufferedReader(new FileReader(f))) {
                while(((content = in.readLine()) != null) && (contaScacchi < 32)){
                    if(content.length() != 4){
                        System.out.println("Configurazione non valida. Ci devono essere solo 4 caratteri per riga (ABxy)");
                        System.exit(-1);
                    }
                    else{
                        next = content.toCharArray();//converte la riga letta in singoli caratteri
                        if('R' == next[0]){ 
                            for (int i=contRe; i < contRe+1; i++) {
                                re[i] = new Re(next[2], next[3], next[1]);                                    
                            }   
                            contRe++;
                        }
                        else if('D' == next[0]){
                            for (int i=contRegina; i < contRegina+1; i++) {
                                regina[i] = new Regina(next[2], next[3], next[1]); 
                            }
                            contRegina++;
                        }
                        else if('T' == next[0]){
                            for (int i=contTorre; i < contTorre+1; i++) {
                                torre[i] = new Torre(next[2], next[3], next[1]); 
                            }
                            contTorre++;
                        }
                        else if('A' == next[0]){
                            for (int i=contAlfiere; i < contAlfiere+1; i++) {
                                alfiere[i] = new Alfiere(next[2], next[3], next[1]); 
                            }
                            contAlfiere++;
                        }                       
                        else if('C' == next[0]){
                            for (int i=contCavallo; i < contCavallo+1; i++) {
                                cavallo[i] = new Cavallo(next[2], next[3], next[1]); 
                            }
                            contCavallo++;
                        }
                        else if('P' == next[0]){
                            for (int i=contPedone; i < contPedone+1; i++) {
                                pedone[i] = new Pedone(next[2], next[3], next[1]); 
                            }
                            contPedone++;
                        }
                        else{
                                System.out.println("Configurazione non valida. Il pezzo "+next[0]+" non è valido  ");
                                System.exit(-1);
                        }
                    }
                    contaScacchi = contaScacchi+1;//conta gli scacchi presenti nella scacchiera
                    //crea un vettore di tipo Pezzo1 con le coordinate lette da file 
                    for(int j = contaScacchi-1; j<contaScacchi; j++){
                        p[j] = new Pezzo1(next[2], next[3]);
                    }
                    
                    //controlla le posizioni già occupate da altri pezzi
                    if(contaScacchi > 1){//parte da due pezzi o più per il controllo
                        for (int i = contaScacchi-1; i>0; i--) {
                            if((next[2] == p[i-1].getX()) && (next[3] == p[i-1].getY())){
                                System.out.println("Non ci possono essere due pezzi nella stessa posizione "+p[i-1].getX()+p[i-1].getY());
                                System.exit(-1);
                            }
                        }
                    }
                }//fine lettura riga
                if(contaScacchi>32){
                    System.out.println("Configurazione non valida. Troppi pezzi nella scacchiera");
                    System.exit(-1);
                }
                if(contaScacchi==32){
                    System.out.println("Scacchiera piena. Non è possibile aggiungere un altro pezzo ");
                    System.exit(1);
                }
                in.close();
            } catch(FileNotFoundException e) {
                System.out.println(f+" File non trovato");
            } catch(IOException e) {
                System.out.println(" IOException  "+e);
            }
            /*
            for (int i = 0; i < contaScacchi; i++) {
                System.out.println(p[i].getX());
                System.out.println(p[i].getY());
                System.out.println(p[i].getColore());
                //System.out.println(cavallo[i].getContCavalloBianco());
               // System.out.println(cavallo[i].getContCavalloNero());
            }*/
            
            String inp=null;
            System.out.println("Inserisci una configurazione del tipo (abxy) a=(R,D,A,C,T) b=(B,N) xy=colonna,riga ");
            inp = input.nextLine();
            next= inp.toCharArray();
            try {
                if((inp.length()!=4) || (next[0] != 'R' && next[0] != 'D' && next[0] != 'A' && next[0] != 'C' && next[0] != 'T' )){
                    System.out.println("Non è una configurazione valida ");
                    System.exit(-1);
                }
                else{
                    Pezzo1 newConfig = new Pezzo1(next[2],next[3],next[1]);
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(f,true))) {
                        out.newLine();
                        out.write(inp);
                        out.close();
                    }catch(FileNotFoundException e) {
                        System.out.println(f+" File non trovato");
                    } catch(IOException e) {
                        System.out.println(" IOException  "+e);
                    } 
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Configurazione non valida");
            }
            
            System.out.println("Scrivi esci per uscire oppure al raggiungimento di 32 pezzi ");
            scelta = input.nextLine(); 
        }while(!scelta.equals("esci"));
    }
}
