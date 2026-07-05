### Z-score
- one value compared to a sample

### Z-statistics
- one sample compared to the population

### Z-statistics
- Has ==population standard deviation==
- But we need all population value to find standard deviation, which is not plausible so

### T-statistics
- Has ==sample standard deviation==, does not have population standard deviation
- Has some room for error, the more data you have, the closer the distribution is to the real authentic distribution

### Confidence interval
- 95% confidence interval means if we repeatedly find the interval of mean (range of possible mean), 95% of it would include true mean (range which true means falls into)
- Either the true mean is inside the interval or outside
- we are 95% confidence that true mean falls within the range of the interval

### Hypothesis testing
1) Make assumption about population
2) Use sample to test assumption

	1) Create hypothesis
		- $H_{0}$ = Null hypothesis, what we assume about the population ==opposite of alternative hypothesis, null hypothesis is a boring assumption, that nothing happens==
		- $H_{a}$ = Alternative hypothesis, what we test about the population ==alternative hypothesis is an assumption that there is a change, that we expect, that something is **happening**==
		- Ex. The mean income in the US is 7000 USD, we want to test whether the actual mean is lower than that
			- $H_{0}$ : $\mu$ >= $70k ==our NOT hypothesis==
			- $H_{a}$ : $\mu$ < $70k ==our hypothesis==
	2) Check conditions
	3) Calculate 
		1) Test statistic = $T_{0}$ standardized value r Z Xbar or  Pcone ChiSqr
			- Test statistics is like a ==standardize value== for the ==sample==
		2) P value
			- P value, in a world of null hypothesis (boring hypothesis) p value is the percent chance of sample coming from such boring population pool. 
				- If P value is too low, then it is impossible, meaning that sample has to come from a world of alternative hypothesis
				- If P value is high enough, then it is possible that sample comes from null hypothesis world, we fail to reject null hypothesis
			- The shading works by ==following the direction of alternative hypothesis==, since we try to find the chance of sample and even more extreme value occurring in the null hypothesis world ==we tries to find the chance of sample and extreme sample occurring in null hypothesis world==
	4) Compare
		- Alpha tolerance baseline for P value to be high or low : to conclude whether P value can be considered high or low, we judge by how it is compared to alpha
			- P value > alpha : this means the ==sample is possible that it comes from null== hypothesis world, we **==fail to reject==** null hypothesis
			- P value < alpha : this means the ==sample is impossible to come from null hypothesis world==, we **==reject==**.
		- Two criterias of rejection
			- Alpha value (area of rejection) and P value
			- Critical value (boundary of rejection) and test statistics
				- Critical value is when the area of rejection is turned into a boundary like ==test statistic, like a position in distribution graph==
				- When ==| test statistics | > | critical value | **reject**==
				- When ==p-value < alpha== sample is ==impossible to come from null hypothesis world==, so we ==**reject** null hypothesis==
					- "If P is too low, reject H-O"
	5) Conclude
		- "because of our P value  __ is less than alpha value of __ we have a sufficient evidence to ==reject== null hypothesis and to support the claim that __ "
		- "because of our P value __ is greater than the alpha value, we don't have sufficient evidence to support the claim that __ thus we fail to reject null hypothesis" 

> - alpha value as shaded region represents rejection region, if P value falls within this range then we have to reject null hypothesis as well. ==visualization== 
> - test statistic, if it also ends up in the rejection region, then we have to reject it

Your favorite candy company claims that their chocolate bars have a mean weight of 200 grams, and their population standard deviation is 5 grams. You've noticed that they've seemed lighter than usual, You take a simple randok sample of 35 candy bars and find they have a mean weight of 198 grams, at $\alpha$ 0.05 test the company's claim.

### Confidence interval
Confidence interval with (1-alpha)% confidence value means the true population mean (from the sample mean) cannot exceed this range

### Confidence bound
Confidence bound is like the lowest possible acceptable limti and the highest (upper bound) for the true population mean to possibly be, with (1-alpha)% confidence level of course. 

> Confidence bound is like one side, most or least, confidence interval is two sides

### Right tail Z (alpha/2) value and T (alpha/2) value for confidence interval calculation
Because right side and left side of the Z and T distribution is identical, it's only the matter of symbol difference, but the ==formula is designed for positive Z and T value, so right tail==

> n>=30 can use Z test, does not need t test anymore, the sample is large enough to be a population

![[Pasted image 20260702222625.png]]

### Confidence bound and confidence interval
Confidence bound is upper/lower bound. Confidence interval will just be upper bound or lower bound.

### T test
In case the standard deviation of population is not known and n does not reach 30 yet, then t test is needed. It uses the same CI and CB as Z test, exactly the same, just different test and excel formula.

### Chi square
Chi square is non negative
it is for ==variance and stdev.s hypothesis testing==
The curve bends left, starts from 0 to infinity (that is its domain).
- Stdev and variance cannot be negative, there are only 0, or no variation, or inf as machine degrades, the quality control is worse, and outcomes start to deviate from each other as a sign of failure.
- ==center is degree of freedom==

**Hypothesis testing for chi square**
Is mostly the same, just that in order to find P value, because Chi square graph is not symmetrical, so basically we have to determine whether test statistics lands on the left side or right side of the graph, and calculate the area to the extreme, then multiply it by two.
![[Pasted image 20260703103059.png]]

### Hypothesis testing, P value
- Right tail, P value means the chance of sample mean and more extreme value (higher) coming from null hypothesis world
- Left tail, P value means the chance of sample mean and more extreme value (lower) coming from null hypothesis world
- Two tail, P value means the chance of sample mean and more extreme value (==not equal to center mean==) coming from null hypothesis world

### confidence bound
In confidence bound, if there is a notation of single chi square, Z and T, it means that ==they are critical value, but positive, but no more mirroring technique, because of chi square, or either left tail or right tail, depends on formula==

## Yes or no like Poisson, proportion, norm.s
- When dealing with yes/no statistics, proportion is brought to play, from category data (mean) to proportion statistics
- **proportion statistic or p-hat** = incident we are interested in (sample) / total incident of sample







 


- 1 sample Z-test
- 1 sample T-test
- Chi-squar
