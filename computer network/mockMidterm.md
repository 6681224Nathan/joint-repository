## How can computer A sends packets to computer B via router R
Packet A sends ARP to the entire subnet to see who has target IP, the target computer responds with the MAC address, then Computer A sends packet to the replied MAC address, via router and switches

When switch encounters ARP, since it is IP blind, it floods the ARP request on every port, through the router as well, the ARP reaches the target device, then target device responds to the sender's MAC address of its MAC address, now the sender device knowns the target MAC address, then it sends the packet to that address.

ANSWER : Two computers are in different network, A sends packet to the default MAC address (subnet mask yields no result), so it sends packet with MAC address of a router, then router has a table of what IP address matches the MAC address of the destination, then it change packet's MAC address to match those of IP owner.

## Show Dijikstra algorithm to find the shortest path

A -> B
A-> B 5
A-> E 8

ANSWER : Dijikstra tries to create a shortest path tree, default node weight is inf, starting with A chooses the shortest path (A->B : 5), move to B, B -> A -> E is shorter than B -> E is cut, now moves to E -> C and E -> G, it calculates the entire path agian