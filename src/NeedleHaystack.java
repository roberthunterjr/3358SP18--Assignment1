public class NeedleHaystack {
    public NeedleHaystack() {

    }

    public static void main (String[] args) {
        System.out.println("Hello ");
        System.out.println(" ");
        String needle = MyUtil.getInput("Please enter your needle",1);
        String[] haystacks = getHaystacks();
        searchNeedleInHaystack(needle, haystacks);
    }

    public static String[] getHaystacks() {
        String haystack1 = "The following is an example of what a haystack should consist of.";
        String haystack2 = "This haystack will contain a few numbers to check: 1, 2, 3, 2, 3, 1, 1";
        String haystack3 = "Not all haystacks have to be long haystacks";
        String haystack4 = "In fact, this haystack will intentionally be left short to show the other haystacks...wait this haystack is long";
        String haystack5 = "Weird Haystack with extra ee eee ee lets see when a needle is ee";
        String[] haystacks = new String[]{haystack1, haystack2, haystack3, haystack4, haystack5};
        return haystacks;
    }

    /***
     * This function is to be called on each haystack to begin the search process
     * @param needle A string representing the search term
     * @param haystack The string to search for the needle
     * @return returns the number of needles in haystack
     */
    public static int getNumNeedlesInHaystack(String needle, String haystack) {
        // Will use scanforNeedle to perform a linear search of the haystack
        int needleCount = 0;
        haystack = haystack.toLowerCase();   // handle the all case situations
        char firstChar = needle.charAt(0);  //When this char shows up in haystack it is a possible needle

        //  Iterater linearly through the haystack
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == firstChar && scanForNeedle(needle, haystack, i)) {
                needleCount += 1;
            }
        }
        return needleCount;
    }

    /***
     *
     * @param needle represents the String that we are searching for
     * @param haystack represents the String that may contain the needle
     * @param haystackIndex represents the index that the first Char of the needle was found in the haystack
     * @return was this indeed a needle
     */
    public static boolean scanForNeedle(String needle, String haystack, int haystackIndex) {
        int needleLength = needle.length(); // Used to see how far in the haystack to go
        int endPoint = (haystackIndex + needleLength >= haystack.length()) ? haystack.length() - haystackIndex : needleLength;    // The last index the loop needs to check before confirming needle

        for (int i = 0; i < endPoint; i++) {
            if(needle.charAt(i) != haystack.charAt(haystackIndex + i)) {
                return false;
            }
        }
        //  If we get here, then we have a match
        return true;
    }
    public static void showResults(String needle, String haystack, int count){
        System.out.println("Your haystack: ");
        System.out.println(haystack);
        System.out.println("Your needle: "+needle);
        System.out.println("Number of instances: "+ count+"\n");
    }

    public static void searchNeedleInHaystack(String needle, String[] haystacks) {
        for (int i = 0; i < haystacks.length; i++) {
            int numNeedles = getNumNeedlesInHaystack(needle, haystacks[i]);
            showResults(needle, haystacks[i], numNeedles);
        }
    }



}
