.include "m328pdef.inc"

.equ N = 10
.equ ARR_START = 0x0100
.equ AVG_ADDR = 0x010A
.equ MAX_ADDR = 0x010B
.equ COUNT_ADDR = 0x010C

;=============================
; Program Memory Table
;=============================
.cseg
.org 0x0000
    rjmp MAIN

TABLE:
    .db 23, 5, 100, 45, 2, 89, 34, 77, 1, 50


;=============================
; MAIN
;=============================
MAIN:

    ; ====== STACK POINTER (??????????????) ======
    ldi r16, high(RAMEND)
    out SPH, r16
    ldi r16, low(RAMEND)
    out SPL, r16

    clr r1        ; ????????! r1 ?????????????????

;---------------------------------
; 1) Copy Flash -> SRAM
;---------------------------------

    ldi ZH, high(TABLE<<1)
    ldi ZL, low(TABLE<<1)

    ldi YH, high(ARR_START)
    ldi YL, low(ARR_START)

    ldi r16, N

COPY_LOOP:
    lpm r0, Z+
    st Y+, r0
    dec r16
    brne COPY_LOOP

;---------------------------------
; 2) Compute 16-bit SUM
;---------------------------------

    ldi YH, high(ARR_START)
    ldi YL, low(ARR_START)

    clr r17
    clr r18

    ldi r16, N

SUM_LOOP:
    ld r19, Y+
    add r17, r19
    adc r18, r1
    dec r16
    brne SUM_LOOP

;---------------------------------
; 3) Divide SUM / 10
;---------------------------------

    ldi r20, 0
    ldi r21, 10

DIV_LOOP:
    cp  r17, r21
    cpc r18, r1
    brlo DIV_DONE

    sub r17, r21
    sbc r18, r1
    inc r20
    rjmp DIV_LOOP

DIV_DONE:

    sts AVG_ADDR, r20

;---------------------------------
; 4) Modify array + find MAX + COUNT
;---------------------------------

    ldi YH, high(ARR_START)
    ldi YL, low(ARR_START)

    ldi r16, N
    clr r22
    clr r23

MOD_LOOP:
    ld  r24, Y

    cp  r24, r20
    brsh KEEP_VALUE

    ldi r24, 0
    st  Y, r24
    rjmp NEXT_ELEMENT

KEEP_VALUE:
    cp r24, r22
    brlo CHECK_COUNT
    mov r22, r24

CHECK_COUNT:
    tst r24
    breq NEXT_ELEMENT
    inc r23

NEXT_ELEMENT:
    adiw YL,1
    dec r16
    brne MOD_LOOP

;---------------------------------
; 5) Store MAX and COUNT
;---------------------------------

    sts MAX_ADDR, r22
    sts COUNT_ADDR, r23

END:
    rjmp END
