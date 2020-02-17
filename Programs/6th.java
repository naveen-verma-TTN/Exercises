// There is an array with every element repeated twice except one. Find that element
class myClass {
    public static void main(String args[]) {
        char str[]= {'a', '%', 'a', '%', 'L', '3', '^', '3', 'L'};
        int count[]= new int[255];
        for(char ch : str) {
                count[(int)ch]++;
        }
        for(int i = 0; i< count.length; i++){
            if(count[i] == 1) {
                System.out.print("Character which came one time in the array is " 
                + (char)(i) + " ");
            }
        }
        System.out.println();
    }
}