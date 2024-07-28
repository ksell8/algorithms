# Kurt's Algorithms

The point of this project is to teach algorithms and test driven development with Java.

Algorithms are a set of steps that are carried out to solve problems.
While there are well known algorithms for well-defined,
well-studied problems, mst of what you encounter in the real world is not
well-defined or well studied.  So this approach to teaching algorithms will
give you the tools to approach any problem with an investigative mindset
and apply well known as well as novel techniques to conquer any challenge.

Gradle is the build tool used for this project.  To build the site which
takes you through the steps needed to navigate this learning tutorial run:

`./gradlew :mkdocsServe`

makdocsServe is a gradle `task` which initiates a series of component tasks:

`checkPython`: checks that python is installed in the gradle environment
`pipInstall`: installs the needed packages in the gradle specific python environment
and then finally sets up the site for access on your own computer.

When you run web projects on your computer it's called running on `localhost`.  Normally
localhost is assigned ip address `127.0.0.1`.  More on this can be found on the site!  Happy coding!