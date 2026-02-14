.include "m328pdef.inc"

.def temp     = r16
.def counter  = r17
.def tens     = r18
.def units    = r19
.def digit    = r20

.cseg
.org 0x0000
    rjmp MAIN

;========================================
; 7-segment lookup table (Common Cathode)
; gfedcba
;========================================
SEG_TABLE:
    .db 0x3F ;0
    .db 0x06 ;1
    .db 0x5B ;2
    .db 0x4F ;3
    .db 0x66 ;4
    .db 0x6D ;5
    .db 0x7D ;6
    .db 0x07 ;7
    .db 0x7F ;8
    .db 0x6F ;9

;========================================
; MAIN
;========================================
MAIN:

    ; ----- Stack -----
    ldi temp, high(RAMEND)
    out SPH, temp
    ldi temp, low(RAMEND)
    out SPL, temp

    clr r1

    ; ----- PORT setup -----
    ldi temp, 0xFF
    out DDRD, temp        ; segments output

    ldi temp, 0x03
    out DDRB, temp        ; digit select output

    ldi temp, 0x00
    out DDRC, temp        ; switches input

    ldi temp, 0x03
    out PORTC, temp       ; enable pull-up on PC0, PC1

    clr counter

;========================================
; MAIN LOOP
;========================================
LOOP:

;---------- Check Switch1 (Increment) ----------
    sbic PINC, 0          ; if pressed (active low)
    rjmp CHECK_RESET

    rcall DEBOUNCE
    inc counter
    cpi counter, 100
    brlo CONTINUE
    clr counter

CONTINUE:

;---------- Check Switch2 (Reset) ----------
CHECK_RESET:
    sbic PINC, 1
    rjmp DISPLAY

    rcall DEBOUNCE
    clr counter

;---------- Display ----------
DISPLAY:

    ; ----- Calculate tens & units -----
    mov temp, counter
    ldi tens, 0

DIV10:
    cpi temp, 10
    brlo DIV_DONE
    subi temp, 10
    inc tens
    rjmp DIV10

DIV_DONE:
    mov units, temp

    ; ----- Show Tens -----
    mov digit, tens
    rcall SHOW_DIGIT
    ldi temp, 0b00000001
    out PORTB, temp
    rcall SHORT_DELAY

    ; ----- Show Units -----
    mov digit, units
    rcall SHOW_DIGIT
    ldi temp, 0b00000010
    out PORTB, temp
    rcall SHORT_DELAY

    rjmp LOOP

;========================================
; SHOW_DIGIT
; Input: digit (0-9)
;========================================
SHOW_DIGIT:
    ldi ZH, high(SEG_TABLE<<1)
    ldi ZL, low(SEG_TABLE<<1)
    add ZL, digit
    adc ZH, r1
    lpm temp, Z
    out PORTD, temp
    ret

;========================================
; Debounce Delay
;========================================
DEBOUNCE:
    ldi r21, 100
D1:
    ldi r22, 255
D2:
    dec r22
    brne D2
    dec r21
    brne D1
    ret

;========================================
; Short Display Delay
;========================================
SHORT_DELAY:
    ldi r23, 50
SD1:
    dec r23
    brne SD1
    ret