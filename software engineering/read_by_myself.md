## License

### MIT license
- Created in 1980 MIT
- **permissive** software license
	- anyone can do anything to code, just don't sue and keep copyright notice in tact
	- free of charge for software
- CAN do
	- Use the code commercially
	- modify the code
	- distribute it
	- sublicense it
		- derived project can be equipped with difference license
	- use it privately
		- run and modify the code privately
- CONDITION
	- **include the original copyright notice and MIT license** in all copies of software
- LIMITATION
	- No liability
		- It's free, dom't complain, don't sue
	- Silent trademark rights (rely on local trademark laws)

### Apache license
*copy right license is about the code, patent is about the idea*
corporate-grade license, **permissive**
Patent
- " original creator makes a program and let the code be open source, I use it to make an app, it becomes successful, but it infringes the patent of original code, so the original open source creator sues me "
**Patent grant**
- Software with Apache license gives derived software a perpetual non-exclusive world wide **patent right**
**Retaliation clause**
- If original creator sues anyone with patent infringement, then their original software loses the license entirely
CAN
- commercial use
- modification and distribution
CONDITIONS
- keep the license  intact
- state the changes made to the original code
- NOTICE file for third party software specification must be kept intact
LIMITATION
- No liability
- No trademark rights
	- Formally stated that no brand or logo rights are used

### GNU General Public License
**copyleft**
**Reciprocity rule**
- If a derived software uses any code from GNU licensed software, and the derived software is made public, then the derived software has to be **open-source** under the same GNU GPL license
**also has a license protection like Apache**
CAN
- commercial use
- modification and redistribution
CONDITION
- disclosure source code
	- if the code is distributed, the source code must be available to the user
- same license inherited
- state change
- 
LIMITATION
- No Tivoization
	- Hardware which runs GPL software must allow users to install a modified version of software as well, not restrict it to their own GPL software
- No patent ambiguity
	- GNU GPL has patent rules as well
VERSIONS
- Standard GPL
	- Rules : basic reciprocity rules
	- for standalone tools, and OS
- LGPL (lesser GPL)
	- Weak copyleft : If derived software links to the GNU library, that is fine, but if the library is modified, reciprocity rule will be in affect
	- for shared code blocks, rendering engine
- AGPL (Affero GPL)
	- Standard GPL only triggers when distribution happens, but if software is on cloud, then distribution doesn't happen, but if **API, web-software** interaction happens, then reciprocity rules will be in effect.

### SUMMARY
None covers trademark
MIT
- permissive
- Allows anything with a code, as long as the original copyright notice is intact in derived software
- allows for commercial use
Apache
- permissive
- Allows anything with a code, as long as NOTICE (third party software specifier)
- needs to state change
- patent right
	- The license grants patent rights to all derived software, the original author of the original code cannot sue the derived software author for patent infringement
- retaliation clause
	- if patent right is broken, then the license for original code would be ineffective, losing its ability
- ironclad trademark rights : license does not provide any trademark rights (explicitly)

GNU GPL
- copyleft
- Reciprocity rule : any code which uses the software with this license, will be forced to be made into open source
- has patent right similar to apache
- source code disclosure (with compiled software for example, has to have an easy way for users to direct themselves to the source code of the program)
- ironclad trademark rights : for standard GNU GPL, trademark is not given
- anti-tivoization (software-change for hardware is locked)
- inherited license
- versions
	- standard GNU GPL
		- standard copyleft
	- LGPL
		- if derived program uses library with GPL license, then copyleft will not be forced upon it, but if library is modified, then the program is forced to be copyleft
	- AGPL
		- code which interacts with the cloud version of the software, like webapp, will be forced by reciprocity rule as well

All requires complied code copyright notice to be present in the compiled software


## Software testing

### Verification and validation

**Verification, confirm to ==specification**==
- *are we building the right?*
- Software should conform to its specification
**Validation, is software what the user really wants? ==Is it useful?==**
- *are we building the right product*
- Software should do what the user really requires

### Verification and validation process
Two principle ==objectives==
- discover ==defects==
- whether system is ==useful and usable== in ==operational== situation

### Verification and validation
- both should establish confidence that software fits its purpose
- ==does not mean free of defect, just good enough for intended use==

### Static and dynamic verification
Verification : have we followed the requirement?
- Software ==inspection==, ==static verification==
	- analysis of system to discover defect
	- **see and find problem**
- Software ==testing,== ==dynamic verification==
	- software is tested, and results are collected
	- **actually run it with specified data**

![[egci341-lecture06-08.pdf#page=11]]
will this even be in the exam?

### Program testing
- testing can reveal ==present of errors== (not their absense)
- ONLY validation technique for non-functional requirements has to e executed to see how it works

### Testing
- defect testing
	- discover sys defects, ==defect will appear==
- validation testing
	- to show that ==software meet requirements==
	- successful test : requirements are ==properly implemented==

### testing and debugging
- ==*verification and validation== are for finding ==defects== in program, makes it appear*
- debugging is for ==locating== that ==errors== and ==repairing==
	- create ==hypothesis ==about program behavior and ==test ==it to ==find error==

![[egci341-lecture06-08.pdf#page=15]]
locate -> design repair -> repair -> retest

### Verification and validation planning
- planning makes testing more useful
- planning should start early in development process
- ==balance between static verification and testing==
- more of **setting standards** for testing, instead od describing the test itself

### Structure of software test plan
- testing process
- requirement tracability
- tested items
- testing schedule
- test recording procedures
- hardware and software requirements
- constraints

### Software inspections
- people examining code to find anomalies and defect
- ==inspection==, not execution, so can be ==used before implementation==
- Can be applied to a==ny representation of a system==
- effective for finding program errors

>system representation : requirements, design, configuration data, test data, etc

### Inspections and testing
- both are ==equally necessary== and should be used during ==verification and validation== process
- inspection can check whether ==program fits requirement== but **==not==** whether customer ==likes software or not==
- inspection ==cannot check== for non-functional characteristics such as performance, usability, ==the status of software like performance==
Inspect can : software fits requirement, not customer's preference
cannot check for non-func characteristic like **performance**

### Inspection procedure
team = inspection team
- ==system overview ==presented to team
- ==code and documents ==are handed out to team
- inspection happens, ==notes taken==
- mod happens to ==fix== found errors
- reinspection may or may not be required

### Automated static analysis
- consumes code and automatically find defect

### Stages of static analysis
- **control flow analysis, code**
	- checks for loops with multple exit or entry points
	- ==find unreachable code==
- **data usage analysis, ==variables assignment**==
	- uninitialized variables
	- var written twice
	- declared var but never use
- **information flow analysis**
	- highlights information for code inspection or review
- **Path analysis**
	- Identify paths through the program and sets out the ==statement executed in that part.==

### Use of static analysis
C language
- errors are ==not detected by compiler==
	- so inspection helps
Java language
- ==less cost-effective==
- strong type checking
- detect many errors during compilation

### Testing process
- component testing
	- ==testing individual program components==
	- responsibility of ==component developers==
- system testing
	- testing ==component's groups== integrated to a system/subsytem
	- responsibility of independent ==testing team==
	- tests are based on sytem specification

### Testing phase
Component testing --> system testing
Software developer --> independent testing team

### Testing process goal
**Validation testing** 
- demonstrat to developer and customer that software meets requirements
- successful test shows that system ==operates as intended use==
**Defect testing**
- ==discover defects== where program's behavior does not follow specification
- successful test makes that the s==ystem perform incorrectly, exposing defects==

![[egci341-lecture06-08.pdf#page=31]]

### Testing approach
- Architectural validation
	- ==top-down ==integration testing, better at ==discovering errors ==in the system architecture
- system demonstration
	- ==top-down ==integration testing allows a ==limited demonstration== at an ==early stage== in the development
- test implementation
	- easier with ==bottom-up== integration testing
- test observation
	- extra codes are required to observe test

### Top-down approach
We test by ==each major group of functions==, then smaller to each ==methods==
![[egci341-lecture06-08.pdf#page=33]]

### Bottom up approach
we test by drivers, ==smaller methods/components== first before testing more ==major functions==

### Release testing
"test before release, befor distribution to customer"
- release testing of a system that would be distributed to customers
- primary goal is to ==increase supplier's confidence== that the system meets requirements
- release testing is usually ==**black box**== or ==functional testing==
	- based on system's specification only
	- testers ==do not need to have== knowledge of the ==system implementation==
- Alpha testing and beta testing

### Blackbox testing
- valid
	- within scope, pass
	- not within scope, not pass
- invalid
	- invalid input, reject
	- null, reject


| test case      | test data    | expected result | program result | note |
| -------------- | ------------ | --------------- | -------------- | ---- |
| 0<x<20.00      | 19.00 18 2   | 10              | 10             | pass |
| 20<x<100       | 25 30 30.5   | 5               | 5              | pass |
| x>100          | 1000 999 101 | 0               | 0              | pass |
| invalid values | -1, a, yolo  | reject          | reject         | pass |
| null, invalid  | null         | reject          | reject         | pass |

### White box testing
Practice :

| test case           | test data            | expected result | program result | note |
| ------------------- | -------------------- | --------------- | -------------- | ---- |
| disciplinary denied | disciplinary blocked |                 |                |      |
|                     |                      |                 |                |      |

### Use cases
to create use cases
- identify ==tested operation==
- designed required ==test case==
From a sequence diagram, the inputs and outputs, created for the tests, can be identified

### Performance testing, part of release testing
- testing the properties of the system, like ==performance and reliability==, test ==nonfunctional== stuff
- up UP : planning tests where the load is steadily increase to see when the performance becomes unacceptable

### Stress test (performance test)
- Exercise the system ==beyond== its ==maximum design load==
- Stress system test ==failure behavior==
	- should ==not fail catastrophically==
	- stress test checks for unacceptable ==lost of services or data==
- Particular relevant to ==distributed system==
	- Exhibit severe degradation as a network becomes overloaded

### Component testing
- testing individual ==components== in ==isolation==
- ==defect== testing process
- components type
	- individual ==function or method== within an object
	- object ==classes ==with several attr and methods
	- ==composite components== with defined interfaces used to access their functionality
"find defect of, individual methods, object class, composite components, in isolation" ==test in isolation==

### Object class testing
- testing all operations associated with an object
- setting and interrogating all obj attr
- exercise object in all possible states
"test class, methods, attributes, every states, and operations"

### Interface testing (object interface)
- detect faults due to ==interface errors== or ==invalid assumption ==about interfaces
- importance for **==OPP==** as objects are defined by their ==interfaces==

### Interface tyoes
- parameter interfaces, data pass
	- data pass from one procedure to another
- shared ==memory== interfaces
	- block of memory is shared ==between procedures of functions==
- procedural interfaces
	- subsystem has ==encapsulation set of procedures==, which can be called by another subsystem
- message passing interfaces
	- subsystem request services from other sub-systems

### Interface errors
- interface misuse
	- e.g. ==parameters in wrong order==
- interface misunderstanding
	- assume wrongly about the use case of the interface, which is called
	- ==call wrongly==
- Timing errors
	- the called and calling component operate at different speeds and out of date information is accessed
	- ==different speed in concurrency work==

### Software integration

### The world before DevOPs
- waterfall model
- V model 
	- Dev life cycle -> tester's life cycle
- customer <-[gap filled by Agile]> developer+tester <-> IT infrastructure

### DevOps
Connect development and operation (infras) together

Customer <-[agile]-> developer <-[devOps] -> infrastructure

### The world before devOps
- developers
	- frequently ==disagree with sys admin==
	- spending time on ==mundane manual task==
- operations
	- challenging ==audits==
	- hard-to-diagnose outages
	- received codes from ==developer with little communication
- product manager
	- disagree with sys admin
	- cost and inefficient project
- Sys admin
	- disagree with developers
	- lack visibility in developing process
	- considerable time spent on upkeeop
"mostly are disagreement and knowledge management between two parties"

### DevOps
Culture, movement which emphasize on the ==collaboration and communication== between ==developers== and ==infrastructure== while ==automating process== of software delivery (dev's work) and infrastructure change (IT's work)

**addition to Agile**
- customer value
- keeping creativity (development)
- stability (operations)

### DevOps
is an entire sets of philosophy and tools, not just not single thing but a set of many things

### DevOps framework overview
- People
	- mindset
	- role and responsibility
- process
	- pracrices
		- devOps pipeline
		- configuration measurement
		- 5C
		- automation
		- iaC
		- containerization
- Technology
	- DevOps toolchain
	- devOps periodic table

### Agile Dev + IT Ops = devOps
- communication
- collaboration
- integration
- automation

### Mindset
V mode = nothing
V mode + devOps
Agile
Agile + devOps

### DevOps mindset : people - lean thinking
**value and waste**
- lean (S/W Dev) is a systematic ==method== in which the core ideas is to ==maximize customer== value and ==minimizing waste==
- value : anything customer ==willing to pay for==
- waste : action or step in a process that does not add value to customer, process that customer does not want to pay for ==redundant process, that customer wont pay for==

### devOps pipeline
organized sets of instructions for dev and infra
- dev : plan -> code -> build -> test
- infras : release -> deploy -> operate -> monitor

- plan -> code -> integrate -> test -> release -> deploy -> oprerate -> monitor

### Software configuration management (SCM)
- process to systematically manage, organize and control changes  in the documents, codes, and other entities during Sofware Dev Life Cycle, aims to ==increase productivity with minimal task==
- ==**control change in code and docs**==

### 5C
Practice that is repeatable and can be automated, to increase productivity
continuous integration -> continuous testing -> continuous delivery -> continuous deployment -> continuous monitoring
![[egci341-lecture09-10.pdf#page=27]]
![[egci341-lecture09-10.pdf#page=28]]

### Automation
- creating software to replace a repeatable process
- increase quality and productivity

Example :
Build (Maven)
Unit test
Code inspection
Packaging
Deployment
System/functional test
Non-functional test
Documentation

### Infrastructure as a code
Managing and provisioning computer data center through machine-readable definition files rather than hardware configuration

## Containerization
Packaging an application along wiht its required library, separately

### KPIs
CALMs
Culture, automation, lean, measurement, sharing

### More KPIs
- Mean Time To Production: How long does it take for any newly committed
- source code to reach production?
- Deployment Frequency: How often are releases deployed into production?
- Average Lead Time: How long does it take for a new feature to be developed, built, tested, and deployed into production?
- Deployment Speed: How much time does it take to deploy a new release into production?Production Failure Rate: How often do failures occur in production?
- Mean Time To Recover (MTTR): How long does it take to recover from a failure?

### Apply DevOps
1. build the devOps team
2. design devOps metholodogy
3. design software architecture
4. design devOps pipeline
5. start building devOps pipeline
6. start building software solution
7. delivery measure and iterate with improvement

### Software cost estimation
FP
- External inputs and outputs (EI, EO)
- User interaction and external queries (EQ)
- External interface files (EIF) API that app uses
- file used by the system or internal logical file (LIF)
UFC = sum(number of elements of given type) x weight
LOC = AVC * number of function points
AVC = average number of lines of code

Productivity Estimates
Real-time embedded systems, 40-160 LOC/P-month
(LOC/P-month: Lines of code per person-month)
System programs , 150-400 LOC/P-month
Commercial applications, 200-900 LOC/P-month
Object points:
Productivity has been measured between 4 and 50 object points/month
Depend on tool’s supports and developer capability

- VAF = ==0.65 + (0.01xTDI) === 0.48 + 0.65 = 1.13
- UFC = sum of all weight factor = $\sum$ no. of functions * weight (refers from types of function as well, and weight factor)  = 2 * 7  + 3 * 5 + 3 * 15 + 1 * 3 + 3 * 5 + 2 * 5 + 2 * 3 = 108
- Function points : FP = UFC x VAF = 1.13 * 108= 122.04  
- Find estimated LOC : AVC * FP = 34 * 122.04 = 4149.36
- Find cost estimation of software : Est LOC * Dollar/LOC : 4149.36 * 204 = $99584.64
- Effort : Est. LOC / (LOC/pmonth) = 4149.36 / 360 = 11.526 p-month (effort for the total project)
	- Add more people, more cost, but lower calendar month (no. of dev * calendar month = p-month) p-month mostly stays the same

Effort = A x size^B x M
A is a organization-dependent constant
B disproportionate effort for large projects
M mutiplier reflecting product, process and people attrs

## COCOMO 2 models
1. Application composition model
	- used when software is composed from existing part
2. early design model
	1. used when requirements are available but design has not yet started
3. reuse model
	1. used to compute effort of integrating reusable components
4. post-architecture model
	1. used once the system architecture has been designed and more information about the system is available 

## Application composition model
PM = (NAP x (1 - %reuse/100)) / PROD
PM is the effort in person-months
NAP or NOP is the number of application points of object points
PROD is the productivity

## Early design model
PM = A x Size^B x M
M = PERS × RCPX × RUSE × PDIF × PREX × FCIL × SCED
A = 2.94 in initial calibration,
Size in KLOC
B varies from 1.1 to 1.24

RCPX - product reliability and complexity
RUSE - the reuse required
PDIF - platform difficulty
PREX - personnel experience
PERS - personnel capability
SCED - required schedule
FCIL - the team support facilities

B = 1.01 + 0.01 x SUM(SF)
SF = scale factor
Each SF is rated on 6-point scale (ranging from 0 to 5) : very low (5), low ( 4), nominal (3), high (2), very high (1), extra high (0)

## Reuse model
For regenerated code :
PM = (ASLOC * AT/100)/ATPROD
ASLOC is the number of lines of generated code
AT is the percentage of code automatically generated
ATPROD is the productivity of engineers in integrating this code
code has to be understood and integrated
ESLOC = ASLOC * (1-AT/100) * AAM

ASLOC is the number of lines of generated code
AT is the percentage of code automatically generated
AAM is the adaptation adjustment multiplier computed from the costs of changing the reused code, the costs of understanding how to integrate the code and the costs of reuse decision making. AAM is the sum of three components (AAF+SU+AA)
AAM is the sum of three components
AAF (Adaptive Component)
SU (Understanding Component) ranges from 50 for complex to 10 for well-written, object-oriented code AA (Assessment Component) varies from 0 to 8 depending on the amount of analysis effort required

Calendar time can be estimated using a COCOMO 2 formula
TDEV = 3 × (PM)^(0.33+0.2*(B-1.01))
PM is the effort computation and B is the exponent computed as discussed above (B is 1 for the early prototyping model) This computation predicts the nominal schedule for the project






