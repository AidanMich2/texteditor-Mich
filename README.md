# CSC 207: Text Editor

**Author**: Sam Beck and Aidan Michaelson

## Resources Used

+ Mentor Session
+ Googled some info on stack overflow for how to get the display working
+ ...

## Changelog

10/5: Finished up simpleString and most of the tests for simpleString
10/5: Finished up the simpleStringBuffer tests and the readme for the simpleStringBuffer analyss
10/5: finished draft of GapBuffer
10/6: Finished up gabuffer and gapbuffer tests
10/8: Got delete working, just added screen.clear
11/6: removed the cursor character
11/6: made size changes to strings and buffers
11/6: Fixed movement for gap buffer
11/6: Fixed some syntax errors
11/6: Did readme
 

## Part 2 Analyzing simple string
1. The relevant input(s) to the method. 
The size of the original simpleStringBuffer string. That then gets iterated over.
2. The critical operation(s).
Reading from the original string str.charAt (i), and writing to the new string newStr.
3. A mathematical model of the runtime of insert as a function of the inputs and operations you chose.
T(n) = 2n
4. A Big-O characterization of the model, i.e., "insert is O(…)."
O(n)

Our reasoning for our mathematical model, is we let n be the size of the original simpleStringBuffer String as that is what we are iterating over in our for loops. Then for our critical operations we said they were when we were reading and writing from the string and to the new string as these occured a total of n number of times in our function. So together with our 2 critical operations and iterating through n we came to the conlusion of T(n) = 2n. This is of course a linear function as expressed by the Big-O of O(n). The linear big o is a consequence of the immutability of strings, that is because instead of being able to simply change a string, we must create an entirely new string and iterate through the old one inputing all of the data into the new string while shifting over.

