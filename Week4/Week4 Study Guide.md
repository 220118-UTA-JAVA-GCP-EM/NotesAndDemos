1. What is GCP compute engine?

Allows us to set up virtual machines on the cloud where we can run our applications

2. Why are cloud based virtual machines popular to use among development?

Cost effective, accessible from anywhere, pay for what need

3. What is a persistent disk?

A virtual storage device/harddrive, use them between any of your GCP instances (typically compute engines)

4. What are security groups?

Determines the level of access to what the users can do within gcp. (Who can connect to our computer engines/databases/buckets/etc)

5.  What is DevOps? What is the goal of various DevOps processes?

Combination of Devlopment and Opertaions, a cycle that helps us rapidly build appliations, and have CI to have tests and integrate the application continously

6.  Explain CI/CD. What is the difference between Continuous Deployment and Continuous Delivery?

Continuous Integration push your changes frequently, to make sure there arent large changes that cause issues

Continuous Deployment automatically building and testing your code, then deploying it to a production like environment for further advanced testing automatically

Continuous Delivery like continous release to the users. Automatically building, testing, and deploying your code to the production environment

7.  What tools have you used to achieve CI/CD? Explain how you’ve setup and used them
    
Jenkins, github (webhooks), docker, gradle, 
Created a Jenkins server with Docker, setup a github webhook to send requests to our jenkins server when we make a push, build the project with jenkins and gradle, ran the project in a docker container on the compute engine

8.  What is a DevOps pipeline? Explain the steps to setting one up

The steps of automatically building and deploying our application

9.  What is SonarQube / SonarCloud? Explain some of the features of it
    
10.  What is a “build”? What is the end result of a build? What is the build tool you’ve used for Java projects?

A java archive file (jar), gradle
    
11.  What is Gradle? What are Gradle tasks?

Build tool, creates a workflow, developing jars, managing dependencies. Gradle task does one specific job (building our jar)

12.  What is Unix? Linux? How are Linux OS’s different from other OS’s?

Operating System, Open source, root kernel of many os's, developed in AT&T Bell Labs in the 70's

Family of OS's based on the UNIX kernel
- Open Source

13.  List some Linux distributions

Redhat
Ubuntu
Mint
Debian
Manjaro
Kali
Arch

15.  What is the bash shell? How would you write a bash script?
    
Bourne Again Shell, the main terminal of linux systems

A .sh file

17.  What is an environment variable and how would you set one?
    
A variable with system wide scope

Put it in ~/.bashrc, or use the export command

18.  What is the difference between relative and absolute paths?

/var/lib/whatever/whatever

cd relative

19.  Where are the root and home directories located? How to get to each?

root: /

home: ~

root: cd /

home: cd

20.  What Linux command would you use to:
    
*  Navigate your file hierarchy on the command line?
    
    - just cd into the filing your going into

* List files? What about hidden files? See permissions for the files?
    
    - ls
    - ls -a
    - ls -l

* Change the permissions of a file

    - chmod [oga] file
    
*  Edit a file from the terminal

    - vim
    - cp
    - nano

22.  How do file permissions work on a Linux system?
    
Total of nine bits, 1st three owner, 2nd three group, 3rd other
The total value of the groups of three bits determines read, write, execute

23.  What is a package manager? What are some common Linux package managers?

Program that allows you to install programs from a central directory/repo

APT, YUM, PACMAN, RPM, DPKG

24.  Explain the following bash commands:

* echo hello world > myfile.txt
    
    - Create myfile and move hello world into that file

25.  You run a command but get an error message saying you don’t have enough permissions. What could you try to resolve this?

sudo (super user do)

26.  What are the steps in the software development lifecycle?

Planning (Requirements)
Documentation (Analysis)
Design
Coding (Development)
Testing
Deploy (Integration and Deploy)
Maintenance

27.  What is the difference between Waterfall and Agile methodologies? Explain the benefits and drawbacks of each

Agile is iterative, go through all the steps in a couple weeks

Waterfall does all of the steps in order to completion
    
29.  What specific Agile frameworks exist? What are the main features of each?

Scrum, kanban, Scrumban

30.  What is the Scrum process? Explain each of the Scrum ceremonies

Working in sprints, with daily standups, and other ceremonies once per sprint
- Spring Planning
- Standups
- Review
- Retrospective

31.  How long is a typical sprint?

2 - 4 weeks

32.  What is a “standup” and what should you report about your work?

A daily meeting to talk about project, what we did, and what we are planning, issues you had (blockers)

33.  What is the role of a “Scrum master” in a project? What about the “Product owner”?

Master: in charge of the sprints, make sure everyone is on task, aka team leader

Product owner: your client/customer

34.  Explain the following metrics/charts: sprint velocity, burndown chart

Show the progress of the sprint/project

36. Name some technologies teams can use to keep track of progress on different projects, tasks, and due dates.

Trello, or Github projects

37. What is the difference between a VM and a Container?

VM is emulating an entire computer (OS), container takes what is needed to run an image, doesn't emulate the entire OS, only takes specifically what we need to run some process (shares the underlying kernel of the OS)

38. What are the different components of the docker architecture?

Docker CLI

Docker Daemon

Docker Registry

39. What are docker objects?

Images and Containers

40. What file is used to outline a docker image?

Dockerfile

41. What is the command used to create a docker image?

- docker build
- docker commit

42. What is the command used to run a docker container?

- docker run
- docker create

43. What is Jenkins?

Open-source automation server, used to help build and deploy our applications

44. What is a Jenkins Job?

Workflow, what we want jenkins to do. 

A set of steps to accomplish whatever you are trying to do (in our case build a jar from our code)

45. What is a Jenkins Build?

The output of your job, 

46. How is the status of a job represented in Jenkins?

Weather conditions