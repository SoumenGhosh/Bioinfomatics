import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class GOR {
    static String protein1 = "MKIDAIVGRNSAKDIRTEERARVQLGNVVTAAALHGGIRISDQTTNSVETVVGKGESRVLIGNEYGGKGFWDNHHHHHH";
    static String protein2 = "MRRYEVNIVLNPNLDQSQLALEKEIIQRALENYGARVEKVAILGLRRLAYPIAKDPQGYFLWYQVEMPEDRVNDLARELRIRDNVRRVMVVKSQEPFLANA";
    static String protein3 = "MVGLTTLFWLGAIGMLVGTLAFAWAGRDAGSGERRYYVTLVGISGIAAVAYVVMALGVGWVPVAERTVFAPRYIDWILTTPLIVYFLGLLAGLDSREFGIVITLNTVVMLAGFAGAMVPGIERYALFGMGAVAFLGLVYYLVGPMTESASQRSSGIKSLYVRLRNLTVILWAIYPFIWLLGPPGVALLTPTVDVALIVYLDLVTKVGFGFIALDAAATLRAEHGESLAGVDTDAPAVAD";
    static String protein4 = "MNGTEGPNFYVPFSNKTGVVRSPFEAPQYYLAEPWQFSMLAAYMFLLIMLGFPINFLTLYVTVQHKKLRTPLNYILLNLAVADLFMVFGGFTTTLYTSLHGYFVFGPTGCNLEGFFATLGGEIALWSLVVLAIERYVVVCKPMSNFRFGENHAIMGVAFTWVMALACAAPPLVGWSRYIPEGMQCSCGIDYYTPHEETNNESFVIYMFVVHFIIPLIVIFFCYGQLVFTVKEAAAQQQESATTQKAEKEVTRMVIIMVIAFLICWLPYAGVAFYIFTHQGSDFGPIFMTIPAFFAKTSAVYNPVIYIMMNKQFRNCMVTTLCCGKNPLGDDEASTTVSKTETSQVAPA";
    static String protein5 = "DITCCGQFHFAIIYHDWQYKIFRYAATSPVKEPWKHRMWYSIVAANDVENCNSFHGPYQQKHQWQDNTAQYLEYKTIGYQKRDQPNNVWIHHPMVYYEPVHYRQFNDRQAFTYSDQFCSKSCTIIWNGEANQCHNKQTASDHTGWPRMFAYLKENYTQYSTFFICMLDKYTCSNMKSLPEMHWELMEWALMCSCEKERARYQCNSWRKSIADPEFNYCIAWMFCKHEEKGEETRCEQKHQALLPPHEDYGDSLNDCQVNNGEPYTTKGEQRVKLQKEGHKNEQCRKATKRKYQASQCEAKREMMKNWRSYTATESNARVMQHWRQWRLHSMCVITDDHTQRRETCEAKENRMLRTALHIWVVWASHWFPVMNITQIWTGEDHGDHNSFLALCDSVVASYRILEQQLECCPNEDQCPMSIFHYKVKMCWEWRIVYAPNQSHTRNCALDFKKMEPIAGMMHCPGMQSGMLTSDRPVLEPGSVENPLFDNHVRFSYFFEQVNNGKFMLECSTCGDNEEIFGYHCIVQNYQDCASAKSAIFCFMFANQHAERGWSPGLIVRNF";
    static String protein6 = "MQSIEDIWQETLQIVKKNMSKPSYDTWMKSTTAHSLEGNTFIISAPNNFVRDWLEKSYTQFIANILQEITGRLFDVRFIDGEQEENFEYTVIKPNPALDEDGIEIGKHMLNPRYVFDTFVIGSGNRFAHAASLAVAEAPAKAYNPLFIYGGVGLGKTHLMHAVGHYVQQHKDNAKVMYLSSEKFTNEFISSIRDNKTEEFRTKYRNVDVLLIDDIQFLAGKEGTQEEFFHTFNTLYDEQKQIIISSDRPPKEIPTLEDRLRSRFEWGLITDITPPDLETRIAILRKKAKADGLDIPNEVMLYIANQIDSNIRELEGALIRVVAYSSLVNKDITAGLAAEALKDIIPSSKSQVITISGIQEAVGEYFHVRLEDFKAKKRTKSIAFPRQIAMYLSRELTDASLPKIGDEFGGRDHTTVIHAHEKISQLLKTDQVLKNDLAEIEKNLRKAQNMF";
    static String protein7 = "MALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVY";
    static String protein8 = "IVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVY";
    static String protein9 = "MALEKMALEKMALEKMALEKMALEKMALEKMALEK";

    static int [][] helix = new int[20][17];
    static int [][] strand = new int[20][17];
    static int [][] coil = new int[20][17];
    static char[] table = {'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L',
                            'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Y'};

    static ArrayList<ArrayList <Integer>> alphaRegion = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList <Integer>> betaRegion = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList <Integer>> turnRegion = new ArrayList<ArrayList<Integer>>();

    public static void main(String args[]){
        System.out.println("Soumen is here");
        makeMap();
        gor(protein5);
    }

    public static void makeMap() {
        try{
            File file = new File("/Users/user/Music/BioInformatics Codes/helix");
            Scanner sc = new Scanner(file);

            File file1 = new File("/Users/user/Music/BioInformatics Codes/strand");
            Scanner sc1 = new Scanner(file1);

            File file2 = new File("/Users/user/Music/BioInformatics Codes/coil");
            Scanner sc2 = new Scanner(file2);

            for(int i = 0; i < 20; i ++){
                for(int j = 0; j < 17; j++){
                    helix[i][j] = sc.nextInt();
                    strand[i][j] = sc1.nextInt();
                    coil[i][j] = sc2.nextInt();
                }
            }
            sc.close();
            sc1.close();
            sc2.close();
            
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void gor(String seq){
        System.out.println(seq.length());
        int rest = seq.length() % 17;
        System.out.println(rest);
        int alpha = 0, beta = 0, turn = 0;

        for(int i = 0; i < seq.length() - rest; i += 17){
            for(int j = i; j < i + 17; j++) {
                char c = seq.charAt(j);
                int index = getIndex(c);
                
                alpha += helix[index][j - i];
                beta += strand[index][j - i];
                turn += coil[index][j - i];

            }            
            int max1 = (int)Math.max(alpha, beta);
            int finalMax = (int)Math.max(max1, turn);

            if(finalMax == alpha){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(i + 17);
                alphaRegion.add(temp);
            } else if(finalMax == beta){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(i + 17);
                betaRegion.add(temp);
            } else if(finalMax == turn){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(i + 17);
                turnRegion.add(temp);
            }
            alpha = 0;
            beta = 0;
            turn = 0;
        }
        
        System.out.println("Alpha is: "+alphaRegion);
        alphaRegion = finalRegion(alphaRegion);
        System.out.println("Final Alpha is: "+alphaRegion);

        System.out.println("Beta is: "+betaRegion);
        betaRegion = finalRegion(betaRegion);
        System.out.println("Final Beta is: "+betaRegion);

        System.out.println("Turn is: "+turnRegion);
        turnRegion = finalRegion(turnRegion);
        System.out.println("Final Turn is: "+turnRegion);

    }
    public static ArrayList<ArrayList<Integer>> finalRegion(ArrayList<ArrayList<Integer>> reg){
        boolean isSame = false;
        while(!isSame){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(reg);
            
            temp = mergeRegion(temp);
            if(temp.equals(reg)){
                isSame = true;
                // System.out.println(temp);
                // System.out.println(reg);
            }else{
                isSame = false;
                // System.out.println("here");
                reg = temp;
                temp = mergeRegion(temp);
            }

        }
        return reg;
    }

    public static ArrayList<ArrayList<Integer>> mergeRegion(ArrayList<ArrayList<Integer>> reg){
        for(int i = 0; i < reg.size() - 1; i++){
            ArrayList<Integer> r1 = reg.get(i);
            ArrayList<Integer> r2 = reg.get(i + 1);
            int a1 = r1.get(0);
            int a2 = r1.get(1);
            int b1 = r2.get(0);
            int b2 = r2.get(1);

            if((a1 <= b1 && b1 <= a2) || (b1 <= a1 && a1 <= b2)){
                ArrayList <Integer> temp = new ArrayList<Integer>();
                temp.add((int)Math.min(a1, b1));
                temp.add((int)Math.max(a2, b2));
                reg.set(i, temp);
                reg.remove(i+1);
            }
        }
        return reg;
    }

    public static int getIndex(char c) {
        int index = -1; 
        for(int i = 0 ; i < table.length; i++){
            if(c == table[i]){
                index = i;
                break;
            }
        }
        return index;
    }

}