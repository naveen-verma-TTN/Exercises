// WAP to sorting string without using string Methods
class myClass {

    int compareStr(String s1, String s2)
    {
        int c = 0;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i<s1.length() && i<s2.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(a<b){
                c = 1;
                break;
            }
            else if(a>b)
            {
                c=-1;
                break;
            }
            else
            {
                continue;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        String str = "this is a apple";
        String s2[] = str.split(" ");
        int count = s2.length;
        String temp;
        int m=0;
        myClass obj = new myClass();
        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                m = obj.compareStr(s2[i],s2[j]);
                if(m<0)
                {
                    temp = s2[i];
                    s2[i] = s2[j];
                    s2[j] = temp;
                }
            }
        }

        for (String s : s2) {
            System.out.println(s);
        }


    }
}
