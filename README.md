# NumberOfBSTs
You are given a list of sorted integers. you need to return the total number of possible BSTs.

First of all:
Number_of_subtrees_at_left * Number_of_subtrees_at_right = the total number of subtrees for each element in the array as root
And 0 or 1 adjacent element both means 1 BST.

The code submitted is a recursive solution.

This is how I computed the number of BSTs first when I tried to do this via an iterative solution but it works only for: length <=3

For example:
{1,2,3}
 1 as root: 1 subtree at left (0 elements at left which will cause 1 bst) * 2 at right (2 elements at right)
So for length <=3, the number of BSTs at left equals to the number of elements at left with an exception of 0 element also causes 1 BST. And the same with the right side.

Then I realized that, I know the solution for the small scope of the problem but it doesn’t work for length>3.

For example:
{1,2,3,4}
The number of  BSTs at right for “2” is 2 which equals to the number of elements at left but it’s not the same with 1 or 4. The number of BSTs at right for “1” is 5 which is larger than the number of the elements at right.

So I decided to breakdown the problem to calculate the numbers based on the small-scoped problems which I already know how to deal with.

This is the reason why I go for a recursive solution. When I know the answer of the small-scoped problem but not for the general case.


Here is the iterative solution I developed first which only works for length<=3

public static int getNumberOfBSTs(int[] numbers){
   int BSTs = 0;
   for (int i=0; i<numbers.length;i++){
       int leftSubtrees = 0;
       int rightSubtrees = 0;
       if (i==0){
           leftSubtrees =1;
       }
       else{
           leftSubtrees = i;
       }
       if (i==numbers.length -1){
           rightSubtrees = 1;
       }
       else{
           rightSubtrees = numbers.length - (i+1);
       }
       BSTs += leftSubtrees * rightSubtrees;
   }
   return BSTs;
}

