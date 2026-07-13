
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



