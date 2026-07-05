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

## Test table

![[721841018_1302018894937536_4464210967977231559_n.jpg|619]]

## Test table
Aims to test all available scenarios.

## Licenses
![[Pasted image 20260616130723.png]]
- GNU (General public license) 
- Open-source software license : to prevent patent and legal issues, including the derivative software malfunctions and the software dev sues the open-source dev.
- FROM THE DIAGRAM : The lines indicate what the new license can be for the derived software which comes from software with the shown specific license.
	- Prohibition of arrow reversal : for Apache, the derived software cannot use MIT license.


## Back to white-box testing
Source code redundancy elimination. When a code has a part which will not be used, any variables will not go to that path/part of the code, the test aims to help eliminate that part for maximum optimization. 

```
function isPrimeNumber(number) {
  if(number > 0){
    if (number == 1 || number == 2) {
      return true;
    }
    for (var i=2;i<number;i++) {
      if (number % i == 0) {
        return false;
      }
    } 
    return true;
  } else {
    return "error"
  }
}
```

| test case | test table | expected result | program result |
| --------- | ---------- | --------------- | -------------- |
|           |            |                 |                |
Find the complete table in inclass-assgn09

## Stress testing (a kind of performance testing)
- exercise the system beyond its maximum design load
	- Stressing the system often causes defects to come
- Stressing the system test failure behavior
	- System should not fail catastrophically
	- Stress testing checks for unacceptable lost of services or data
- stress testing is particularly relevant to distributed systems
	- Exhibit severe degradation as a network becomes overload

## Component testing
component or unit testing is the process of testing individual components in isolation
- It is a defect testing process
- Types of components :
	- Individual functions or methods within an object
	- Object classes with several attributes and methods
	- Composite components with defined interfaces used to access their functionality

## Object class testing
Testing all operations associated with an object
- setting and interrogating all object attributes
- exercising the object in all possible states

## Interface testing
- Objectives are to detect faults due to interface errors or invalid assumptions aboout interfaces
- Importance for object-oriented development as objects are defined by their interfaces
![[egci341-lecture06-08.pdf#page=50]]

## Interface types
- Parameter interfaces
	- Data passed from one procedure to another
- Shared memory interfaces
	- Block of memory is shared between procedures or functions
- Procedural interfaces
	- Subsystem encapsulates a set of procedure to be called by other sub-system
- Message passing interfaces
	- Subsystems request services from other sub-system

## Interface erorrs
- Interface misuse
	- A calling component calls another component and make an error in its use of its interface (wrong typing in interface header)
	- e.g. parameters in the wrong order (wrong order typing in interface header)
- Interface misunderstanding
	- A calling component embeds assumptions about the behavior of the called component which are incorrect
- Timing errors
	- The called and the calling component operate at different speeds and out-of-date information is accessed.
		- Ex. Imagine a concurrency information tranmission, it fucks up the entire agreed-upon order procession.

## Software integration

## The world before devOps
Waterfall linear software development model
- Waterfall model
- V-model
- Incremental model

Customers often have a gap between developer and operational workers (communication gap).
![[egci341-lecture09-10.pdf#page=9]]

## DevOps
A concept to help solve the conflict between development and operations side. Deployment and stabiity, a crash of two operation principle.

## The world before devOps
Frequent disagreement between developers and operational work operator. 
![[egci341-lecture09-10.pdf#page=12]]

## The birth of devOps
- After the birth of Agile in 2001 Utah, concept of devOps has been proposed in Agile conference in 2008.
	- Concept of devOps is automation, we minimize anything manual

## DevOps
A culture, movement, practice which ==emphasizes collaboration and communication== between software developers and other information-technology professionals, while ==automating== the process of software delivery and infrastructure changes.

## DevOps framework overview
People
- Mindset
- Roles and responsibilities
Process
- practice
	- DevOps pipeline
	- Configuration measurement
	- 5Cs
	- Automation
	- IaC
	- Containization
	- Kpis
Technology
- DevOps toolchain
- DevOps periodic table

## Mindset
Lean thinking, minimize the number of processes, minize any process/steps that have to be done manually. ==automatic== 

**What happen if they use devOps?**
- Developers has less conflict wiht operations
- Value is everything that your customer is willing to pay money for
- Waste is any action or step that customer does not want to pay for

## DevOps pipeline
- Development team
	- plan -> code -> build -> test
- Operations team
	- Release -> deploy -> operate -> monitor
![[egci341-lecture09-10.pdf#page=25]]

## Software configuration management
-  a process to systematically manage, organize, and control the chnages in the documents, codes, and oter entities during the software development life cycle, the primary goal is to increase productivity with minimal mistakes

## 5C of devLops
![[egci341-lecture09-10.pdf#page=27]]
![[egci341-lecture09-10.pdf#page=28]]

## Automation

## Software project management
concerned with activities involved in ensuring that : 
- Software is delivered *on time* and *on schedule*
Project management is needed because software development is always subject to:
- Budget and schedule constraints that are set by the organization developing the software.
![[egci341-lecture11-12.pdf#page=4]]
![[egci341-lecture11-12.pdf#page=5]]

## Project staff
- may not be possible to appoint the ideal people to work on a project
	- Project budget may not allow for the use of highly-paid staff
	- Staff with the appropriate experience may not be available
- Managers have to work within these constraints especially when there are shortages of trained staff

## Project plan
- resources available to the project
- Work breakdown
- schedule for the work

## Activity organization
- Activities in a project should be organized to produce tangible outputs for management to judge progress
- Milestones are the end-point of a process activity
- Deliverables are project results delivered to customers

![[egci341-lecture11-12.pdf#page=10]]

## Project scheduling
- Split project into tasks and estimate time and resources required to complete each task
- Organization tasks concurrently to make optimal use of workforce
- Minimize task dependencies to avoid delays caused by one task waiting for another to complete
- Dependent on project managers intuition and experience

![[egci341-lecture11-12.pdf#page=12]]

## Scheduling problems
- estimating the difficulty of problems and hence the cost of developing a solution is hard
- productivity is not proportional to the number of people working on a task
- Adding people to a late project makes it later because of communication overheads
- Unexpected always happen
	- Always allow contingency in planning

## Bar charts and activity networks
- Graphical notations used to illustrate the project schedule
- Show project breakdown into tasks
	- Tasks should not be too small
	- They should take about a week or two
- Activity charts show task dependencies and the critical path
- Bar charts show schedule against calendar time
![[egci341-lecture11-12.pdf#page=15]]
![[egci341-lecture11-12.pdf#page=17]]
Gantt chart is basically just a time line :¯\_(ツ)_/¯ 
![[egci341-lecture11-12.pdf#page=18]]
![[egci341-lecture11-12.pdf#page=19]]
![[egci341-lecture11-12.pdf#page=20]]

## Estimate task durations
- Estimate the ==minimum amount of time== it would take to perform the task - to optimistic duration (OD)
- Estimate the ==maximum amount of time ==it would take to perform the task - the pessimistic duration (PD)
- Estimate the ==expected duration== (ED) that will be needed to perform the task
- Calculate a weighted average of the most likely duration as follow
$$ D = \frac{(1 \times OD) + (4 \times ED) + (1 \times PD)}{6} = 3.33 $$

## Schedule adjustments
- Using intertask dependencies, determine every possible path through the project
- Sum the durations of all tasks in each path
- **path with the longest total duration is the critical path**
	- ==critical path ==for a project is that sequence of dependent tasks that have the largest sum of most likely durations
		- critical path determines the earliest completion date of the project
		- **Slack time** available for any noncritical task is the amount of delay that can be tolerated between the starting time and completion time of a task without casuing a delay in the completion date of the entire project

## Slack time
Slack time for each path, slack time means the time each path is less than the critical path, it means how long each path can be delayed because the critical path is not finished anyway.

## Exercise, which is expected to be in the finals
1) Draw the PERT diagram
2) Draw the Gantt chart
3) Find the critical path and critical tasks and duration
4) Calculate the slack time of each time


## Software estimation cost

## Fundamental estimation question
- how much effort is required to complete an activity
- How much calendar time is needed to complete an activity
- What is the total cost of an activity

| Effort | Project A | 12 P-months != 12 months |
| ------ | --------- | ------------------------ |
|        | Project B | 10 P-months              |
## Software cost components
- hardware and software costs
- travel and training costs
- Effort costs (the dominant factor in most projects)
	- The salaries of engineers involved in the project
	- Social and insurance cost
- Effort costs must take overheads into account
	- Cost of building, air condition, lighting
	- Costs of networking and communications
	- Costs of shared facilities (e.g library, staff restaurant, etc)

## Software pricing factors
- Market opportunity, **demand**
	- Demand of the app for each company is very high, and between software dev. com. are very competitive, so the price to build app is very high
- Cost estimate uncertainty
	- When the client's requirements are not clear, the software house will overestimate 
- Contractual term 
	- With the restriction of software development (contract A says that software developed for this contract cannot be used in another project, with another contract)
- Requirements votality
	- In order to win a contract, some requirements are reduced to reduce pricing for customers
- Financial health
	- When software house does not have any project at the moment, in order to pay employees, price per contract can be lowered in order to find project to fill in the gap

>software house means software development company

> P month means per month
## Software productivity
- A measurement of the rate at which individual engineers involved in software devlopment produce software and associated documentation. ==productivity measurement per individual per month==
	- Can be used to measure to team's productivity
		- **size-related measurement**
			- Like lines of codes written per month
			- No. of lines of sources codes
			- no. of objects in the program
		- **function-related measurement**
			- Based on the functionality of the program created
### Measurement problems
- Estimating the size of the measurement
	- i.e. How many function points
- Estimating the total number of programer's months that have elapsed
- Estimating contractor productivity (e.g. documentation team)

### Line of Code (LOC)
- Problem that can arises is that for different languages, different number of  lines of codes reflect different productivity
- **Physical line of code** : count every line except comment, physical code line
- **Logical line of code** : line that can be executed

`for (i=o..) printf;`
Logical line of codes : 2
Physical line of codes : 1
Comment : 0

> Elapsed means the time that passed or slipped by

## Productivity comparison
- The lower level the language, the more productive the programmer
	- The same functionality takes more codes to implement in a lower-level language than in a high-level language
- The more verbose the programmer, the higher the productivity

> Verbose means more code than necessary, ยืดยาว
## System development times
![[egci341-lecture13-14.pdf#page=10]]
- the higher the language, the lower the effort, so it is better (less time as well)

## Functional points
Based on a combination of program characteristics
- External inputs and outputs (EI, EQ)
- User interactions and external queries (EQ)
- External interface files (EIF)
- files used by the system or internal logical files (ILF)
 A weight is associated with each of these characteristics and the function point count is computed by multiplying each raw count by the weight and summing all values
- Internal interface files
	- Files used locally within the system
- External interface files
	- Files that have to be called from other application/outside
- External input
	- data that goes in from other app, outside
- External outputs
	- data tht comes "out" of the system
- External inquiries
	- EQ is a transaction function with both input and output which results in an information retreival

## Function points
- Function points count is modified by the complexity of the project
- FPs can be used to estimate LOC depending on the average number of LOC per Function Points (FP) for a given language
	- LOC = AVC * number of function points
	- AVS is a language-dependent factor varying from 200-300 for assemble language for 2-40 for a 4GL
	- AVC : the average number of lines of code
- FPs are very subjective
	- They depend on the estimator
	- Automatic function-point counting is impossible
![[egci341-lecture13-14.pdf#page=14]]
![[egci341-lecture13-14.pdf#page=16]]
## Practice
## ==WILL BE IN FINAL EXAM==

| No. of functions | Description                       | Weight  | Type |
| ---------------- | --------------------------------- | ------- | ---- |
| 2                | Send data to web service          | Average | EIF  |
| 3                | Call function to reset the sensor | Low     | EIF  |
| 3                | Query data from API in app        | High    | ILF  |
| 1                | Get name and address from user    | Low     | EI   |
| 3                | print reports on the screen       | Average | EO   |
| 2                | Print reports to the printer      | Average | Eo   |
| 2                | read sensor's data from database  | Low     | EQ   |
TDI : 48
Language : Visual C++
LOC/P-month : 360
$/LOC: 24

- VAF = ==0.65 + (0.01xTDI) === 0.48 + 0.65 = 1.13
- UFC = sum of all weight factor = $\sum$ no. of functions * weight (refers from types of function as well, and weight factor)  = 2 * 7  + 3 * 5 + 3 * 15 + 1 * 3 + 3 * 5 + 2 * 5 + 2 * 3 = 108
- Function points : FP = UFC x VAF = 1.13 * 108= 122.04  
- Find estimated LOC : AVC * FP = 34 * 122.04 = 4149.36
- Find cost estimation of software : Est LOC * Dollar/LOC : 4149.36 * 204 = $99584.64
- Effort : Est. LOC / (LOC/pmonth) = 4149.36 / 360 = 11.526 p-month (effort for the total project)
	- Add more people, more cost, but lower calendar month (no. of dev * calendar month = p-month) p-month mostly stays the same

## Object points
- Object points (alternatively named application points) are an alternative function-related measurement to function points
- Object points are NOT the dame as object classes
- The number of object points in a program is a weighted estimation of: 
	- Number of separate screens that are displayed
	- Number of reports that are produced by the system
	- Number of program modules that must be developed to supplement the database code

## Factors affecting productivity
- Application domain experience
- Process quality
- Project size
- Technology support
- Working environment

## Estimation techniques
For ==software cost estimation==

- Algorithmic cost modelling : Estimation made on the history of cost of developed software that is similar to the developing software
- Expert judgement : Experts on the project made their own judgement of software cost, discussion is made, and being repeated until agreed price is given
- Estimation by analogy : 
- Parkinson's law : Measured by person-month, measured from effort ($total\space time \times people$)
- Pricing to win : Depends on the customer's funding, high low. Estimated to be whatever the customer has available to spend.

## Pricing to win
Project costs whatever the customer has to spend on it
- Advantages
	- Get a contract
- Disadvantages
	- The small probability that the customer gets the system they want as a small one
	- Costs do not accurately reflect work required

## Top-down and bottom-up estimation
- **Top down**
	- Estimate based on the system (high level ) and slowly separate the components one by one ,and estimate from that
- **Bottom up**
	- Usable when the architect of the system is known and components identified
	- This can be an accurate method of the sys has been designed in detia

## Example : Object counts
- 2 simple screens x 1 = 2
- 3 mediume screens x 2 = 6
Total objects = 8

## Object point productivity
![[egci341-lecture13-14.pdf#page=34]]

![[egci341-lecture13-14.pdf#page=31]]

![[egci341-lecture13-14.pdf#page=47]]

1. PM = A x size ^ B x M
		= 2.5 x 128 ^ 1.17 x 1 = 730.089
PM = 2.5 x 128 ^ 1.17 x (1.39 x 1.3 x)

### COCOMO model
### Early design model
PM = A x Size^B x M
B = 1.01 + 0.01 x $\sum$ SF(i) 
A : organisation-dependent constant
B : reflects the disproportionate effort for large projects
M : multiplier reflecting product, process and people attribute
Size : code size (measured in KLOC, or Kilo line of code)
SF = scale factor

A = 2.7
LOC = 75,000 LOC
Multiplier : 
	RUSE = 1.3
	PDIF = 2.1
	PREX - 1.8

Exp B for effort calculation
$\sum$ SF(i) = 25

Size = KLOC = 75
M = 1.3 * 2.1 * 1.8 =4.914
A = 2.7
B = 1.01 + 0.01 * 25 = 1.26
PM = 2.7 * 75^1.26 * 4.914 = ==3057.57==


## Project
- The raw data is in .rick format, there is an exact coordinate of a residue, turned into plaintext data (.txt) being translated into a diagonal matrix, literally diagonal **there is an origin of a data which can be traced back to the raw data, the distance is calculated from those coordinates already**, but there are also a full complete matrix as well.
	- Mentel 
- There are 500 types of kinase. Among residues, lines are made to measure distance

### Ontology
- each PDB file has its own PDB code, 
	- initial_of_proteinname_code_unicode

### Gene ontology
- Unique cocab to classify each type of protein, GO:word

If we have PDB, we will have the protein code, 
every protein has sets of turn until the last node, ge

Browser annotation, goes to molecular function, type gene ontology, it becomes the whole class or protein kinease, it ghoes up to protein kinase PDB code, there is a structured vocab, if we go to RCSB

> PDB protein data bank there is a way to get API, "unifront", "gene ontology", if we browse by annotation, molecular function, search for "0004672", it will go to protein kinase and there will be a correct name for protein kinase, under each ontology, there will be an identifier of what kinase it is, there will be ==information of what it is, ranging from organism type to ...==

CDK2_HUMAN
in ==Uniprot== there should be API
- there will be information, subcellular location tells the location of the cell
- PDB code for each kinase for website
- ID mapping
	- 3D structure data base
	- PDB
	- map it back to uniprot
> there seems to be two websites now, PDB and Uniprot. Use information we get from PDB, to map it to Uniprot. This is basic mapping
> API request, there will be specific place to get API, get gene ontology from Uniprot. The protein is connected to human body using Ansembly ID (อองซอมเบิล), 

Protein_organism
==Ajarn has mapped already, the uniprot and everything==

Every PDB code would exist in Mahori, if it exists in human (gene ontology includes the keyword human)

For example, we have cancer in intestine, we can repurpose drug for breast cancer to be at small intestine. 

For a table, there are distance between points, the last column has to be the outcome, that is how we do clustering, independent variable is the content, last column is dependent. To use neural network to guess the body part in the last column.
- More than a half of kinase appearance in certain body parts indicate that that body parts have that kinase for the most

Shape of the ATP pocket looks the same, indicates the body parts where it works the most effective. 

Which nodes in the shape tell certain meaning, breast cancer characteristic. 

manoraa.icbs.mahidol.ac.th
platform.opentargets.org/target/ENSG000000113262

baseline expression
there is also API query

We have limited data, 

Steps
- We have distance, then we get the name of the kinase, search in PDB, get the name (ensembly ID), go to uniprot, get CDK2, go to target protein, and then we would get body parts
- With the emsemble ID, there are also program to translte from the emsemble ID to be the uniprot ID, go to opentargets site to get uniprot ID to get body parts which kinase appears the most
	- uniprot behaves like a center of buses, it links everything, 

1nvr kinase uniprot

==change the tree, from the clustering of drugs, to body parts instead==

==alternative tree methods, and body parts mapping==

The lasr appendix will have all talbes that we can  extract, Ajarn's thesis. 

Use non redundant data set
Either one 

