public class KMP {
    private static int[] getNext(String str){
        if(str == null || str.length() == 0) return null;
        int len = str.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 1,j = -1;
        while(i < len - 1){
            if(j == -1 || str.charAt(i) == str.charAt(j)){
                j++;
                i++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }
    public static int getIndex(String t, String s){
        if(s == null || s.length() == 0){
            return -1;
        }
        if(t == null || t.length() == 0){
            return 0;
        }
        int[] next = getNext(t);
        int i = 0, j = 0;
        while(i < t.length() && j < s.length()){
            if(t.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else{
                if(next[i] == -1){
                    j++;
                    i = 0;
                }else{
                    i = next[i];
                }
            }
            if(i == t.length()){
                return j - i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(getIndex("ababb","aabaabaabbabbbabbababababababaaabaababababbabababaabbbabbabbaba") );
    }
}
