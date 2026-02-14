;
; AssemblerApplication1.asm
;
; Created: 2/11/2026 11:38:25 AM
; Author : User
;


; Replace with your application code
;========================================
; ATmega328P
; Copy -> Sort -> Compute Median
;========================================

.include "m328pdef.inc"

.equ N = 10
.equ MY_ARRAY_START = 0x0100
.equ MY_MEDIAN_ADDR = 0x010A
.equ MEDIAN_ADDR = 0x010A
.cseg
.org 0x0000
    rjmp MAIN

TABLE:
    .db 0x33,0x01,0xFF,0x12,0x7C
    .db 0x09,0x80,0x2A,0x05,0x10
    .db 0x00

MAIN:

; Copy Flash -> SRAM

    ldi ZH, high(TABLE<<1)
    ldi ZL, low(TABLE<<1)

    ldi YH, high(MY_ARRAY_START)
    ldi YL, low(MY_ARRAY_START)

    ldi r16, N


COPY_LOOP:
    lpm r0, Z+
    st Y+, r0
    dec r16
    brne COPY_LOOP


;----------------------------------------
; 2) Bubble Sort (Ascending)
;----------------------------------------

    ldi r17, N-1          ; outer loop counter

OUTER_LOOP:
    ldi YH, high(SRAM_START)
    ldi YL, low(SRAM_START)

    mov r18, r17          ; inner loop counter

INNER_LOOP:
    ld  r19, Y            ; current
    ldd r20, Y+1          ; next

    cp  r19, r20
    brlo NO_SWAP          ; if current < next skip

    ; swap
    st  Y, r20
    std Y+1, r19

NO_SWAP:
    adiw YL, 1            ; move pointer
    dec r18
    brne INNER_LOOP

    dec r17
    brne OUTER_LOOP


;----------------------------------------
; 3) Compute Median
; Median = (ARR[4] + ARR[5]) / 2
;----------------------------------------

    ldi YH, high(SRAM_START)
    ldi YL, low(SRAM_START)

    ldd r21, Y+4
    ldd r22, Y+5

    add r21, r22          ; sum

    lsr r21               ; divide by 2

    sts MEDIAN_ADDR, r21  ; store median


END:
    rjmp END

