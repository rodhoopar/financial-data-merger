/*******************************************************************************
  *  Name: Rohan Dhoopar
  *  Email: rdhoopar@princeton.edu
  *  School: Princeton University
  *  Class Year: 2019
  *  Description: Given any number of streams, this program merges the streams
  *  into one and prints all elements in sorted order. 
  ******************************************************************************/

import java.util.Arrays;

public class Merger {
    private Stream[] streams; //Array of streams that will be merged
    private int N; //Counter number
    
    //Constuctor that makes the Merger for n streams
    public Merger(int n) {
        N = 0;
        streams = new Stream[n];
    }
    
    //Adds a stream to the Merger
    public void addStream(Stream s) {
        streams[N++] = s;
    }
    
    //Gets the sum of all the lenghts of the streams
    public int sumLength() {
        int sum = 0;
        for (int i = 0; i < streams.length; i++) {
            sum += streams[i].length();
        }
        return sum;
    }
    
    public void kWayMerge() {
        //Array to take the most recently popped values
        int[] values = new int[streams.length];
        
        //Popping the first values of each stream into values
        for (int i = 0; i < streams.length; i++) {
            values[i] = streams[i].pop();
        }
        
        //Finding the current minimum in values and printing it
        //Loop runs until it reaches the sumLength
        for (int i = 0; i < this.sumLength(); i++) {
            //Finding minimum
            int min = values[0];
            int index = 0;
            for (int j = 0; j < streams.length; j++) {
                if (values[j] < min) {
                    min = values[j];
                    index = j;
                }
            }
            System.out.println(min);
            
            //Popping the next value from the stream we just took the minimum from
            if (streams[index].isEmpty() != 1) {
                values[index] = streams[index].pop();
            }
            //If the stream has terminated, "get rid" of it by maximizing it
            else values[index] = Integer.MAX_VALUE;
        }   
    }
    
    //Test cases
    public static void main(String[] args) {
        //Arrays to feed into the streams
        int[] arr1 = {1, 6, 7, 10, 15, 16, 20, 100};
        int[] arr2 = {2, 3, 4, 5, 8};
        int[] arr3 = {9, 11, 12, 13, 14};
        
        //Initalizing the streams
        Stream a = new Stream(arr1);
        Stream b = new Stream(arr2);
        Stream c = new Stream(arr3);
        
        //Creating merger and adding streams
        Merger myMerger = new Merger(3);
        myMerger.addStream(a);
        myMerger.addStream(b);
        myMerger.addStream(c);
        
        //Merging and printing
        myMerger.kWayMerge();
    }
}

//Object represenation of the stream
class Stream {
    private int[] stream; //Array representation of the stream
    private int N; //Current position to pop from
    
    //Constructor that makes a stream given any array of integers
    public Stream(int[] nums) {
        N = 0; //Setting pop position to 0
        Arrays.sort(nums);
        
        //Defensive copy of the sorted array of integers
        stream = new int[nums.length];
        for (int i = 0; i < stream.length; i++) {
            stream[i] = nums[i];
        }
    }
    
    //Returns the first element of the stream
    public int pop() {
        return stream[N++];
    }
    
    //Returns 1 if stream has terminated, 0 if it is not
    public int isEmpty() {
        if (N == stream.length) return 1;
        else return 0;
    }
    
    //Returns the length of the stream
    public int length() {
        return stream.length;
    }
}