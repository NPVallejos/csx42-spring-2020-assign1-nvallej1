# CSX42: Assignment 1
## Name: Nicholas Vallejos

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Assumptions:
1. Words separated by a 'newline' character count as two separate words. More specifically, a word that ends with the 'newline' character is considered valid. Example:
```
Hello
World.
```
2. Due to the way that my processFile() is implemented in the FileProcessor class, I must assume that the following is valid input:
```
He
llo.
```
   This is because I use readLine() from the Scanner class, which uses the newline character '\\n' to separate lines in the file.

   The only way to change this would be to build the sentence word by word, i.e. read the file word by word, and at that point I may as well handle the word manipulation in FileProcessor instead of SentenceHandler.

   In other words, building the sentence word by word in the FileProcessor class seems to make the SentenceHandler class redundant because you could reverse the words as you build each sentence in processFile().

-----------------------------------------------------------------------
## Description:

List of Data Structures Used:
- StringBuilder:
	- Used to build a reversed word in SentenceHandler class. I chose this because it can be used to concatenate strings together using the append() and insert() methods.
- ArrayList:
	- Used for storing String objects in Results class. I chose this because it is a growable data structure, thus, it's size is independent of the number of sentences in the input file. Worst-case storage complexity is O(N) where N represents the total number of sentences in the input file.
- HashMap:
 	- Used for computing max frequency word in MetricsCalculator class. I chose it because it allows me to pair a String to an Integer object, thus, I can associate a word in the file with its frequency. Also, it has great look-up time and insertion time (both O(1)), so it's fast. Worst-case storage complexity is O(N) where N represents the total number of UNIQUE words.

Some important references:
- StringBuilder Documentation: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
- Writer Class Documentation: https://docs.oracle.com/javase/7/docs/api/java/io/Writer.html#write(java.lang.String)
- FileWriter Class Documentation: https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html#FileWriter(java.lang.String)
- Exception Documentation: https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
- Scanner Class Documentation: https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
- HashMap Documentation: https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
- ASCII Table: http://www.asciitable.com/
- Idea for rounding to 2 decimal places: https://stackoverflow.com/a/11701527
- Looping over a word idea: https://stackoverflow.com/a/2451660
- Reading file using Scanner class: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
- HashMap guide: https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/

-----------------------------------------------------------------------
## Notes On Code For Bonus:

- Code in ValidatorUtil.java and Validator.java are direct copies of code found in ValidationTest.java which was posted on piazza. (https://piazza.com/class/k5k3yuyx97612d?cid=37)
- Code in CommandArgHandler.java follows the same idea as the code in Person.java. (https://piazza.com/class/k5k3yuyx97612d?cid=37)


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 2/6/2020
