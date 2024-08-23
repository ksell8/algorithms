# What is a Computer?

## The Turing Machine

In 1936 Alan Turing wrote *On Computable Numbers* which built on the previous
work of Ada Lovelace and Charles Babbage to create a computational model that is equivalent
to that of the machine you are reading this from.  The model was made of an 
infinite tape.  The tape could be written to, read from and moved along.

Turing wanted to mimic what a human could do when computing a
mathematics problem. The computers of his time were mathematicians who did computations by hand.
Turing wished to automate that away (this will be a reoccurring theme).  And so the infinite tape was born,
for if all a human does is write, erase and read figures, surely an automatic process could 
mimic a human computer by doing the same!

Let's solve a very simple problem together to see how we would convert it for a machine to solve.

!!! question "Problem"

    Given a two sentences as input, determine if the sentences are the same.
    If they are, accept, otherwise reject.

??? example "Example Solution"
    === "Intuitive Solution"
        How would a human solve this? Take for example the following input: "The cat sat." and "The cat sat.".
        Easy-peasy, we'd see it and accept.  But what if you were given two sentences that were 500,000 characters long?
        Could you tell me with certainty the sentences matched by eyeballing it?  How could you prove they matched?
    === "Algorithmic Solution"
        One possibility is to go character by character until you find a character that doesn't match.
        If you get to the end of both sentences without finding a mismatch, they match, accept as equal!
        If you find a mismatch or one sentence is longer than the other, reject, they aren't equal!
        
        All that takes is moving and reading!  So Turing's model can handle it!

!!! note
    "Solutions" given as examples on this site are not the sole way to solve a given problem.  Computer science is an art.  Multiple solutions
    may exist.  However, not all solutions are equal.  We'll cover how to measure the effectiveness of a solution later on.
    In all cases, I encourage you to think through your own solution before expanding the provided solution.

!!! info
    In Java a group of characters surrounded by double quotes (e.g. "this is a String") is called a String.  A character
    is called a char and alone is denoted by single quotes (e.g. 'c').  The full implementation of the String
    can be found on [GitHub](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/lang/String.java)
    because Java has an Open Source variant called the OpenJDK.  Most higher level computing languages are Open Source
    because it allows the programmer to more deeply understand what they are actually doing.  We will learn more
    about Strings later, but for now if you see String know it's just a fancy word for a bunch of characters strung together.

How do we write algorithmic solutions in a systematic way that a computer can understand? The Turing machine model defines algorithms in something called a transition table.
The transition table tells us what to do based on the current state of our program. A state can be defined in a number of ways.

Expanding from the previous example, I can define a state based on every single possible pair of 
sentences I encounter and hardcode the answer within the transition table. But, since there are infinite sentences, this would lead to infinite states, and thus infinite transitions.

Simpler still, I could define a transition for each pair of letters that I encounter while reading a sentence. Minimally including (,) ( ) (.) (?) (!) with lowercases and capitals this would make for 57 choose 2, or 1596 possible states.  
If you don't know what choose means here, you don't need to know, just know it makes a big number. The goal is to make the states we decide on as generic as possible to cover all possible combinations of states.  

Let's apply this idea to our problem above.

!!! question
    We are making our way through two Strings checking for equivalence.  What information is
    most important to know about the characters in the two Strings and any given position:

        a) What the current character is.

        b) What the whole String up to the character is equal to.

        c) Whether or not the characters at our current position in the Strings are equivalent.

        d) Whether or not the Strings up to our current position in the Strings are equivalent.

??? tip "Answer"
    The information that is most important to know is c:
    whether or not the characters at our current position in the Strings are equivalent!
    
    a & b are focused on state in one of the given Strings.  We are comparing two Strings,
    so the state we will track will necessarily contain information sbout both Strings.
    
    d is implied by our current position, so we don't have to track it in the information about our current position.
    If we got to our current position and were not able to determine that the Strings are not equal, that means
    all characters up to our current position are equal.  All we need to know at any given position is 
    if both characters at that position are equal!

!!! question
    Given the information selected in the above question, what would the transition logic look like?
    You should provide a state transition for all possible configurations of the state.

??? tip "Answer"
    State (characters in current position do NOT match): Reject the Strings aren't equal.

    State (characters in current position match): Move to the next character in each string.  If the current
    position is the end of both Strings then accept.


I know what, you're thinking: How is an infinite tape I can read and write to equivalent
to my iPhone/Android? My Mom's favorite thing to do on her iPhone is play Candy Crush.

Let's try to automate away one sub-problem of Candy Crush with only read, write and move operations.

!!! question "Problem - Candy Crush"
    === "Problem Definition"
        Given an nxm matrix of items (or board) determine if a possible move exists.

        A possible move is defined as:
        Swapping an element with its surrounding element will create a line of
        3 or more of the same type of element.
    
    === "Examples"
    
        - Moves exist
        
        ```
        r g r r
        g r g r
        g r r b
        ```
    
        Sample moves:
    
        (0,1) swap with (1,1)
        (0,1) now in-line with (0,0) (0,2) and (0,3)
        (1,1) now in-line with (1,0) (1,2)
        
        (0,0) swap wih (0,1)
        (0,1) now in-line with (0,2) (0,3) (1,1) (1, 2)
        (0,0) now in-line with (1,0) (2,0)
        
        - Moves don't exist: 
        ```
        g b r y
        r g b g
        b y r y
        ```
    
    === "Notation"
    
        Notation for these sample moves is based on the following Battleship grid:
        ```
          0 1 2 3
        0   x
        1
        2
        ```
        The x in the map above is at (0, 1).  We will give (row number, column number)
        because we will store the matrix as a list of rows.  You have to fetch
        the nth row and then fetch the nth item within that row.  This is an implementation
        detail though, you can do it both ways, but it changes how the implementation is done,
        so for simplicity sake, we'll say we are storing rows.
        ```
        char[][] exampleMatrix = { { r, g, r, r },
                                  { g, r, g, r },
                                  { g, r, r, b } };
        ```
    

Designing an algorithm is all about finding key patterns between all inputs of the problem
to reason about them.

!!! question
    Do you see patterns for when a move exists and when it doesn't? 

??? example "Example Answer"
    If a move exists then there are 3 or more like items surrounding a matching element vertically or horizontally
    where 2 of the matching elements are sequential either vertically or horizontally
    OR 2 or more of the current element on the diagonals.  This pattern can be determined by enumerating all types
    of possible matches.

    ```
    c x c c

    c c x c

    x c
    c
    c

    c 
    c
    x c
    
    c x
      c
      c

      c
      c
    c x
 
    c x c
      c 

      c
    c x c

    c
    x c
    c

      c
    c x
      c
    ```

??? question "Follow Up Question to Implement Example Answer"
    How do you get a the items surrounding an element?

??? example "Example Solution"

    ```
    item = board[a][b]
    surrounding_tems = [
                        board[a-1][b], 
                        board[a+1][b], 
                        board[a][b-1],
                        board[a][b+1]
                        //diagonals
                        board[a-1][b+1],
                        board[a-1][b-1],
                        board[a+1][b+1],
                        board[a+1][b-1]
                        ]
    ```

    We'd of course have to account for the edges.  But it's clear we could
    get the surrounding elements.  We could write the surrounding elements
    down and check to see if 2 or more of any element surround it.
    If there are 2+ of the same element we have proved a move exists, otherwise we continue.
    If we check all the elements on the board without finding a move we can confidently
    state no move exists.

So storing information and doing different things based on what's stored seems
to be a robust enough model to solve cool problems with.  The "based on what's stored"
is the critical component here.  In computer science we call this state.  A program
is considered stateful if it got to it's present state by stepping through a series of states.
A program is stateless if each computation is viewed as a separate transaction, independent of each
other.  In most programs there are normally instances of both stateless and stateful elements.
That being said processes with any state are normally classified as stateful as maintaining
stateless computation is often more trivial than stateful computation.

!!! question
    Are Turing Machines stateful or stateless?

## The Modern Computer

How did we get from a theoretical infinite tape to the smartphone though?

PUNCH CARDS?

MACHINE CODE

MAINFRAME CONSOLES and COMPUTER OPERATORS


![IBM Console](../img/IBM_7094.jpeg)

[Machine Code vs. Assembler](https://www.youtube.com/watch?v=HWpi9n2H3kE)

ASSEMBLER 

This was tedious work, and it made computers largely unavailable
except within government and university applications.  Around 1947
a very smart lady by the name of Kathleen Booth was working on a computer
at her university when she came up with the idea to automate away some of the drudgery.
There were only a certain set of operations 

HIGHER LEVEL LANGUAGES - C

JAVA BYTECODE, JVM, JIT

[De-Mystifying JiT Compilers](https://www.youtube.com/watch?v=d7KHAVaX_Rs)

