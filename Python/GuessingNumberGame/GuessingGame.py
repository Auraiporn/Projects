# A guessing game in Python where it allows a user to guess and a computer to guess a number
import random

def user_guess(x):
    rand = random.randint(1, x)
    guess = 0
    count = 0
    while guess != rand:
        guess = int(input(f'Guess a number between 1-{x}: '))
        count = count + 1
        if guess > rand:
            print("Guess is high, try again.\nEnter your guess?")
        elif guess < rand:
            print("Guess is low, try again.\nEnter your guess?")
    print(f'The secret number is: {rand}')
    print(f'Correct in {count} guesses')

def computer_guess(x):
    low = 1
    high = x
    user_input = ""
    while user_input != "y" and low != high:
        rand = random.randint(low, high)
        user_input = input(f"Is {rand} a correct number?... \nEnter y for yes, h for high, and l for low:  ")
        if(user_input == "h"):
            high = rand -1
        if(user_input == "l"):
            low = rand + 1
    print (f"The computer guess the correct number which is {rand}")

how_to_play = input("Would you like to play a guessing game or computer guess a number?\nEnter p for play or c for computer: ")
if(how_to_play=='p'):
    total = int(input("Enter the range of the number you want to play (from 1 to...): "))
    user_guess(total)
elif(how_to_play=='c'):
    total = int(input("Enter the range of the number you want the computer to guess (from 1 to...): "))
    computer_guess(total)