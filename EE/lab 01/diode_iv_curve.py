"""
Diode I-V characteristic curve
EGCI 232 Lab 1 - forward and reverse biased data points
"""

import matplotlib.pyplot as plt

# Forward-biased data (measured in lab)
# Resistor: 22k, 10k, 4.7k, 1k
Vd_forward = [0.52, 0.25, 0.206, 0.682]      # volts
Id_forward = [0.431, 0.975, 2.084, 9.318]    # mA

# Reverse-biased data (from LTspice simulation)
# Resistor: 22k, 10k, 4.7k, 1k
Vd_reverse = [-9.974, -9.988, -9.994, -9.999]        # volts
Id_reverse_uA = [-1.18, -1.20, -1.28, -1.00]         # microamps
Id_reverse = [i / 1000 for i in Id_reverse_uA]        # convert to mA for same axis

# Combine and sort by voltage for a clean curve
points = sorted(zip(Vd_forward + Vd_reverse, Id_forward + Id_reverse))
V = [p[0] for p in points]
I = [p[1] for p in points]

fig, ax = plt.subplots(figsize=(8, 6))

ax.plot(V, I, marker='o', linestyle='-', color='tab:blue', label='Measured data')
ax.axhline(0, color='black', linewidth=0.8)
ax.axvline(0, color='black', linewidth=0.8)

ax.set_xlabel('V (Diode Voltage, V)')
ax.set_ylabel('I (Diode Current, mA)')
ax.set_title('Diode I-V Characteristic Curve')
ax.grid(True, linestyle='--', alpha=0.5)
ax.legend()

plt.tight_layout()
plt.savefig('diode_iv_curve.png', dpi=200)
plt.show()

print("Saved plot to diode_iv_curve.png")
