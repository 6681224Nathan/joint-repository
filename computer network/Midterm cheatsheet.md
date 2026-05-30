Data flow
Simple (one way)
Half-duplex (bidirection, one at a time)
Full-duplex (two way at a time)
Network Criteria : performance (time), reliability (failure)
Point to point direct, multipoint bus
Physical topology, mesh, star (home lan, hub), bus (many stops until end), Ring topology (bus connected end)
LAN, WAN (countries, state, international)
Internetwork : connected router
Network 4 problems, connectivity, addressing, forwarding, reliability
Protocol layering,
![[Pasted image 20260527092754.png|399]]
 OSI : Application : session, presentation, application

## Midterm questions (and answers, if the question is hard enough)
1). A signal with 200 mW power passes through 10 devices, each with an average noise pf 2 microwatts, What is SNR?

2). A signal travels from point A to point B. At point A, the signal power is 100w, At point B, power is 90w, What is attenuation in decibel.

3). The attenuation of a signal is -10dB, What is the final signal power if it was originally 5w.

**from assignment, tryhackme, ARP request, TCP/IP request**
1. 3 computers connected in subnetwork, same thing for second subnet, and two subnet ocnnected by router, subnet stays connected using switch
		- Switch broadcast ARP, every device get, target computer replies
2. Different subnet, known MAC and
	1. Target computer never replies

**Distance vector**
1. Same technique from Dijikstra algorithm, a graph traversal, explain how it works

**IP calculation**
126.0.0.0
Needed usable host : 6

Address class : A
/8
Borrowed 3 bits, 2^3 = 8 - 2 = 6
32/3. 29
custom subnet mask /29
29-8 = 21
2^21 = 2 million

number of bits borrowed = 3

2nd subnet range = 126.0.0.0 - 126.0.0.7 , 126.0.0.8-15
.16 - .23
.24 - .31
.32 - .39








