.text

.data
j main 		# springe direkt zum main
ISODD:	# x == 1 == odd || x == 0 == even 
	andi $v0, $a0, 1	# es wird das letzte BIT in v0 geschrieben (wenn 1 == ungerade)
	jr $ra			# springe zum aufruf zurück
	nop
	
ISEVEN:	# x == 0 == even || x == 1 == odd
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

main:	# main methode
	li $a0, 10		# a0 = 10		# s0 == 0 		s1 == 1
	jal ISODD		# ISODD()	
	add $s1, $zero, $v0	# s0 = v0
	nop
	li $a0, 10		# a0 = 10
	jal ISEVEN		# ISEVEN()
	add $s2, $zero, $v0	# s1 = v0
	nop
exit:
	nop
