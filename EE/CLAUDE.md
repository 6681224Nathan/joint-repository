# CLAUDE.md: EGCI 232 Engineering Electronics (Pin's study folder)

Pin is a 2nd-year student taking EGCI 232 (Mahidol, AY2026-2027 T1, Dr. Somnida Bhatranand). This file is for studying with Claude. It overrides the root CLAUDE.md where they differ (especially on diagrams).

## How to teach Pin (read this first)

- Plain language, step by step, in detail. Not brief. Lessons can span several messages; end each lesson with a few "check yourself" questions and ask Pin to message "next" when ready.
- **Use visual aids a lot for circuit topics.** Pin learns best from diagrams: circuit schematics, step-through widgets, load lines, waveforms, DC vs AC views. Interactive steppers and sliders worked very well (mesh analysis, BJT switch, Thévenin walkthrough, KCL/KVL). Skip visuals only for quick factual answers.
- **Always give practice questions with a figure and a worked solution.** Same kind as the lecture slides (or close variants): draw the circuit, give values, ask 3-5 "find this and that" parts, then give the solution separately so Pin can try first. Match the exam style below.
- Teach, do not dump answers. Pin must be able to explain every step.
- Correct Pin's mislabeled values or misconceptions directly and say why (this has happened: V_BE mislabeled as V_B, I_C mislabeled as I_B, "output from the emitter" in the CE amplifier).
- Be honest about what was and wasn't read in the slides.

## The study plan (the most important part)

Pin missed the first weeks of class, so the plan restarts from slide 1 of lecture 1 and follows the lectures in order. Send "next" to advance.

| Part | Lecture | Lessons | Status (as of 26 Oct 2026) |
|---|---|---|---|
| A | 1 Review on ECA | A1 intro + capacitor/resistor/battery; A2 Ohm, KCL, KVL; A3 Thévenin + signals (RMS, sine); A4 dependent sources | A1, A2 done. **A3, A4 next** |
| B | 2 Physics of elements | B1 semiconductors + PN junction; B2 diode I-V curve; B3 diode models + examples (assume ON/OFF and check) | Covered informally in chat, not as formal lessons |
| C | 3 Diode circuits | C1 half-wave; C2 center-tapped + bridge; C3 rectifier design + power supply; C4 clippers, limiters, zener | C1-C3 covered informally. **C4 not covered** |
| D | 4 BJT | D1 structure, how it works; D2 modes + curves; D3 biasing (fixed, voltage divider, Thévenin); D4 switch + load line | Covered informally. Slides 14-31 of lecture 4 were not viewed |
| E | 5 CE amplifier | E1 DC + AC method, capacitors; **E2 hybrid-pi model; E3 CE gain with variables (class assignment); E4 full CE numeric example with Z_in, Z_out**; E5 common collector; E6 common base | **E1 done. E2-E4 are the biggest gap.** E5-E6: slides missing |
| F | Quiz prep | One timed rectifier problem + one timed amplifier problem, quiz style | Not started |

**Dates:** Quiz #1 Tue 27 Oct 2026. Midterm Fri 30 Oct 2026 (25%), 12:30-14:30, rooms 6274/6275 (per the professor's Teams post; check the attached name list), calculator and stationery only, bring student ID. MOSFETs, op-amps come after the midterm and are not needed yet.

**Quiz #1 format (told by Pin):** one rectifier circuit + one amplifier circuit, multi-part "find this and that", 1 hour, calculator allowed.

**Current plan: see `EE/study_plan.md`** (rewritten 26 Oct 2026 after OCR of every slide). Pin sends one message per section (S0-S5 today for Quiz #1, T1-T6 before the midterm). Each section: short lesson with diagrams, then exam-style problems with a figure, solutions after. Pin knows KVL, KCL, Ohm, mesh, nodal; Thévenin/Norton need a refresher. Slides L5 p15, 20, 21, 24, 25 are blank in the PDF; L2 "(with note)" has the professor's worked diode examples. Lesson HTML pages live in `EE/study_pages/` (one-line index in its `README.md`; add new pages there).

**Old priority (superseded):** (1) E2-E4 CE amplifier AC analysis, (2) one timed amplifier problem, (3) one timed rectifier problem (include the lecture 3 slide 28 design: 30 V, 300 mA, 120 V RMS, <10% ripple), (4) then clippers/zener and CC/CB if time remains.

## Class notes from Pin (use these to match the professor)

- Amplifier questions: do DC analysis first (to confirm active region and get I_C), then AC analysis.
- The BJT is replaced by the hybrid-pi AC model, which is given in the exam. Pin only needs to understand what each part means (r_π, g_m·v_π, r_o).
- Configurations: CE (base in, collector out), CC (base in, emitter out), CB (emitter in, collector out).
- Assignment: find the voltage gain at no load, using variables, replacing the transistor with the AC model, by hand. The CE output is the **collector**, inverted, which gives the negative sign.
- Rectifier notes use V_r / V_m = 1 / (f_r R_L C) with V_r = V_max − V_min and f_r the ripple frequency.

## Core methods (short reference)

- **Diodes:** guess ON/OFF, swap in the model (ideal: wire/gap; non-ideal: 0.7 V source/gap), solve, check (ON needs positive current; OFF needs voltage below threshold). Only flip the diode that failed.
- **Rectifier:** V_m = secondary peak; output peak = V_m − 0.7 (half-wave, center-tap) or V_m − 1.4 (bridge). Mains 220 V is RMS (peak 311 V). Full-wave ripple frequency is 2f. PIV: half-wave ≈ V_m (≈2V_m with a capacitor), center-tap ≈ 2V_m − 0.7, bridge ≈ V_m − 0.7. Round capacitors up.
- **BJT DC (voltage divider):** V_Th = V_CC·R2/(R1+R2); R_Th = R1∥R2; I_B = (V_Th − 0.7)/(R_Th + (β+1)R_E); I_C = βI_B; I_E = (β+1)I_B; V_CE = V_CC − I_C R_C − I_E R_E; active if V_CE > 0.2 V. Shortcut only if βR_E ≥ 10R2.
- **Mode check (NPN):** V_BE < ~0.5 V cutoff; V_BE ≈ 0.7 V then V_C > V_B active, V_C < V_B saturation.
- **AC view:** capacitors become wires, V_CC becomes ground (so R1∥R2 and R_C∥R_L), bypassed R_E is shorted.

## Files and what Claude has read

- Lectures 1-5 PDFs, Lab 1/3/4 instructions, HW01, and the syllabus are in this folder. Lab 2 instruction is in ~/Downloads, not here. `lab 01/` has Pin's diode I-V script and graph.
- **Missing slides:** "Other BJT Amplifiers" (17 Oct, CC/CB) and "Simulation tools" (10 Oct). Ask Pin to add them.
- **Not yet viewed:** most images in lectures 2 and 3, lecture 4 slides 14-31, lecture 5 slides 20-25 (drawn as vector graphics, so text extraction returns nothing).
- Labs: Lab 3 (voltage divider bias) is done in Tinkercad. Pin's example readings: V_BE 0.654 V, V_CE 5.21 V, I_C 2.46 mA, I_B ≈ 8 µA, I_E ≈ 2.47 mA, β ≈ 300.

## Tooling notes

- PDFs: `pdftoppm` is not installed; use `pypdf` for text and to extract embedded images, then Read the PNGs. macOS `sips` can convert only the first PDF page. Offer `brew install poppler` before installing anything.
- Pin runs a Jupyter notebook in the background: ask before running anything resource-intensive.
- Clean up temp/helper files in the scratchpad when a task finishes and report what was removed. Never touch Pin's backups.
- Claude in Chrome is not connected (Pin uses Brave). The built-in browser has no Teams sign-in.
