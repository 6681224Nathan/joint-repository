## By 6681224 Nathan Tanaboriboon
## First part
1. Run _nslookup_ to obtain the IP address of a Web server in Asia.

Ans. ![[Pasted image 20260608134924.png]]
DNS (Domain Name System) is like a phone book, a name of a location, but IP is like a phone number
	1. Non-authoritative answer (this is the information it gets from cache of a local DNS server (most of the time, it is a local router)) 

2. Run _nslookup_ to determine the authoritative DNS servers for a university in Europe.

**Ans.** 
	Authoritative-answers (answer from local DNS server, basically a local phonebook) **name server**
	Authoritative name, name from **actual** server, and the authoritative server does not hold cache as well.
	With the request (nslookup) for authoritative server, we are asking for information (IP address) from actual server itself, not cache
![[Pasted image 20260608135605.png]]


3. Run _nslookup_ so that one of the DNS servers obtained in Question 2 is queried for the mail servers for Gmail.

**Ans.**
 If standard DNS record is a phone book for general location, MX record is for mail room (company analogy). We want to find the location of where the mail is sent to the company location registered under @gmail.com
 ![[Pasted image 20260608140840.png]]
 the refusal is due to university's blockade to refuse to give out such information of their gmail server to outsider, instead with MU website.
 ![[Pasted image 20260608141124.png]]

## Second part
- ifconfig
- sudo dscacheutil -flushcache; sudo killall -HUP mDNSResponder | for macOS to clear local DNS cache
- ifconfig en0 (this limits ifconfig to only see the information of IPs and everything, but related to local router only)

Locate the DNS query and response messages. Are they sent over UDP or TCP?

Ans.![[Pasted image 20260608145313.png]]
UDP

5. What is the destination port for the DNS query message? What is the source port
of DNS response message?
![[Pasted image 20260608145503.png]]
query dst port 53
![[Pasted image 20260608145548.png]]
response src port : 53 
Ans.

6. To what IP address is the DNS query message sent? Use _ipconfig_ to determine the IP address of your local DNS server. Are these two IP addresses the same?

Ans.
Query message is sent to 192.168.64.3
![[Pasted image 20260608145939.png]]
This is the IP of local DNS server
Both matches


7. Examine the DNS query message. What “Type” of DNS query is it? Does the query message contain any “answers”?
Ans.
![[Pasted image 20260608150134.png]]
DNS query type : Type A (address record), no answer for query

## Part 3
![[Pasted image 20260608152031.png]]
a) What is an Initial Sequence Number (also show a captured screenshot)?
Ans.
![[Pasted image 20260608152239.png]]
Sequence number = 0
Sequence number (raw) : 4087543545

b) What is a Sequence and Ack Number (also show a captured screenshot)?
![[Pasted image 20260608152452.png]]
Ans. Sequence number = 0, Acknowledgement number = 1 (relative ack number)

c) What is an Ack Number (also show a captured screenshot)?
![[Pasted image 20260608152625.png]]
Ans.
	Acknowledgement number = 1 (and raw number is as followed in the screenshot
	)


