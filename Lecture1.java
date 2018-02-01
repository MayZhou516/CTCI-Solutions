// Lecture 1 Questions and Solutions

// CTCI Q1.1: check whether or not a string is made from all unique characters
// Assumptions: 128 characters
static boolean isUnique(String str) {
	// if the length of the string is > 128 there is no way it can be unique 
	// if there are only 128 unique characters, immediately return false
	if (str.length() > 128) {
		return false;
	}
	// creates an array 128 in length, all elements are false so it looks like
	//    0      1      2          127
	// [false, false, false ..., false]
	boolean [] char_set = new boolean[128];
	for(int i = 0; i < str.length(); i++) {
		// if the element has already been flipped to true
		// this is the second time you're visiting that char
		// indicates a repeat, return false
		if (char_set[str.charAt(i)]) {
			return false;
		}
		// str.charAt(i) will return a int, pointing to the array, always flip
		// the false to true
		char_set[str.charAt(i)] = true;
	}
	return true;
}

/* This is the solution we came up with in class! Assume we're dealing
 * with 128 characters. */
static boolean isUnique(String str) {
  
  // Since we are dealing with 128 characters, anything longer has duplicates.
  if (str.length() > 128) return false;

  /* Create an array of length 128, where each spot represents a character.
   * 'a' -> 0th index, 'b' -> 1st index, etc... Each spot is initialized to 0. 
   * The purpose of this array to count the number of occurences of each character
   * in the string. */
  int[] char_count = new int[128];

  for (int i=0; i < str.length(); i++) {
    /* This will take the character at a particular index in the string, automatically
     * convert it to it's numerical equivalent (EX: 'a' -> 0), and access that
     * index in the array. Then it will increment the value stored at that index
     * by one. */
    char_count[str.charAt(i)]++; 
  }

  // Iterate through the array to find anything > 1, which means duplicates were found.
  for (int i=0; i < 128; i++) {
    if (char_count[i] > 1) return false;
  }

  return true;
}

// CTCI Q1.4: rotate a N x N matrix by 90 degrees anticlockwise
// This solution is not from CTCI solutionn since that one is very confusing
static void rotateMatrix(int N, int mat[][]) {
	// Consider all squares one by one, only need to go through half of matrix
	// which is why the loop goes until N/2
	for (int x = 0; x < N / 2; x++) {
		// Consider elements in group of 4 in 
		// current square
		for (int y = x; y < N-x-1; y++) {
			// store current cell in temp variable
			int temp = mat[x][y];
			// move values from right to top
			mat[x][y] = mat[y][N-1-x];
			// move values from bottom to right
			mat[y][N-1-x] = mat[N-1-x][N-1-y];
			// move values from left to bottom
			mat[N-1-x][N-1-y] = mat[N-1-y][x];
			// assign temp to left
			mat[N-1-y][x] = temp;
		}
	}
}

// CTCI Q1.8: given the function isSubstring() which returns whether or not two strings 
// substrings of one another, and using isSubstring once, check if two strings are a
// rotation of one another. For example: APPLE and PPLEA are rotations, but APPLE and PLEPA
// are not (not synonymous to an anagram)

public static boolean isRotation (String s1, String s2) {
	int s1Len = s1.length();
	int s2Len = s2.length();
	// the algorithm works because if you double any string, the rotation must
	// exist within the doubled string
	// for example, the rotations for apple are itself, pplea, pleap, leapp, eappl
	// and they exist within appleappel as aPPLEAppel, apPLEAPpel, etc.
	if (s1Len == s2Len && s1Len > 0 && s2Len > 0) {
		String repeat = s1 + s1;
		return isSubstring(repeal, s2);
	}
	return false;
}

