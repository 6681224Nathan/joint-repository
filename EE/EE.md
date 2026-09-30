### P-type semiconductor
For P-type semiconductor, majority charge carrier is ...

### Depletion region
- Direction of internal built-in electric field (E) from N side to P side

### Typical built-in potential barrier for standard silicon PN junction at room temperature
- 0.5 - 0.7 V, voltage has to be more than this in order for forward-biased diode to allow current to move through

### When reverse bias voltage is applied to a p-n junction what happens to the physical width of the depletion region
- depletion layer will get wider

### + Anode __ - Cathode
If Anode is -2V and Cathode is -5V then ==forward-biased==

### Ideal diode forward bias
- short (non-ideal is 0.7v battery)

there is a limit for reverse-biased voltage

### VI characteristic curve
![[2-Physics of Elements.pdf#page=27]]

### Rectifier circuit
Converts AC to DC, for charging battery (DC can be stored, in battery, ==AC cannot be stored==)

Direct current : the direction of current and amount of voltage are always constant, one direction
Alternating current : direction of the current is always switched periodically, voltage is also switched
![[3-Diode Circuits & Applications.pdf#page=4]]

RMS value (not peak of the AC sine graph), root mean square

**For AC**, in order to find P (for a non-constant V and I), = $V_{rms} \times I_{rms}$ 

To find $V_{avg}$ = 1/T int from 0 -> t v(t) dt

$V_{rms} = \sqrt(\int_{0}^{t}v^2(t)dt)$

$V = V_{m} \space sin(wt)$

![[3-Diode Circuits & Applications.pdf#page=5]]

In this case for diode with alternating current, ideal diode, for positive part of the AC, diode will let it pass, but for negative voltage from the source, diode will block it and make it 0, open circuit. **look at sinusodal waveform supply and rectified output waveform, no negative half-cycle**

Vm = max amplitude

PIV (peak inverse voltage) = the reverse amplitude, the lowest part of the graph

$V_{DC}$ is an average of the graph, the middle point (which is a constant value, a good way to AC -> DC) after passing through diode

Note : frequency in = frequency out

### Neu
connect capacitor, this graph
![[3-Diode Circuits & Applications.pdf#page=5]]

connect from cathod of diode to ground (lower part of circuit) with capacitor

### capacitor
Capacitor placed there, will store the charges emitting from diode, but it will also **discharge**. **Nature of capacitor is to store and release elec. charges**

**capacitor works as filter**

Transformer to tone down the voltage, but the current is still AC

So for the part of 0V after diode (it is a periodic graph), for capacitor it will **discharge** 

![[3-Diode Circuits & Applications.pdf#page=9]]

Discharge until the new climb of diode potential is higher than the capacitor's current potential

Which means one thing AC -> Transformer -> diode -> capacitor, in **capacitor, you will get a smoother line of current** peak -> linear discharge -> climb to peak -> peak, the climb to peak is called **"ripple voltage"**

$\frac{Vr}{Vm} = \frac{1}{f_rR_LC}$

For rectifier
To find out the perfect capacitor to settle the power gap 

$\frac{Vr}{Vm} = \frac{1}{f_rR_LC}$

fr is ripple frequency

difference between max and min of voltage of load after being added capacitor. Vr  = Vmax - Vmin

### Rectifier design
- calculating the load
- selecting the right diode
- the output capacitor filter
- testing the design circuit
> So the capacitor to help bridge the gap is the filter after all huh

Prob : We are given a load of wattage 0.2W and voltage rating of 5V. The problem statement is, we need to design a half wave rectifier to power the device up from the main power AC i.e. 220v. ==refers to the paper notebook==


















