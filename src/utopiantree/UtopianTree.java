package utopiantree;

import java.util.Scanner;

/**
 *
 * @author Slava
 * 
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. 
 * Each summer, its height increases by 1 meter.
 *
 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. 
 * How tall will her tree be after N growth cycles?
 * 
 * Input Format
 *
 * The first line contains an integer, T, the number of test cases. 
 * T subsequent lines each contain an integer, N, denoting the number of cycles for that test case.
 * 
 * Output Format
 * 
 * For each test case, print the height of the Utopian Tree after N cycles. 
 * Each height must be printed on a new line.
 * 
 */
public class UtopianTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] inputArray = new int[t];
        
        for(int a0 = 0; a0 < t; a0++){
            inputArray[a0] = in.nextInt(); 
        }
        
        for(int i = 0; i < t; i++){
            System.out.println(getTreeHeightBinary(inputArray[i]));
        }
    }
    
    private static int getTreeHeight(int nrCycles)
    {
        int height = 1;
        
        for(int i = 0; i < nrCycles/2; i++)
        {
            height = height * 2 + 1;
        }
        
        if(nrCycles % 2 == 1)
            height *= 2;
        
        return height;
    }
    
    /*
     * This implementation does the same as getTreeHeight using binary operations instead.
     * This is of course ludicrously fast, but difficult to read and understand.
     * 
     * The method divides nrCycles by 2 to get number of years (the remainder of division is lost in a right shift operation):
     * nrCycles >> 1
     * and then it adds 1 to left shift an extra step in the next operation
     * (nrCycles >> 1) + 1
     * The result gives us the number of times we need to shift left a 1, which we do in the next step:
     * 1 << ((nrCycles >> 1) + 1)
     * we subtract 1 from the result to get only ones after our 1 that we shifted left 
     * for nrCycles=10 we will get 1000000. In order to turn this into 111111 we subtract -1 in the next step
     * (1 << ((nrCycles >> 1) + 1)) - 1
     * In the last step the result is multiplied by 2 with a shift to right operation as in getTreeHeight
     * in case nrCycles/2 gives a remainder that equals 1 
     * ((1 << ((nrCycles >> 1) + 1)) - 1) << nrCycles % 2.
     * or written in binary operations:
     * ((1 << ((nrCycles >> 1) + 1)) - 1) << (nrCycles & 1)
    */
    private static int getTreeHeightBinary(int nrCycles)
    {
        return ((1 << ((nrCycles >> 1) + 1)) - 1) << (nrCycles & 1);
    }
}
