import random


# Rule: Rock Paper Scissors game generator in Python where it allows user to play with computer
# Win condition:
#   If a user chooses Rock, computer chooses Scissors.
#   If a user chooses Paper, computer chooses Rock.
#   If a user chooses Scissors, computer chooses Paper.

def play():
    user = input("Please choose the following...\nEnter 'r' for Rock, 'p' for Paper, and 's' for Scissors: ")
    computer = random.choice(['r', 'p', 's'])
    print("Computer chose: "+ computer)
    if user == computer:
        return "It is tie..."
    if win_condition(user, computer):
        return "Yay! You won!!"
    return "Sorry, you lost..."


# Return True if the user wins
def win_condition(player, computer):
    if (player == 'r' and computer == 's') or (player == 'p' and computer == 'r') or (
            player == 's' and computer == 'p'):
        return True


print(play())
