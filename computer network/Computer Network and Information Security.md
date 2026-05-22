Fresh start in Obsidian and MacBook Neo (performative male moment)

## Data communication
==Exchange== of data between two devices. Depends on these characteristics.
1. Delivery
2. Accuracy
3. Timeliness
4. Jitter

**Components of data communication**
Sender --- transmission medium -- == Message == -- Receiver
and Protocol

![[Pasted image 20260522101507.png]]

**Protocol**
Rules of communication to make two parties understand each other.

**Messages, comes in different format**
- Text (Unicode)
	- *Unicode is a universal representation of characters, including emojis and stuff, it is a table, turns weird characters into integers.*
	- *UTF-8 is a protocol, to to turn numbers into binaries so computer can understand*
- Numbers (represented in binary)
- Images (bit pattern, RGB or YCM)
- Audio
- Video (can be a continuous images or combinations of images)

## Data Flow
Types of communication between two devices are shown below.

![[Pasted image 20260522102214.png]]

Simplex : one way ONLY
Half-duplex : two ways, one at a time
Full-deplex, two ways, all the time, at the same time

## Networks
Interconnections of ==devices==
- Host : computers
- Connecting devices : Hubs, routers, switches

## Network Criteria
- **Performance** : transmission time, response time etc
- **Reliability** : frequent of failure, time to recover from failure
- **Security** : Protect against unauthorized access, protect from damage modification

## Connections
Links are connection path between two or more devices
- Point-to-point![[Pasted image 20260522103437.png]]
- Multipoint![[Pasted image 20260522103504.png]]

## Physical topology
How a network is laid out physically (in the sense of visual graph representation)
![[Pasted image 20260522103611.png]]

**Star typology** : Home LAN
![[Week01 Intro.pdf#page=27]]



**Bus topology** : Many stops until the end
![[Week01 Intro.pdf#page=28]]

**Ring topology** : Bus topology with connected end
![[Week01 Intro.pdf#page=29]]



## LAN (local area network)
Local area network, 
Before : bus topology
Now : star topology with switch as a middle man

## WAN (wide area network)
Geographically wider than LAN, spanning a town, state, country, even worldwide.
Point-to-point WAN, connecting two devices.
Switched WAN, network with more than two ends, backbone of modern day communication.
![[Week01 Intro.pdf#page=37]]

## Internetwork
or ==internet==, a connected WAN and LAN, standard as in modern day, isolated LAN and WAN are not common anymore
LAN connected to another LAN via WAN
![[Week01 Intro.pdf#page=39]]
![[Week01 Intro.pdf#page=40]]

## Accessing the internet
Allows anyone to join, user needs to connect to ISP, physical connection is done through WAN.
- **Telephone network** using modem, make use of existing infrastructure
- **Cable network** cable TV
- **Wireless network** Wireless WAN allows ease of access to the internet
- **Direct connect** Large corporation lease high speed WAN from carrier provider and connects itself to regional ISP.

> JARGONS EXPLAINED ==ISP== means ==internet service provider==


## Protocol
> JARGONS EXPLAINED Protocol defines the is a **pre-defined set of rules** that allows two entities to communicate and work together without confusion.

Layers of encryption using different methods of protocol. Encryption levels can vary

--- 
Time skip to routing
## Week 5 Routing protocol

## Unicast Routing
Hosts/devices send to default router, and routers keep forwarding information around, routers become a node
![[Week05 New-Routing.pdf#page=3]]

The network can be mapped into a graph with routers = nodes and links = edges, each have weights. 

## Routing algorithm family
Distance vector : 
Link-state : 

## Distance-vector (DV) Intuition
Start with cost to **immediate** neighbors; unknown cost (not immediate neighbor for example) cost = infinity


![[Week05 New-Routing.pdf#page=6]]
![[Week05 New-Routing.pdf#page=7]]

From that, a tree which of a specific node to every node can be mapped, with costs calculated.

## Bellman-ford at the Core (DV)
cost(x->y)p = min over neighbors

## Link-state (LS ) essentials
- mreasure each adjacment link cost
- Lower cost 

## Link-state database
The information of graphs can be stored in a table format, with the information of link weight.

## least cost tree
Run Dijkstra algorithm until you get the least cost tree

## Path-Vector Routing (concept)
- Core ideas : routers advertise paths, not just distances,
- Loop prevention : if an update's path already contains me, discard
- Policy-friendly : decisions can use business/administrative policy (prefer/avoid certain paths)
- Contrast: 
	- **Distance-vector : sends costs only**
	- **Link-state : floods full topology**
	- **Path-vector : send the path; avoid loops by inspection**

## Internet-scale routing overview
- hierarchical routing; different protocols by scope
Map concepts to practice : 
- RIP (DV)
- OSPF (LS)
- BGP (path-vector)

## Internet structure & autonomous systems (AS)
===ISP is an autonomous system=== in terms of managing networks and routers under its control.
Each AS is given an autonomous number (ASN) by the ICANN


## internet structure
![[Week05 New-Routing.pdf#page=23]]

## RIP - Distance-vector in practice
- Intra-domain protocol; metric often hop count
- Advertises reachability to networks/subnets; simple, wildly supported
===Hop from routers, imagine routers connected in a network behavior, each router uses path-finding algorithm to "hop" from starting point to the destinatation router, to get to a bigger network THE SMALL NETWORK IS CALLED PROVIDER NETWORK===

## OSPF link-state in practice
- Open standard, rich links 

## Why BGP? 
- Only inter-domain routing protocol on today's internet
- Path-vector : advertise reachability + AS-PATH; policy driven selection

## eBGP and iBGP

## BGP stability

This is the end of **unicast routing**
## IMPORTANT : VECTOR ROUTING VS LINK
NotebookLM is a must now, I don't understand any concept right now, this one is just hard...

---

## Multicast routing
In a highly concurrent system, unicast cannot handle all that heavy traffic, so multicast is introduced.

one source : many destinations
source address = unicast address

![[Week05 New-Routing.pdf#page=40]]




## Why multicast?

## Multicast delivery tree
- Build distribution trees toward receivers (group members)
- Avoid duplicate per-destination copies over the same link

## Review - Algorithms -> protocols -> scale
- DV vs LS : trade-offs in state and convergence
- RIP/OSPF for inside an AS; BGP across AS boundaries
- Multicast for efficient 1 : many delivery

**END OF ROUTING PROTOCOL, END OF MIDTERM**
Thursday, 10 - 12, week one until **this**, one page cheat sheet.F

---


