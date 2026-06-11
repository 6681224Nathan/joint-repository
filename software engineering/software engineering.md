## Software types
Generic : developed to be sold to mass customer
Bespoke, custom mode : developed to a single customer based on their specification

## Capability Maturity Model Integration (CMMI)
- Software engineering institute (**SEI**)
	- CMMI model is relied on a set of system and software engineering capabilities
	- CMMI model represents different levels of **process capabilities and maturity**

## To achieve capabilities
Company should develop process model and make sure it follow the guideline of CMMI.

## CMMI representation of process model
1. Continuous model : capability
	- Each process area is assessed against specific goal based on ==capability levels==
		0. Level 0 : incomplete
		1. Level 1 : performed
		2. Level 2 : managed
		3. Level 3 : defined
		4. Level 4 : Quantitatively managed
		5. Level 5 : optimized
2. Stage : ==maturity==

## CMMI's goal
CMMI defined a set of **generic goals** and related practice
Each **goal** corresponds to one of the five **capabilities level.**'

**To achieve a particular ==capability level==**
==**Generic goal**== for that level and generic **practices** that corresponds to that goal must be ==achieved==.
![[software engineering/lectures/egci341-lecture02.pdf#page=10]]

## Self-test
The development team starts the project right away by writing the codes. When they need more information, they contact the customer/client to gather/clarify some requirements.
**CMMI level self : Performed ✅**

The development team uses Git to help them back up and manage their project’s codes.
**CMMI level self : Performed ✅**

## Staged model
same process areas, goal, and practices as continuous model ==same as continuous==
**Differences** : five ==maturity level==, than five capability
![[software engineering/lectures/egci341-lecture02.pdf#page=14]]

## Process models
- a structured set of activities required to develop a software system
- abstraction representation of a process

## Agile principle
focus on ==customer satisfaction and early incremental==
- Software
- ==small==, highly motivated ==project team==
- minimal software engineering work product
- overall development ==simplicity==

## Agile process, the principle
1. **Hard to predict software requirement**, and how it will change, customer's software priority as well
2. Design and construction are merged, both should be performed in sequence
3. Analysis, design, construction, and testing **are not predictable**

## Agile method (AM)
Agile method is a practice-based methodology for effective modeling and documentation of software-based system.

**Agile models are better because they are just good, no need for perfection, จับต้องได้มากกว่า**

## CBSE
- component analysis, see what you have
- requirements modification
- system design with reuse
- development and integration

## Feature driven development FDD
By Peter Coad as a practical model for OOP software engineering
![[software engineering/lectures/egci341-lecture02.pdf#page=21]]


## Agile software process model
Feb 2001, 17 software developers met at Snowbird, Utah resort to publish Manifesto for Agile software.
- Individuals and interactions
- Working software over comprehensive documentation
- Customer collaboration
- Responding to change

## Post-agile
Team structure 
- Silo (works individually, low coupling, high cohesion)
- Clear reponsibility

Team discipline
- Document oriented
- Each step has a clear definition of document standard
- Timeline is king
- change is bad

Individual discipline
- Make something done but not right
- Please do not change it
- Make it for last, not for change

**Treat change as something to be scared of**

## Agile
Team structure
- One single team, break the silo

Team discipline
- Change is good, we love change
- ==Eliminate unchangeable module==

Individual discipline
- Super clear and have to follow
- Test : code : refactor

## Scrum

User stories : A story of what the ==user wants to happen, idealistic scenario== which becomes backlog

Scrum board : not check out, check out, done

Daily meeting (client representative can join)

**PM Tool** : scrum board (can be in a digital version, backlog being moved through each column)

**Sprint burn down chart** : a planned time taken to finish project vs reality line, if real line is below ideal line, that means things might be done sooner than expected, opposite situation creates opposite outcome

**version control** : github and bitbucket

![[egci341-lecture03.pdf#page=27]]

One sprint for certain number of backlog, **sprint backlog**

**Daily scrum meeting** : to sync up work, not for status report and to plan whatever for the next 24 hours
	- What have I done today
	- What will I do tmr
	- What is the current roadblock

## Midterm question (from guide) that is related to Scrum and stuff
What is the duties of “Scrum Master”? And What are the questions that Scrum master asks during the daily meeting. : Asks about what have I done, what will I do next, and problem facing. Scrum master mainly manages and help the team navigates through the scrum process, more like a coach rather than a manager.
How to get product backlog : from user stories

## Design model
Customer requirements, business needs, and technical consideration meets
**Provides details about**
- Software data structure
- architecture
- interfaces
- components that are necessary to implement in the system
**this model can be assessed for software quality before : **
- code is generared, test are ocnducted, end-users become involved in large number
- ==this is where software quality is establised==

1. Architecture of the system or product
2. Interface that connect the software to : 
	1. end-users
	2. other systems or devices
	3. components
3. Software components that are used to construct sys

## Good design evaluation
- ==implement== all ==explicit ==requirements
- accommodate all ==implicit== requirements desired by customers
- design must be ==readable and understanable ==for dev
- Should provide a complete picture of software, with data functional and behavioral of software

## Class-based modelling

## Level of abstraction
==class attr and methods==
Procedural abstraction : ==sequence of instructions that have specific function==, word open lists a long procedural abstraction

**data abstraction** : naed collection of data that describes a data object, ==class attribute==

## Message
information sent to object to trigger methods
==signal for method call of action==
contains
- procedure name
- information : parameter list

## Generalization and inheritance
**pros**
Abstraction mechanism, may be used to classify entities
==reused== mechanism at both design and programming level
inheritance graph is a ==source of organizational knowledge== about domains and system
**cons**
- classes are ==not self-contained==
- tendency to ==reuse inheritance graph during design process== (inheritance graph from analysis part)
- inheritance graph for ==analysis, design, implementation==, should be ==separated==

## Polymorphism & dynamic binding
Polymorphism : same message can be interpreted differently by different classes of objects. Doctor_name and name, Doctor_birth_date and birth_date

## Class diagram
- Derived: slash (/)
- Public +
- Protected #
- Private -
![[software engineering/lectures/egci341-lecture04.pdf#page=27]]

## Operations
- create
- read (query)
- update

**association** 1..* `_____` 0..3, 5

## Aggregation and composition
- **aggregation** "is a part of"/ "has a" ==white diamond==, can exist without it
- **composition** "is entirely made of", ==black diamond== cannot exist without it, ==live and die== with it

## Class diagram, arrow head meaning
Unidirectional, order needs to know the name of the customer it will be sent to, customer is not necessarily have that data to exist. Existence requirement of other class's variable. **Order points at customer**
Bidirectional is no arrow at all.

## Software architecture
- structure or organization of program components (modules0
	- **Overall structure of software

## Modularity & Software cost
separated into separated components
![[egci341-lecture04.pdf#page=48]]

## Methods and message
Message from new instance is sent to application, the method of a class will be called and proceeded.

## Information hiding
To hide detail of data structure and procedural processing behind a module interface.

## Encapsulation & information hding
Encapsulation is when **attributes and methods are packed in one class** instead of being global or native to other class, 
information hiding is when **getter method**

## Functional independence
Direct consequence of modularity, abstraction, and information hiding
==Cohesion== and ==Coupling==

## Cohesion, focus on its task
"GOD OBJECT"
- Methods and attr similar = ==high cohesion, good==, not similar, low cohesion, bad
	- **Low cohesion** : method is not related to class, utility class, hidden objects and sublcasses

## Coupling, how much one class knows about others, dependance
- Tight/high coupling : classes tied together
- loose/low coupling : classes only relate to the practical extent, ==interface is introduced here==

## High cohesion, loose coupling

## Design class
Refine the analysis classes by providing design details.
- User interface classes
- Business domain classes
- Process classes
- Persistent classes
- System classes

## Model-view-control & Model-view-view-model
Model view control uses UI as a display only, but Model view view model uses UI to take user input as well.

## Well-formed design class
- Complete and sufficient
- Primitive (or Originality)
- High cohesion
- Low Coupling

**Data design elements**
Create a model of data and/or information that is represented as a high level of abstraction

**Architectural design element**
From : 
- **Information** about the application domain for the software to be built 
- Specific analysis model elements
- Availability of architectural patterns and styles

## Interface design elements
- UI
- External interfaces
- Internal interfaces

## Distributed system
Information processing is distributed over several computers rather than confined to a single machine
Very important for enterprise computing system
**Instagram is a distributed system**
==characteristics==
- Resource sharing
- Openness : use of equipment and software **from different vendors**
- Concurrency concurrent processing
- Scalability
- Fault tolerance : able to operate after sys failure

==**Disadvantage**==
- Complex
- Security : susceptible to external attack
- Hard to manage (size is large)
- Unpredictable reponse, depending on the sys organization and network load

## Distri. Sys. Architecture
- Client-server architecture
	- ==Client and service server are treated differently,== permission restriction
	- Clients know servers, servers need not to know client
- Distributed object architectures
	- No distinction between clients and server
	- ==Any objects can provide and use ==service from each other
	- Communication happens through object request broker, middleware
	- More compelx than C\S system
	- Data mining system

## Multiprocessor architectures
- ==Simplest== distributed system model
- Composed of ==multiple processes== which can excecute on different processors
- This is a base for many large real-time system
**Many processes, different modules, work differently, concurrently**
![[egci341-lecture05.pdf#page=8]]

## Client-server system
![[egci341-lecture05.pdf#page=10]]

## Layered application architecture
1. Presentation : presenting result to user
2. Application : a function, open bank acc, close acc..
3. Data management : DB management

## Client --- Server
## Thin-client
`Presenting --- [application - data management]`
- Legacy (app and data are together), computatonally-intensive, data-intensive

## Fat client
`[presenting - application] --- [data management]`
- A genuine software product like Excel, data visualization, stable end-user

## Three-tier architecture
- Each layer can execute on a separate processor
- Better performance than thin-client, simpler to manage than fat-client
- Scalable as server extension is possible
- Many users

## Service-oriented architecture (SOA)
Web available software
- Externally provided service (web service)
- Standard approach to make a reusable component available across the web.
![[egci341-lecture05.pdf#page=21]]

## Service standard
Based on agreed XML-based standards so can be provided on any platform and written in any programming language
SOAP - simple object access protocol
WSDL - Web services description language
UDDI - Universal description discovery and integration

## Application types
1. Data processing application
	1. Billing systems, payroll systems
	2. Data is input and processed and output in batches
2. Transaction processing application
	1. E-commerce, reservation
	2. Query or modify data from DB
3. Event processing systems
	1. Word processors, real-time systems
	2. System reacts to events, like games, real-time editing system including rapid feedback to user. 
4. Language processing systems
	1. Compilers, command interpreters
	2. Compiler

## IF HAVE SPACE INSERT DIAGRAMS FROM THE LAST PART AS WELL

## ==POST MIDTERM==

## Verification and validation
- Verification : 
	- "are we building the product right?"
	- The software should conform to its specification
- Validation :
	- "Are we building the right product"
	- The software should do what the user really requires
		- Even outside of specified specification, more of making what users really want

![[egci341-lecture06-08.pdf#page=4]]
Figure 6.7 : The right one is better. It is better suited for all users.  The left one is hard to navigate, UI organization is kinda... bad.

## Verification and validation process
**two principals objectives**
- ==Discover of defects== in a system
- Assessment of whether the ==system is useful and usable== in an operational situation

## Example of user interface design
![[egci341-lecture06-08.pdf#page=7]]
Left figure asks for more detailed for calculation, thee are strict drop-down choices to enforce a limit of choices to limit the error the calculation may generate. The right one has less navigation of the input data.

## Verification and validation goal
- Verification and validation should establish confidence that the software is fit for purpose
- This does ==not mean completely free of defects==
- it must be ==good enough== for its intended use
- Backlog management
	- If the **backlog** cannot pass verification and validation process, it cannot stay in DONE column
## Static and dynamic verification
**Software inspection**, static verification
- read code line by line, inspect the code and program manually to discover defects
- Just read the report and the diagram can be considered as inspection as well.
**software testing** dynamic verification
- Test and observe product behavior

## Software inspection
![[egci341-lecture06-08.pdf#page=10]]
Find the defect : the automatic reaction of password box is to hide the password, but the **open eyes** icon indicates that the default behavior is the reveal the password, shouldn't be that way. This is **software inspection**.

## Static and dynamic verification and validation
![[egci341-lecture06-08.pdf#page=11]]

## Program testing
- Testing can reveal the presence of errors (NOT their absense)
	- ==static verification CANNOT use with non-functional ==requirement, speed, response time, these requirements will be shown only when the software is tested, by observe static program cannot happen, that's why it needs **dynamic verification or software testing**

## Type of testing
Defect testing
- to discover system defects
- A successfuyk defect test is one which reveals the presence of defects in the system
Validation testing
- To show that the software meets its requirements
- A successful test shows that a requirements has been properly implemented

## Testing and debugging
- debugging is concerned with locating and repairing errors
- Involves formulating a hypothesis about program behavior then testing these hypotheses to find system errors

## Verification and validation planing
- careful planning is requireed to get the most out of the testing and inspection process
- plannig should start early in the development process
- The plan should identify the balance between static verification and testing
- Test planning si about defining standards for the testing process erather than describing product tests

![[egci341-lecture06-08.pdf#page=17]]

## Inspection procedure
- **System overview presented** to inspection team
- **Code and associated documents** are distributed to inspection team in advance
- When inspection takes place, **discovered errors are noted**
- **Modifications** are made to **repair** the discovered errors
- Reinspection may or may not be required.

## Inspection
- Although most are done by humans, but source code can also be inspected by humans
	- Static analysor, the program which finds defects in program
		- uninitialized data, duplicate variable names. It helps reduce time for inspection team to inspect all the codes by themselves
## Stage of static analysis
Control flow analysis
- Check for loops within multiple exits or entry points, finds unreachable codes
Data usage analysis
- Detect unitialized variables, variables written twice without an intervening assignments, variables which are declared but never used
Interface analysis
- Checks the consistency of routine and procedure declarations and their use
- "interface" means the input box of a class 
	- sayHi(String "message", int times)
Information flow analysis
- Identify dependencies of output variable
- Do not detect anomalies itself but hightlights information for code inspection or review
- "10/10/10" -> "10 October 2010"
Path analysis
- Identity oaths through the program and sets out of the sttatment executed in that path

## Use of static analysis
C language
- Weak typing and may errors are undetected by the compiler
Java
- less cost-effective
- Strong type checking
- Detect many errors during compilation

## Testing process
Component testing
- testing individual program components
- Responsibility of the component developers
System testing
- Testing of component's groups integrated to a system or subsystem
- Responsibility of the independent testing team
- tests are based on a system specification

## Testing phase
![[egci341-lecture06-08.pdf#page=29]]
![[egci341-lecture06-08.pdf#page=31]]

## Testing process goal
Validation testing
- Demonstrate to the developer and the customer that the software meets requirements
- A successful test shows that the system operated as intended use
Defect testing
- Discover fauults or defects in the software where its behavior is incorrect or not in conformance with its specificatio
- A successful test makes that the system perform incorrectly ad so exposes a defect in the system

![[egci341-lecture06-08.pdf#page=32]]
![[egci341-lecture06-08.pdf#page=33]]
![[egci341-lecture06-08.pdf#page=34]]

## Release testing
- release testing of a system that will be distributed to customers
- primary goals is to incerase the supplier's confidence that the system meets the requirements
- Release testing is usually black-box or functional testing
- Alpha testing : have specific testing group, and a defined scenario to test, and defined the time to tes
- Beta testing : released into a wild, the test version though

## Black-box testing
![[egci341-lecture06-08.pdf#page=36]]
We put the data in without seeing the content of the system, we know the **input and output**, and we match whether the input gives the desired output or not.
- Test the valid input, and **invalid input**, to test how the system reponses, **system should reject**
- Test with out-of-the-box input, all inputs users might input
- Ex. "firstname.lastname@hotmail@gmail.com" is input into Google, but google allows it (example of neglegance of invalid input testing)

## Black-box testing tables
![[egci341-lecture06-08.pdf#page=38]]
Test with valid/invalid input, specify data, and see whether the results meet the expected result. **This is of a range detector, we specify range and test the data, the program will say whether the data fits in the range or not**

## White-box testing
![[egci341-lecture06-08.pdf#page=41]]
*Pss. there are another testing, the in-between of white box and black box testing, is a grey box, but we are not going go learn that here*

Test only the valid data. Test by path, if program has 3 paths for 3 conditions, we try to feed in the data into 3 paths, like looking into a clear pipe, and if there are certain pipes that don't have anything flowing through, then that's the dev's job to make that happen, or delete the pipe entirely.



