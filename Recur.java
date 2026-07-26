class Recur{
    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
     

    public static void printfib(int a , int b , int n){
        if(n==0){
            return;
    }    

     int c = a + b  ;
     System.out.print(c + " ");
     printfib(b, c, n - 1);    
}  


public static int calcPower(int x, int n) {
    if (n == 0) {
        return 1;
    }

  
    if (n % 2 == 0) {
        return   calcPower(x, n / 2) *  calcPower(x, n / 2) ;
    } else {
        return   calcPower(x, n / 2) *  calcPower(x, n / 2) * x;
    }

}

public int sum(){
    return sumHelper(5);
}

public static int sumHelper(int n) {
    if (n == 0) {
        return 0;
    }
    return n + sumHelper(n - 1);
}
    
    public static void main(String[] args){
        // int a = 0;
        // int b = 1;
        // System.out.print(a + " " + b + " ");
        // int n = 7;

        // // System.out.println(factorial(n));
        // printfib(a, b, n-2); 

        int x = 2;
        int n = 5;
        System.out.println(calcPower(x, n));
    }


}