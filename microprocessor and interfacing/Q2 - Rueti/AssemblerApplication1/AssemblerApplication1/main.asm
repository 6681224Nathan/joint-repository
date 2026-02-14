;
; AssemblerApplication1.asm
;
; Created: 2/12/2026 1:16:06 AM
; Author : User
;


; Replace with your application code
.include "m328pdef.inc"

.cseg
.org 0x0000
    rjmp START

;====================================
; 7-Segment Table (Common Cathode)
;====================================
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

;====================================
; START
;====================================
START:

    clr r1

; ---- PORTD output (segments)
    ldi r16, 0xFF
    out DDRD, r16

; ---- PB0, PB1 output (digit select)
    ldi r16, (1<<PB0)|(1<<PB1)
    out DDRB, r16

MAIN_LOOP:

;-------------------------
; Turn OFF both digits
;-------------------------
    cbi PORTB, PB0
    cbi PORTB, PB1

;=========================
; Show Digit 2 (Left)
;=========================
    ldi r20, 2

    ldi ZH, high(SEG_TABLE<<1)
    ldi ZL, low(SEG_TABLE<<1)
    add ZL, r20
    adc ZH, r1
    lpm r16, Z

    out PORTD, r16
    sbi PORTB, PB0
    rcall DELAY

;-------------------------
; Turn OFF before next
;-------------------------
    cbi PORTB, PB0

;=========================
; Show Digit 3 (Right)
;=========================
    ldi r20, 3

    ldi ZH, high(SEG_TABLE<<1)
    ldi ZL, low(SEG_TABLE<<1)
    add ZL, r20
    adc ZH, r1
    lpm r16, Z

    out PORTD, r16
    sbi PORTB, PB1
    rcall DELAY

    rjmp MAIN_LOOP

;====================================
; Delay
;====================================
DELAY:
    ldi r18, 200
D1:
    ldi r19, 255
D2:
    dec r19
    brne D2
    dec r18
    brne D1
    ret

