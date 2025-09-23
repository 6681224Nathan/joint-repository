A = [0,0,2,5,3,1,10,5,6,2,0]

def f(n):
    if n == 0:
        return 0
    elif n == 1:
        return 0
    elif n == 2:
        return A[2]
    
    dp = [0] * (n + 1)
    dp[0] = 0
    dp[1] = 0
    dp[2] = A[2]
    
    for i in range(3, n+1):
        dp[i] = max(dp[i-1], dp[i-3] + A[i])
    
    return dp[n]

print(f(10))

def f_recursive(n):
    if n == 0 or n == 1:
        return 0
    elif n==2:
        return A[2]
    else:
        return max( f_recursive(n-1), f_recursive(n-3)+A[n] )

print(f_recursive(10))