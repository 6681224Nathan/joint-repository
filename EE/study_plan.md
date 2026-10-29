# EGCI 232: study plan (written 26 Oct 2026, from a full re-read of every slide)

Quiz #1: Tue 27 Oct, 12:00. Midterm: Fri 30 Oct (25%). Quiz = 1 rectifier + 1 BJT amplifier problem, 1 hour.
How to use: send one message per section ("S1", "S2", ...). Each section = short lesson with diagrams, then exam-style problems (figure first, solution after).

Tags: [slide] = taught in the slides. [extra] = not written on the slides, but needed to solve the slide problems (standard formulas).

## Part 1: Quiz #1 (do today)

| # | Section | What's in it | Source | Time |
|---|---|---|---|---|
| S0 | Circuit toolkit | Thévenin + Norton (redo), nodal + mesh quick recap, capacitor (DC = open, AC = wire), sine wave: peak, RMS, average | L1 p9-15 [slide]; HW01 (mesh) | 25 min |
| S1 | Diode as a circuit part | Ideal vs 0.7 V model, "assume ON/OFF, then check", load line + Q-point, diode circuits with mesh analysis | L2 p27-35 + professor's worked notes in "(with note)" file [slide] | 40 min |
| S2 | Rectifiers | Half-wave, center-tapped, bridge; Vdc = 0.318 Vm (half), 0.636 Vm (full); RMS; filter capacitor and ripple; PIV; design problems (slide 27: 0.2 W 5 V from 220 V; slide 28: 30 V, 300 mA, 120 V RMS, <10% ripple); 7805 power supply | L3 p4-31 [slide]; ripple + PIV formulas [extra] | 60 min |
| S3 | BJT DC bias | Terminals + currents (IE = IB + IC, IC = beta IB), regions (cutoff/active/saturation) and how to check, fixed bias (Ex 1), switch (Ex 2), voltage-divider bias with Thévenin (Ex 3, class assignment), DC load line | L4 p3-31, L5 p2-7 [slide] | 75 min |
| S4 | CE amplifier (AC) | Q-point and load line, why the Q-point matters (clipping), what coupling and bypass capacitors do, AC equivalent, hybrid-pi (r_pi, gm, ro), Zi, Zo, Av (with and without load), Ai; slide 16 design example (+12 V, Rs 2k, RL 5.1k, IC 1 mA, VCE 6 V, IR1 = 10 IB); lab circuit (47k/10k/2.2k/560/820) | L5 p8-25 [slide]; r_pi = beta/gm, gm = IC/VT [extra] | 90 min |
| S5 | Timed mock quiz | 1 rectifier + 1 amplifier, 60 min, then marked solutions | exam style | 60 min |

Total about 5.5 hours. Order matters (S3 before S4, S0 before S3 because of Thévenin).

## Part 2: before the quiz tomorrow morning (30-45 min)
- S6 Clippers, limiters, "what is the output waveform?" questions [L3 p32-40]: quick drill, 6 small problems.
- Redo the weakest part of the mock.

## Part 3: before the midterm (Wed-Thu)
Theory is examined too. Slides are mostly pictures with short bullets, so questions will be "explain / compare / label".

| # | Section | What's in it | Source |
|---|---|---|---|
| T1 | Semiconductor basics | Conductor vs semiconductor vs insulator, band gap (Si 1.11 eV, Ge 0.66 eV at 300 K), valence/conduction band, electron-hole pairs, intrinsic vs extrinsic, N-type (pentavalent, donor), P-type (trivalent, acceptor), doping, temperature coefficient | L2 p5-16 |
| T2 | PN junction and diode physics | Depletion region, barrier potential (Si 0.7 V, Ge 0.3 V), forward vs reverse bias, I-V curve, knee, breakdown (Zener/avalanche), diode symbol and packages | L2 p17-28 |
| T3 | BJT theory | NPN/PNP structure, why base is thin and lightly doped, how current flows, alpha and beta (beta = alpha/(1-alpha)), CB vs CE characteristics, Early effect, pros/cons, BJT as switch | L4 p2-20 |
| T4 | Special diodes | LED (colors, forward voltage), photodiode, Zener (regulation), solar cell; clippers + limiters if not done in S6 | L3 p35-45 |
| T5 | Other BJT amplifiers | CC (emitter follower) and CB. SLIDES MISSING ("Other BJT Amplifiers", 17 Oct). Needs you to add the file | missing |
| T6 | Midterm mock | Mixed theory + circuits | |

## What I found in the slides (so you know what is and isn't there)
- Lecture 5 slides 15 (AC analysis), 20, 21 (Example), 24, 25 (Experiment) are BLANK in the PDF. The professor presumably solves them on the board. I will teach the AC method from the standard approach and the slide 16 example.
- Lecture 4 slides 25, 27, 29 are empty graph sheets (for drawing load lines). Slide 31 is the curve sheet for the class assignment.
- Lecture 2 "(with note)" version contains the professor's worked solutions for the diode examples (mesh analysis with diodes assumed ON, then checked). Use it.
- Missing from the folder: "Other BJT Amplifiers" (CC/CB) and "Simulation tools" slides, Lab 2 instruction.
- Rectifier formulas (ripple, PIV, capacitor sizing) are barely on the slides; the design problems (slide 27, 28) need them. Tagged [extra].
- Lecture 1 slides 3-8 are motivation only. Nothing to study.
