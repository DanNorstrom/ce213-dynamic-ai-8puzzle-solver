# ce213-dynamic-ai-8puzzle-solver

The 8-puzzle consists of a 3 by 3 grid. On each grid square there is a title, except for one square that remains
empty. The 8 tiles are numbered from 1 to 8 respectively, so that each tile can be uniquely identified. A tile
next to the empty square can be moved into the empty space, leaving its previous square empty in turn. The
objective of the 8-puzzle problem is to find a solution, a sequence of tile moves, which leads from any initial
grid configuration to a given goal grid configuration, e.g.,

we can give this solver a grid containing the numbers 1-8 and it will provide us with a solution by using an exhaustive width first binary search tree algorithm. this will go trough the !9 = 133496 possible combinations and return the quickest one.
