public class BitWiseTest {
    public static void main (String[] args)
    {
        System.out.println( 7 & 3 );				// LINE 1

        System.out.println( 5 ^ 12 );				// LINE 2

        System.out.println( 14 | 23 );				// LINE 3

        System.out.println( 25 << 1 );				// LINE 4

        System.out.println( 100 >> 2 );				// LINE 5

        System.out.println( 7 & 33 | 14 );			// LINE 6

        System.out.println(Integer.parseInt("75",8));	// LINE 7

        System.out.println( Integer.toString(60,5));		// LINE 8

        System.out.println( 25 << 1 | 19 );			// LINE 9

        System.out.println( 0x12 );

        System.out.println(~15 << 3);

    }

}
