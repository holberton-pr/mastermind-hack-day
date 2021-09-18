# Holberton Mastermind Challenge.
---------------------------------

## ○ How to Play - What is the Mastermind game?
Mastermind consists of two players, the code maker and the code braker. The code maker has to create a code, typically an
arrangement of 4 differed colored game tokens. The code braker's role is to try to figure out the color sequence, they have
a limited number of tries. Everytime the code braker makes a mess, the code maker will inform the code braker via 2 different
colors tokens how close they came to cracking the code. You can see in the picture below a line with black and white tokens,
one color will represent colored tokens placed in the correct place/color and the other color will indicate correct color but
wrong placement in the code.

For example, according to the image below:

If the code is ```red blue green pink``` and the code braker guesses ``red green blue pink`` then the code maker will place 2 black
tokens and 2 white ones. Since 2 are in the right place and 2 are the right color but wrong location.

![image](https://user-images.githubusercontent.com/77739870/133868031-8ac78ef4-7a4a-4f59-b66c-1866cfc1d4f0.png)  

## ○ The Challenge:
Develop at least one version Mastermind in the language of your choice. Each game can be one player (against a bot) or 2 players.
You are free of the number of columns, colors and turns.

## ○ List of langages used:
* Java

## ○ Java
I used Java 14 to write a program that allows an user to play Mastermind against a bot.
You can check out https://github.com/cmdelcarmen/mastermind-hack-day for how to install and play.
Below is a screenshot of the gameplay:
![image](https://user-images.githubusercontent.com/77739870/133868800-8c5a6928-ca98-4650-b176-4981d76f3d69.png)  
<br>

The program starts with giving the player a few instructions and asking them to enter their four digit attempt.
My method ``prompt_and_validate`` takes user input and verifies the player only entered four digits:
![image](https://user-images.githubusercontent.com/77739870/133868877-86f66d56-7f2e-4e5d-a496-3e085d9390d8.png)  
<br>

The program then checks to see if the code entered by the user was the correct one, if it wasn't then the program
calls my ``count_coorect_spots`` method to give the user some hints. It converts the code and the user's guess into
strings:
![image](https://user-images.githubusercontent.com/77739870/133869083-e2d6f010-1f0d-49ec-8969-49eba60b32a6.png)  
Then it compares every index of both strings in order to evalute which numbers the player guessed in the right position.
![image](https://user-images.githubusercontent.com/77739870/133869110-952b9936-24ca-45a4-9ee3-dc3dde695ed5.png)  
I use ``.substring`` to get the number at a specific index.

After the program acquires that information, it moves on to the next peace of information it will provide the user, the
number of numbers they guessed correctly, reguardless of postition. For that I wrote a method called ``check_if_in_code``:
![image](https://user-images.githubusercontent.com/77739870/133869208-743c98ca-56aa-484f-9e2c-50d1839ced1e.png)  
The method parses through both numbers, the code and the user's guess and counts the number of times each number in the
user's guess appears in the code, in order to return number of correct guesses the user made. I use ``.charAt()`` to retrieve the numbers at a specifi index. I break once a match is found to avoid duplicate sums, for codes like '5454' for example. If the user guesses '5467' I was to make sure my mothod returns 2, and not 4.

After the hints are given, I tell the user whether they cracked the code or how many attempts they have left. Finally, I repeat the process. At any moment the user can enter -1 to give up and reveal the code. <br>
![image](https://user-images.githubusercontent.com/77739870/133869370-ab86c456-d3a6-4cee-9960-cc0da6826c6c.png)    



Things I found useful about using Java:
*

### ○ Contributors and languages used:
* Caroline Del Carmen C14 Github: cmdelcarmen - Java
