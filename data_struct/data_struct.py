def min_rate(tasks, h):
    def can_finish(k):
        return sum((task + k - 1) // k for 
                   task in tasks) <= h

    low, high = 1, max(tasks)
    while low < high:
        mid = (low + high) // 2
        if can_finish(mid):
            high = mid
        else:
            low = mid + 1
    return low

#03 dynamic programming
def num_decodings(s):
    if not s or s[0] == '0': return 0
    n = len(s)
    dp = [1] + [0] * n
    dp[1] = 1

    for i in range(2, n+1):
        one = int(s[i-1])
        two = int(s[i-2:i])
        if 1 <= one <= 9:
            dp[i] += dp[i-1]
        if 10 <= two <= 26:
            dp[i] += dp[i-2]
    return dp[n]

#04 greedy
from functools import cmp_to_key

def compare(x, y):
    return (int(y + x) > int(x + y))
    - (int(y + x) < int(x + y))

def largest_number(nums):
    nums = list(map(str, nums))
    nums.sort(key=cmp_to_key(compare))
    return '0' if nums[0] == '0' else ''.join(nums)

#05 graph BFS
from collections import defaultdict, deque

def course_schedule(n, prerequisites):
    graph = defaultdict(list)
    indegree = [0] * n

    for c, p in prerequisites:
        graph[p].append(c)
        indegree[c] += 1

    queue = deque([i for i in range(n) if indegree[i] == 0])
    order = []

    while queue:
        node = queue.popleft()
        order.append(node)
        for neighbor in graph[node]:
            indegree[neighbor] -= 1
            if indegree[neighbor] == 0:
                queue.append(neighbor)

    return order if len(order) == n else []

#06 Prim's algo GRAPH manhattan distance
import heapq

def min_cost_connect_points(points):
    n = len(points)
    visited = set()
    min_heap = [(0, 0)]  # cost, index
    res = 0

    while len(visited) < n:
        cost, u = heapq.heappop(min_heap)
        if u in visited:
            continue
        visited.add(u)
        res += cost
        for v in range(n):
            if v not in visited:
                dist = abs(points[u][0] - points[v][0]) + 
                abs(points[u][1] - points[v][1])
                heapq.heappush(min_heap, (dist, v))
    return res


#1. Cookie run DP, house Robber Problem
def max_points(points, X):
    n = len(points)
    dp = [0] * (n + 1)
    
    for i in range(n - 1, -1, -1):
        skip = i + X + 1
        take = points[i] + (dp[skip] if skip < n else 0)
        dp[i] = max(dp[i + 1], take)
    
    return dp[0]

#2. 0/1 knap sack
def knapsack(weights, values, W):
    n = len(weights)
    dp = [[0]*(W+1) for _ in range(n+1)]
    
    for i in range(1, n+1):
        for w in range(W+1):
            if weights[i-1] <= w:
                dp[i][w] = max(dp[i-1][w], dp[i-1][w - 
                weights[i-1]] + values[i-1])
            else:
                dp[i][w] = dp[i-1][w]
    
    return dp[n][W]

#3. longest common subsequence
def lcs(a, b):
    n, m = len(a), len(b)
    dp = [[0]*(m+1) for _ in range(n+1)]

    for i in range(n):
        for j in range(m):
            if a[i] == b[j]:
                dp[i+1][j+1] = dp[i][j] + 1
            else:
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
    
    return dp[n][m]

#Huffman coding/compression algorithm
import heapq

def huffman(freq):
    heap = [[w, [char, ""]] for char, w in freq.items()]
    heapq.heapify(heap)
    
    while len(heap) > 1:
        lo = heapq.heappop(heap)
        hi = heapq.heappop(heap)
        for pair in lo[1:]: pair[1] = '0' + pair[1]
        for pair in hi[1:]: pair[1] = '1' + pair[1]
        heapq.heappush(heap, [lo[0] + hi[0]] + lo[1:] + hi[1:])
    
    return sorted(heapq.heappop(heap)[1:], key=lambda p: (len(p[-1]), p))

#Greedy stay ahead
def interval_scheduling(intervals):
    intervals.sort(key=lambda x: x[1])
    end_time = 0
    count = 0
    for start, end in intervals:
        if start >= end_time:
            count += 1
            end_time = end
    return count

#Fractional knap sack
class Item:
    def __init__(self, value, weight):
        self.value = value
        self.weight = weight

def fractional_knapsack(capacity, items):
    items.sort(key=lambda x: x.value / x.weight, reverse=True)
    total_value = 0.0
    for item in items:
        if capacity >= item.weight:
            total_value += item.value
            capacity -= item.weight
        else:
            total_value += item.value * (capacity / item.weight)
            break
    return total_value

#Cross the dark tunnel
def dark_tunnel(times):
    times.sort()
    total = 0
    while len(times) > 3:
        total += min(times[0] + 2*times[1] + times[-1],
                     2*times[0] + times[-2] + times[-1])
        times.pop()
        times.pop()
    if len(times) == 3:
        total += sum(times)
    elif len(times) == 2:
        total += times[1]
    elif len(times) == 1:
        total += times[0]
    return total

#Binary Search (classic)
def binary_search(arr, target):
    l, r = 0, len(arr)-1
    while l <= r:
        mid = (l + r) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            l = mid + 1
        else:
            r = mid - 1
    return -1

#Kadane's algorithm, maximum sum sub array
def max_subarray(arr):
    max_ending = max_so_far = arr[0]
    for x in arr[1:]:
        max_ending = max(x, max_ending + x)
        max_so_far = max(max_so_far, max_ending)
    return max_so_far

#Go hill problem
def can_finish_in_days(distances, max_day_dist, max_days):
    days = 1
    curr_dist = 0
    for d in distances:
        if d > max_day_dist:
            return False  # can't even make this leg
        if curr_dist + d <= max_day_dist:
            curr_dist += d
        else:
            days += 1
            curr_dist = d
            if days > max_days:
                return False
    return True

def min_max_distance_per_day(distances, max_days):
    low = max(distances)
    high = sum(distances)
    answer = high

    while low <= high:
        mid = (low + high) // 2
        if can_finish_in_days(distances, mid, max_days):
            answer = mid
            high = mid - 1
        else:
            low = mid + 1
    return answer

# =============================
# ✅ YOU CAN EDIT BELOW
# =============================

# Distance between camps (in km, miles, or any unit)
# There are n+1 camps → n distances between them
distances = [3, 8, 2, 6, 4]  # ← change this to your case

# Number of days allowed for the trip
max_days = 3  # ← change this to your case

# =============================
# ✅ RUN THE SOLUTION
# =============================
result = min_max_distance_per_day(distances, max_days)
print("Minimum distance/day required to finish in", max_days, "days is:", result)









