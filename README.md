# financial-data-merger

Written as a solution to Bloomberg LP's coding challenge at HackPrinceton 2015. Program successfully completed the challenge and won a prize for efficiency. 

The challenge was twofold: 1. Design and implement a class that models Bloomberg's streams of financial data, which are sorted, of different lengths, and have the ability to remove and return the smallest element. 2. Design and implement a sorting program that takes elements from any number of streams and prints _all_ elements in sorted order. 

My solution to the first part takes in an array of ints, sorts them, and maintains an index to pop from, somewhat similar to an array-based stack. For the second part, I implemented a k-way merging algorithm: looking at all the streams to find the one with the smallest first element, printing that stream's first element, then moving one element forward in that stream and repeating the process.

A test case is included within the main() method of the Merger class. 
