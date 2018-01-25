public class Main {

    public static void main(String[] args) {
        int[] sortedArray = {1,4,7,9};
        System.out.println(getNumberOfBSTs(sortedArray.length));
    }

    public static int getNumberOfBSTs(int length){
        int numberOfBSTs=0;
        int numberOfSubTreesAtLeft =0;
        int numberOfSubTreesAtRight =0;

        if (length == 0 || length==1){
            return 1;
        }

        for (int i=1; i<=length;i++){
            numberOfSubTreesAtLeft = getNumberOfBSTs(i-1);
            numberOfSubTreesAtRight = getNumberOfBSTs(length-i);
            numberOfBSTs += numberOfSubTreesAtLeft * numberOfSubTreesAtRight;
        }
        return numberOfBSTs;
    }
}
