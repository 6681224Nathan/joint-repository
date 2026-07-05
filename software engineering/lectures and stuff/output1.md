Lecture15-16:	Software	Cost	Estimation

EGCI341:	WEEK10

Fundamental	Estimation	Questions

§ How	much	effort	is	required	to	complete	an	activity?

§ How	much	calendar	time	is	needed	to	complete	an	activity?

§ What	is	the	total	cost	of	an	activity?

EGCI341

2

Software	Cost	Components

§ Hardware	and	software	costs

§ Travel	and	training	costs

§ Effort	costs		(the	dominant	factor	in	most	projects)

o The	salaries	of	engineers	involved	in	the	project
o Social	and	insurance	costs

§ Effort	costs	must	take	overheads	into	account

o Costs	of	building,	air	condition,	lighting
o Costs	of	networking	and	communications
o Costs	of	shared	facilities	(e.g library,	staff	restaurant,	etc.)

EGCI341

3

Software
Pricing
Factors

EGCI341

4

Software	Productivity

§ A	measurement	of	the	rate	at	which	individual	engineers	involved

in	software	development	produce	software	and	associated
documentation

§ Not	quality-oriented	although	quality	assurance	is	a	factor	in

productivity	assessment

§ Measure	the	functionality	produced	per	time	unit

EGCI341

5

Productivity	Measures

§ Size-related measures based	on	output	from	the	software	process
o This	may	be	lines	of	delivered	source	code,	object	code	instructions,	etc.

§ Function-related measures based	on	an	estimation	of	the

functionality	of	the	delivered	software
o Function-points	are	the	best	known	of	this	type	of	measure

EGCI341

6

Measurement	Problems

§ Estimating	the	size	of	the	measurement

o e.g.	How	many	function	points

§ Estimating	the	total	number	of	programmer’s	months	that	have

elapsed

§ Estimating	contractor	productivity	(e.g.	documentation	team)

EGCI341

7

Lines	of	Code	(LOC)

§ What's		a	line	of	code?

o The	measurement	was	the	first	propose	when	programs	were	typed	on

cards	with	one	line	per	card

o How	does	this	correspondent	to	statements	as	in	Java	which	can	span
several	lines	or	where	there	can	be	several	statements	on	one	line

§ What	programs	should	be	counted	as	part	of	the	system?

§ This	model	assumes	that	there	is	a	linear	relationship	between

system	size	and	volume	of	documentation

EGCI341

8

Productivity	Comparisons

§ The	lower	level	the	language,	the	more	productive	the

programmer
o The	same	functionality	takes	more	codes	to	implement	in	a	lower-level

language	than	in	a	high-level	language

§ The	more	verbose	the	programmer,	the	higher	the	productivity

o Measures	of	productivity	based	on	lines	of	codes	suggest	that

programmers	who	write	verbose	code	are	more	productive	than
programmers	who	write	compact	code

EGCI341

9

System	Development	Times

EGCI341

10

Function	Points

Based	on	a	combination	of	program	characteristics

1.

External	Inputs	and	Outputs	(EI,	EO)

2. User	Interactions	or	External	Queries	(EQ)

3.

4.

External	Interface	files	(EIF)

files	used	by	the	system	or	Internal	Logical	Files	(ILF)

A	weight	is	associated	with	each	of	these	characteristics	and	the	function
point	count	is	computed	by	multiplying	each	raw	count	by	the	weight	and
summing	all	values
§ Three	types	of	No.	of	elements	:	data	element	(DET),	record	element	(RET),	and	file

type	reference	(FTR)

§ Weight	or	value	adjustment	factor	(VAF)

UFC = å(number of elements of given type) ´ (weight)

EGCI341

11

Function	Points (Cont.)

§ Function	point	count	is	modified	by	complexity	of	the	project

§ FPs	can	be	used	to	estimate	LOC	depending	on	the	average	number	of	LOC

per	Function	Points	(FP)	for	a	given	language
o LOC	=	AVC	*	number	of	function	points
o AVC	is	a	language-dependent	factor	varying	from	200-300	for	assemble	language	to	2-40

for	a	4GL

o AVC:	the	average	number	of	lines	of	code

§ FPs	are	very	subjective

o They	depend	on	the	estimator
o Automatic	function-point	counting	is	impossible

EGCI341

12

Function	Points (Cont.)

FP Complexity	Level

Internal	Logical	Files	and	External	Interface	Files

Record	Elements

Data	Element

Complexity	Level
§ Low
§ Average
§ High

EGCI341

1

2-5

6+

1-19

Low

Low

Average

20-50

Low

Average

High

Internal	External	Output and	External	Inquiry

File	Types

Data	Element

0	or 1

2-3

4+

1-5

Low

Low

Average

6-19

Low

Average

High

For	External	Input

File	Types

Data	Elements

0	or	1

2-3

3+

1-4

Low

Low

Average

5-15

Low

Average

High

51+

Average

High

High

20+

Average

High

High

16+

Average

High

High

13

Function	Point
Calculation

Complexity-Weight

Weight-Factor

Function	Type

Count

Low

Average

High

Total

1.	Internal	Logical	File	(ILF)

2.	External	Interface	File	(EIF)

3.	External	Input (EI)

4.	External	Output (EO)

5.	External	Inquiry	(EQ)

UFC

___ x

___ x

___ x

___ x

___ x

7

5

3

4

3

10

7

4

5

4

15

10

6

7

6

Sum	Total	=

Complexity	Multiplier	(VAF)

VAF	=	0.65+(0.01xTDI)	=

Function	Points	=

FP	=	UFCxVAF =

EGCI341

14

Degree	of	Influence

EGCI341

To	calculate	DI,	the	following	factors	are	rated	on	a	scale	of	0	to	5:

0
No
Influence

1
Incidental

2
Moderate

3

Average

4
Significant

5
Essential

S/N
1	 Does	the	system	require	reliable	backup	and	recovery?

Question

Rating

2	 Are	data	communications	required?
3	 Are	there	distributed	processing	functions?
4
5	 Will	the	system	run	in	an	existing	heavily	utilized	operational	environment?

Is	performance	critical?

6	 Does	the	system	require	online	data	entry?
7	 Does	the	online	data	entry	require	the	input	transaction	to	be	built	over	multiple

screens	or	operations?

8	 Are	the	master	files	updated	online?
9	 Are	the	inputs,	outputs,	files,	or	inquires	complex?

Is	the	internal	processing	complex?
Is	the	code	designed	to	be	reusable?

10
11
12	 Are	conversion	and	installation	included	in	the	design?

13

Is	the	system	designed	for	multiple	installations	in	different	organizations?

14

Is	the	application	designed	to	facilitate	change	and	ease	of	use	by	the	user?

Total DI	(TDI)	=

S

15

Average	Number	of	Lines	of	Code	(AVC)

Lines	of	Codes:	LOC	=	AVC	*	FP

Language

SLOC/FP

Access

C

C++

HTML

JAVA

Perl

Visual	C++

38

128

55

15

53

27

34

(From	Capers	Jones,	1996)

EGCI341

16

Example:	Lines	of	Code

There	are	4	subsystems	in	this	project

Given	for	each	subsystem:
§ size	in	LOC
§ productivity	metric:		LOC/P-month
§ Cost	metric:	$/LOC

Calculate	the	system	total	cost	in	$	and	effort	in	months

Functions

Estimated	LOC

LOC/P-month

$/LOC

Cost

Effort

UICF

2DGA

DSM

PCF

Total

2340

5380

3350

2140

315

220

240

140

14

20

18

28

32760

7.4

EGCI341

17

Object	Points

§ Object	points (alternatively	named	application	points)	are	an
alternative	function-related	measurement	to	function	points

§ Object	points	are	NOT the	same	as	object	classes

§ The	number	of	object	points	in	a	program	is	a	weighted	estimation	of:

o Number	of	separate	screens	that	are	displayed
o Number	of	reports	that	are	produced	by	the	system
o Number	of	program	modules	that	must	be	developed	to	supplement	the

database	code

EGCI341

18

Productivity	Estimates

§ Real-time	embedded	systems,	40-160	LOC/P-month

o (LOC/P-month:	Lines	of	code	per	person-month)

§ System	programs	,	150-400	LOC/P-month

§ Commercial	applications,	200-900	LOC/P-month

§ Object	points:

o Productivity	has	been	measured	between	4	and	50	object	points/month
o Depend	on	tool’s	supports	and	developer	capability

EGCI341

19

Factors	Affecting	Productivity

§ Application	Domain	Experience

§ Process	Quality

§ Project	Size

§ Technology	Support

§ Working	Environment

EGCI341

20

Estimation	Techniques

EGCI341

21

Pricing	to	Win

§ Project	costs	whatever	the	customer	has	to	spend	on	it

§ Advantages:

o You	get	the	contract

§ Disadvantages:

o The	probability	that	the	customer	gets	the	system	he	or	she	wants	is

small

o Costs	do	not	accurately	reflect	the	work	required

EGCI341

22

Top-Down	and	Bottom-Up	Estimation

§ Top-down

o Start	at	the	system	level	and	assess	overall	system	functionality	and	how

this	is	delivered	through	subsystems

§ Bottom-up

o Start	at	the	component	level	and	estimate	the	effort	required	for	each

component

o Add	these	efforts	to	reach	a	final	estimation

EGCI341

23

Top-Down	Estimation

§ Usable	without	knowledge	of	the	system	architecture	and	the

components	that	might	be	part	of	the	system

§ Takes	into	account	costs	such	as	integration,	configuration

management	and	documentation

§ It	may	underestimate the	cost	of	solving	difficult	low-level

technical	problems

EGCI341

24

Bottom-Up	Estimation

§ Usable	when	the	architecture	of	the	system	is	known	and

components	identified

§ This	can	be	an	accurate	method	if	the	system	has	been	designed

in	detail

§ It	may	underestimate	the	costs	of	system	level	activities	such	as

integration	and	documentation

EGCI341

25

Algorithmic	Cost	Modelling

§ Cost	is	estimated	as	a	mathematical	function	of	product,	project	and
process	attributes	whose	values	are	estimated	by	project	managers:

Effort	=	A	× SizeB × M

o A is	an	organisation-dependent	constant,
o B reflects	the	disproportionate	effort	for	large	projects	and,
o M is	a	multiplier	reflecting	product,	process	and	people	attributes

§ Most	commonly	used	product	attribute	for	cost	estimation	is	code	size

§ Most	models	are	similar	but	they	use	different	values	for	A,	B	and	M

EGCI341

26

Estimation	Accuracy

§ Size	of	a	software	system	can	only	be	known	accurately	when	it	is

finished

§ Several	factors	influence	the	software	size:

o Use	of	COTS	and	components
o Programming	language
o Distribution	of	system

§ As	the	development	process	progresses	then	the	size	estimate

becomes	more	accurate

EGCI341

27

COCOMO	Model

§ Constructive	Cost	Model	(COCOMO)

§ Long	history	from	initial	version	published	in	1981	(COCOMO-81)

through	various	instantiations	to	COCOMO	2

§ COCOMO	81	was	developed	with	the	assumption	that	a	waterfall
process	would	be	used	and	that	all	software	would	be	developed
from	scratch

§ There	have	been	many	changes	in	software	engineering	practice
o COCOMO	2	is	designed	to	accommodate	different	approaches	to

software	development

EGCI341

28

COCOMO	2	Models

Submodels in	COCOMO	2	are:

1. Application	composition	model

o Used	when	software	is	composed	from	existing	parts

2. Early	design	model

o Used	when	requirements	are	available	but	design	has	not	yet	started

3. Reuse	model

o Used	to	compute	the	effort	of	integrating	reusable	components

4. Post-architecture	model

o Used	once	the	system	architecture	has	been	designed	and	more

information	about	the	system	is	available

EGCI341

29

COCOMO	2	Models	(Cont.)

EGCI341

30

Application	Composition	Model

§ Supports	prototyping	projects	and	projects	where	there	is	extensive	reuse

§ Based	on	standard	estimates	of	developer	productivity	in	application

(object)	points/month

§ Takes	CASE	tool	use	into	account

§ Formula	is: PM	=	(	NAP	x	(1	- %reuse/100	)	)	/	PROD

o PM is	the	effort	in	person-months
o NAP or	NOP	is	the	number	of	application	points	or	object	points
o PROD is	the	productivity

EGCI341

31

Object	Point:	Complexity	Level	and	Weighting

For	Screen

For	Report

#	and	source	of	data	tables

#	and	source	of	data	tables

Total	<4
(<2	servers,
<3	clients)

Total<8
(2-3	servers,
3-5	clients)

Total	8+
(>3	servers,
>5	clients)

Number
of
Section

Total<4
(<2	server,
3	clients)

Total<8
(2-3
servers,	3-5
clients)

Total	8+
(>3	servers,
>5	clients)

simple

simple

simple

Medium

medium

difficult

medium

difficult

difficult

0-1

2-3

4+

simple

simple

Medium

simple

medium

difficult

medium

difficult

difficult

No.	of
Views

<3

3-7

8+

Object	Type

Simple

Medium

Difficult

Screen

Report

Each	3GL
Module

1

2

10

2

5

10

3

8

10

EGCI341

32

Example:	Object	Counts

Object	counts:

2	simple	screens		x	1

3	medium	screens		x	2

Total	Objects

=		2

=		6

=		8

EGCI341

33

Object	Point	Productivity

EGCI341

34

Early	Design	Model

§ Estimation	can	be	made	after	the	requirements	have	been	agreed

§ Based	on	a	standard	formula	for	algorithmic	models

PM	=	A	× SizeB × M	where

o M =	PERS	× RCPX	× RUSE	× PDIF	× PREX	× FCIL	× SCED;
o A	=	2.94	in	initial	calibration,
o Size in	KLOC
o B varies	from	1.1	to	1.24

Ø Depending	on	novelty	of	the	project,	development	flexibility,	risk

management	approaches	and	the	process	maturity

EGCI341

35

Multipliers

Multipliers	reflect	the	capability	of	the	developers,	the	non-functional
requirements,	the	familiarity	with	the	development	platform,	etc.
§ RCPX	- product	reliability	and	complexity
§ RUSE	- the	reuse	required
§ PDIF	- platform	difficulty
§ PREX	- personnel	experience
§ PERS	- personnel	capability
§ SCED	- required	schedule
§ FCIL	- the	team	support	facilities

You	estimate	values	for	these	attributes	using	a	six-point	scale	where	1
corresponds	to	very	low	values	and	6	corresponds		to	very	high

EGCI341

36

The	Exponent	B	:	Scale	Factor(SF)

Exponent	B	for	effort	calculation

B	=	1.01		+		0.01	x		S SF	(i)			,	i=1,…,	5
§ SF	=	Scale	Factor
§ Each	SF	is	rated	on		6-point	scale	(ranging	from	0	to	5)	:
§ very	low	(5),	low	(	4),	nominal	(3),		high	(2),	very	high	(1),		extra	high	(0)

Five	Scale	Factor	(exponent	drivers)

1. Precedenteness
2. Development	flexibility
3. Architecture/risk	resolution
4. Team	cohesion
5. Process	maturity

EGCI341

37

Exponent	Scale	Factors

EGCI341

38

Example:	The	Exponent	Term

§ This	depends	on	5	scale	factors	(see	next	slide).	Their	sum/100	is	added	to	1.01

§ A	company	takes	on	a	project	in	a	new	domain.	The	client	has	not	defined	the

process	to	be	used	and	has	not	allowed	time	for	risk	analysis.
The	company	has	a	CMM	level	2	rating:

o Precedence	- new	project	(4)

o Development	flexibility	- no	client	involvement	- Very	high	(1)

o Architecture/risk	resolution	- No	risk	analysis	- V.	Low	(5)

o Team	cohesion	- new	team	- nominal	(3)

o Process	maturity	- some	control	- nominal	(3)

Scale	factor	is	therefore	1.17

EGCI341

39

Reuse	Model

§ Takes	into	account	black-box	code	that	is	reused	without	change	and

code	that	has	to	be	adapted	to	integrate	it	with	new	code

§ There	are	two	versions:

o Black-box	reuse	where	code	is	not	modified

Ø Effort	estimation	(PM)	is	computed

o White-box	reuse	where	code	is	modified

Ø A	size	estimation	equivalent	to	the	number	of	lines	of	new	source	code	is	computed
Ø This	adjusts	the	size	estimation	for	new	code

EGCI341

40

Reuse	Model	Estimation

For	generated	code:

PM	=	(ASLOC	*	AT/100)/ATPROD

§ ASLOC is	the	number	of	lines	of	generated	code
§ AT is	the	percentage	of	code	automatically	generated
§ ATPROD is	the	productivity	of	engineers	in	integrating	this	code

For	Generated	code	example
PM	=	(20,000	x	30/100)	/	2400	=	2.5	person-months

EGCI341

41

Reuse	Model	Estimates	2

When	code	has	to	be	understood	and	integrated:

ESLOC	=	ASLOC	*	(1-AT/100)	*	AAM

§ ASLOC is	the	number	of	lines	of	generated	code
§ AT is	the	percentage	of	code	automatically	generated
§ AAM is	the	adaptation	adjustment	multiplier	computed	from	the	costs	of

changing	the	reused	code,	the	costs	of	understanding	how	to	integrate	the
code	and	the	costs	of	reuse	decision	making.

§ AAM	is	the	sum	of	three	components	(AAF+SU+AA)

EGCI341

42

Reuse	Model	Estimation	(Cont.)

AAM is	the	sum	of	three	components
§ AAF (Adaptive	Component)
§ SU (Understanding	Component)	ranges	from	50	for	complex	to	10	for	well-

written,	object-oriented	code

§ AA (Assessment	Component)	varies	from	0	to	8	depending	on	the	amount

of	analysis	effort	required

EGCI341

43

Post-architecture	Level

§ Uses	the	same	formula	as	the	early	design	model	but	with	17

rather	than	7	associated	multipliers

§ The	code	size	is	estimated	as:

o Number	of	lines	of	new	code	to	be	developed;
o Estimation	of	equivalent	number	of	lines	of	new	code	computed	using

the	reuse	model;

o An	estimation	of	the	number	of	lines	of	code	that	have	to	be	modified

according	to	requirements	changes

EGCI341

44

Multipliers

Product	attributes
§ Concerned	with	required	characteristics	of	the	software	product	being	developed

Computer	attributes
§ Constraints	imposed	on	the	software	by	the	hardware	platform

Personnel	attributes
§ Multipliers	that	take	the	experience	and	capabilities	of	the	people	working	on	the

project	into	account

Project	attributes
§ Concerned	with	the	particular	characteristics	of	the	software	development	project

EGCI341

45

EGCI341

46

Effects	of	Cost	Drivers

EGCI341

47

Project	Planning

§ Algorithmic	cost	models	provide	a	basis	for	project	planning	as	they	allow

alternative	strategies	to	be	compared

§ Embedded	spacecraft	system

o Must	be	reliable
o Must	minimise	weight	(number	of	chips)
o Multipliers	on	reliability	and	computer	constraints	>	1

§ Cost	components

o Target	hardware
o Development	platform
o Development	effort

EGCI341

48

Management	Options

EGCI341

49

Management	Option	Costs

EGCI341

50

Option	Choice

§ Option	D	(use	more	experienced	staff)	appears	to	be	the	best

alternative
o However,	it	has	a	high	associated	risk	as	experienced	staff

may	be	difficult	to	find

§ Option	C	(upgrade	memory)	has	a	lower	cost	saving	but	very	low

risk

§ Overall,	the	model	reveals	the	importance	of	staff	experience	in

software	development

EGCI341

51

Project	Duration	and	Staff

§ As	well	as	effort	estimation,	m	anagers must	estimate	the	calendar
time	required	to	complete	a	project	and	when	staff	will	be	required

§ Calendar	time	can	be	estimated	using	a	COCOMO	2	formula

o TDEV	=	3	× (PM)(0.33+0.2*(B-1.01))
o PM	is	the	effort	computation	and	B	is	the	exponent	computed	as

discussed	above	(B	is	1	for	the	early	prototyping	model)

o This	computation	predicts	the	nominal	schedule	for	the	project

§ The	time	required	is	independent	of	the	number	of	people	working	on

the	project

EGCI341

52

Staffing	Requirements

§ Staff	requirement	cannot	be	computed	by	dividing	the	development	time	by

the	required	schedule

§ Number	of	people	working	on	a	project	varies	depending	on	the	phase	of	the

project

§ The	more	people	who	work	on	the	project,	the	more	total	effort	is	usually

required

§ A	very	rapid	build-up	of	people	often	correlates	with	schedule	slippage

EGCI341

53

Reference

§ This	set	of	slides	and	examples	are	modified		from	Ian	Sommerville,	Software	Engineering	8th

Edition,	Addison-Wesley;	2007

EGCI341

54

Any	Questions?

:O)

Thank	you

EGCI341

55


