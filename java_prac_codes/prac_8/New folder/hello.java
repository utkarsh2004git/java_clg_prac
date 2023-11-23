public class hello{
    public static void main(String[] args) {
        String s1="hello bro",s2="";
        int len=s1.length();
        // for(int i=len-1;i>=0;i--){
        //     s2+=s1.charAt(i);
        // }
        // System.out.println(s2);
        char a[]=s1.toCharArray();
        char temp;
        for (int i = 0; i <( a.length/2); i++) {
            temp=a[i];
            a[i]=a[len-1-i];
            a[len-1-i]=temp;
        }
        for (int i = 0; i < a.length; i++) {
           s2+=a[i];
        }
        System.out.println(s2);
    }
}