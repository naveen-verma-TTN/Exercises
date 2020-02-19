// Create a custom exception that do not have any stack trace.
class JavaException{
   public static void main(String args[]){
  try{
       throw new myException("myException", true);
  }
 catch(myException e){
    System.out.println(e) ;
 }
}
}


class myException extends Exception {

  private boolean suppressStacktrace = false;

  public myException(String message, boolean suppressStacktrace) {
      super(message, null, suppressStacktrace, !suppressStacktrace);
      this.suppressStacktrace = suppressStacktrace;
  }

  @Override
  public String toString() {
      if (suppressStacktrace) {
          return getLocalizedMessage();
      } else {
          return super.toString();
      }
  }
}