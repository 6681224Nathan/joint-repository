
Z = stdev for pop have
T = stdev for pop no, just sample
### Confidence interval
Two way, back to back. 
- Z test and T test uses the same formula, ==critical value== is positive only, that is what the formula is made for, so calculate right tail critical value
$$ \bar{x} - \frac{z_{\alpha /2} \cdot \sigma}{\sqrt{n}} \leq \mu \leq \bar{x} + \frac{z_{\alpha /2} \cdot \sigma}{\sqrt{n}}$$
$\sigma$ is a standard deviation, for T, use sample, for Z, use pop

> if n >= 30, use Z test right away because sample is large enough

**Chi square**
$$ \frac{(n-1)s^2}{X^2_{\alpha/2, n-1}} \leq \sigma^2 \leq\frac{(n-1)s^2}{X^2_{1-\alpha/2, n-1}}$$
The formula is about denominator so it is switched, for a larger/smaller value
### Confidence bound
One way, very extreme
Remember, Z, T, and X are critical value

Either, for upper confidence bound, for z and t
$$ \mu \leq u = \bar{x} + \frac{z_{\alpha}\cdot\sigma}{\sqrt{n}} $$
Or, for lower confidence bound, for z and t
$$\bar{x} - \frac{z_{\alpha}\cdot\sigma}{\sqrt{n}} = l \leq \mu $$
 or ==chi square==, upper conf bound, remember, X is critical value
 $s^2$ is sample variance
 ==WARNING : alpha means ALPHA FROM THE RIGHT==
$$ \frac{(n-1)s^2}{X^2_{\alpha, n-1}} \leq \sigma^2 $$
And lower con bound
$$ \sigma^2 \leq \frac{(n-1)s^2}{X^2_{1-\alpha, n-1}} $$

### Chi square test
Is not symmetric so two tail test for P value, needs to determine first whether which side of the graph is the test stats stay, then find the extreme value according to that side and multiply by 2. ==center of the graph is degree of freedom==

## Proportion, sample prop and pop prop
**CI**
![[Pasted image 20260703153156.png|475]]
**CB**
![[Pasted image 20260703153637.png]]
**Reverse engineer, how large n we require to get that we can make sure that the error is below 0.05 with 95% confidence**
![[Pasted image 20260703153832.png]]
P is **sample** proportion, Z is also left tail as always. The error, well, depends
For upper bound on n, change p(1-p) to be 0.25

### Test statistics for Z test
$\bar{X}$ = sample mean
$\mu_{0}$ = hypothesis
$\sigma$ = ==pop stdev==
n = sample count 
![[Pasted image 20260703160643.png]]

### Test statistics for T test
$\bar{X}$ = sample mean
$\mu_{0}$ = hypothesis
$s$ = ==sample stdev==
n = sample count 
![[Pasted image 20260703171900.png]]

### Test statistics for Chi Square $X^2$
n= sample count
$s^2$ is sample variance
$\sigma^2$ is hypothesized variance
![[Pasted image 20260709211547.png]]

### Test statistics for Z test (proportion)
$\hat{P}$ = sample proportion
$p_{0}$ = hypothesized proportion
n = sample count
![[Pasted image 20260709220625.png]]

- **population** mean : Z 
- sample mean : T

- **population** variance : Z
- sample variance : X^2

==in THESE INTERVALS AND BOUND, it has to be right tail critical value, to get the positive value==

Two sample Z test : known pop stdev
![[Pasted image 20260711182411.png]]
![[Pasted image 20260711183425.png]]
![[Pasted image 20260711183740.png|460]]

### Two sample pooled t-test : pop stdev are unknown, equal pop stdev
![[Pasted image 20260711182435.png]]
![[Pasted image 20260711182448.png]]
![[Pasted image 20260711183151.png]]

### Two sample Welch's t-test : pop stdev are unknown, unequal pop stdev
![[Pasted image 20260711182526.png]]
![[Pasted image 20260711182534.png]]
V is degree of freedom
![[Pasted image 20260711183245.png]]



Paired t test : two matched or paired measurement, same item, different testing under two different conditions or methods.
- same subject twice, before and after **same number of samples**
![[Pasted image 20260711184636.png]]
==D bar is mean of differences of two data, Sd is likewise==
![[Pasted image 20260711185106.png]]
Two variance F-test : measure variance of two data, equal or not
![[Pasted image 20260711185351.png]]
![[Pasted image 20260711185329.png]]
For two tail test, the center of the distribution is 1
Two proportion Z-test : measure proportion of data
![[Pasted image 20260711185414.png]]
$\hat{P}$ is total P

![[Pasted image 20260713152459.png]]
==NOT IMPORTANT==

## CORREL(data1, data2) = r

## Simple linear regression
![[Pasted image 20260712103946.png]]
![[Pasted image 20260712104001.png]]
![[Pasted image 20260712104035.png]]
$Y_{0} \space and \space X_{0}$ are the exact point
![[Pasted image 20260712104324.png]]
Y hat i is the predicted Y. Real Y - predicted Y	
![[Pasted image 20260712104332.png]]

### Multivariable regression
X1 *  X2, X1^2, X2^2 Extra column
Input in data analysis, Y is y, x is all x, including extra column
Look at P value, select those that is under 0.05 (95% CI), significant enough
P value < alpha, reject H0

Two regression always intersects at the same point
$r = \sqrt{b_{yx} \times b_{xy}}$ 
Corrolation of two regression, of x based y, and of y based x
When r = 0 (no corrolation) the best predictor of one variable, by another, is its mean, because that is all we have

## Design experiment
Conjecture– the original hypothesis that motivates the experiment.
![[Pasted image 20260713232300.png]]
a, b , ab, (1) are total from here, this is for ==effect estimator for A B AB==
![[Pasted image 20260713232133.png]]
![[Pasted image 20260713232321.png]]
k = number of variables (A, B). n is number of tests (4) from green table above
![[Pasted image 20260713232606.png]]
==sigma^2 is average of variances of each variable test ==(4 test for 2 variables, (1), a b ab) (average(variance of each row))
( standard error (effect) )^ 2 = variance (effect)
residual degrees of freedom = degree of freedom
![[Pasted image 20260713232919.png]]
effect estimator comes from effect estimator that was found earlier, t ratio has formula, P value is a two tail of T, an area, only those under alpha is accepted, significant enough
![[Pasted image 20260713233213.png]]
Average here is average of every test, represent Y intercept
==y is thickness, that is why mean is like that, and we are trying to get a predictor equation==
Qualitative : discrete
Quantitative : continuous

1. Find effect estimator (there is a formula)
2. Find standard effect error (use variance, k number of trials, and n number of variables)
3. find t ratio ef/se
4. find P value (use T ratio and find two tail of it, degree of freedom can be found using formula)
5. identify significance value
6. find coefficient
7. prediction model with significance only, with Y intercept as ==mean of all==

### $2^k$ design experiment
contrast -> effect estimator -> standard error -> t-ratio -> P value -> significant model
![[Pasted image 20260714001551.png]]
for effect, the k-1 formula is affected for fractional design, since the no. of real variable is reduced
![[Pasted image 20260714013830.png]]
contrast is to combine the entire column above it.
Focus on the sum square, it is the determiner. 
Coefficient is effect/2.

### Statistical process control
S.D. of sample mean = stdev/sqrt(n)
3-sigma control limit
- UCL = mean + 3* s.d. of sample mean
- CL = mean
- LCL = mean - 3* s.d. of sample mean
- Actual value can exceed this limit
![[Pasted image 20260714022041.png]]

![[Pasted image 20260714022121.png]]
For graph creation purpose
![[Pasted image 20260714022527.png]]
![[Pasted image 20260714022941.png]]

![[Pasted image 20260714024258.png]]
![[Pasted image 20260714024631.png]]
customer's promise, specification
$z = \frac{value - mean}{\sigma}$ 
can it fit?
does it skew near border?
![[Pasted image 20260714083143.png]]
Probability that it goes out the border, turning normal var into z and use norm.s.dist

![[Pasted image 20260714025043.png]]
proportion-related
![[Pasted image 20260714025208.png]]
n is no. of sample per batch, 5 boards are inspected every hour
![[Pasted image 20260714025406.png]]