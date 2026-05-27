

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
> JARGONS EXPLAINED ===Protocol=== defines the is a ===**pre-defined set of rules** ===that allows two entities to ===communicate=== and work together without confusion.

Layers of encryption have different protocols.
![[Week01 Intro.pdf#page=53]]

## 1. What is the "Job" of Networking?

The job of networking is to move a piece of information from a brain in one location to a brain in another location—**reliably, quickly, and securely.**

To do that, the network has to solve four big problems:

1. ===**Connectivity:**=== Is there a physical path (wire or wave) between us?
2. ===**Addressing:**=== How do I find you among 8 billion people? (This is where **IP/CIDR** comes in).
3. ===**Forwarding:**=== How do I get the message through all the "intersections" (routers) along the way?
4. ===**Reliability:**=== How do I know the message didn't get "smashed" or lost during the trip?

## 2. What is Protocol Layering? (The "Pizza Delivery" Redux)

Think of ===**Protocol Layering**=== as a way to ===divide=== a huge, impossible ===task=== into tiny, easy jobs. Each "Layer" is a specialist that only knows how to do **one thing**.

Imagine you are ordering a pizza. You don't want to worry about how the delivery car's engine works, and the delivery driver doesn't want to worry about how much pepperoni you ordered.

### The "Slices" of the Network

When you send data, it goes through these layers like a **Matryoshka doll** (Russian nesting dolls):

| Layer           | The Specialist   | The "Job"                                                                        |
| --------------- | ---------------- | -------------------------------------------------------------------------------- |
| **Application** | The "Writer"     | You type an email. This layer just cares about the text/message.                 |
| **Transport**   | The "Supervisor" | Chops the message into pieces and gives them numbers (1 of 5, 2 of 5).           |
| **Network**     | The "Navigator"  | Puts the pieces in envelopes and writes the **IP Addresses** on them.            |
| **Data Link**   | The "Driver"     | Moves the envelope from one specific point to the next (e.g., Laptop to Router). |
| **Physical**    | The "Road"       | Converts everything into electrical pulses or light flashes on a wire.           |
## ==Protocol layering is Taylorism of digital communication==
## Protocol layering principle
1. Each layer perform two opposite task in each direction (Encrypt, decrypt, for example)
2. Two objects under each layer should be identical

## TCP/IP Protocol suite
Transmission control protocol / internet protocol
![[Week01 Intro.pdf#page=60]]

## Brief introduction of each layer

## Physical layer : the road
The layer that concerns only the transportation of information, sending bits and bytes, electrical signal, how can information goes through wires. ==Logical communication== (I don't even know what it means)
- Related devices : Cables, hubs and repeaters
==convert anything into electrical signal==

## Data link layer : Delivery truck
Between devices, within LAN. 
Data link speaks in ==MAC address==, but it helps with across LAN transportation as well, with the help of network layer, which will provide MAC address of destination to this layer, which it will transport to there. ==DATA LINK LAYER IS IP BLIND, ONLY MAC ADDRESS.==

## Network layer : the navigator
Host-to-host transportation, from sender computer to receiver computer. It is responsible for finding and selecting the best route ==between routers==.

## Transportation layer
## Application layer
==TO BE CONTINUED==

## OSI Model
TCP/IP protocol suite is the main one but not only one, ISO (international organization for standardization) stated that the protocol suite which covers everything is OSI model.
![[Week01 Intro.pdf#page=75]]![[Week01 Intro.pdf#page=76]]
## Lack of OSI model success
OSI comes later, although expected to fly high, becomes a flop

--------
## Chapter 2
**Physical layer**

## Signals
What is ==exchanged== between two devices is ==data==, but what really goes through the ==wire== is ==signal==.

## Analog signal
Analog signal is continuous, whilst digital signal is discrete.
![[Week02 Physical.pdf#page=5 ]]

**Analog signal** often uses periodic signal, a ==sine wave==,which cannot be decomposed into simpler signals.

**Peak Amplitude**, ==absolute value== of its highest intensity.

**Period and Frequency**, period means time taken to complete one cycle, frequency is number of cycle in one second. Second and Hz. $f= \frac{1}{T}$ 

**Phase** position of waveform relative to time 0. related to shift.

**Wavelength**, distance a simple signal can ==travel in one period==. $wavelength = \frac{speed}{f} = speed \times T$ 

**SIne wave is comprehensively defined by its amplitude, frequency, and phase** in both time and frequency domain.
![[Week02 Physical.pdf#page=15]]

**Composite signal** is a signal made of many simple sine waves.

## Bandwidth
 ==A range of frequencies== contained in a composite signal is **bandwidth**. Bandwidth is the ==**difference between the lowest and highest frequencies**== in the signal.

## BANDWIDTH IS ALL ABOUT FREQUENCIES

**Digital signal**, rigid form of signal, can be more than two levels (0 and 1)
![[Week02 Physical.pdf#page=19]]

> JARGONS EXPLAINED **periodic** means signal which has ==pattern==, nonperiodic means signal that doesn't have pattern
## Bit rate (digital)
Most digital signal is nonpreriodic, thus period and frequency are not appropriate characteristics to describe such signal. ==Bit rate== is then meant to ==describe nonperiodic signal==.

## Example 2.3 ==FOR CHEATSHEET==
Assume we have downloaded text documentation at the rate of 100 pages per minute. ==have to be per second== A page is an average of 24 lines with 80 characters per line. If we assume that one character requires 8 bits, the bit rate is: ==**Bit rate is a rate of bit transfer**==
$$ 100 \times 24 \times 80 \times 8 = 1,536,000 = 1.536\space Mbs $$
## Bit length (digital)
==Similar to wavelength== for analog. Bit length is the distance one bit occupy on the transmission medium.
$$ bit\space length = \frac{1}{bit\space rate} $$
## Digital signal
Is a ==**composite analog signal**== with $0 < frequency < \infty$
- baseband transmission : ==send digital== signal without changing it to analog
- broadband : ==change to analog== signal then send

## Signal impairment
Signal sent is ==corrupted== during the way due to factors :
- **attenuation** a loss of energy, when signal travels through the medium, medium's resistance causes a loss of energy, to compensate, **amplification** is needed.
- **Distortion**
- **Noise**

## Attenuation (loss of power) formula
$$ 10\log_{10}(\frac{P_{2}\space (power \space received)}{P_{1}\space (power\space sent)}) = \space negative\space number \space dB$$

## Distortion
Signal changes its form or shape, distortion can occur in a composite signal made up of different frequencies.

## Noise
Noise is disturbance signal, it corrupts the signal as well.

## ==SNR (Signal-to-Noise Ratio)==

**SNR**$= \frac{average\space signal\space power}{average\space noise\space power}$

## Data rate limits
How fast we can send data, in bits per second. Data rate depends on:
- Bandwidth availalble
- Level of signals used
- Quality of the channel (level of noise)
Two formulas were developed to ==calculate data rate==, Nyquist for a noiseless channel, and Shannon for a noise channel.

## Noiseless channel data rate limit, Nyquist bit rate, theoratical bit rate
$$ Bit\space rate = 2 \times Bandwidth \times log_{2}(Signal\space level)$$
## Noisy channel data rate limit, Shannon capacity
$$ bit\space rate\space capacity=Bandwidth\times log_{2}(1+SNR)$$

![[Week02 Physical.pdf#page=38]]
The reason to lower the bit rate at second part is engineering safety and to round down the log issue, to lowball the number can make it safer to run the system instead of running it at theoratical breaking point.

## SNRdB
$$ SNRdB = 10\times log_{10}(SNR) $$
## Performance
So far we have discussed the tools of data transmission, now its time to measure performance. One characteristic to measure is **bandwidth**.

**Bandwidth** of a fast Ethernet network is 100 Mbps, it means 100 Mbps can be sent through this network.

## Throughput
Measurement of how fast the data can actually be sent through a network.

## Latency (delay)
==Time taken to finish delivery== of the data, from first bit to last bit, from source to destination. 
- Propagation delay
- Tranmission delay
- Queueing delay
- Processing delay
$$ Latency = \Sigma\space delays $$
## Bandwidth-delay product
Since bandwidth and delay are important metrics of network performance. ==Product of bandwidth and delay== is also important.

## Pipe
Link is pipe, volume of the pipe defines bandwidth-delay product.
![[Week02 Physical.pdf#page=47]]

## Jitter
Information is delivered in many packets, and when ==delays for each packet varies==, it creates inconsistent at the receiver device, the real-time application that uses the packets endures jitter.

## Digital-to-digital conversion
Representing digital data using digital signals. Techniques : 
- Line coding (needed)
- Block coding (may or may not be needed)
- Scrambling (may or may not)

## Line coding NEED TO RESEARCH MORE
Digital data --> digital signals. Assuming digital data is stored in a form of bits.

## Block coding NEED TO RESEARCH MORE
We need redundancy to ensure synchronization and to provide additional information for error detecting. Block coding works this way by changing block of m bits into n bits, while n > m in size. **mB/nB encoding technique** ==small bit block ---> large bit block==

## Analog-to-digital conversion
Analog signal like signal created by microphone or camera needs to be transmitted. Sometimes, analog is changed to digital signal because it has less noise. Techniques : 
- Pulse-code modulation
- Delta modulation
## Pulse-code modulation ANA->DIGI
Usually 8 to 16 bits per sample.
![[Week02 Physical.pdf#page=56]]

![[Week02 Physical.pdf#page=57]]

## Nyquist-Shannon sampling theorem
**==ANA -> DIGI==**
By converting analog signal to digital, the frequency have to be **==twice the original==** one to recreate the perfect signal. This is due to "taking picture of wave" over and over again to perfectly recreate the wave.
**==Hz itself is also a per-second unit already==** 1 cycle per second

## Delta modulation ANA->DIGI
PCM is a complex technique, a simpler one is delta modulation. PCM finds the value of the signal amplitude for each sample, **Delta finds the change from previous sample.**
![[Week02 Physical.pdf#page=59]]
**It detects whether the signal goes up or down, if up, then 1, if down, 0** Always 1 bit (0 or 1)

## Analog transmission
Low-pass channel allows signal that ==starts with 0== to pass, ==bandpass== channel ==doesn't==, so if we want to use bandpass, digital signal needs to be converted ot analog. **DIGI->ANA**

## Amplitude shift keying (ASK) DIGI->ANA
Phase and frequency stays the same, if 1 means max amplitude, if 0 means low to none amplitude.

## Frequency shift keying
Amplitudes and phase tays the same, but the frequency changes based on the digital signal, 1 means higher frequency, 0 means lower frequency.

## Phase shift keying
Amplitude and frequency stays the same, phase varies based on the digital signal, 1 means higher phase, 0 means lower phase

> **ASK:** Changes the **Amplitude** (height).
   **FSK:** Changes the **Frequency** (wiggles per second).
   **PSK:** Changes the **Phase** (the point in the cycle where the wave starts). 

## Analog to analog conversion
Change of analog information into analog signal. The conversion (modulation) is needed when medium is bandpass, cuz sometimes, analog signal also starts at 0 Hz too.

## Amplitude modulation (AM)
Amplitude of the carrier signal changes to follow the changes in modulating signal.
**Carrier amplitude now match modulating sig's change**
![[Week02 Physical.pdf#page=70]]
==Look at the left side figure==

## Frequency modulation
Frequency changes to follow the change in modulating signal. ==carrier frequency change to match modulating's sig change==
![[Week02 Physical.pdf#page=72]]
==Look at the left side figure==

## Phase modulation
Phase of carrier signal changes to follow the changes in the modulating signal.  **Carrier signal phase change to match modulating signal change**
![[Week02 Physical.pdf#page=72]]

> **Amplitude modulation** : change carrier's amplitude
> **Frequency modulation** : change carrier's frequency
> **Phase modulation** : change carrier's phase

## Multiplexing
Links irl comes with ==limited bandwidth==, we need to ==combine several low-bandwidth== channels to make use of ==one large bandwidth channel. ==Sometimes we need to expand the bandwidth of a channel to achieve goals such as privacy and anti-jamming.
![[Week02 Physical.pdf#page=76]]

## Frequency division multiplexing
Analog technique. When bandwidth of a link is greater than the signal ==(wasted bandwidth, so we divide to share)==
![[Week02 Physical.pdf#page=78]]

## Time-division multiplexing
Digital technique. Allows ==several connections== to share link with high bandwidth. ==One connection at a time, like concurrent process.==
![[Week02 Physical.pdf#page=80]]

## Transmission media
Below physical layer, and is directly controlled by physical layer. 
==Electromagnetic, light, electrical==
![[Week02 Physical.pdf#page=82]]
**Don't care much about it**
![[Week02 Physical.pdf#page=83]]

## Guided media
Those that provide conduit from one device to another, **basically a wire**

## Twisted pair cable
Two cable (two conductors) twisted together
Twisted cable let two cables share the same amount of radiation, preventing data from one side from being too corrupted
![[Week02 Physical.pdf#page=86]]

## Coaxial cable
Carries signal of higher frequency ranges more than those in twisted-pair cable
![[Week02 Physical.pdf#page=91]]

## Fiber optic cable
Made of glass or plastic, which transmits signal in a form of light, bouncing around within the tube.
- Plastic (short haul)
- Glass
- Fused silica (best)
Lower attenuation electromagnetic isolation, use LEF and ILD
Light propagates from one end to another in one of the following ways
- mono mode (straight line)
	- The source is laser
	- Most expensive
- Multimode stepped index
	- Source is LED
	- Bounces of cladding
- Multimode graded index
	- Cladding refractive index increase as it moves away from the core

## Unguided media : wireless
Broadcast to anyone who has device to receive.
![[Week02 Physical.pdf#page=101]]

## Radio waves
Electromagnetic waves in frequency 3kHz and 1 GHz are often called radio waves. **Omnidirectional**

## Microwaves
1 and 300 GHz freq waves are microwaves. **Unidirectional** The wave can be sent in a straight way to other antenna, lowering the chance of it disturbs others, and others disturb it.

## Infared
300 GHz to 400 THz, can be used for short-range communication, cannot penetrate walls, this also lowers the chance of the wave being disturbed, since it is a **short-range wave**.

---
## Data link, it's going to be tough

## Collision
- Simultaneous transmissions on a shared medium -> corrupted frame
- common with hubs/**half-duplex** Ethernet (legacy)
## Collision domain
Area where one device's transmission can collide with another
- Hub/repeater : ==entire hub== = 1 collision domain
- Switch (full-duplex) ==each port== = separate collision domain --> collisions effectively eliminated
## Collision 02
- Modern ethernet switches ==isolate every link and run full-duplex== , there is no longer "shared wire where frames can crash into each other
- **Each port is its own collision domain ("micro-segmentation")**
- A hub repeated bits to all ports, **hubs broadcasted to all ports**, everyone shares one medium ==**collision with port is possible**==
- For switch, frames enter switch not the other ports, this isolation prevents inter-host collisions

> hub is a broadcaster, one shared medium, collision can happen 
> switch **isolate** links, no collision can happen

- **Full duplex** links remove collision condition, TX (transmits) and RX (receive) use separate fibers, device can **receive and send** simultaneously without interfering
	- Because collision is not possible, **CSMA/CD** is disabled and unnecessary

> CSMA/CD is protocol for when hub is still a thing, computers
> 1. Listen if medium is available
> 2. Send data if medium is available
> 3. Detect collision, if it does, signal is broadcasted to halt sending operations
> 4. Every device back off for a random period of time before joining agian

## Switch
- **MAC learning + unicast forwarding** The switch learns (MAC-> ingress port (physical port data enters switch)) MACs from sources (and create MAC address table)
- When data arrives, switch looks up destination MAC address and forward data only to the matching port
- Separate links here stop collision

- **Flooding** : ==unknown MAC address== is sent to switch, switch doesn't know so it ==broadcasts to everyone in LAN==, the target device responds, and switch put MAC address in the MAC address table

- **Escape subnet** In case of IP, **host** checks whether IP is in LAN or not (same **subnet** or not), if not, then it attaches IP to the packet and ==MAC address of router,== it sends to switch, switch forwards it to router, and router forwards to a broader network

- **Store-and-forward** Switch ==waits until entire frame arrives==  inside its memory, check for any corrupted or flipped bits using **CRC (Cyclic Redundancy)** test (mathematical test) 

- **Cut-through** This is when there is ==no CRC==, switch forward data to MAC addr. of destination, this is fast ==(lower latency)== but can cause data that is sent to be garbage (corrupted data)

- **Buffering** Switch has a waiting room for data from two devices with the same destination, it handles **data concurrency** by ==**one-at-a-time** logic==

- **Flow control**, when ==buffer is full== IEEE 802.3x PAUSE solves, when switch port's buffer is about to full, switch gives out ==pause signal==

- **Parallel processing** : many ==ports== in switch can ==talk== with its own designated pair ==concurrently==
- **Non-blocking** switch's brain is fast enough to process paralelism communication without blocking
- **Occasion collisions in new system**
	- Half-duplex relics that still use CSMA/CD
	- Duplex-mismatch : one device uses full-duplex, another use half-duplex, communication is interrupted
	
- **Wifi, the old relics that still live**, for wifi, everyone is using the same frequency, it's like a room where everyone is shouting, **CSMA/CA** is introduced, they use **avoidance** since for wifi, it is not easy to detect collision, so ==it sends RTS (request to send) and wait for CTS (clear to send)== basically it asks for ==permission to speak== signal before it starts talking, for a ==large data and busy network== refer to CSMA/CA down below

## Segmentation
Put up walls in crowded room so that people can talk without crossing each other
- Collision domain : every port on a switch has its own ==private pair of links, switch fabric==
	- collision is trapped in a single port, so when it happens, others will be fine
- Broadcast domain : broadcast
	- By default ,switch broadcast goes to every port
	- Solution ==VLAN : ports are grouped together==
- Outcome of switches and VLANs
	- less junk traffic, security (because of isolation), stability (failure containment)

## Evolution of politeness
## ALOHA, wildwest
Everyone talks whenever they want, if messages collide, then wait for some time then try again

## CSMA/ CSMA/CD, Polite listener
- **CSMA** Listen before talk, ==listen ==to the wire first, ==if its quiet, then you start talk==
- **CSMA/CD** Listens while you talk, if message collides, you stop immediately, send jam signal to halt to everyone, and back off for random moment then try again. ==Talk, bump, stop, wait for random, try again==
- Too old, ==dead==, because switch solves these problems already

## CSMA/CA Careful planner, wifi
- ==**WIFI IS A SHARED MEDIUM**==
- Wifi cannot detect collision mid talking, so traditional CSMA never works here
	- Listen
	- if it's clear, wait for some more to be sure, if it's not, pause count down
	- *RTS and CTS supposed to be here, request to send and answer to clear to send or not*
	- send your data
	- Wait for ACK (acknowedgement) from receiver, if none comes, then there is a collision, then you try again
- RTS, and CTS are used for ==large files and noisy links ==(busy network) and used between sender and receiver
- Neighbors set NAV (virtual carrier sense) and stay silent to avoid collision ==network is reserved==
- Hidden node : A and B can't hear each other but can ==hear someone else's collision==

## Exposed node & spatial issue
- Exposed node : hear someone else's frame and stays silent unnecessarily
- Modern wifi adds spatial reuse / BSS coloring
	- mark frames by BSS color, far-away BSS can transmit concurrently
- "Not every transmission you hear will actually interfere, coloring help you reuse the air"

## MU-MIMO & OFDMA
- Multiple input, user, output : access point uses ==multiple antennas to signal in different direction ==(spatial streams) athe the same time, things become more simultaneous
- OFDMA Orthogonal frequency division multiple access : instead of one data taking all lane for short period, it packs multiple data for multiple address and send at the same time, from ==empty truck to full truck that stops many times==

## MAC address
Address of a specific device
- Unicast : one to one, specific delivery
- Multicast : 1 to many
- Broadcast : one to all (FF:FF...), every device in LAN must process this

## Ethernet frame
When data travels in Lan, it's wraped in ethernet frame
- Destination MAC
- Source MAC
- EtherType what is inside the payload (usually IPv4 or IPv6)
- MTU (Maximum tranmission unit)

## ARP
address resolution protocol
"I know the IP I want to talk to but what is their MAC address?"
- ==Broadcast to asks== for who has the IP and tells the person to respond to MAC of self
- ==Reply (unicast)== the target computer introduces itself with its ==MAC address==
- Save to ARP table, so this process needs not to repeat

## Security and special cases
- Gratuitous ARP : broadcasting IP without being asked, used to detec IP conflict
- Spoofing : ==hacker disguises== as router and broadcast to everyone as router, and they gets all the data, this is ==ARP poisoning==
- Dynamic ARP insepction (DAI) to verify whether the person claimed to have IP is allowed to have it or not
## Modern reality
Wires (Ethernet) uses switches
Air (wifi still use CSMA\CA

Will not note until IP

**Hubs** : also works as a repeater, 

![[Pasted image 20260526233856.png]]


## Network layer
## Packetizing
- Network layer is responsible for ==carrying packet from source to destination== without using or changing it. 
- "Encapsulating the payload in network-layer packet at the source and decapsulate at the destination" wrap it up, and send it

## Routing
Router learns the entire network mapping, and find the shortest path from source to destination.

## Forwarding
Take the packet from input port, to a correct output port.

## Error control
Error control is not managed in this layer (network layer)

## Flow control
The amount of data a source can send without ovewhelming the receiver. To control the flow of dta, the receiver needs to send some signal to the sender to notify of the data overload.

## Congestion control
Too many datagrams are concentrated in a area of an internet, can happen when the number of datagrams sent by source computer is beyond the capacity of the networ or routers.

>Datagram is a self-contained unit of data sent over the internet, the idea is that it is thrown in the internet, with source and destination IP address enough for routing through network, and meta data and payload, with no previous handshake of source and destination required **connectionless**
> an ==internet postcard==


##  Datagram approach
Each packet is treated independently, the network layer is supposed to only be responsible for transportation from src to des. Different packets of a message can take different paths.

## Virtual circuit approach
in this approach, a virtual circuit is made before hand, and packets of the same message must follow the trail which the virtual circuit has laid out.

## Delay
- Transmission delay : the delay it takes for bit by bits to be put individually in a packet
	- Delay tr = packet length / transmission rate
- Propagation delay : time it takes for a bit to travel from point A to point B, travel delay
	- Delay = distance / propagation speed
- Processing delay : delay from file procession at the output

## Throughout
The number of bits passing through the point in a second.
As datagram traverse through different segment of the internet, transmission rate can vary but the throughout of entire can still be found

## Packet loss
Buffer full, so next packet that cannot get into buffer is dropped, which has to be sent again, which can worsens the overflowing.

## IPv4
the identifier used in the IP layer of TCP/IP protocol suite to identify the connection of each device to the internet is called internet address or IP address.
IPv4 : 32-bit address defines the connection of a host or a router to the internet, IP ==address is the address of a connection==, not the device

## Address space
Total number of addresses used by the protocol, if protocol uses b bits to define an address, the address space is 2b because one bit can have two values (binary, 0 and 1), IPv4 address space is 232 -> 4.2M
Three common notations of IPv4 : binary, dotted-decimal, hexadecimal notation

## Addressing system
Hierachical, with two parts
Prefix comes before suffix

## IPv4 02
IPv4 has 3 prefixes, address space is then devided into fives classes
![[Week04 NetworkIP.pdf#page=35]]
![[Week04 NetworkIP.pdf#page=36]]
**In classful addressing, a large part of available addresses were wasted**

Classful addressing is replaced with classless addressing

Left most n bits (prefix) defines the network
Right most define whether it is poisonous or not.























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


