


public class Local_Global_Alignment {
	
	static int match_award = 1;
	static int mismatch_penalty = -1;
	static int gap_penalty = -2;
	
	public static void main(String args[]) {
		NeedlemanWunsch("TREE", "REED");
		System.out.println();System.out.println();
		SmithWaterman("TREE", "REED");
	}
	public static String reverse(String str) {
		String newStr = "";
		for(int i = str.length() - 1; i >=0; i--) {
			newStr += str.charAt(i);
		}
		return newStr;
	}
	
	public static int match_score(char a, char b) {
		if(a == b) return match_award;
		else if(a == '-' || b == '-') return gap_penalty;
		else return mismatch_penalty;
	}
	
	public static void SmithWaterman(String seq1, String seq2) {
		int m = seq1.length();
		int n = seq2.length();
		
		int score[][] = new int[m + 1][n + 1];
		int pointer[][] = new int[m + 1][n + 1];
		
		int max_score = -1, max_i = -1, max_j = -1;
		
		for(int i = 1; i < m + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				int score_diagonal = score[i - 1][j - 1] 
						+ match_score(seq1.charAt(i - 1), seq2.charAt(j - 1));
				int score_up = score[i][j-1] + gap_penalty;
				int score_left = score[i-1][j] + gap_penalty;
				
				int max1 = (int)Math.max(score_diagonal, score_left);
				int max2 = (int)Math.max(score_up, 0);
				
				score[i][j] = (int)Math.max(max1, max2);
				
				if(score[i][j] == 0) pointer[i][j] = 0; // 0 means end of path
				if(score[i][j] == score_left) pointer[i][j] = 1; // 1 means trace up
				if(score[i][j] == score_up) pointer[i][j] = 2; // 2 means trace left
				if(score[i][j] == score_diagonal) pointer[i][j] = 3; // 0 means trace diagonal
				
				if(score[i][j] >= max_score) {
					max_score = score[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		String align1 = "", align2 = "";
		int i = max_i, j = max_j;

		// trace back
		while(pointer[i][j] != 0) {
			if(pointer[i][j] == 3) {
				align1 += seq1.charAt(i - 1);
				align2 += seq2.charAt(j - 1);
				i -= 1;
				j -= 1;
			} else if(pointer[i][j] == 2) {
				align1 += '-';
				align2 += seq2.charAt(j - 1);
				j -= 1;
			} else if(pointer[i][j] == 1) {
				align1 += seq1.charAt(i - 1);
				align2 += '-';
				i -= 1;
			}
		}
		
		finalizeAlign(align1, align2);
	}

	public static void finalizeAlign(String align1, String align2) {
		align1 = reverse(align1);
		align2 = reverse(align2);
		
		int i = 0, j = 0;
		String symbol = "";
		int found = 0;
		int score = 0;
		int identity = 0;
		
		for(i = 0; i < align1.length(); i++) {
			if(align1.charAt(i) == align2.charAt(i)) {
				symbol += align1.charAt(i);
				identity += 1;
				score += match_score(align1.charAt(i), align2.charAt(i));
			} else if(align1.charAt(i) != align2.charAt(i) 
						&& align1.charAt(i) != '-' && align2.charAt(i) != '-') {
				score += match_score(align1.charAt(i), align2.charAt(i));
				symbol += ' ';
				found = 0;
			} else if(align1.charAt(i) == '-' || align2.charAt(i) == '-') {
				symbol += ' ';
				score += gap_penalty;
			}
		}
		
		identity = identity / align1.length() * 100;
		System.out.println(align1);
		System.out.println(align2);
		System.out.println(score);
		System.out.println(symbol);
	}

	public static void NeedlemanWunsch(String seq1, String seq2) {
		int m = seq1.length();
		int n = seq2.length();
		
		int match = 0, delete = 0, insert = 0;
		
		int score[][] = new int[m + 1][n + 1];
		
		for(int i = 0; i < m + 1; i++) score[i][0] = gap_penalty * i;
		for(int j = 0; j < n + 1; j++) score[0][j] = gap_penalty * j;
		
		for(int i = 1; i < m + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				match = score[i - 1][j - 1] + match_score(seq1.charAt(i - 1), seq2.charAt(j - 1));
				delete = score[i - 1][j] + gap_penalty;
				insert = score[i][j - 1] + gap_penalty;
				
				int max1 = (int)Math.max(match, insert);
				score[i][j] = (int)Math.max(max1, delete);
			}
		}
		
		String align1 = "", align2 = "";
		int i = m, j = n;
		
		while(i > 0 && j > 0) {
			int score_current = score[i][j];
			int score_diagonal = score[i - 1][j - 1];
			int score_up = score[i][j - 1];
			int score_left = score[i - 1][j];
			
			if(score_current == score_diagonal 
								+ match_score(seq1.charAt(i - 1), seq2.charAt(j - 1))){
				align1 += seq1.charAt(i - 1);
				align2 += seq2.charAt(j - 1);
				
				i -= 1;
				j -= 1;
			} else if(score_current == score_left + gap_penalty) {
				align1 += seq1.charAt(i - 1);
				align2 += '-';
				i -= 1;
			} else if(score_current == score_up + gap_penalty) {
				align1 += '-';
				align2 += seq2.charAt(j - 1);
				j -= 1;
			}
		}
		
		while(i > 0) {
			align1 += seq1.charAt(i - 1);
			align2 += '-';
			i -= 1;
		}
		while(j > 0) {
			align1 += '-';
			align2 += seq2.charAt(j - 1);
			j -= 1;
		}
		
		finalizeAlign(align1, align2);
	}

	
}
