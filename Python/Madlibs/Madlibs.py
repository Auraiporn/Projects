from tkinter import *                         # for the GUI objects

window = Tk()                                 # creating the basic window
window.geometry("390x390")                    # size of the window width:- 360, height:- 390
window.resizable(0,0)                         # prevents window resizing
window.title("Mad Libs Game Generator")       # Window's title
Label(window, text="Welcome to Mad Libs \nGame Generator!!", font="Helvetica 20 bold",bg="SeaGreen3").pack()
Label(window, text="Click a bottom to START a game: ", font="Helvetica 15 bold",bg="SeaGreen2").place(x=40, y=80)


def madlibs_one():
    love = input("Tell me what you love: ")
    hate = input("Tell me what you hate: ")
    cannot = input("Tell me what you can't do: ")
    can = input("Now, tell me what you can do: ")
    wish = input("Tell me what are your wishes... ")
    forget = input("Tell me what you usually forget to... ")
    notForget = input("Tell me what you never forget to...")
    thankful = input("Tell me what are you thankful for: ")
    adj = input("Tell me one adjective that describes yourself: ")
    statement = "I am someone who "
    print("Who am I?\n"+ statement + "loves " + love + "\n" + statement + "hates " + hate + "\n" + statement + "cannot " + cannot + "\n" + statement + "can " + can + "\n"+
          statement + "wishes " + wish + "\n" + statement + "usually forgets to " + forget + "\n" + statement + "never forgets to "  + notForget + "\n" +
          statement + "is thankful for " + thankful + "\n" + "I am a " + adj + " person!!!")

def madlibs_two():
    name = input("Enter your name: ")
    food = input("Enter your favorite food: ")
    verb = input("Enter a verb to describe what you can do: ")
    adj = input("Enter a positive adjective: ")
    embarrassing = input("Enter one embarrassing thing you did: ")
    honor = input("Enter one honorable thing you did: ")
    endearment = input("Enter your favorite endearment: ")
    negative = input("Enter a negative adjective: ")
    positive = input("Enter a positive adjective: ")
    positive1 = input("Enter one more positive adjective: ")
    positive2 = input("Enter another positive adjective: ")
    adj1 = input("Enter an adjective: ")
    noun = input("Enter a noun: ")
    verb1 = input("Enter a verb: ")
    body = input("Enter a body part: ")
    print("Face it " + name + ", you are about the greatest thing since " + food +
          ". \nNo one else can " + verb + " like you can. \nYour best friend says you are the "
          + adj + "-est person in the world. \nSure, you once " + embarrassing+
          ", but you also " + honor +". \nSo, " + endearment
          + ", today is the day you are going to stop beating up on yourself for being " +
          negative + " and start loving yourself for being " + positive + ", "
          + positive1 + ", and " + positive2 + ". \nAnd if people give you a "
          + adj1 + " time, just tell them that they can take their " + noun + " and " +
          verb1 + " it up their " + body + "!!!")

def madlibs_three():
    adj = input("Enter an adjective: ")
    adj1 = input("Enter another adjective: ")
    adj2 = input("Enter the last adjective: ")
    noun = input("Enter a noun: ")
    adj3 = input("Enter an adjective: ")
    adj4 = input("Enter another adjective: ")
    noun1 = input("Enter the noun: ")
    verb = input("Enter the verb: ")
    verb1 = input("Enter another verb: ")
    adj5 = input("Enter an adjective: ")
    noun2 = input("Enter a noun: ")
    verb2 = input("Enter a verb: ")
    noun3 = input("Enter a noun: ")
    verb3 = input("Enter a verb: ")
    adj6 = input("Enter an adjective: ")
    print("I walk through the color jungle. I take out my " + adj +" canteen.\n"+
          "There is a " + adj1 + " parrot with a " + adj2+ " " + noun +" in his mouth right there in front of me in the " + adj3 + " tree!\n" +
          "I  gaze at his " + adj4 + " " + noun1+".\n" + "A sudden sound awakes me from my daydream!\nA panther’s " + verb
          + " in front of my head!\nI " + verb1 + " his " + adj5 + " breath.\n"
          + "I remember I have a packet of " + noun2 + " that makes go into a deep slumber!\nI" +
          verb2 + " it away from me in front of the " + noun3 +".\nYes he's eating it!\nI " +
          verb3 + " away through the " + adj6 + " jungle.\nI meet my parents at the tent.\n Phew! It’s been an exciting day in the jungle. ")


Button(window, text= "Who Am I?...", font="Helvetica 15", command=madlibs_one, bg="gray76").place(x=120, y=120)
Button(window, text= "Sel-Talk...", font="Helvetica 15", command=madlibs_two, bg="gray76").place(x=120, y=180)
Button(window, text= "Advanture in the Jungle!", font="Helvetica 15", command=madlibs_three, bg="gray76").place(x=120, y=240)

window.mainloop()   # Keep displaying window until it is manually closed.