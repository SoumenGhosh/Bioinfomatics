import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
// import java.util.Collection;
// import java.util.LinkedList;
import java.util.Collections;

public class ChouFasman {

    static String protein1 = "MKIDAIVGRNSAKDIRTEERARVQLGNVVTAAALHGGIRISDQTTNSVETVVGKGESRVLIGNEYGGKGFWDNHHHHHH";
    static String protein2 = "MRRYEVNIVLNPNLDQSQLALEKEIIQRALENYGARVEKVAILGLRRLAYPIAKDPQGYFLWYQVEMPEDRVNDLARELRIRDNVRRVMVVKSQEPFLANA";
    static String protein3 = "MVGLTTLFWLGAIGMLVGTLAFAWAGRDAGSGERRYYVTLVGISGIAAVAYVVMALGVGWVPVAERTVFAPRYIDWILTTPLIVYFLGLLAGLDSREFGIVITLNTVVMLAGFAGAMVPGIERYALFGMGAVAFLGLVYYLVGPMTESASQRSSGIKSLYVRLRNLTVILWAIYPFIWLLGPPGVALLTPTVDVALIVYLDLVTKVGFGFIALDAAATLRAEHGESLAGVDTDAPAVAD";
    static String protein4 = "MNGTEGPNFYVPFSNKTGVVRSPFEAPQYYLAEPWQFSMLAAYMFLLIMLGFPINFLTLYVTVQHKKLRTPLNYILLNLAVADLFMVFGGFTTTLYTSLHGYFVFGPTGCNLEGFFATLGGEIALWSLVVLAIERYVVVCKPMSNFRFGENHAIMGVAFTWVMALACAAPPLVGWSRYIPEGMQCSCGIDYYTPHEETNNESFVIYMFVVHFIIPLIVIFFCYGQLVFTVKEAAAQQQESATTQKAEKEVTRMVIIMVIAFLICWLPYAGVAFYIFTHQGSDFGPIFMTIPAFFAKTSAVYNPVIYIMMNKQFRNCMVTTLCCGKNPLGDDEASTTVSKTETSQVAPA";
    static String protein5 = "DITCCGQFHFAIIYHDWQYKIFRYAATSPVKEPWKHRMWYSIVAANDVENCNSFHGPYQQKHQWQDNTAQYLEYKTIGYQKRDQPNNVWIHHPMVYYEPVHYRQFNDRQAFTYSDQFCSKSCTIIWNGEANQCHNKQTASDHTGWPRMFAYLKENYTQYSTFFICMLDKYTCSNMKSLPEMHWELMEWALMCSCEKERARYQCNSWRKSIADPEFNYCIAWMFCKHEEKGEETRCEQKHQALLPPHEDYGDSLNDCQVNNGEPYTTKGEQRVKLQKEGHKNEQCRKATKRKYQASQCEAKREMMKNWRSYTATESNARVMQHWRQWRLHSMCVITDDHTQRRETCEAKENRMLRTALHIWVVWASHWFPVMNITQIWTGEDHGDHNSFLALCDSVVASYRILEQQLECCPNEDQCPMSIFHYKVKMCWEWRIVYAPNQSHTRNCALDFKKMEPIAGMMHCPGMQSGMLTSDRPVLEPGSVENPLFDNHVRFSYFFEQVNNGKFMLECSTCGDNEEIFGYHCIVQNYQDCASAKSAIFCFMFANQHAERGWSPGLIVRNF";
    static String protein6 = "MQSIEDIWQETLQIVKKNMSKPSYDTWMKSTTAHSLEGNTFIISAPNNFVRDWLEKSYTQFIANILQEITGRLFDVRFIDGEQEENFEYTVIKPNPALDEDGIEIGKHMLNPRYVFDTFVIGSGNRFAHAASLAVAEAPAKAYNPLFIYGGVGLGKTHLMHAVGHYVQQHKDNAKVMYLSSEKFTNEFISSIRDNKTEEFRTKYRNVDVLLIDDIQFLAGKEGTQEEFFHTFNTLYDEQKQIIISSDRPPKEIPTLEDRLRSRFEWGLITDITPPDLETRIAILRKKAKADGLDIPNEVMLYIANQIDSNIRELEGALIRVVAYSSLVNKDITAGLAAEALKDIIPSSKSQVITISGIQEAVGEYFHVRLEDFKAKKRTKSIAFPRQIAMYLSRELTDASLPKIGDEFGGRDHTTVIHAHEKISQLLKTDQVLKNDLAEIEKNLRKAQNMF";
    static String protein7 = "MALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKMALEKIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVY";
    static String protein8 = "IVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVYIVY";
    static String protein9 = "MALEKMALEKMALEKMALEKMALEKMALEKMALEK";
    // >tr|A0PQ23|A0PQ23_MYCUA Chorismate pyruvate-lyase
    
    static ArrayList<Double>Pa = new ArrayList<Double>();
	static ArrayList<Double>Pb = new ArrayList<Double>();
	static ArrayList<Double>Pturn = new ArrayList<Double>();
	static ArrayList<Double>F0 = new ArrayList<Double>();
	static ArrayList<Double>F1 = new ArrayList<Double>();
	static ArrayList<Double>F2 = new ArrayList<Double>();
    static ArrayList<Double>F3 = new ArrayList<Double>();
    
    static ArrayList<ArrayList<String>> acids = new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
    

    public static void main(String args[]) {
        // System.out.println(protein1);
        makeMap();
        chouFasmas(protein7);
    }

    public static void makeMap() {
		
		try {
			File file = new File("/Users/user/Music/BioInformatics Codes/acids");
			Scanner sc = new Scanner(file);			
			int count = 0;			
			while(sc.hasNextLine()) {
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 0; i < 3; i ++) temp.add(sc.next());
				acids.add(count++, temp);
			}
			sc.close();
			
			File file1 = new File("/Users/user/Music/BioInformatics Codes/acidTable");
			Scanner sc1 = new Scanner(file1);
			int count1 = 0;
			while(sc1.hasNextLine()) {
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 0; i < 8; i ++) temp.add(sc1.next());
				table.add(count1++, temp);
				
			}
			sc1.close();
			// System.out.println(acids);
			// System.out.println(table);
			
			for(int i = 0; i < table.size(); i++) {
				Pa.add(Double.parseDouble(table.get(i).get(1)));
				Pb.add(Double.parseDouble(table.get(i).get(2)));
				Pturn.add(Double.parseDouble(table.get(i).get(3)));
				F0.add(Double.parseDouble(table.get(i).get(4)));
				F1.add(Double.parseDouble(table.get(i).get(5)));
				F2.add(Double.parseDouble(table.get(i).get(6)));
				F3.add(Double.parseDouble(table.get(i).get(7)));
			}
			// System.out.println(Pa);
		} catch(Exception ex) {
			System.err.println("err");
		}
		
	}
    
    public static int getIndex(char c) {
        int index = -1; 
        for(int i = 0; i < table.size(); i++){
            String temp = table.get(i).get(0);
            char tempChar = temp.charAt(0);
            if(c == tempChar){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public static int getTotal(ArrayList<ArrayList<String>> tmp){
        int val = 0;
        for(int i = 0; i < tmp.size();i++){
            ArrayList<String> temp = tmp.get(i);
            String a1 = temp.get(0);
            String a2 = temp.get(1);
            int x1 = Integer.parseInt(a1);
            int x2 = Integer.parseInt(a2);
            for(int j = x1; j < x2; j++){
                val++;
            }
        }
        return val;
    }
    
    public static void chouFasmas(String seq) {
        // System.out.println(seq);
        ArrayList <ArrayList<String>> alphas = new ArrayList<ArrayList<String>>();
        ArrayList <ArrayList<String>> betas = new ArrayList<ArrayList<String>>();
        ArrayList <String> turns = new ArrayList<String>();

        alphas = findAlpha(seq);
        betas = findBeta(seq);
        turns = findTurn(seq);
        System.out.println(seq.length());
        // System.out.println("first Alphas: "+alphas);
        // System.out.println("first Betas: "+betas);

        
        alphas = act(alphas);
        betas = act(betas);
        System.out.println("initial Alphas: "+alphas);
        System.out.println("initial Betas: "+betas);
        System.out.println("turns: "+turns);
        // int al = getTotal(alphas);
        // int be = getTotal(betas);
        
        // System.out.println(al +" "+ be+" "+turns.size());
        // separateValue(alphas, betas, seq);
        getFinal(alphas, betas, seq);        
    }

    public static void getFinal(ArrayList<ArrayList<String>> alphas, 
                                    ArrayList<ArrayList<String>> betas, String seq) {
        ArrayList<ArrayList<String>> testAlphas = alphas;
        ArrayList<ArrayList<String>> testBetas = betas;
        ArrayList<ArrayList<String>> alpha2 = new ArrayList<ArrayList<String>>();

        while(testAlphas.size() > 0){
            int x = testAlphas.size() - 1;
            ArrayList<String> alpha = testAlphas.get(x);
            testAlphas.remove(x);
            boolean shortAlpha = false;

            // System.out.println(testBetas.size()); // works good

            for(int i = 0; i < testBetas.size(); i++){
                ArrayList<String> beta = testBetas.get(i);
                // System.out.println(beta);
                if(regionOverlap(alpha, beta)){
                    int inter[] = regionIntersect(alpha, beta); // good up
                    // System.out.println(inter[0] +" "+inter[1]);

                    int sumPa = 0, sumPb = 0;
                    for(int j = inter[0]; j < inter[1] + 1; j++) {
                        sumPa += Pa.get(getIndex(seq.charAt(j)));
                        sumPb += Pb.get(getIndex(seq.charAt(j)));
                    }
                    // System.out.println(sumPa+" "+sumPb); // good up
                    if(sumPa > sumPb) { // alpha helix region
        //                 // System.out.println("alpha");
                        int diff[] = regionDiff(beta, alpha);
                        // System.out.println("dfsfsdfsd");
                        // System.out.println(diff[0]+" "+diff[1]);
                        ArrayList <String> temp1 = new ArrayList<String>();
                        ArrayList <String> temp2 = new ArrayList<String>();
                        temp1.add(""+diff[0]);
                        temp1.add(""+diff[1]);
                        temp2.add(""+diff[2]);
                        temp2.add(""+diff[3]);
                        for(int j = 0; j < diff.length; j += 2) {
                            if(diff[j + 1] - diff[j] > 4) {
                                testBetas.add(temp1);
                                testBetas.add(temp2);
                            }
                        }
                        testBetas.remove(i);
                    } else {
        
                        shortAlpha = true;
                        int diff[] = regionDiff(alpha, beta);
                        // System.out.println(diff[0]+" "+diff[1]);
                        ArrayList <String> temp1 = new ArrayList<String>();
                        ArrayList <String> temp2 = new ArrayList<String>();
                        temp1.add(""+diff[0]);
                        temp1.add(""+diff[1]);
                        temp2.add(""+diff[2]);
                        temp2.add(""+diff[3]);
                        for(int j = 0; j < diff.length; j += 2) {
                            if(diff[j + 1] - diff[j] > 4){
                                testAlphas.add(temp1);
                                testAlphas.add(temp2);
                            }
                        }

                    }
                }
            }
            // System.out.println(shortAlpha);
            if(!shortAlpha){
                alpha2.add(alpha);
            }
        }

        alphas = alpha2;
        betas = testBetas;

        alphas = removeDuplicate(alphas);
        betas = removeDuplicate(betas);
        // Collections.reverse(alphas);
        
        
        System.out.println("final Alpha "+alphas); 
        System.out.println("final Betas "+betas);
    }

    public static ArrayList<ArrayList<String>> removeDuplicate(ArrayList<ArrayList<String>> temp){
        temp = (ArrayList<ArrayList<String>>) temp.stream().distinct().collect(Collectors.toList());
        for(int i = 0; i < temp.size();i++){
            ArrayList<String> newTemp = temp.get(i);
            int arr[] = indexes(newTemp);
            if(arr[0] == arr[1]){
                temp.remove(i);
            }
        }
        return temp;
    }

    public static int[] indexes(ArrayList<String> temp){
        int arr[] = new int[2];
        String a1 = temp.get(0);
        String a2 = temp.get(1);
        arr[0] = Integer.parseInt(a1);
        arr[1] = Integer.parseInt(a2);
        return arr;
    }

    public static ArrayList<ArrayList<String>> act(ArrayList<ArrayList<String>> data){
        int x = 0;
        while(x < data.size() - 1){
            if(regionOverlap(data.get(x), data.get(x + 1))){
                int merge[] = regionMerge(data.get(x), data.get(x + 1));
                ArrayList <String> temp = new ArrayList<String>();
                temp.add(""+merge[0]);
                temp.add(""+merge[1]);
                
                data.set(x, temp);
                data.remove(x + 1);
            } else {
                x++;
            }
        }
        return data;
    }

    public static ArrayList<ArrayList<String>> findAlpha(String seq){
        int start = (int)Math.random() * (seq.length() - 5);
        ArrayList <ArrayList<String>> results = new ArrayList<ArrayList<String>>();

        while(start + 6 < seq.length()){
            int goodAminoAcid = 0;
            int maker = 0, breaker = 0;
            for(int i = start; i < start + 6; i++){
                char c = seq.charAt(i);
                int index = getIndex(c);
                
                //new
                if(c == 'M' || c == 'A' || c == 'L' || c == 'E' || c == 'K'){
                    maker++;
                }
                if(c == 'G' || c == 'P'){
                    breaker++;
                }

                if(Pa.get(index) >= 103 || (Pa.get(index) >= Pb.get(index))){ //100
                    // System.out.println(Pa.get(index) +" "+ Pb.get(index));
                    goodAminoAcid++;
                }
                
            }
            //new
            // if(maker >= 3 && breaker <= 2){
                // System.out.println("Possible"+" "+ start+" "+goodAminoAcid);
                
            // }
            // System.out.println(goodAminoAcid);
            if(goodAminoAcid >= 4 || (maker >= 3 && breaker <= 2)){
                // System.out.println("hi");
                int startEnd[] = new int[2];
                startEnd = extendAlpha(seq, start, start + 6);
                // System.out.println(startEnd[0]+" "+startEnd[1]);
                ArrayList <String> temp = new ArrayList<String>();
                temp.add(""+startEnd[0]);
                temp.add(""+startEnd[1]);

                if(!results.contains(temp)){
                    results.add(temp);
                }
            }

            start++;
        }
        return results;
    }

    public static int []extendAlpha(String seq, int start, int end){
        int arr[] = new int[2];
        int endSum = 0;
        

        int n = 0;
        for(int i = end - 3; i < end + 1; i++){
            int index = getIndex(seq.charAt(i));
            endSum += Pa.get(index);
            if(Pa.get(index) < 100){
                n++;
            }
        }

        double endAvg = endSum / 4;
        // System.out.println(n+ " "+ endAvg);
        if(endAvg > 100 && end < seq.length() - 1 && n < 4){
            end++;
        }

        int startSum = 0;
        int m = 0;
        for(int i = start; i < start + 4; i++){
            int index = getIndex(seq.charAt(i));
            startSum += Pa.get(index);
            if(Pa.get(index) < 100) {
                m++;
            }
        }
        double startAvg = startSum / 4;
        if(startAvg > 100 && start > 0 && m < 4){
            start--;
        }
        arr[0] = start;
        arr[1] = end;

        
        // System.out.println(start+" "+end);
        return arr;
    }

    public static ArrayList<ArrayList<String>> findBeta(String seq){
        int start = (int)Math.random() * (seq.length() - 5);
        // System.out.println(start);
        // int start = 100;
        ArrayList <ArrayList<String>> results = new ArrayList<ArrayList<String>>();

        while(start + 5 < seq.length()){
            int goodAminoAcid = 0;
            int maker = 0, breaker = 0;
            for(int i = start; i < start + 5; i++){
                char c = seq.charAt(i);
                int index = getIndex(c);

                if(c == 'I' || c == 'V' || c == 'Y'){
                    maker++;
                }
                if(c == 'N' || c == 'P' || c == 'Q'){
                    breaker++;
                }


                if(Pb.get(index) >= 105 || (Pb.get(index) >= Pa.get(index))){
                    goodAminoAcid++;
                }
            }

            if(goodAminoAcid >= 3 || (maker >= 3 && breaker <= 2)){
                int startEnd[] = new int[2];
                startEnd = extendBeta(seq, start, start + 5);
                ArrayList <String> temp = new ArrayList<String>();
                temp.add(""+startEnd[0]);
                temp.add(""+startEnd[1]);

                if(!results.contains(temp)){
                    results.add(temp);
                }
            }
            start++;
        }
        return results;
    }

    public static int []extendBeta(String seq, int start, int end){
        int arr[] = new int[2];
        int endSum = 0;
        int n = 0;
        

        for(int i = end - 3; i < end + 1; i++){
            int index = getIndex(seq.charAt(i));
            endSum += Pb.get(index);
            if(Pb.get(index) < 100){
                n++;
            }
        }

        double endAvg = endSum / 4;
        // System.out.println(endAvg);
        if(endAvg > 100 && end < seq.length() - 1 && n < 4){
            end++;
        }

        int startSum = 0;
        int m = 0;
        for(int i = start; i < start + 4; i++){
            int index = getIndex(seq.charAt(i));
            startSum += Pb.get(index);
            if(Pb.get(index) < 100) {
                m++;
            }
        }
        double startAvg = startSum / 4;
        if(startAvg > 100 && start > 0 && m < 4){
            start--;
        }
        arr[0] = start;
        arr[1] = end;
        return arr;
    }

    public static ArrayList<String> findTurn(String seq){
        ArrayList <String> results = new ArrayList<String>();

        for(int i = 0; i < seq.length() - 3; i++) {
            boolean c1 = false;
            boolean c2 = false;
            boolean c3 = false;

            if(F0.get(getIndex(seq.charAt(i))) * F1.get(getIndex(seq.charAt(i + 1))) 
                * F2.get(getIndex(seq.charAt(i + 2))) * F3.get(getIndex(seq.charAt(i + 3)))  
                                                            > 0.000075){
                c1 = true;
            } 
            double sumTurn = 0;
            double sumA = 0, sumB = 0;
            for(int x = i; x < i + 4; x++){
                sumTurn += Pturn.get(getIndex(seq.charAt(x)));
                sumA += Pa.get(getIndex(seq.charAt(x)));
                sumB += Pb.get(getIndex(seq.charAt(x)));
            }
            double avgTurn = sumTurn / 4;
            if(avgTurn > 100) {
                c2 = true;
            }
            if(sumTurn > Math.max(sumA, sumB)){
                c3 = true;
            }

            if(c1 == true && c2 == true && c3 == true){
                results.add(""+i);
            }
        }
        return results;
    }


    public static boolean regionOverlap(ArrayList<String> r1, ArrayList<String> r2){
        boolean isOverlap = false;
        // System.out.println(r1+"---"+r2);
        String x1 = (String) r1.get(0);
        String x2 = (String) r1.get(1);

        String y1 = (String) r2.get(0);
        String y2 = (String) r2.get(1);

        int a1 = Integer.parseInt(x1);
        int a2 = Integer.parseInt(x2);

        int b1 = Integer.parseInt(y1);
        int b2 = Integer.parseInt(y2);
        
        // System.out.println(a1+" "+a2+"-----"+b1+" "+b2);
        if((a1 <= b1 && b1 <= a2) || (b1 <= a1 && a1 <= b2)){
            isOverlap = true;
        }
        return isOverlap;
    }

    public static int[] regionMerge(ArrayList<String>r1, ArrayList<String> r2){
        int arr[] = new int[2];
        String x1 = (String) r1.get(0);
        String x2 = (String) r1.get(1);

        String y1 = (String) r2.get(0);
        String y2 = (String) r2.get(1);

        int a1 = Integer.parseInt(x1);
        int a2 = Integer.parseInt(x2);

        int b1 = Integer.parseInt(y1);
        int b2 = Integer.parseInt(y2);

        arr[0] = (int)Math.min(a1, b1);
        arr[1] = (int)Math.max(a2, b2);
        return arr;
    }


    public static int[] regionIntersect(ArrayList<String> r1, ArrayList<String> r2){
        int arr[] = new int[2];
        String x1 = (String) r1.get(0);
        String x2 = (String) r1.get(1);

        String y1 = (String) r2.get(0);
        String y2 = (String) r2.get(1);

        int a1 = Integer.parseInt(x1);
        int a2 = Integer.parseInt(x2);

        int b1 = Integer.parseInt(y1);
        int b2 = Integer.parseInt(y2);

        arr[0] = (int)Math.max(a1, b1);
        arr[1] = (int)Math.min(a2, b2);
        return arr;
    }

    public static int[] regionDiff(ArrayList<String> r1, ArrayList<String> r2){
        int arr[] = new int[4];
        String x1 = (String) r1.get(0);
        String x2 = (String) r1.get(1);

        String y1 = (String) r2.get(0);
        String y2 = (String) r2.get(1);

        int a1 = Integer.parseInt(x1);
        int a2 = Integer.parseInt(x2);

        int b1 = Integer.parseInt(y1);
        int b2 = Integer.parseInt(y2);

        // region_a start before region_b and stop before region_b
        if(a1 < b1 && a2 <= b2){
            arr[0] = a1;
            arr[1] = b1 - 1;
        }
        //region_a start after region_b and stop after region_b
        else if(a1 >= b1 && a2 > b2){
            arr[0] = b2 +1;
            arr[1] = a2;
        }

        //region_b is included in region_a => return 2 regions
        else if(a1 < b1 && a2 > b2){
            arr[0] = a1;
            arr[1] = b1 - 1;
            arr[2] = b2 + 1;
            arr[3] = a2;
        } 
        // region_a is included in region_b
        else {
            Arrays.fill(arr, 0);
        }
        return arr;
    }

}
