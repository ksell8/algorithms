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
localhost is assigned ip address `127.0.0.1`.  

The CIDR (which stands for Classless Inter-Domain Routing) for all loop-back mechanisms
is `127.0.0.0/8` where loop-back means the computer is networking with itself.  
But lets quickly break down what Classless Inter-Domain Routing means.  It's classless
because the old way of tracking IPs put each range of IPs in a different class, CIDR notation doesn't
have classes, thus making it a lot easier to track IPs.  Inter-Domain means communication between different
places on the internet.  And Routing refers to the paths that computers use to communicate.

Computer's know which route to use based on a routing table.  CIDR made routing tables easier
to maintain because routes can be aggregated together `127.0.0.0/8` is an example of this
as it actually stands for the range of `127.0.0.0-127.255.255.255`.  The first IP in a subnet
is reserved as the access point to that subnet, so because `127.0.0.1` is the first usable
IP that is the one that is used!

These foundational decisions in computer science shape how we design real world solutions.
So while the focus of these modules is on refining your algorithms skills.  We'll be
weaving through the history of computer science on the way! 