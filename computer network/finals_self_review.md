### UDP vs TCP
- **UDP Header:** Fixed size of **8 bytes**.
- **UDP Total Size Range:** Minimum = **8 bytes** (0 payload), Maximum = **65,535 bytes** (216−1).
- **UDP Max Payload Size:** 65,535−8=65,527 bytes.
- **TCP Header Range:** Minimum = **20 bytes** (HLEN = 5), Maximum = **60 bytes** (HLEN = 15).
- **HLEN Multiplier:** Multiply HLEN by 4 to get bytes (HLEN×4=Bytes).
In a 16-hex-character UDP dump (`0632 000D 001C E217`):
- `0632` (Chars 1–4) = **Source Port**
		- 
- `000D` (Chars 5–8) = **Destination Port**
- `001C` (Chars 9–12) = **Total Length**
- `E217` (Chars 13–16) = **Checksum**

Data length = total length - header size
Source port, destination port. LOW : server, HIGH : user

