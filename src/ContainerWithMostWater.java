package src;
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater
{
    public static int maxArea(int[] height)
    {
        int len = height.length;
        int max = 0;
        int start = 0;

        if (len == 0)
            return 0;
        if (len == 1)
            return height[0];
        if (len == 2)
            return (Math.min(height[0], height[1]));
        int end = len - 1;
        int content;
        /*Algorithm is pretty simple,
        we are starting from the first and last elements,
        going to each other with each step of the loop
        and in each step we are calculating the area between those elements*/
        while (start < end)
        {
            content = (end - start) * Math.min(height[start], height[end]);
            // end - start - that's the length of the container
            // Math.min(height[start], height[end]) - minimum of those two is the actual height of the container
            if (max < content)
                max = content;
            if (height[start] > height[end])
                end--;
            else
                start++;
            // In order to keep area as big as possible we are moving the elements that way
        }
        return max;
    }
}

/*
To test, copy and paste that code to the main() in the TestClass
int[] arr = {3, 1, 2, 4, 5};
int res = ContainerWithMostWater.maxArea(arr);
System.out.println(res);
*/