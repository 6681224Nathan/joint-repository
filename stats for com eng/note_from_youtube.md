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


 


- 1 sample Z-test
- 1 sample T-test
- Chi-squar
