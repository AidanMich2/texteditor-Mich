# CSC 207: Text Editor

**Author**: _(TODO: fill me in)_

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_
 

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

