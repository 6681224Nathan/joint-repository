
Sample data : a sample from a large population
Population data : all data

## Deming experiment
Process should not be adjusted in response to random variation.

## Variance
average physical distance from mean
$s^2$ = VAR.S(data)

## Standard deviation
s = STEV.S(data) = $\sqrt(s^2)$

## Mean Median Mode
AVERAGE MEDIAN MODE(range)

## Percentile
K% (percentile) of all data values are less than it. **80% of the data values lie below 80th percentile.**
==we use exclude as the main one, percentile.exc==
Include is **population**, exclude is **sample**

## Quartile
25 percentile amount for each quartile

## Range and inter quartile range
Inter quartile range = Q3 - Q1
Range = max - min

## Stem and leaf diagram
Leaf must always be a single digit
Ordered stem and leaf just have ordered leaf

## Histogram
Bar chart

## Pareto chart
similar to bar chart I guess

## Box plot
![[02-DataSummaryPresentation.pdf#page=35]]


## Chapter 2 need to know for ==cheat sheet==
Box plot : Upper limit = 1.5IQR + Q3
Lower limit = 1.5IQR - Q1
correl(data A, data B) finding correlation between two data, a plot can be created as well
upper quartile != upper limit

## Probability
P(A|B) = P(A sec B) / P(B)

Order matters = factorial
Order does not matter = Out of n total items, I am choosing r items.
n fact / r fact (n-r) fac

## Norm.dist, norm.s.dist
Standard normal distribution is a normal distribution with 0 mean and 1 variance
**continuous btw**

## From normal variable to standard norm variable
Z = (x-mean)/standard deviation
P(Z, z) means standard normal distribution z
For standard normal distribution, P(Z<4.5) and P(Z<=4.5) are the same
Inv converts from standard normal distbution chance to a Z (random var)


## Uniform distribution
mean = sum of all x * f(x)
standard deviation = sum of x^2 * F(x) * mean ^ 2
power(a, b) = a^ b

**short cut : in case that all f(x) of all x values are equal,** 
mean = 1/2 * (min+max)
variance = (max-min+1)^2-1)/12
sd = sqrt(variance)

## Binom.dist
Typically a discrete function, but have cumulative as well
binom.dist(random_var, no. of trials, prob of success, cumulative?)
=binom.dist(number of success we want, number of total trials that will happen, prob of success per one occurence, cumulative?)
=POISSON.DIST(number of occurrences we want, average rate of occurrences that will happen, cumulative?)
**Poisson lacks hard limit**

## Binom and poisson
Binom measures the number of success of hard limit "n" trials
Whilst poisson counts a number of success over a continuous field or window (time, distance, area) no fixed upper limit of how many times it can happen
**binom is discrete, poisson is continuous**

## Normal distribution
All you need is there, bell curve

## Binom to normal.s
convert from x to z using formulas x-mean/(sqrt(n(1-p)(p))
'Z=(X+-0.5-mean)/std (x adds 0.5 due to convert from continuous to discrete), adds or subtracts based on more or less
P(X = 5) ≈ P(4.5<=X<=5.5)
std = "=SQRT(n*p*(1-p))
np=mean

## Confidence interval
alpha = 1- confidence interval 
z=alpha/2
lower bound = mean "+"- norm.s.inv(CI + Z) * stdev / sqrt(n)
![[Pasted image 20260602094232.png]]
![[Pasted image 20260602094248.png|331]]
![[Pasted image 20260602094303.png]]

![[Pasted image 20260602094356.png]]
![[Pasted image 20260602094536.png]]
![[Pasted image 20260602094931.png]]
![[Pasted image 20260602094956.png]]
![[Pasted image 20260602095020.png]]
![[Pasted image 20260602095036.png]]
![[Pasted image 20260602095050.png]]



## Additional for data filering
- Use filter option (just press) in "Data" section, to sort a large ass cells out
- =VLOOKUP(what you want to look for,data, for what column you want to show, approximate or not (for large data, true for approx, false for not approx))
- same thing, double click the "+" icon that originally used to expand the formula to other rows, to cover a column that expands downward infinitely, **for the column of the formula, not the data**
- 


