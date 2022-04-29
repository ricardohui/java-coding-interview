
class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        String str1Removed = stripSharp(str1, -1);
        String str2Removed = stripSharp(str2, -1);
        return str1Removed.equals(str2Removed);
    }

    public static String stripSharp(String str, int substringWithoutSharp) {
        for (int i = substringWithoutSharp+1; i < str.length(); i++) {
            if (str.charAt(i)!='#') {
                substringWithoutSharp++;
                continue;
            }

            return stripSharp(str.substring(0, substringWithoutSharp).concat(i+1 < str.length()? str.substring(i+1):"") , substringWithoutSharp-1);

        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#")); //true
        System.out.println(compare("xy#z", "xyz#")); // false
        System.out.println(compare("xp#", "xyz##")); //true
        System.out.println(compare("xywrrmp", "xywrrmu#p")); //true
    }
}
