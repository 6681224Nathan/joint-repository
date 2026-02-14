;
; AssemblerApplicationTemVer.asm
;
; Created: 2/11/2026 10:53:28 PM
; Author : User
;


; Replace with your application code
.include "m328pdef.inc"


.equ N = 8


;===================================

; SRAM SECTION

;===================================

.dseg

.org 0x0100

ARR:        .byte N          ; original array


.org 0x0110

SORTED:     .byte N          ; sorted array destination


;===================================

; CODE SECTION

;===================================

.cseg

.org 0x0000

rjmp START


;===================================

; MAIN PROGRAM

;===================================

START:


    clr r1                    ; zero register (important)


;-----------------------------------

; Initialize original data

;-----------------------------------

    ldi XH, high(ARR)

    ldi XL, low(ARR)


    ldi r16, 23

    st  X+, r16

    ldi r16, 5

    st  X+, r16

    ldi r16, 17

    st  X+, r16

    ldi r16, 12

    st  X+, r16

    ldi r16, 45

    st  X+, r16

    ldi r16, 8

    st  X+, r16

    ldi r16, 30

    st  X+, r16

    ldi r16, 2

    st  X+, r16


;===================================

; Bubble Sort (Descending)

; Rule: if A[i] < A[i+1] swap

;===================================



    ldi r18, N-1              ; outer loop


OUTER_LOOP:

    ldi r19, N-1              ; inner loop


    ldi XH, high(ARR)

    ldi XL, low(ARR)


INNER_LOOP:


    ld  r16, X                ; A[i]


    mov r30, XL               ; copy X ? Z

    mov r31, XH

    adiw r30, 1               ; Z = X + 1


    ld  r17, Z                ; A[i+1]


    cp  r16, r17

    brsh NO_SWAP              ; if A[i] >= A[i+1], correct order


    ;---------- SWAP ----------

    st  X, r17

    st  Z, r16

    ;--------------------------


NO_SWAP:

    adiw XL, 1                ; move to next element

    dec r19

    brne INNER_LOOP


    dec r18

    brne OUTER_LOOP



;===================================

; Copy sorted array to 0x0110

;===================================


    ldi XH, high(ARR)

    ldi XL, low(ARR)


    ldi YH, high(SORTED)

    ldi YL, low(SORTED)


    ldi r20, N


COPY_LOOP:

    ld  r16, X+

    st  Y+, r16

    dec r20

    brne COPY_LOOP


END:

    rjmp END
