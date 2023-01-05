# Java Battleships Game

This is a console application written in Java where you can play a one-player version of "Battleships".
The starting positions of the ships are chosen randomly at the beginning of each game.
There is a visual representation of the board using ACSII art. It starts empty, and fills up as you enter coordinates, e.g. "a3".
A hit will redraw the board with the correct square showing a "!", a miss will do the same with a "x". 

## Problem

"I am having trouble with my ship coordinates. I know where the trouble lies - with me improperly imagining the 2D array - I just need to find exactly where I am making
the mistake! Other than that, it works. I also need to implement anti-cheating code, as currently you can win by just hitting the same part of a boat 17 times." - 31/12/2022

Solved, 5/5/2023: the random number generator was a) generating numbers that were 1 too low and b) creating overlapping ships. I solved it when I realised that my board, despite being an array, starts at 1 because of how I have written it, and then by separating the two "types" of coordinate - the random starting points and the ascending numbers that fill out the rest of the ships - into 1-5 and 6-10 which prevents any repeated coordinates and therefore overlapping ships. This is rather hard to explain simply with words, it's easier if you look at the code and work it out on paper.