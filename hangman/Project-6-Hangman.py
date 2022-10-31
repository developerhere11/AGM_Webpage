import random
word_list = ["amtrak", "baboon", "camel"]
chosen_word = random.choice(word_list)
stages = ['''
  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
  |   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
      |
      |
      |
=========''', '''
  +---+
  |   |
      |
      |
      |
      |
=========''']

logo = ''' 
 _                                             
| |                                            
| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  
| '_ \ / _` | '_ \ / _` | '_ ` _ \ / _` | '_ \ 
| | | | (_| | | | | (_| | | | | | | (_| | | | |
|_| |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|
                    __/ |                      
                   |___/                  
'''

lives = 6
print(logo)
display = []
for _ in range(len(chosen_word)):   # for letter in chosen_word:
    display.append("_")  # or display += "_"
print(display)

end_of_game = False
while end_of_game == False:
    user_guess = input("Guess a letter: ").lower()   # lower()

    if user_guess in display:
        print(f"You have already guessed this letter {user_guess}!!!")
    for position in range(0, len(chosen_word)):
        letter = chosen_word[position]
        if letter == user_guess:
            display[position] = letter
    print(display)

    if user_guess not in chosen_word:
        print(f"you guessed {user_guess}, that's not the word. you lose a life.")
        lives -= 1
        if lives == 0:
            end_of_game = True
            print("You Lose.")

    if "_" not in display:
        end_of_game = True
        print("You Win")

    print(stages[lives])

