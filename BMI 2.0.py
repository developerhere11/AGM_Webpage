height = input("enter your height in m: ")
weight = input("enter your weight in kg: ")

# BMI = int(weight / (height ** 2)) # error as height is str and 2 is int

BMI = round(float(weight) / float(height) ** 2,2)
print("Your BMI is :", BMI)    # , was necessary warna error
if BMI < 18.5:
    print("You are Underweight")
elif BMI < 25:
    print("You have Normal weight")
elif BMI < 35:
    print("You are Obese")
else:
    print("You are Clinically Obese")