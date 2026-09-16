### Machine learning
![[Pasted image 20260814153734.png|412]]
We have a set of data, and we want to predict the future by using several models. Method to test is we divide the data into two sets, training and testing sets.
![[Pasted image 20260814153825.png|380]]
Green one is the testing set.

### Linear regression
Linear regression is also a part of machine learning, but linear regression can only predict the future in straight line, there is an inability to predict the result accurately. That is called ==bias==
>Bias : inability to achieve accurate result of the machine learning. Notice : ==inability==
![[Pasted image 20260814153921.png|486]]

**linear regression has a large bias, because it cannot curve, deviation of predicted information from the true value is present**

### Bias measurement
Find the offset, square them, and add them all up. ==sum square== is for finding bias. But this is for ==training sets== only

Sometimes, testing with training set (sum square), and testing set yield different results.

### Variance
Amount by which prediction/machine learning itself would change if we fit the mode to a different training data set.
Simply, variance is how much model differs from ==testing data.==

### Overfit
==Squiggy line==, when a model can fit training set perfectly, but not testing set AT ALL. ==Train set yes, test set NO==

### Idealistic machine learning
Can achieve the true relationship, meaning low bias, and low variance. Keep consistent prediction across all dataset.

**sweet spot** between simple model (linear line) and complex model (too complex, squiggy line)

### Decision tree
A tree which has ==statement== and ==choices to choose== which will follow. 
![[Pasted image 20260815100443.png|468]]
### Classification tree
When decision tree ==classifies things into categories==, we call it classification tree.

### Regression tree
Like decision tree, it gives choices for a statement, but this time, it ==predicts numeric value==

### Typical/standard notation
- left is usually true (left child node) and right is false
- top most node is called ==root node==
- internal node, or ==branches==, are nodes in between, it comes from somewhere, and it grows to somewhere else. They have arrow pointing to them, and they have arrows pointing away from them. 
- ==leafs== are the bottom of the tree, they have arrows pointed at them, but no arrow away from them.
- root -> branches -> leaves (the end)

>The end... or the beginning??

### To build a tree
![[Pasted image 20260815112709.png|491]]
We can make a tree of a table.
But the question arises, "then what shall be the root node?"

We start from making micro tree, of every attributes and leaves first.
![[Pasted image 20260815113246.png|478]]
And in these micro trees, since each ==attribute has two states, true or false==, two states can lead to two different ways, and we note, like this, for the leaves, or the outcome of those two states. ==Yeah, I know it's weird, but that's just what it is==

![[Pasted image 20260815113641.png|418]]
These three states of two attributes here fail to give a ==definitive answers== for leaves, so they are called ==impure==.
![[Pasted image 20260815114452.png|405]]
But in Soda tree, False choice can gives a ==definitive answer== Cool as Ice, is no. So ==it is not impure== and it implies that ==Soda is a better determinator== of leaves rather than Popcorn, or the other one.

But **only implication is not enough** so to ==quantify impurity==
We will use

### Gini impurity
Measuring by ==leaf== (green box, you see) on micro tree.
Gini impurity for a leaf = **1 - (probability of yes)^2 - (probability of no)^2**
Probability = no. of our interested choice / total number of choices that fall down on that leave.
![[Pasted image 20260815115616.png|529]]
Gini impurity LEFT = 1 - (1/(1+3))^2 - (3/(1+3))^2 = 0.375 = ==1-sum square of chance==
Gini impurity RIGHT = 1 - (2/(2+1))^2 - (1/(2+1))^2 = 0.444

But because the ==number of people ==which fall down to ==each sides are not equal==, they cannot simply be represented by the found probability. We need a weight.
Since "Total Gini impurity = ==weighted== average of Gini impunities for the leaves"

**Total Gini impurity = (no. of people on left side / total no. of people on two side) * Gini impurity left + (no. of people on right side/ total no. of people on two sides) * Gini impurity right.** 
This ==total Gini impurity== = ==Gini impurity for that branch==

>things to note here that so far, we have calculated Gini impurity only for ==yes/no questions==

### Gini impurity for numerical data
![[Pasted image 20260819152552.png|524]]

1. We start by sorting the data first, from lowest value to highest

![[Pasted image 20260819152659.png|533]]

2. Calculate ==average weight== for values that are next to each other, ==calculate between values, for average value of those 2==

![[Pasted image 20260819153007.png|542]]

3. Calculate ==Gini impurity== for ==each average== value

To calculate for each, we put the value we want to find Gini impurity to be ==root== node

![[Pasted image 20260819153814.png|475]]

Like this, we put the value we want to find Gini impurity as the root, make the criteria to go ==lower as true==, and put information in that leaf. 
==and do that for right (false) leaf as well==
and calculate the **total Gini impurity** 

![[Pasted image 20260819155047.png|440]]
![[Pasted image 20260819155148.png|438]]
After that we pick the ==lowest Gini impurity== and use the ==associated average number== to be the ==root node== of that micro tree.

### Bigger picture

![[Pasted image 20260819155337.png|506]]
We now find the ==branch, or microtree which has the lowest Gini impurity== and then that one would be the ==root node== of the entire tree

![[Pasted image 20260819155754.png|514]]
After we get the root node, we then check with the lower branch to see, try other choices of node's leaf to find out which one has the lowest Gini impurity, the one with lowest Gini impurity will be chosen as branch of the root. This is called by myself as ==tree expansion.

**Tree expansion**
![[Pasted image 20260819160116.png]]
We expand the tree with other attributes when there is an impurity left for leaves, but if any leaf does not have any impurity left (like **right leaf of root node**) and there is no reason to expand the tree. **Expand the tree** : use other attribute to divide the data into groups to lower the impurity, i.e. ==use categorization to reduce noise or impurity==

### Finalizing the tree
![[Pasted image 20260819161249.png|519]]
Leaves that we have, which are impure free, will now be ==labeled== according to their ==majority of answers==.

![[Pasted image 20260819163154.png|502]]

![[Pasted image 20260819163310.png|505]]

The leaf you see above, it is impure-free, but the "No" has only one dataset to support it, which means that although impure-free, the leaf is quite not confident.. we can solve that by using
1. Pruning (to be continued)
2. Limit data set, we put a limit on the ==minimum number of total dataset for each leaf==, although it would ==cause impure leaf== but the impure leaf can still give output. **caution : the number to limit is unclear, which can be made clear using cross validation**
![[Pasted image 20260819163657.png|517]]

Leaf like above has 75% leans to Yes, love cool as ice, thus, that's the output

## ISLR
Inference : See what variables are essential/ significant enough, and what is not (kinda reminds me of stats class)
Prediction : predict the future data, from existing variable

f(x) is the prediction function of y using x, according to the (x,y) data that we have

Parametric : assume the form of f, it will make calculating easier, less parameters and less data sets
Non-parametric : lot messy process, requires larger data set, can be overfitting, but would fit more to the data as well since it does not assume the form of f, (imagine we try to predict parabola using linear, that would be damn awful isn't it?)

**Flexibility and restrictiveness**
- Inflexible : linear regression
- flexible : thin plate spline, imagine a curved plate, can adapt more to the data set

==For instance, when inference is the goal, the linear model may be a good choice since it will be quite easy to understand the relationship between Y and X1, X2, . . . , Xp==

