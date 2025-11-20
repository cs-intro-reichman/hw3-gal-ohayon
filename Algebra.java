// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(-2,6));   // 2 + 3
	    //System.out.println(minus(-3,-5));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(-5,-12));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(2,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(9,9));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(9,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2<0)
		{
			for (int i = 0; i > x2; i--) {
			x1--;
		}
		}
		else
		{
		for (int j = 0; j < x2; j++) {
			x1++;
		}
		}
		return x1;
	}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		if(x2<0)
		{
			for (int i = 0; i > x2; i--) {
			x1++;
		}
		}
		else
		{
		for (int j = 0; j < x2; j++) {
			x1--;
		}
		}
		return x1;
	
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int count=0;
			if((x1>0)&&(x2>0))
			{
			for (int i = 0; i < x1; i++) {
			for (int j= 0; j < x2;j++) 
			{	
				count++;
			}
			}}
			else if ((x1>0)&&(x2<0)){
				for (int i = 0; i < x1; i++) {
			for (int j= 0; j > x2;j--) 
			{	
				count--;
			}
			}}
			else if ((x1<0)&&(x2>0)){
				for (int i = 0; i > x1; i--) {
			for (int j= 0; j < x2;j++) 
			{	
				count--;
			}
			}}
			else if ((x1<0)&&(x2<0)){
				for (int i = 0; i > x1; i--) {
			for (int j= 0; j > x2;j--) 
			{	
				count++;
			}
			}}
		return count;
	
		
	}

	// Returns x^n (for n >= 0)
public static int pow(int x, int n) {
    int result = 1; 
    int i = 0;
    while (i < n) {
        result = times(result, x);  
        i++;                       
    }
    return result;
}

	// Returns the integer part of x1 / x2 
public static int div(int x1, int x2) {
    if (x2 == 0) {
      
        return 0;
    }

    int sign = 1; 

    if (x1 < 0) {
        x1 = minus(0, x1);    
        sign = minus(0, sign); 
    }


    if (x2 < 0) {
        x2 = minus(0, x2);   
        sign = minus(0, sign); 
    }

    int count = 0;

   
    while (x1 >= x2) {
        x1 = minus(x1, x2);   
        count++;           
    }

   
    if (sign < 0) {
        count = minus(0, count); 
    }

    return count;
}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
    int q = div(x1, x2);
    int prod = times(q, x2);
    int r = minus(x1, prod);
    return r;
}



	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
    int i = 0;
    while (times(i, i) <= x) {
        i++;
    }
    return i - 1;
}

}