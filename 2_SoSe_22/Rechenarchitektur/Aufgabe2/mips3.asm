.data
n: .word 6			# größe von Array A und B
A: .word 3, 4, 6, 8, 11, 13  	# Array A = [6] = { 3, 4, 6, 8, 11, 13 }
B: .word 0, 0, 0, 0,  0,  0  	# Array B = [6] = { 0, 0, 0, 0,  0,  0 }

.text
j main # überspringe die Prozeduren
ISODD:	# x == 1 == odd || x == 0 == even 
	andi $v0, $a0, 1	# es wird das letzte BIT in v0 geschrieben (wenn 1 == ungerade)
	jr $ra			# springe zum aufruf zurück
	nop
	
ISEVEN:	# x == 1 == even || x == 0 == odd
	addi $sp, $sp, -4 	# Im Stack word Speicherplatz "belegen"
	sw $ra, 0($sp)		# speichern der Rücksprung-Adresse
	jal ISODD		# rufe ISODD() auf
	nop
	addi $v0, $v0, 1	# addiere 1 zum v0, um 00 + 1 = 01 | 01 + 1 = 10
	andi $v0, $v0, 1	# schreibe das letzte bit in v0, 11110 = 0 | 11001 = 1
	
	lw $ra, 0($sp)		# Rücksrpung Adresse vom Stack laden
	addi $sp, $sp, 4	# Stackplatz wieder freigeben
	jr $ra			# Auf Rücksprung Adresse $ra springen
	nop
	
EVEN_ELEM: # int evenElem(int A[] = a0, int B[] = a1, int n = a2)
	addi $sp, $sp, -16	# Belege Stack mit 4 Words
	sw $a0, 0($sp)		# Parameter A[] in Stack legen
	sw $a1, 4($sp)		# Parameter B[] in Stack legen
	sw $a2, 8($sp)		# Parameter n in Stack legen
	sw $ra, 12($sp)		# $ra in Stack legen
	
	add $t5, $zero, $a1 	# DEBUG 
	
	add $t9, $zero, $a0	# speicher Parameter A[] in $t9
	add $t8, $zero, $a1	# speicher Parameter B[] in $t8
	
	li $t1, 0		# t0 = 0 // int i = 0
	li $t2, 0 		# t1 = 0 // int j = 0
	
	startEvenElemLoop:			# while schleife 
	bge $t1, $a2, endEvenElemLoop		# t0 > a2 => exit loop
		lw $a0, 0($t9)			# lade das word vom Speicher mit der Adresse von $t0
		jal ISEVEN			# v0 = ISEVEN()
		bne $v0, 1, endif			# Prüfe ob $v0 == 0 ist, wenn nicht springe zu endif
			sw $a0, 0($t8)			# Schreibe dan aktuellen Wert a0 in t8
			addi $t8, $t8, 4		# Zur nächsten Word Adresse zeigen
			addi $t2, $t2, 1 		# addiere $t2 (j) eins dazu
		endif:					# beende die Abfrage
		addi $t9, $t9, 4	 	# springe zur nächsten Word-Adresse vom Array
		addi $t1, $t1, 1		# addiere t1 (i) eins dazu
		j startEvenElemLoop
	endEvenElemLoop:			# beende die WHILE Schleife

	add $v0, $zero, $t2	# Rückgabewert in $v0 schreiben, mit dem Wert von $t2 (j)

	lw $ra, 12($sp)		# Returnadresse vom Stack laden
	addi $sp, $sp, 16	# Gebe Stackspeicher zurück
	jr $ra			# Rücksprung zur Aufruf-Adresse
	nop
	
main:
	la $a0, A		# Parameter (a0) 1 mit Array Adresse "A" belegen
	la $a1, B		# Parameter (a1) 2 mit Array Adresse "B" belegen
	lw $a2, n		# Parameter (a2) 3 mit Word "n" belegen
	jal EVEN_ELEM		# Führe Prozedur EVEN_ELEM() aus
	nop
	add $s0, $zero, $v0 	# Speicher Rückgabewert in s0
exit:
	nop