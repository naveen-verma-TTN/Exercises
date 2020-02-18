// Create a custom exception that do not have any stack trace.
class JavaException{
   public static void main(String args[]){
  try{
       throw new myException("myException");
  }
 catch(myException e){
    System.out.println(e) ;
 }
}
}
class myException extends Exception{
    String s;
   myException(String str) {
     s = str;
   }
   public String toString(){
     return ("Exception: " + s) ;
  }
}